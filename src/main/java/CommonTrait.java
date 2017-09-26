import org.docx4j.model.datastorage.migration.VariablePrepare;
import org.docx4j.utils.SingleTraversalUtilVisitorCallback;
import org.docx4j.wml.ContentAccessor;

import javax.xml.bind.JAXBElement;
import java.util.ArrayList;
import java.util.List;

public interface CommonTrait
{
    default List<Object> getAllElementFromObject(Object obj, Class<?> toSearch)
    {
        List<Object> result = new ArrayList<>();
        if (obj instanceof JAXBElement) obj = ((JAXBElement<?>) obj).getValue();

        if (obj.getClass().equals(toSearch))
        {
            result.add(obj);
        } else if (obj instanceof ContentAccessor)
        {
            List<?> children = ((ContentAccessor) obj).getContent();
            for (Object child : children)
            {
                result.addAll(getAllElementFromObject(child, toSearch));
            }

        }
        return result;
    }

    default Object prepareVariables(Object body)
    {
        SingleTraversalUtilVisitorCallback paragraphVisitor
                = new SingleTraversalUtilVisitorCallback(
                new VariablePrepare.TraversalUtilParagraphVisitor());
        paragraphVisitor.walkJAXBElements(body);
        return body;
    }
}
