package classes;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class FlightScheduled {
    private String flightID;
    private String departure;
    private String arrival;
    private double fare;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    public FlightScheduled(String flightID, String departure, String arrival, double fare, LocalDateTime departureTime, LocalDateTime arrivalTime){
        this.flightID = flightID;
        this.departure = departure;
        this.arrival = arrival;
        this.fare = fare;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getFlightID() { return flightID; }
    public void setFlightID(String id) { this.flightID = id; }
    public String getDeparture() { return departure; }
    public void setDeparture(String departure) { this.departure = departure; }
    public String getArrival() { return arrival; }
    public void setArrival(String arrival) { this.arrival = arrival; }
    public double getFare() { return fare; }
    public void setFare(double fare) { this.fare = fare; }
    public LocalDateTime getDepartureTime() { return departureTime; }
    public void setDepartureTime(LocalDateTime departureTime) { this.departureTime = departureTime; }
    public LocalDateTime getArrivalTime() { return arrivalTime; }
    public void setArrivalTime() { this.arrivalTime = arrivalTime; }

}
