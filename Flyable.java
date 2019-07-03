package za.co.bngweny;

public interface Flyable {

    public void updateConditions();
    public void registerTower(WeatherTower wt);
    public Coordinates getCoordinates();
    public String getFlyableName();
    public long getFlyableID();
}