package lsibanda.aircraft;

public class Coordinates {
    Coordinates(int longitude, int latitude, int height)
    {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height > 100 ? 100 : height;
        // if (height > 100)
    }

    public int getLongitude()
    {
        return this.longitude;
    }

    public int getLatitude()
    {
        return this.latitude;
    }

    public int getHeight()
    {
        return this.height;
    }

    private int longitude;
    private int latitude;
    private int height;
}
