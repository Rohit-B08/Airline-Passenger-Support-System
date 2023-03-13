package classes;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class FlightBooked {
    private int id;
    private int flightNo;
    private LocalDateTime departure;
    private LocalDateTime arrival;
    private ArrayList<Luggage> luggage;
    private double fare;
    private Duration delay;

    public FlightBooked(int id, int flightNo, LocalDateTime departure, LocalDateTime arrival, ArrayList<Luggage> luggage, double fare) {
        this.id = id;
        this.flightNo = flightNo;
        this.departure = departure;
        this.arrival = arrival;
        int LUGGAGE_LIMIT = 3;
        if (luggage.size() <= LUGGAGE_LIMIT) {
            this.luggage = luggage;
        }
        else {
            System.out.println("luggage size must be <=3");
            System.exit(0);
        }
        this.delay = Duration.ZERO;
        this.fare = fare;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(int flightNo) {
        this.flightNo = flightNo;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }

    public ArrayList<Luggage> getLuggage() {
        return luggage;
    }

    public void setLuggage(ArrayList<Luggage> luggage) {
        this.luggage = luggage;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public Duration getDelay() {
        return delay;
    }

    public void setDelay(Duration delay) {
        this.delay = delay;
    }
}



