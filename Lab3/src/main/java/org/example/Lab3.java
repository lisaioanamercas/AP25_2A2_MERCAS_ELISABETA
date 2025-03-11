package org.example;

import org.example.*;
import org.example.interfaces.CargoCapable;
import org.example.models.Airliner;
import org.example.models.Drone;
import org.example.models.Freighter;

public class Lab3 {
    public static void main(String[] args) {
        Lab3 lab3 = new Lab3();
        lab3.compulsory();
    }

    public void compulsory(){
        Airliner airliner = new Airliner("Boeing 888", 400, 10000);
        Freighter freighter = new Freighter("CargoLux 2903", 50000);
        Drone drone = new Drone("Drona Dorna", 5);

        CargoCapable[] cargoAircraftsArray = {freighter, airliner};

        System.out.println("Cargo Capable Aircrafts: ");
        for(CargoCapable cargo : cargoAircraftsArray){
            System.out.println(cargo);
        }
    }
}
