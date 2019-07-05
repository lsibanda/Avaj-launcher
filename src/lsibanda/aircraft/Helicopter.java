package lsibanda.aircraft;


import lsibanda.main.WriteFile;
import lsibanda.tower.WeatherTower;

import java.io.*;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String identifier = "Helicopter#" + this.name + "(" + this.id + ")";


        switch(weatherTower.getWeather(this.coordinates)) {
            case "SUN":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude() + 10,
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() + 2
                );
                WriteFile.getWriteFile().writetofile(" #Balloon: This is hot.");
                break;
            case "RAIN":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude() + 5,
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight()
                );
                WriteFile.getWriteFile().writetofile(identifier + ": It sure is wet outside!");
                break;
            case "FOG":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude() + 1,
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight()
                );
                WriteFile.getWriteFile().writetofile(identifier + ": It's hot enough to cook an egg on the dash right now!");
                break;
            case "SNOW":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() - 12
                );
                WriteFile.getWriteFile().writetofile(identifier + ": My rotor is going to freeze!");
                break;
        }

        if (this.coordinates.getHeight() <= 0)
        {
            WriteFile.getWriteFile().writetofile(identifier + " landing.");
            this.weatherTower.unregister(this);
            WriteFile.getWriteFile().writetofile("Tower says: " + identifier + " unregistered from the weather tower.");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        WriteFile.getWriteFile().writetofile("Helicopter#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
}


