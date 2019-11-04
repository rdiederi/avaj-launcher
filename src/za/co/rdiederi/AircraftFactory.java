package za.co.rdiederi;

import za.co.Exceptions.InvalidCoordinateException;
import za.co.Exceptions.TypeNotFoundException;

public class AircraftFactory {
    AircraftFactory() {
    }

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
            throws TypeNotFoundException, InvalidCoordinateException {
        Flyable theOne;
        switch (type) {
        case "Helicopter":
            theOne = new Helicopter(name, new Coordinates(longitude, latitude, height));
            break;
        case "JetPlane":
            theOne = new JetPlane(name, new Coordinates(longitude, latitude, height));
            break;
        case "Baloon":
            theOne = new Baloon(name, new Coordinates(longitude, latitude, height));
            break;
        default:
            throw new TypeNotFoundException("Type not Found");
        }
        return theOne;
    }

}