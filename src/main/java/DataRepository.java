import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class DataRepository
{
    private LinkedList<Driver> drivers;
    private List<GasStation> stations;


    DataRepository()
    {
        stations = new ArrayList<>();
        stations.add(new GasStation("vimbo"));
        stations.add(new GasStation("semimbee"));
        stations.add(new GasStation("aginder"));
        stations.add(new GasStation("neonu"));
        stations.add(new GasStation("dynatude"));
        stations.add(new GasStation("skamba"));
        stations.add(new GasStation("avando"));
        stations.add(new GasStation("premore"));
        stations.add(new GasStation("conible"));
        stations.add(new GasStation("polyil"));
        stations.add(new GasStation("multixo"));
        stations.add(new GasStation("parambo"));
        stations.add(new GasStation("vicecy"));
        stations.add(new GasStation("pixolium"));
        stations.add(new GasStation("garent"));
        stations.add(new GasStation("animoid"));
        stations.add(new GasStation("conoodle"));
        stations.add(new GasStation("dulia"));
        stations.add(new GasStation("telender"));
        stations.add(new GasStation("monic"));
        stations.add(new GasStation("abafix"));
        stations.add(new GasStation("amise"));
        stations.add(new GasStation("leezzy"));
        stations.add(new GasStation("albize"));
        stations.add(new GasStation("postist"));
        stations.add(new GasStation("amphinix"));

        drivers = new LinkedList<>();
        drivers.push(new Driver("Selena Scheetz", getRandom()));
        drivers.push(new Driver("Rosalva Conely", getRandom()));
        drivers.push(new Driver("Catrina Criddle", getRandom()));
        drivers.push(new Driver("Louis Metzer", getRandom()));
        drivers.push(new Driver("Hilario Ottley", getRandom()));
        drivers.push(new Driver("Zonia Hulse", getRandom()));
        drivers.push(new Driver("Keith Lugar", getRandom()));
        drivers.push(new Driver("Rosaura Brumbaugh", getRandom()));
        drivers.push(new Driver("Carmela Slankard", getRandom()));
        drivers.push(new Driver("Victorina Hora", getRandom()));
        drivers.push(new Driver("August Krol", getRandom()));
        drivers.push(new Driver("Clemencia Schatz", getRandom()));
        drivers.push(new Driver("Viki Beyers", getRandom()));
        drivers.push(new Driver("Marya Topete", getRandom()));
        drivers.push(new Driver("Codi Ciulla", getRandom()));
        drivers.push(new Driver("Deanne Symons", getRandom()));
        drivers.push(new Driver("Amos Pooley", getRandom()));
        drivers.push(new Driver("Alishia Pangle", getRandom()));
        drivers.push(new Driver("Bebe Huck", getRandom()));
        drivers.push(new Driver("Marhta Beane", getRandom()));
    }

    private Set<GasStation> getRandom()
    {
        Set<GasStation> set = new HashSet<>(5);

        for (int i = 0; i < 5; i++)
        {
            set.add(stations.get(ThreadLocalRandom.current().nextInt(0, stations.size())));
        }

        return set;
    }

    LinkedList<Driver> getDrivers()
    {
        return drivers;
    }

    List<GasStation> getStations()
    {
        return stations;
    }
}
