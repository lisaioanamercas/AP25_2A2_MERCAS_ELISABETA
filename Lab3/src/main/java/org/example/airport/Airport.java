package org.example.airport;

import java.util.*;

public class Airport {
    private String name;
    private List<Runway> runways = new ArrayList<>();

    public Airport(String name){
        this.name = name;
    }

    public void addRunway(Runway runway){
        runways.add(runway);
    }

    public List<Runway> getRunways(){
        return runways;
    }

    @Override
    public String toString(){
        return "Airport {name= " + name + ", runways= " + runways.size() + "}";
    }
}
