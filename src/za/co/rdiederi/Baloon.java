package za.co.rdiederi;

import za.co.Exceptions.HeightTooLowException;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
        weatherTower = new WeatherTower();
    }

    public void updateConditions() {
        switch (weatherTower.getWeather(this.coordinates)) {
        case "SUN":
            System.out.println(String.format("%s#%s(%d): The sun is so hot!", this, getFlyableName(), getFlyableID()));
            try {
                this.coordinates.changeHeight(4, "+");
            } catch (HeightTooLowException ex) {
                System.out.println(String.format("%s#%s(%d): A baloon cannot operate at this height! Landing NOW!", this, getFlyableName(), getFlyableID()));
            }
            this.coordinates.changeLongitude(2, "+");
            break;
        case "RAIN":
            System.out.println(String.format("%s#%s(%d): Its raining oh no!! my baloon", this, getFlyableName(), getFlyableID()));
            try {
                this.coordinates.changeHeight(5, "-");
            } catch (HeightTooLowException ex) {
                System.out.println(String.format("%s#%s(%d): A baloon cannot operate at this height! Landing NOW!", this, getFlyableName(), getFlyableID()));
            }
            break;
        case "FOG":
            System.out.println(String.format("%s#%s(%d): I can't see because of this fog", this, getFlyableName(), getFlyableID()));
            try {
                this.coordinates.changeHeight(3, "-");
            } catch (HeightTooLowException ex) {
                System.out.println(String.format("%s#%s(%d): A baloon cannot operate at this height! Landing NOW!", this, getFlyableName(), getFlyableID()));
            }
            break;
        case "SNOW":
            System.out.println(String.format("%s#%s(%d): We're gonna crash!! The snow", this, getFlyableName(), getFlyableID()));
            try {
                this.coordinates.changeHeight(15, "-");
            } catch (HeightTooLowException ex) {
                System.out.println(String.format("%s#%s(%d): A baloon cannot operate at this height! Landing NOW!", this, getFlyableName(), getFlyableID()));
            }
            break;
        }
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public void registerTower(WeatherTower wt) {
        this.weatherTower = wt;
    }

    @Override
    public String toString() {
        return "Baloon";
    }

    public String getFlyableName() {
        return this.name;
    }

    public long getFlyableID() {
        return this.id;
    }
}