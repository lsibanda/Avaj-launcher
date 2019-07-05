package lsibanda.provider;

import lsibanda.aircraft.Coordinates;

import java.util.Random;

public class WeatherProvider {
    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }

        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return weather[Math.abs(new Random().nextInt()) % 4];
    }

    private static WeatherProvider weatherProvider = null;
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
}
