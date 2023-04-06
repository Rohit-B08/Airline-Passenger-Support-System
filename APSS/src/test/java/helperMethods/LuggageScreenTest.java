package helperMethods;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.ResultSet;
import database.initialDatabaseSetup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class LuggageScreenTest {
    LuggageScreen luggageScreen;

    @BeforeEach
    void setUp() {
        luggageScreen = new LuggageScreen("chAtEAUx45671234!");
    }

    @Test
    void getLuggageInfoTest() throws SQLException {
        String itineraryNum = "IT234";
        String output = luggageScreen.getLuggageInfo(itineraryNum);

        String expectedOutput = "-------------------- Luggage Info -------------------- \n";
        expectedOutput += "Bag Name \t Token Number \t Weight \t Fare\n";

        expectedOutput += String.format(" %-15s", "bag1") + String.format(" %-12s", 11) +
                String.format(" %-10s", 25) + String.format(" %-8s", 80.0)+ "\n";
        expectedOutput += String.format(" %-15s", "bag2") + String.format(" %-12s", 12) +
                String.format(" %-10s", 25) + String.format(" %-8s", 80.0)+ "\n";

        assertEquals(expectedOutput, output);
    }

    @Test
    void addBagTest() throws SQLException {
        int token = 0;
        int passId = 12001;
        String itineraryNum = "IT234";
        String bagName = "mock_bag";
        int weight = 25;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        luggageScreen.addBag(passId, itineraryNum, bagName, weight);

        ResultSet luggage = luggageScreen.conn.getLuggage(itineraryNum);
        while (luggage.next()) {
            if (Objects.equals(luggage.getString(3), bagName)) {
                token = luggage.getInt(1);
            }
        }
        luggageScreen.removeBag(token);

        String expectedOutput = "Bag added successfully!\r\n";
        expectedOutput += "Removed bag successfully!\r\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void removeBagTest() throws SQLException {
        int tokenNum = 19;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        luggageScreen.removeBag(tokenNum);
        luggageScreen.addBag(12007, "IT987", "bag1", 25);

        String expectedOutput = "Removed bag successfully!\r\n";
        expectedOutput += "Bag added successfully!\r\n";

        assertEquals(expectedOutput, outContent.toString());
    }
}