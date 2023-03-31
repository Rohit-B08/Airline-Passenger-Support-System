package helperMethods;

import classes.Flight;
import database.initialDatabaseSetup;
import javafx.util.converter.LocalDateTimeStringConverter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class flightBookedScreen {
    initialDatabaseSetup conn;
    public flightBookedScreen(String mysqlPass) {
        conn = new initialDatabaseSetup(mysqlPass);
    }

    public String showAllBookedFlights(int passgId) throws SQLException {
        String result = "-------------------- Upcoming Booked Flight -------------------- \n";
        ResultSet data = conn.getFlightBooked(passgId);
        int count =1;
        while(data.next()) {
            result += count + ".) " + data.getString(1) + " \n";
            count++;
        }
        return result;
    }

    public String showScheduledflights() throws SQLException {
        String flights = "------------------------ Scheduled flights ------------------------\n";
        flights += "Flight ID \t Departure \t\t Arrival \t\t Fare \t\t\t Departure Time \t\t\t Arrival time \n";
        ResultSet result = conn.allFlightsTable();
        Flight flight;
        while(result.next()) {
            flight = new Flight(result.getString(1), result.getString(2), result.getString(3),
                    result.getDouble(4), result.getString(5), result.getString(6));
            flights += String.format("  %-11s", flight.getFlightID()) + String.format("%-16s",flight.getDeparture()) + String.format("%-16s",flight.getArrival()) +
                    String.format("%-13s",flight.getFare()) + String.format("%-28s",flight.getDepartureTime()) + String.format("%-20s", flight.getArrivalTime()) + "\n";

        }
        return flights;

    }
}
