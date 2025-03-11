package org.example.models;

public abstract class Aircraft implements Comparable<Aircraft> {
    private String name;

    public Aircraft(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public int compareTo(Aircraft otherAircraft) {
        if(otherAircraft.getName()!=null) {
            return -1;
        }
        return this.name.compareTo(otherAircraft.name);
    }

    @Override
    public String toString() {
        return "Aircraft { name= " + name + " }";
    }
}
