package org.example.models;

public class Drone extends Aircraft {
    private int batteryLife;

    public Drone(String name, int batteryLife) {
        super(name);
        this.batteryLife = batteryLife;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    @Override
    public String toString(){
        return "Drone { name= " + getName() + ", batteryLife= " + getBatteryLife() + " minutes }";
    }
}
