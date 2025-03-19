package org.example;

import com.github.javafaker.Faker;
import org.example.locationUtils.*;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Main lab4 = new Main();
        lab4.compulsory();

        System.out.println("\n-------------------------------\n");

        //lab4.homework();
    }

    public void compulsory() {
        List<Location> listOfLocations = Arrays.asList(
                new Location("Galați", LocationTypes.ENEMY),
                new Location("Iași", LocationTypes.FRIENDLY),
                new Location("Ploiești", LocationTypes.NEUTRAL),
                new Location("Vaslui", LocationTypes.ENEMY),
                new Location("Suceava", LocationTypes.FRIENDLY),
                new Location("București", LocationTypes.ENEMY),
                new Location("Brașov", LocationTypes.FRIENDLY),
                new Location("Sibiu", LocationTypes.NEUTRAL)
        );

        TreeSet<Location> friendlyLocations = listOfLocations.stream()
                .filter(location -> location.getLocationType() == LocationTypes.FRIENDLY)
                .collect(Collectors.toCollection(TreeSet::new));

        System.out.println("Friendly Locations: " + friendlyLocations + "\n");

        LinkedList<Location> enemyLocations = listOfLocations.stream()
                .filter(location -> location.getLocationType() == LocationTypes.ENEMY)
                .collect(Collectors.toCollection(LinkedList::new));

        System.out.println("Enemy Locations: " + enemyLocations);
    }
}