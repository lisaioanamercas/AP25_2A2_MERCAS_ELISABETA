package org.example;
 import lombok.*;
 import org.example.Locations.*;

 import java.util.*;
 import java.util.stream.*;

public class Lab4 {
    public static void main(String[] args) {
        Lab4 lab4 = new Lab4();
        lab4.compulsory();

        System.out.println("\n---------------------------------------------\n ");

        lab4.homework();
    }

    public void compulsory(){
        List<Location> myLocationsForCompulosry = Arrays.asList(
                new Location("Galați", LocationType.ENEMY),
                new Location("Iași", LocationType.FRIENDLY),
                new Location("Căzănești", LocationType.NEUTRAL),
                new Location("Baia Mare", LocationType.ENEMY),
                new Location("Ciurea", LocationType.ENEMY),
                new Location("Tecuci", LocationType.FRIENDLY),
                new Location("București", LocationType.ENEMY),
                new Location("Vaslui", LocationType.FRIENDLY)
        );

        TreeSet<Location> friendlyLocations = myLocationsForCompulosry.stream().
                filter(location -> location.getLocationType() == LocationType.FRIENDLY).collect(Collectors.toCollection(TreeSet::new));

        System.out.println("Friendly locations: " + friendlyLocations);

        LinkedList<Location> enemyLocations = myLocationsForCompulosry.stream().
                filter(location -> location.getLocationType() == LocationType.ENEMY).collect(Collectors.toCollection(LinkedList::new));

        System.out.println("\nEnemy locations: " + enemyLocations);
    }

    public void homework(){

    }
}