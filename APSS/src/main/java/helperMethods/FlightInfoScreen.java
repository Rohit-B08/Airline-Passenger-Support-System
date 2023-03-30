package helperMethods;

import classes.FlightBooked;
import classes.Luggage;
import database.initialDatabaseSetup;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FlightInfoScreen {
    private final initialDatabaseSetup conn;
    public FlightInfoScreen() {
        conn = new initialDatabaseSetup("rohit@2002");
    }


    public boolean validateItenaryNum(String itenaryNum, int passengerId) throws SQLException {
        boolean valid = false;
        ResultSet data = conn.getFlightBooked(passengerId);
        while(data.next()){
            if(data.getString(1).equals(itenaryNum)){
                valid = true;
                break;
            }
        }
        return valid;
    }
    public String getFlightInfo(String itenaryNum, String flightId) throws SQLException {
        String result = "-------------------- Flight Info -------------------- \n";
        ResultSet luggage = conn.getLuggage(itenaryNum);
        ResultSet flightInfo = conn.getFlightInfo(flightId);
        FlightBooked flight;
        ArrayList<Luggage> luggageList = new ArrayList<>();
        Luggage lugTemp;

        while(luggage.next()){
            lugTemp = new Luggage(luggage.getInt(1), luggage.getInt(2), luggage.getString(3),
                    luggage.getDouble(4));
            luggageList.add(lugTemp);
        }

        while(flightInfo.next()){
            flight = new FlightBooked(flightInfo.getString(1), flightInfo.getString(2),
                    flightInfo.getString(3), flightInfo.getDouble(4), flightInfo.getString(5),
                    flightInfo.getString(6), flightInfo.getString(7), luggageList);

            result += "Itenary Num:    " + flight.getItineraryNo() + "\n";
            result += "Departure:      " + flight.getDeparture()+ "\n";
            result += "Arrival:        " + flight.getArrival() + "\n";
            result += "Fare:           " + flight.getFare()+ "\n";
            result += "Departure Time: " + flight.getDepartureTime()+ "\n";
            result += "Arrival Time:   " + flight.getArrivalTime()+ "\n";
            result += "Luggage:        " + flight.getNumOfBags()+ "\n";

            if(flightInfo.getInt(8) == 1){
                flight.setCheckIn(true);
            }
            else{
                flight.setCheckIn(false);
            }
        }

        return result;

    }

    public String getFlightId(String itenaryNum) throws SQLException {
        String flightId = "";
        ResultSet flightIds = conn.getFlightId(itenaryNum);
        while(flightIds.next()){
           flightId = flightIds.getString(1);
        }
        return flightId;
    }


}
