package lsibanda.aircraft;

public abstract class Aircraft {
    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    private long nextId() {
        return (++idCounter);
    }

    protected long  id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;

}