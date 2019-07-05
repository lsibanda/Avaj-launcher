package lsibanda.tower;


import lsibanda.aircraft.Flyable;

import java.util.*;

public abstract class Tower {

    private List<Flyable> observers = new ArrayList<Flyable>();
    private List<Flyable> landed = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        landed.add(flyable);
    }

    protected void conditionsChanged() {
        for (Flyable flight : this.observers) {
            flight.updateConditions();
        }

        this.observers.removeAll(this.landed);
        this.landed = new ArrayList<Flyable>();
    }
}
