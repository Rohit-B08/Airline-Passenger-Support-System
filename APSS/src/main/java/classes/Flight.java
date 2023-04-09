package classes;

import database.initialDatabaseSetup;

import java.time.Duration;
import java.time.LocalDateTime;

public class Flight {
    private String flightID;
    private String departure;
    private String arrival;
    private double fare;
    private String departureTime;
    private String arrivalTime;

    public Flight(String flightID, String departure, String arrival, double fare, String departureTime,
                  String arrivalTime){
        this.flightID = flightID;
        this.departure = departure;
        this.arrival = arrival;
        this.fare = fare;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Flight() { }
    public String getFlightID() { return flightID; }

    public void setFlightID(String id) { this.flightID = id; }

    public String getDeparture() { return departure; }

    public void setDeparture(String departure) { this.departure = departure; }

    public String getArrival() { return arrival; }

    public void setArrival(String arrival) { this.arrival = arrival; }

    public double getFare() { return fare; }

    public void setFare(double fare) { this.fare = fare; }

    public String getDepartureTime() { return departureTime; }

    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }

    public String getArrivalTime() { return arrivalTime; }

    public void setArrivalTime(String arrivalTime) { this.arrivalTime = arrivalTime; }

}
