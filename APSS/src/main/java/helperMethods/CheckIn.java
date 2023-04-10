package helperMethods;

import database.initialDatabaseSetup;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckIn {
    initialDatabaseSetup conn;
    public CheckIn(String mysqlPass) {
        conn = new initialDatabaseSetup(mysqlPass);
    }

    public void checkIn(String itenaryNum) throws SQLException {
        ResultSet data = conn.getBoardingInfo(itenaryNum);
        int passId = 0;
        String departure = "";
        String arrival = "";

        while(data.next()){
         passId = data.getInt(1);
         departure = data.getString(2);
         arrival = data.getString(3);
        }

        conn.setCheckInTrue(itenaryNum);

        String output = "****************************************************************" + "\r\n"
                + String.format("%27s", passId) + "\r\n"
                + String.format("%7s", "Departure") + String.format("%41s", "Arrival") + "\r\n"
                + String.format("%5s", departure) + String.format("%43s" , arrival) + "\r\n"
                + String.format("%33s", "Itinerary Number") + "\r\n"
                + String.format("%27s" , itenaryNum) + "\r\n"
                + "****************************************************************";

        System.out.println(output);


    }
}
