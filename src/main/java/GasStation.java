public class GasStation
{
    private String name;

    GasStation(String name)
    {
        this.name = name;
    }

    String getName()
    {
        return name;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GasStation gasStation = (GasStation) o;

        return name != null ? name.equals(gasStation.name) : gasStation.name == null;
    }

    @Override
    public int hashCode()
    {
        return name != null ? name.hashCode() : 0;
    }
}
