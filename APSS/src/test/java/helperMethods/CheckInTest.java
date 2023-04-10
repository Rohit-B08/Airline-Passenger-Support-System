package helperMethods;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
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
    void checkInTest() throws SQLException, FileNotFoundException {
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

        String expectedOutput = "****************************************************************" + "\r\n"
                                + String.format("%27s", passengerId) + "\r\n"
                                + String.format("%7s", "Departure") + String.format("%41s", "Arrival") + "\r\n"
                                + String.format("%5s", departure) + String.format("%43s" , arrival) + "\r\n"
                                + String.format("%33s", "Itinerary Number") + "\r\n"
                                + String.format("%27s" , itineraryNum) + "\r\n"
                                + "****************************************************************" + "\r\n";

        assertEquals(expectedOutput, outContent.toString());

        checkIn.conn.resetDataBase();


    }

}