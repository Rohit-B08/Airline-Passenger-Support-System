package helperMethods;

import classes.Luggage;
import database.initialDatabaseSetup;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LuggageScreen {

    initialDatabaseSetup conn;
    public LuggageScreen() {
        conn = new initialDatabaseSetup("000Jass##");
    }

    public String getLuggageInfo(String itenaryNum) throws SQLException {
        String result = "-------------------- Luggage Info -------------------- \n";
        ResultSet luggage = conn.getLuggage(itenaryNum);
        ArrayList<Luggage> luggageList = new ArrayList<>();
        Luggage lugTemp;

        while(luggage.next()){
            lugTemp = new Luggage(luggage.getInt(1), luggage.getInt(2), luggage.getString(3),
                    luggage.getDouble(4));
            luggageList.add(lugTemp);
        }
        for(int i =0; i<luggageList.size(); i++){
            result += luggageList.get(i).getName() + " " + luggageList.get(i).getTokenNo() + " "+ luggageList.get(i).getWeight() + "\n";
        }

        return result;
    }


}
