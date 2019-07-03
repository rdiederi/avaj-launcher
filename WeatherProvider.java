package za.co.bngweny;

public class WeatherProvider
{
    private static String weather[] = {"RAIN", "FOG", "SUN", "SNOW"};
    
    public WeatherProvider()
    {
    }
    
    public static WeatherProvider getProvider()
    {
        return new WeatherProvider();
    }

    public static String getCurrentWeather(Coordinates c) 
    {
        //Must take into account point coordinates
        int den = c.getHeight() + c.getLatitude() + c.getLongitude();
        den = den + (int)(Math.random() * 4);
        return weather[den % 4];
    }

}