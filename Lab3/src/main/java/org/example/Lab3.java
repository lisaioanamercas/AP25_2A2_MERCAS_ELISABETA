package org.example;

import org.example.*;
import org.example.interfaces.*;
import org.example.models.*;
import org.example.airport.*;
import org.example.flight.*;
import java.time.*;
import java.util.*;

public class Lab3 {
    public static void main(String[] args) {
        Lab3 lab3 = new Lab3();
        lab3.compulsory();

        lab3.homework();

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

    public void homework() {
        Airport airport = new Airport("Aeroport Galati");
        Runway runway1 = new Runway(1);
        Runway runway2 = new Runway(2);
        airport.addRunway(runway1);
        airport.addRunway(runway2);

        Flight flight1 = new Flight(new Airliner("Boeing 777", 300, 12000), "FL123", LocalTime.of(10, 0), LocalTime.of(10, 30));
        Flight flight2 = new Flight(new Freighter("Cargo King", 60000), "FL456", LocalTime.of(10, 15), LocalTime.of(10, 45));
        Flight flight3 = new Flight(new Drone("Autonomous Drone", 8), "FL789", LocalTime.of(10, 40), LocalTime.of(11, 0));
        Set<Flight> flightList = new HashSet<>(Arrays.asList(flight1, flight2, flight3));

        SchedulingProblem problem = new SchedulingProblem(airport, flightList);
        FlightScheduler scheduler = new FlightScheduler();
        Map<Runway, Set<Flight>> scheduleMap = scheduler.scheduleFlights(problem);

        System.out.println("\n=== Programarea Zborurilor ===");
        for (Map.Entry<Runway, Set<Flight>> entry : scheduleMap.entrySet()) {
            Runway runway = entry.getKey();
            Set<Flight> flights = entry.getValue();

            System.out.println("Runway " + runway.getId() + ":");

            for (Flight flight : flights) {
                long duration = flight.getArrivalInterval().getStart()
                        .until(flight.getArrivalInterval().getEnd(), java.time.temporal.ChronoUnit.MINUTES);
                System.out.println("  - " + flight.getFlightNumber()
                        + " (" + flight.getArrivalInterval().getStart()
                        + " - " + flight.getArrivalInterval().getEnd()
                        + ", " + duration + " min)");
            }
        }
    }
}
