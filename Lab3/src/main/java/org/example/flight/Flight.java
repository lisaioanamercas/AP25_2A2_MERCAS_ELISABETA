package org.example.flight;

import org.example.*;
import org.example.models.Aircraft;

import java.time.*;

public class Flight implements Comparable<Flight> {
    private Aircraft aircraft;
    private String flightNumber;
    private LocalTime arrivalStart;
    private LocalTime arrivalEnd;
    private TimeInterval arrivalInterval;

    public Flight(Aircraft aircraft, String  flightNumber, LocalTime arrivalStart, LocalTime arrivalEnd) {
        this.aircraft = aircraft;
        this.flightNumber = flightNumber;
        this.arrivalStart = arrivalStart;
        this.arrivalEnd = arrivalEnd;
        this.arrivalInterval = new TimeInterval(arrivalStart, arrivalEnd);
    }

    public LocalTime getArrivalStart() {
        return arrivalStart;
    }

    public LocalTime getArrivalEnd() {
        return arrivalEnd;
    }

    public TimeInterval getArrivalInterval() {
        return arrivalInterval;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public boolean conflictsWith(Flight other){
        return this.arrivalStart.isBefore(other.arrivalEnd) && this.arrivalEnd.isAfter(other.arrivalStart);
    }

    @Override
    public String toString() {
        return "Flight no. " + getFlightNumber() + ", arrival: " + arrivalStart + " - " + arrivalEnd;
    }

    @Override
    public int compareTo(Flight otherFlight) {
        return this.arrivalStart.compareTo(otherFlight.arrivalStart);//compare by start time
    }
}
