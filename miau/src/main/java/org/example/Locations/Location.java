package org.example.Locations;
import lombok.*;
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder

public class Location implements Comparable<Location> {
    private String name;
    LocationType locationType;

    public Location(String name, LocationType locationType) {
        this.name = name;
        this.locationType = locationType;
    }

    @Override
    public int compareTo(Location otherLocation) {
        return this.name.compareTo(otherLocation.name);
    }

    @Override
    public String toString() {
        return "\n" +  name + " " + locationType;
    }
}
