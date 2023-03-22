package classes;
import java.util.ArrayList;

public class Passenger {
    private String userName;
    private String password;
    private int passengerId;
    private ArrayList<FlightBooked> listOfBookedFlights;

    public Passenger(String userName, String password, int passengerId,ArrayList<FlightBooked> listOfBookedFlights ) {
        this.userName = userName;
        this.password = password;
        this.passengerId = passengerId;
        this.listOfBookedFlights = listOfBookedFlights;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public ArrayList<FlightBooked> getListOfBookedFlights() {
        return listOfBookedFlights;
    }

    public void setListOfBookedFlights(ArrayList<FlightBooked> listOfBookedFlights) {
        this.listOfBookedFlights = listOfBookedFlights;
    }
}
