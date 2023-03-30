package classes;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class FlightBooked extends Flight {
    private String itineraryNo;
    private ArrayList<Luggage> luggage;
    private boolean checkIn;

    public FlightBooked(String flightID, String departure, String arrival, double fare, String departureTime,
                        String arrivalTime,
                        String itineraryNo, ArrayList<Luggage> luggage) {
        super(flightID, departure, arrival, fare, departureTime, arrivalTime);
        this.itineraryNo = itineraryNo;
        final int LUGGAGE_LIMIT = 3;
        if (luggage.size() <= LUGGAGE_LIMIT) {
            this.luggage = luggage;
        } else {
            System.out.println("luggage size must be <= " + LUGGAGE_LIMIT);
            System.exit(0);
        }
        this.checkIn = false;
    }

    public String getItineraryNo() {
        return itineraryNo;
    }

    public void setItineraryNo(String itineraryNo) {
        this.itineraryNo = itineraryNo;
    }

    public ArrayList<Luggage> getLuggage() {
        return luggage;
    }

    public void setLuggage(ArrayList<Luggage> luggage) {
        this.luggage = luggage;
    }


    public boolean isCheckIn() {
        return checkIn;
    }

    public void setCheckIn(boolean checkIn) {
        this.checkIn = checkIn;
    }

    public double getFare(){
        double fare = super.getFare();
        for(int i = 0; i< luggage.size(); i++){
            fare += luggage.get(i).getLuggFare();
        }
        return fare;
    }

    public int getNumOfBags(){
        return luggage.size();
    }
}



