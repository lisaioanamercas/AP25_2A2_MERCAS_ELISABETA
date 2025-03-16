package org.example.airport;

public class Runway {
    private int id;
    private String name;

    public Runway(int id){
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public String getRunwayName(){
        return name;
    }

    @Override
    public String toString(){
        return "Runway [id=" + id + "]";
    }
}