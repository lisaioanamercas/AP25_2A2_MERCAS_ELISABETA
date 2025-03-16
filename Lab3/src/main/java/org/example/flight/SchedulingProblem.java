package org.example.flight;

import org.example.airport.Airport;
import java.util.Set;

public class SchedulingProblem {
    private Airport airport;
    private Set<Flight> flights;

    public SchedulingProblem(Airport airport, Set<Flight> flights){
        this.airport = airport;
        this.flights = flights;
    }

    public Airport getAirport(){
        return airport;
    }

    public Set<Flight> getFlights(){
        return flights;
    }
}
