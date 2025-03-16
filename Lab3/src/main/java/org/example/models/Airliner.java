package org.example.models;

import org.example.interfaces.CargoCapable;
import org.example.interfaces.PassengerCapable;

public class Airliner extends Aircraft implements PassengerCapable, CargoCapable {
    private int seatCount;
    private double maximumPayLoad;

    public Airliner(String name, int seatCount, double maximumPayLoad) {
        super(name);
        this.seatCount = seatCount;
        this.maximumPayLoad = maximumPayLoad;
    }

    @Override
    public int getSeatCount() {
        return seatCount;
    }

    @Override
    public double getMaximumMoneyForCargoTransport() {
        return maximumPayLoad;
    }

    @Override
    public String toString(){
        return "Airliner {name= " + getName() + ", seats= " + getSeatCount() + ", maximumPayLoad= " + getMaximumMoneyForCargoTransport() + "}";
    }
}
