package org.example.models;

import org.example.interfaces.*;
import org.example.models.*;

public class Freighter extends Aircraft implements CargoCapable{
    private double maximumPayLoad;

    public Freighter(String name, double maxPayLoad){
        super(name);
        this.maximumPayLoad = maxPayLoad;
    }

    @Override
    public double getMaximumMoneyForCargoTransport() {
        return maximumPayLoad;
    }

    @Override
    public String toString(){
        return "Freighter{ name= " + getName() + ", maximumPayLoad= " + maximumPayLoad + " }";
    }
}
