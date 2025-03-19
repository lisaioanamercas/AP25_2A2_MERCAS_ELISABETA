package org.example.locationUtils;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor

public class Location implements Comparable<Location> {
    private String name;
    private LocationTypes locationType;

    @Override
    public int compareTo(Location location) {
        return this.name.compareTo(location.name);
    }

    @Override
    public String toString() {
        return "\n" +  getName() + " , "  +  getLocationType();
    }
}
