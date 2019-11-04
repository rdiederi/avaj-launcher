package za.co.rdiederi;

import za.co.Exceptions.HeightTooLowException;
import za.co.Exceptions.InvalidCoordinateException;

public class Coordinates {
    private int longitude, latitude, height;

    public Coordinates() {
        this.height = 0;
        this.latitude = 0;
        this.longitude = 0;
    }

    public Coordinates(int longi, int lati, int height) throws InvalidCoordinateException{
        if (longi >= 0 && lati >= 0 && height >= 0)
        {
            this.height = height;
            this.longitude = longi;
            this.latitude = lati;
        }
        else
        {
            throw new InvalidCoordinateException("Coordinates must be positive");
        }
    }

    public int getHeight() {
        return height;
    }

    public int getLatitude() {

        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void changeLatitude(int i, String sign) {
        if (sign.equals("+")) {
            this.latitude += i;
        } else if (sign.equals("-")) {
            this.latitude -= i;
        }
    }

    public void changeLongitude(int i, String sign) {
        if (sign.equals("+")) {
            this.longitude += i;
        } else if (sign.equals("-")) {
            this.longitude -= i;
        }
    }

    public void changeHeight(int i, String sign) throws HeightTooLowException {
        if (sign.equals("+")) {
            if (this.height + i < 100) {
                this.height += i;
            } else {
                this.height = 100;
            }
        } else if (sign.equals("-")) {
            if (this.height - i > 0) {
                this.height -= i;
            } else {
                this.height = 0;
                throw new HeightTooLowException("Must land now");
            }
        }
    }
}