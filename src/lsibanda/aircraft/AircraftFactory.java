package lsibanda.aircraft;

public abstract class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        switch (type) {
            case "Balloon":
                return new Balloon(name, coordinates);
            case "Helicopter":
                return new Helicopter(name, coordinates);
            case "JetPlane":
                return new JetPlane(name, coordinates);
            default:
                System.out.println("Bad aircraft type");
                System.exit(1);
        }
        return null;
    }

}