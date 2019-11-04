package za.co.rdiederi;

import za.co.Exceptions.HeightTooLowException;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
        weatherTower = new WeatherTower();
    }

    public void updateConditions() {
        switch (weatherTower.getWeather(this.coordinates)) {
        case "SUN":
            System.out.println(String.format("%s#%s(%d): I can see clearly now the SUN is out!", this, getFlyableName(), getFlyableID()));
            this.coordinates.changeLatitude(10, "+");
            try {
                this.coordinates.changeHeight(2, "+");
            } catch (HeightTooLowException ex) {
                System.out.println(String.format("%s#%s(%d): MayDay!! Mayday!! JetPlane has reached the ground!", this, getFlyableName(), getFlyableID()));
            }
            break;
        case "RAIN":
            System.out.println(String.format("%s#%s(%d): Its raining its pouring", this, getFlyableName(), getFlyableID()));
            this.coordinates.changeLatitude(5, "+");
            break;
        case "FOG":
            System.out.println(String.format("%s#%s(%d): Damn fog is messing up my vision", this, getFlyableName(), getFlyableID()));
            this.coordinates.changeLatitude(1, "+");
            break;
        case "SNOW":
            System.out.println(String.format("%s#%s(%d): Mayday the snow is here", this, getFlyableName(), getFlyableID()));
            try {
                this.coordinates.changeHeight(7, "-");
            } catch (HeightTooLowException ex) {
                System.out.println(String.format("%s#%s(%d): MayDay!! Mayday!! JetPlane has reached the ground!", this, getFlyableName(), getFlyableID()));
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
    public String toString() {
        return "JetPlane";
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