package helperMethods;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class FlightBookedScreenTest {
    FlightBookedScreen flightBookedScreen;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        flightBookedScreen = new FlightBookedScreen("welcomepm3");
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
        expectedOutput += "Flight ID \t Departure \t\t Arrival \t\t Fare \t\t\t Departure Time \t\t\t Arrival time \n";
        expectedOutput += String.format("  %-11s", "FL100") + String.format("%-16s","Vancouver") + String.format("%-16s","Toronto") +
                String.format("%-13s",350.00) + String.format("%-28s", "2023-03-09 15:00:00") + String.format("%-20s", "2023-03-09 17:00:00") + "\n";
        expectedOutput += String.format("  %-11s", "FL114") + String.format("%-16s","Winnipeg") + String.format("%-16s","Toronto") +
                String.format("%-13s",350.00) + String.format("%-28s", "2023-03-13 14:00:00") + String.format("%-20s", "2023-03-13 16:00:00") + "\n";
        expectedOutput += String.format("  %-11s", "FL211") + String.format("%-16s","Alberta") + String.format("%-16s","Toronto") +
                String.format("%-13s",550.00) + String.format("%-28s", "2023-03-16 10:00:00") + String.format("%-20s", "2023-03-16 12:00:00") + "\n";
        expectedOutput += String.format("  %-11s", "FL234") + String.format("%-16s","Vancouver") + String.format("%-16s","Toronto") +
                String.format("%-13s",350.00) + String.format("%-28s", "2023-03-20 15:00:00") + String.format("%-20s", "2023-03-20 17:00:00") + "\n";
        expectedOutput += String.format("  %-11s", "FL236") + String.format("%-16s","Toronto") + String.format("%-16s","Vancouver") +
                String.format("%-13s",350.00) + String.format("%-28s", "2023-03-22 16:00:00") + String.format("%-20s", "2023-03-22 18:00:00") + "\n";
        expectedOutput += String.format("  %-11s", "FL264") + String.format("%-16s","Montreal") + String.format("%-16s","Fredericton") +
                String.format("%-13s",250.00) + String.format("%-28s", "2023-03-19 09:30:00") + String.format("%-20s", "2023-03-19 10:00:00") + "\n";
        expectedOutput += String.format("  %-11s", "FL268") + String.format("%-16s","Moncton") + String.format("%-16s","Toronto") +
                String.format("%-13s",350.00) + String.format("%-28s", "2023-03-15 15:00:00") + String.format("%-20s", "2023-03-15 17:00:00") + "\n";
        expectedOutput += String.format("  %-11s", "FL284") + String.format("%-16s","Vancouver") + String.format("%-16s","Halifax") +
                String.format("%-13s",650.00) + String.format("%-28s", "2023-03-10 15:00:00") + String.format("%-20s", "2023-03-10 18:00:00") + "\n";

        assertEquals(expectedOutput, output);
    }
}