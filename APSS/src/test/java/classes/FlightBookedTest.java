package classes;

import classes.Flight;
import classes.FlightBooked;

import classes.Luggage;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
public class FlightBookedTest {
   private  FlightBooked flightBooked;
    private Luggage luggage;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        flightBooked = new FlightBooked();
        flightBooked.setFare(50);
        luggage = new Luggage(0, 0, "", 350.00);
        ArrayList<Luggage> luggageList = new ArrayList<Luggage>();
        luggageList.add(luggage);
        flightBooked.setLuggage(luggageList);

    }
    @Test
    void getFareTest() throws SQLException {
        double output = flightBooked.getFare();
        double expectedOutput = 400.00;

        assertEquals(expectedOutput, output);
    }
}