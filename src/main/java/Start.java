import org.docx4j.Docx4J;
import org.docx4j.XmlUtils;
import org.docx4j.jaxb.Context;
import org.docx4j.model.datastorage.migration.VariablePrepare;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.*;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Start implements CommonTrait
{
    private static final String TEMPLATE_DOCX = "template.docx";
    private static final String OUT_GENERATED_DOCX = "/tmp/OUT_generated.docx";
    private static final int DRIVERS_PER_TABLE = 6;
    private final WordprocessingMLPackage wordMLPackage;
    private final MainDocumentPart documentPart;

    private final TableTemplate tableTemplate;
    private final DataRepository repository = new DataRepository();

    private Start() throws Exception
    {
        wordMLPackage = WordprocessingMLPackage.load(new File(Start.class.getResource(TEMPLATE_DOCX).getFile()));
        documentPart = wordMLPackage.getMainDocumentPart();
        tableTemplate = new TableTemplate(XmlUtils.deepCopy(getTemplateTable(documentPart)));
    }

    private void fillTemplate() throws Exception
    {
        documentPart.getContent().clear();
        while (!repository.getDrivers().isEmpty())
        {
            List<Driver> drivers = repository.getDrivers().subList(0, getToIndex());

            documentPart.getContent().add(tableTemplate.fillWithData(repository.getStations(), drivers));
            documentPart.getContent().add(createPageBreak());
            drivers.clear();

        }
        clearUnfilledData();

        Docx4J.save(wordMLPackage, new File(OUT_GENERATED_DOCX));
    }

    private int getToIndex()
    {
        return repository.getDrivers().size() >= DRIVERS_PER_TABLE
                ? DRIVERS_PER_TABLE
                : repository.getDrivers().size();
    }

    private void clearUnfilledData() throws Exception
    {
        Map<String, String> mappings = new HashMap<>();
        mappings.put("st", "");
        for (int i = 1; i <= DRIVERS_PER_TABLE; i++)
        {
            mappings.put("d" + i, "");
            mappings.put("ds" + i, "");
        }
        VariablePrepare.prepare(wordMLPackage);
        documentPart.variableReplace(mappings);
    }


    private Tbl getTemplateTable(MainDocumentPart documentPart)
    {
        return (Tbl) getAllElementFromObject(documentPart, Tbl.class).get(0);
    }

    private P createPageBreak()
    {
        Br br = Context.getWmlObjectFactory().createBr();
        br.setType(STBrType.PAGE);

        R run = Context.getWmlObjectFactory().createR();
        run.getContent().add(br);

        P paragraph = Context.getWmlObjectFactory().createP();
        paragraph.getContent().add(run);
        return paragraph;
    }

    public static void main(String[] args) throws Exception
    {
        new Start().fillTemplate();
    }
}
