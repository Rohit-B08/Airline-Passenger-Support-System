package helperMethods;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class CheckInTest {
    CheckIn checkIn;
    @BeforeEach
    void setUp() {
        checkIn = new CheckIn("welcomepm3");
    }

    @Test
    void checkInTest() throws SQLException {
        String itineraryNum = "IT299";
        int passengerId = 0;
        String departure = "";
        String arrival = "";

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        checkIn.checkIn(itineraryNum);

        ResultSet boardingInfo = checkIn.conn.getBoardingInfo(itineraryNum);
        while(boardingInfo.next()){
            passengerId = boardingInfo.getInt(1);
            departure = boardingInfo.getString(2);
            arrival = boardingInfo.getString(3);
        }

        String expectedOutput = "****************************************************************\r\n";
        expectedOutput += "                          "+ passengerId + "                           \r\n";
        expectedOutput += "   Departure                                        Arrival     \r\n";
        expectedOutput += "   "+departure+"                                   \t\t"+arrival+"   \r\n";
        expectedOutput += "                        ItenaryNumber                           \r\n";
        expectedOutput += "                          " + itineraryNum + "                          \r\n";
        expectedOutput += "****************************************************************\r\n";

        assertEquals(expectedOutput, outContent.toString());
    }

}