package com.parkinglot.observe;

import com.parkinglot.enums.SpotType;

import java.util.List;

public abstract class Observable {
    private List<Observer> observers;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(SpotType spotType, Integer bookingCount) {
        for(Observer o : observers) {
            o.update(spotType, bookingCount);
        }
    }
}
