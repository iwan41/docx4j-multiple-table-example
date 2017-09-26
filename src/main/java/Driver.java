import java.util.Set;

public class Driver
{
    private String name;
    private Set<GasStation> gasStations;

    Driver(String name, Set<GasStation> gasStations)
    {
        this.name = name;
        this.gasStations = gasStations;
    }

    String getName()
    {
        return name;
    }

    Set<GasStation> getGasStations()
    {
        return gasStations;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Driver driver = (Driver) o;

        if (name != null ? !name.equals(driver.name) : driver.name != null) return false;
        return gasStations != null ? gasStations.equals(driver.gasStations) : driver.gasStations == null;
    }

    @Override
    public int hashCode()
    {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (gasStations != null ? gasStations.hashCode() : 0);
        return result;
    }
}
