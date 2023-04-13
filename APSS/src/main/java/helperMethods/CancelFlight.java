package helperMethods;

import database.initialDatabaseSetup;

import java.sql.SQLException;

public class CancelFlight {
    initialDatabaseSetup conn;
    public CancelFlight(String mysqlPass) {
        conn = new initialDatabaseSetup(mysqlPass);
    }

    public void cancelFlight(String itenaryNo) throws SQLException {
        conn.cancelFlight(itenaryNo);
        System.out.println("Flight cancelled successfully!");
    }

}
