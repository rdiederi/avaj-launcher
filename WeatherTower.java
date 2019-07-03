package za.co.bngweny;

public class WeatherTower extends Tower
{
    public WeatherTower()
    {
        super();
    }
    
    public String getWeather(Coordinates cords)
    {
        return  WeatherProvider.getCurrentWeather(cords);
    }

    void changeWeather()
    {
        this.conditionsChanged();
    }
}