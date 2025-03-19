package org.example.locationUtils;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter

public class Location implements Comparable<Location> {
    private String nume;
    LocationTypes locationType;

    @Override
    public int compareTo(Location location) {
        return this.nume.compareTo(location.nume);
    }

    @Override
    public String toString() {
        return "\n" + getNume() + " " + getLocationType().name();
    }
}
