package helperMethods;

import database.initialDatabaseSetup;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LogInScreen {
    private final initialDatabaseSetup conn;
    public LogInScreen() {
        conn = new initialDatabaseSetup("rohit@2002");
    }

    public boolean validateLogIn(String usrName, String pass) throws SQLException {

        boolean found = false;
        ResultSet data;
        try{
            data = conn.passengerTable();
            while(data.next()) {
                if(data.getString(2).equals(usrName) && data.getString(3).equals(pass)) {
                    found = true;
                    break;
                }
            }
        }
        catch (SQLException e) {
            System.out.println("Something went wrong!");
        }
        return found;
    }

    public int getPassengerId(String user, String pass) throws SQLException {
        int passId = 0;
        ResultSet data = conn.passengerTable();
        while(data.next()) {
            if(data.getString(2).equals(user) && data.getString(3).equals(pass)) {
                passId = data.getInt(1);
                break;
            }
        }
        return passId;
    }
}
