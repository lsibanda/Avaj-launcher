package lsibanda.aircraft;

import lsibanda.main.WriteFile;
import lsibanda.tower.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String identifier = "JetPlane#" + this.name + "(" + this.id + ")";

        switch(weatherTower.getWeather(this.coordinates)) {
            case "SUN":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude() + 10,
                        this.coordinates.getHeight() + 2
                );
                WriteFile.getWriteFile().writetofile(identifier + ": It's hot enough to cook an egg on the dash right now!");
                break;
            case "RAIN":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude() + 5,
                        this.coordinates.getHeight()
                );
                WriteFile.getWriteFile().writetofile(identifier + ": It's raining. Better watch out for lightning.");
                break;
            case "FOG":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude() + 1,
                        this.coordinates.getHeight()
                );
                WriteFile.getWriteFile().writetofile(identifier + ": These high beams aren't really helping, I can't see anything!");
                break;
            case "SNOW":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude() - 7,
                        this.coordinates.getHeight()
                );
                WriteFile.getWriteFile().writetofile(identifier + ": OMG! Winter is coming!");
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
        WriteFile.getWriteFile().writetofile("JetPlane#" + this.name + "(" + this.id + ") registered to weather tower.");
    }

}
