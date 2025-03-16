package org.example.flight;

import org.example.airport.*;
import org.example.flight.*;
import java.util.*;

public class FlightScheduler {
    public Map<Runway, Set<Flight>> scheduleFlights(SchedulingProblem problem){
        Set<Flight> flights = new TreeSet<>(problem.getFlights());

        List<Runway> runways = problem.getAirport().getRunways();
        Map<Runway, Set<Flight>> schedule = new HashMap<>();

        for(Runway runway : runways){
            schedule.put(runway, new TreeSet<>());
        }

        for(Flight flight : flights){
            for(Runway runway : runways){
                boolean conflict = false;

                for(Flight associatedFlight : schedule.get(runway)){
                    if(associatedFlight.conflictsWith(flight)){
                        conflict = true;
                        break;
                    }
                }

                if(!conflict){
                    schedule.get(runway).add(flight);
                    break;
                }
            }
        }
        return schedule;
    }
}
