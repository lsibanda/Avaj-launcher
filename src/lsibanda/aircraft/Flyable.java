package lsibanda.aircraft;


import lsibanda.tower.WeatherTower;

public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower WeatherTower);
}
