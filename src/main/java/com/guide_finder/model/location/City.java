package model.location;

public class City extends AbstractLocation {
    private final Region region;

    public City() {
        region = null;
    }


    public AbstractLocation getRegion() {
        return region;
    }
}
