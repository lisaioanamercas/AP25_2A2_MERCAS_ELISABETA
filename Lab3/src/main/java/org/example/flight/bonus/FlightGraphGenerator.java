package org.example.flight.bonus;

import org.example.airport.Runway;
import org.example.flight.Flight;

import java.io.IOException;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.*;
import java.util.*;

public class FlightGraphGenerator {
    //Fun Fact: folosesc static pentru ca nu am nevoie de obiecte propriu zise in clasa asta. ca metoda sa poata sa fie apelata direct, fara a fi nevoie de crearea unui obiect de timpul FlightGraphGenerator
    public static List<Flight> loadFlights(String filePath, double selectionProbability) throws IOException {
        List<Flight> selectedFlights = new ArrayList<>();
        Random random = new Random();

        List<String> lines = Files.readAllLines(Paths.get(filePath));

        for(String line : lines){
            String[] tokens = line.split(",");
            if(tokens.length <3){
                continue; //dam skip la linii invalide
            }

            String flightNumber = tokens[0];
            LocalTime startTime = LocalTime.parse(tokens[1]);
            LocalTime endTime = LocalTime.parse(tokens[2]);

            if(random.nextDouble() < selectionProbability){
                selectedFlights.add(new Flight(null, flightNumber, startTime, endTime));
            }
        }
        return selectedFlights;
    }

    public static List<Runway> loadRunways(String filePath, double selectionProbability) throws IOException {
        List<Runway> selectedRunways = new ArrayList<>();
        Random random = new Random();

        List<String> lines = Files.readAllLines(Paths.get(filePath));

        for(String line : lines){
            if(random.nextDouble() < selectionProbability){
                String token[] = line.split("Runway");
                if(token.length > 1){
                    int runwayId = Integer.parseInt(token[1].trim());
                    selectedRunways.add(new Runway(runwayId));
                }
            }
        }
        return selectedRunways;
    }
}
