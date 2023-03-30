package helperMethods;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class flightBookedScreenTest {
    flightBookedScreen flightBookedScreen;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        flightBookedScreen = new flightBookedScreen();
    }

    @Test
    void showAllBookedFlightsTest() throws SQLException {
        int passengerId = 12001;
        String output = flightBookedScreen.showAllBookedFlights(passengerId);

        String expectedOutput = "-------------------- Upcoming Booked Flight -------------------- \n";
        expectedOutput += 1 + ".) " + "IT234" + " \n";
        expectedOutput += 2 + ".) " + "IT299" + " \n";

        assertEquals(expectedOutput, output);
    }

    @Test
    void showScheduledflights() throws SQLException {

        String output = flightBookedScreen.showScheduledflights();

        String expectedOutput = "------------------------ Scheduled flights ------------------------\n";
        expectedOutput += "Flight Id \t Departure \t Arrival \t Fare \t Departure Time \t Arrival time \n";
        expectedOutput += "FL100" + "    "+ "Vancouver" + "    "+ "Toronto" + "    " +
                    350.00 + "    "+ "2023-03-09 15:00:00" + "    "+ "2023-03-09 17:00:00" + "\n";
        expectedOutput += "FL114" + "    "+ "Winnipeg" + "    "+ "Toronto" + "    " +
                350.00 + "    "+ "2023-03-13 14:00:00" + "    "+ "2023-03-13 16:00:00" + "\n";
        expectedOutput += "FL211" + "    "+ "Alberta" + "    "+ "Toronto" + "    " +
                550.00 + "    "+ "2023-03-16 10:00:00" + "    "+ "2023-03-16 12:00:00" + "\n";
        expectedOutput += "FL234" + "    "+ "Vancouver" + "    "+ "Toronto" + "    " +
                350.00 + "    "+ "2023-03-20 15:00:00" + "    "+ "2023-03-20 17:00:00" + "\n";
        expectedOutput += "FL236" + "    "+ "Toronto" + "    "+ "Vancouver" + "    " +
                350.00 + "    "+ "2023-03-22 16:00:00" + "    "+ "2023-03-22 18:00:00" + "\n";
        expectedOutput += "FL264" + "    "+ "Montreal" + "    "+ "Fredericton" + "    " +
                250.00 + "    "+ "2023-03-19 09:30:00" + "    "+ "2023-03-19 10:00:00" + "\n";
        expectedOutput += "FL268" + "    "+ "Moncton" + "    "+ "Toronto" + "    " +
                350.00 + "    "+ "2023-03-15 15:00:00" + "    "+ "2023-03-15 17:00:00" + "\n";
        expectedOutput += "FL284" + "    "+ "Vancouver" + "    "+ "Halifax" + "    " +
                650.00 + "    "+ "2023-03-10 15:00:00" + "    "+ "2023-03-10 18:00:00" + "\n";

        assertEquals(expectedOutput, output);
    }
}