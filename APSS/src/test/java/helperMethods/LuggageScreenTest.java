package helperMethods;

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
        luggageScreen = new LuggageScreen();
    }

    @Test
    void getLuggageInfoTest() throws SQLException {
        String itineraryNum = "IT234";
        String output = luggageScreen.getLuggageInfo(itineraryNum);

        String expectedOutput = "-------------------- Luggage Info -------------------- \n";
        expectedOutput += "Bag Name \t Token Number \t Weight \t Fare\n";
        expectedOutput += "bag1" + "\t\t  " + 11 + "\t\t\t\t"+
                25 + "\t\t  " + 80.00 + "\n";
        expectedOutput += "bag2" + "\t\t  " + 12 + "\t\t\t\t"+
                25 + "\t\t  " + 80.00 + "\n";

        assertEquals(expectedOutput, output);
    }

//    @Test
//    void addBagTest() throws SQLException {
//        int token = 0;
//        int passId = 12001;
//        String itineraryNum = "IT234";
//        String bagName = "mock_bag";
//        int weight = 25;
//
//        boolean output = luggageScreen.addBag(passId, itineraryNum, bagName, weight);
//        boolean expectedOutput = true;
//
//        assertEquals(expectedOutput, output);
//
//        ResultSet luggage = luggageScreen.conn.getLuggage(itineraryNum);
//        while (luggage.next()) {
//            if (Objects.equals(luggage.getString(5), bagName)) {
//                token = luggage.getInt(1);
//            }
//        }
//        luggageScreen.removeBag(token);
//    }

//    @Test
//    void removeBagTest() throws SQLException {
//        int tokenNum = 19;
//        boolean output = luggageScreen.removeBag(tokenNum);
//        boolean expectedOutput = true;
//
//        assertEquals(expectedOutput, output);
//
//        luggageScreen.addBag(12007, "IT987", "bag1", 25);
//    }
}