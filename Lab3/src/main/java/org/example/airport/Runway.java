package org.example.airport;

public class Runway {
    private int id;

    public Runway(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }


    @Override
    public String toString(){
        return "Runway [id=" + id + "]";
    }
}