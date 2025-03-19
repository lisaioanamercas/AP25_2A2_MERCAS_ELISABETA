package org.example.flight.bonus;

import org.example.flight.*;
import java.util.*;


public class ConflictGraph {
    private Map<Flight, List<Flight>> adjacencyList = new HashMap<>();

    public ConflictGraph(List<Flight> flights){
        for(Flight flight : flights){
            adjacencyList.put(flight, new ArrayList<>());
        }

        for(int i=0; i<flights.size(); i++){
            for(int j=i+1; j<flights.size(); j++){
                if(flights.get(i).conflictsWith(flights.get(j))){
                    adjacencyList.get(flights.get(i)).add(flights.get(j));
                    adjacencyList.get(flights.get(j)).add(flights.get(i));
                }
            }
        }
    }


    public Map<Flight, List<Flight>> getAdjacencyList(){
        return adjacencyList;
    }

    public void printAdjacencyList(){
        for(Map.Entry<Flight, List<Flight>> entry : adjacencyList.entrySet())
        {
            System.out.print(entry.getKey().getFlightNumber() + " -> ");

            List<Flight> conflicts = entry.getValue();
            for(int i=0; i<conflicts.size(); i++){
                System.out.print(conflicts.get(i).getFlightNumber());
                if(i<conflicts.size()-1){
                    System.out.print(", "); //adaugam virgula intre ele dar nu dupa ultimul !!!
                }
            }
            System.out.println();
        }
    }
}
