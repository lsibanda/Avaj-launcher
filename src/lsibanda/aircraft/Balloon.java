package lsibanda.aircraft;

import lsibanda.main.WriteFile;
import lsibanda.tower.WeatherTower;

public class Balloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Balloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String identifier = "Balloon#" + this.name + "(" +  this.id + ")";


        switch(weatherTower.getWeather(this.coordinates)) {

            case "SUN":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude() + 2,
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() + 4
                );
                WriteFile.getWriteFile().writetofile(identifier + ": Balloon melt");
                break;
            case "RAIN":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() - 5
                );
                WriteFile.getWriteFile().writetofile(identifier + ": Balloon wet");
                break;
            case "FOG":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() - 3
                );
                WriteFile.getWriteFile().writetofile(identifier + ": Balloon no see");
                break;
            case "SNOW":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() - 15
                );
                WriteFile.getWriteFile().writetofile(identifier + ": Balloon cold");
                break;
        }

        if (this.coordinates.getHeight() <= 0)
        {
            WriteFile.getWriteFile().writetofile(identifier + "landing");
            this.weatherTower.unregister(this);
            WriteFile.getWriteFile().writetofile("Tower says: " +
                    identifier + " unregistered from the weather tower.");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        WriteFile.getWriteFile().writetofile("Balloon#" +
                this.name + "(" + this.id + ") registered to the tower.");
    }
}
