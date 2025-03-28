package com.parkinglot.observe;

import com.parkinglot.enums.SpotType;

public abstract class Observer {
    Observable observable;

    public Observer(Observable observable) {
        this.observable = observable;
    }
    abstract public void update(SpotType spotType, Integer bookingCount);
}
