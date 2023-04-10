package helperMethods;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class CancelFlightTest {
    CancelFlight cancelFlight;

    @BeforeEach
    void setUp() {
        cancelFlight = new CancelFlight("chAtEAUx45671234!");
    }

    @Test
    void cancelFlightTest() throws SQLException {
        int passengerId = 12002;
        String itineraryNum = "IT123";
        String flightId = "FL236";
        int checkIn = 1;

        int token = 15;
        int weight = 25;
        String name = "bag1";
        double luggageFare = 80.00;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        cancelFlight.cancelFlight(itineraryNum);

        cancelFlight.conn.addToFlightBooked(passengerId, itineraryNum, flightId, checkIn);
        cancelFlight.conn.addToLuggage(token, passengerId, itineraryNum, weight, name, luggageFare);

        String expectedOutput = "Flight cancelled successfully!\r\n";
    }
}