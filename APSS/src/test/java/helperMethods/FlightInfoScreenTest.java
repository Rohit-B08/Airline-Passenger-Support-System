package helperMethods;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class FlightInfoScreenTest {
    FlightInfoScreen flightInfoScreen;
    @BeforeEach
    void setUp() {
        flightInfoScreen = new FlightInfoScreen("chAtEAUx45671234!");
    }

    @ParameterizedTest
    @CsvSource({"IT234, 12001, true", "IT299, 12001, true", "IT123, 12002, true", "IT345, 12003, true",
                "IT657, 12004, true", "IT543, 12005, true", "IT987, 12007, true"})
    void validateValidItineraryNumTest(String itineraryNum, int passengerId, boolean expectedOutput) throws SQLException {
        boolean output = flightInfoScreen.validateItineraryNum(itineraryNum, passengerId);
        assertEquals(expectedOutput, output);
    }

    @ParameterizedTest
    @CsvSource({"IT111, 12001, false", "IT222, 12001, false", "IT333, 12002, false", "IT444, 12003, false",
            "IT555, 12004, false", "IT666, 12005, false", "IT777, 12007, false"})
    void validateInvalidItineraryNumTest(String itineraryNum, int passengerId, boolean expectedOutput) throws SQLException {
        boolean output = flightInfoScreen.validateItineraryNum(itineraryNum, passengerId);
        assertEquals(expectedOutput, output);
    }

    @Test
    void getCorrectFlightIdTest() throws SQLException {
        String itineraryNum = "IT234";
        String flightId = "FL268";
        String output = flightInfoScreen.getFlightInfo(itineraryNum, flightId);

        String expectedOutput = "-------------------- Flight Info -------------------- \n";
        expectedOutput += "Itinerary Num:    " + "IT234" + "\n";
        expectedOutput += "Departure:      " + "Moncton" + "\n";
        expectedOutput += "Arrival:        " + "Toronto" + "\n";
        expectedOutput += "Fare:           " + 510.00 + "\n";
        expectedOutput += "Departure Time: " + "2023-03-15 15:00:00" + "\n";
        expectedOutput += "Arrival Time:   " + "2023-03-15 17:00:00"+ "\n";
        expectedOutput += "Luggage:        " + 2 + "\n";

        assertEquals(expectedOutput, output);
    }
}