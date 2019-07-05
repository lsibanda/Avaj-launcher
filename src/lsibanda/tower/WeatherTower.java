package lsibanda.tower;

import lsibanda.aircraft.Coordinates;
import lsibanda.provider.WeatherProvider;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    // changes to the package after testing
    public void changeWeather() {
        this.conditionsChanged();
    }
}
