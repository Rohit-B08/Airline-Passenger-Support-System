package helperMethods;

import classes.Luggage;
import database.initialDatabaseSetup;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LuggageScreen {

    initialDatabaseSetup conn;
    public LuggageScreen() {
        conn = new initialDatabaseSetup("welcomepm3");
    }

    public String getLuggageInfo(String itenaryNum) throws SQLException {
        String result = "-------------------- Luggage Info -------------------- \n";
        result += "Bag Name \t Token Number \t Weight \t Fare\n";
        ResultSet luggage = conn.getLuggage(itenaryNum);
        ArrayList<Luggage> luggageList = new ArrayList<>();
        Luggage lugTemp;

        while(luggage.next()){
            lugTemp = new Luggage(luggage.getInt(1), luggage.getInt(2), luggage.getString(3),
                    luggage.getDouble(4));
            luggageList.add(lugTemp);
        }
        for(int i =0; i<luggageList.size(); i++){
            result += luggageList.get(i).getName() + "\t\t  " + luggageList.get(i).getTokenNo() + "\t\t\t\t"+
                    luggageList.get(i).getWeight() + "\t\t  " + luggageList.get(i).getLuggFare()+ "\n";
        }

        return result;
    }

    public void addBag(int passId, String itenaryNum, String bagName, int weight) throws SQLException {
        ResultSet luggage = conn.luggageTable();
        int token = 0;
        while(luggage.next()) {
//            luggage.last();
            token = luggage.getInt(1);
//            break;
        }
        token++;
        ResultSet luggagels = conn.getLuggage(itenaryNum);
        ArrayList<Luggage> luggageList = new ArrayList<>();
        Luggage lugTemp;

        while(luggagels.next()){
            lugTemp = new Luggage(luggagels.getInt(1), luggagels.getInt(2), luggagels.getString(3),
                    luggagels.getDouble(4));
            luggageList.add(lugTemp);
        }
        if(luggageList.size() < 3) {
            conn.addToLuggage(token, passId, itenaryNum, weight, bagName, 80);
            System.out.println("Bag added successfully!");
        }
        else {
            System.out.println("Three bags already exist. Cannot add more bags!");
        }

    }

    public void removeBag(int tokenNum) throws SQLException {
        boolean exist = false;
        ResultSet resultSet = conn.luggageTable();
        while(resultSet.next()) {
            if(resultSet.getInt(1) == tokenNum) {
                exist = true;
                break;
            }
        }

        if(exist) {
            conn.removeFromLuggage(tokenNum);
            System.out.println("Removed bag successfully!");
        }
        else {
            System.out.println("Bag doesn't exist!");
        }
    }


}
