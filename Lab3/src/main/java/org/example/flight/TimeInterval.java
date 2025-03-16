package org.example.flight;

import org.example.flight.*;
import java.time.LocalTime;

public class TimeInterval extends Pair<LocalTime, LocalTime> {
    public TimeInterval(LocalTime start, LocalTime end) {
        super(start, end);
    }

    public LocalTime getStart() {
        return getFirst();
    }

    public LocalTime getEnd() {
        return getSecond();
    }
     @Override
    public String toString(){
        return "Interval: "+ getStart() + " - " + getEnd();
     }

}
