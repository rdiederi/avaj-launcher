package za.co.bngweny;

import za.co.Exceptions.HeightTooLowException;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
        weatherTower = new WeatherTower();
    }

    public void updateConditions() {
        switch (weatherTower.getWeather(this.coordinates)) {
        case "SUN":
            System.out.println(String.format("%s#%s(%d): THE SUN IS SHINING! UP WE GO", this, getFlyableName(), getFlyableID()));
            this.coordinates.changeLongitude(10, "+");
            try {
                this.coordinates.changeHeight(2, "+");
            } catch (HeightTooLowException ex) {
                System.out.println(String.format("%s#%s(%d): Height too low bro! Chopper will land now!", this, getFlyableName(), getFlyableID()));
            }
            break;
        case "RAIN":
            System.out.println(String.format("%s#%s(%d): Its raining!!! INCREASE THE TEMPO", this, getFlyableName(), getFlyableID()));
            this.coordinates.changeLongitude(5, "+");
            break;
        case "FOG":
            System.out.println(String.format("%s#%s(%d): Hello fog oold friend", this, getFlyableName(), getFlyableID()));
            this.coordinates.changeLongitude(1, "+");
            break;
        case "SNOW":
            System.out.println(String.format("%s#%s(%d): MAHN i hate the snow! its dragging us down", this, getFlyableName(), getFlyableID()));
            try {
                this.coordinates.changeHeight(12, "-");
            } catch (HeightTooLowException ex) {
                System.out.println(String.format("%s#%s(%d): Height too low bro! Chopper will land now!", this, getFlyableName(), getFlyableID()));
            }
            break;
        }
    }

    public Coordinates getCoordinates()
    {
        return this.coordinates;
    }

    public void registerTower(WeatherTower wt) {
        this.weatherTower = wt;
    }

    @Override
    public String toString()
    {
        return "Helicoper";
    }

    public String getFlyableName()
    {
        return this.name;
    }

    public long getFlyableID()
    {
        return this.id;
    }
}