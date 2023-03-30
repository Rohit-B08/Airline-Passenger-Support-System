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
    public flightBookedScreen() {
        conn = new initialDatabaseSetup("welcomepm3");
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
        flights += "Flight ID \t Departure \t Arrival \t Fare \t Departure Time \t Arrival time \n";
        ResultSet result = conn.allFlightsTable();
        Flight flight;
        while(result.next()) {
            flight = new Flight(result.getString(1), result.getString(2), result.getString(3),
                    result.getDouble(4), result.getString(5), result.getString(6));
            flights += flight.getFlightID() + "    "+ flight.getDeparture() + "    "+ flight.getArrival() + "    " +
                    flight.getFare() + "    "+ flight.getDepartureTime() + "    "+ flight.getArrivalTime() + "\n";

        }
        return flights;

    }
}
