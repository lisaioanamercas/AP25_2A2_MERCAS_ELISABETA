package org.example.flight.bonus;

import org.example.flight.*;
import org.example.airport.*;
import java.util.*;
import lombok.*;

public class ColoringProblemForScheduling {

    public Map<Flight, Runway> assignFlightstoRunways(List<Flight> flights, List<Runway> runways) {
        ConflictGraph conflictGraph = new ConflictGraph(flights);
        Map<Flight, Runway> flightAssignments = new HashMap<>();

        // SOrtez zboruri in functie de nr de conflicte descrescator
        List<Flight> sortedFlights = new ArrayList<>(flights);
        sortedFlights.sort(Comparator.comparingInt(f -> conflictGraph.getAdjacencyList().get(f).size()).reversed());

        // Colorare echitabila
        Map<Flight, Integer> flightColors = new HashMap<>();
        Map<Integer, Runway> colorToRunway = new HashMap<>();
        int maxFlightsPerRunway = (int) Math.ceil((double) flights.size() / runways.size());

        for (Flight flight : sortedFlights) {
            Set<Integer> usedColors = new HashSet<>();

            // Care culori sunt folosite pentru zboruri in conflict
            for (Flight neighbor : conflictGraph.getAdjacencyList().get(flight)) {
                if (flightColors.containsKey(neighbor)) {
                    usedColors.add(flightColors.get(neighbor));
                }
            }

            // Gasesc o culoare disponibila
            int assignedColor = 0;
            while (usedColors.contains(assignedColor) ||
                    (colorToRunway.containsKey(assignedColor) &&
                            getRunwayUsageCount(flightAssignments, colorToRunway.get(assignedColor)) >= maxFlightsPerRunway)) {
                assignedColor++;
            }

            flightColors.put(flight, assignedColor);

            // Daca culoarea nu are un runway assigned atunci ghinion
            if (!colorToRunway.containsKey(assignedColor)) {
                if (assignedColor < runways.size()) {
                    colorToRunway.put(assignedColor, runways.get(assignedColor));
                } else {
                    // Daca e nevoie de mai multe runways uri le creez
                    Runway newRunway = new Runway(runways.size() + 1);
                    runways.add(newRunway);
                    colorToRunway.put(assignedColor, newRunway);
                }
            }

            // Assign :)
            flightAssignments.put(flight, colorToRunway.get(assignedColor));
        }

        return flightAssignments;
    }

    private long getRunwayUsageCount(Map<Flight, Runway> flightAssignments, Runway runway) {
        return flightAssignments.values().stream()
                .filter(r -> r.equals(runway))
                .count();
    }

}
