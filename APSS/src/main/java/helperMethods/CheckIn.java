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

        System.out.println("****************************************************************");
        System.out.println("                          "+ passId + "                           ");
        System.out.println("   Departure                                        Arrival     ");
        System.out.println("   "+departure+"                                   \t\t"+arrival+"   ");
        System.out.println("                        ItenaryNumber                           ");
        System.out.println("                          "+itenaryNum+"                          ");
        System.out.println("****************************************************************");
    }
}
