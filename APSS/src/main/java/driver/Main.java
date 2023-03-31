package driver;
import classes.Luggage;
import database.initialDatabaseSetup;
import helperMethods.FlightInfoScreen;
import helperMethods.LogInScreen;
import helperMethods.LuggageScreen;
import helperMethods.flightBookedScreen;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, FileNotFoundException {
        String username = "";
        String password = "";
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        try{
            LogInScreen logIn = new LogInScreen();
            while(run) {
                System.out.print("Please enter your username : ");
                username = sc.next();
                System.out.print("Please enter your password : ");
                password = sc.next();
                if(logIn.validateLogIn(username, password)) {
                    run = false;
                }
                else{
                    System.out.println("Please enter correct username and password!");
                }
            }
            if(!run) {
                System.out.println("Successfully logged in!");
                System.out.println("**************************************************************************");
                boolean valid = true;
                while(valid) {
                    String itenaryNum;
                    flightBookedScreen bookedFlights = new flightBookedScreen();
                    System.out.println("Select from the options below :-");
                    System.out.println("1) Show itinary number of upcoming booked flights");
                    System.out.println("2) Show all the scheduled flights");
                    System.out.print("Please enter the number related to the option above : ");
                    int input = sc.nextInt();
                    if(input == 1) {
                        int passId = logIn.getPassengerId(username, password);
                        System.out.println(bookedFlights.showAllBookedFlights(passId));
//                        valid = false;
                        FlightInfoScreen flight = new FlightInfoScreen();
                        boolean validItenaryNum = true;
                        while(validItenaryNum){
                            System.out.print("Enter your Itineary Number for more details: ");
                            itenaryNum = sc.next();
                            if(flight.validateItenaryNum(itenaryNum, passId)){
                                System.out.println(flight.getFlightInfo(itenaryNum, flight.getFlightId(itenaryNum)));
                                validItenaryNum = false;
                            }
                            else{
                                System.out.println("Invalid Itenary Number!");

                            }
                        }

                    }
                    else if (input == 2) {
                        System.out.print(bookedFlights.showScheduledflights());
//                        valid = false;
                    }
                    else {
                        System.out.print("Please enter a valid input!");
                    }
                }

                System.out.println("**************************************************************************");
                System.out.println("Select from the options below :-");
                System.out.println("1) Update my Luggage");
                System.out.println("2) CheckIn");
                System.out.print("Please enter the number related to the option above : ");
                int input2 = sc.nextInt();
                LuggageScreen lug = new LuggageScreen();
                if(input2 == 1){


                }
                else if(input2 == 2){
                    System.out.println("************************************************************");
                    System.out.println("                  " );

                }
                else{
                    System.out.print("Please enter a valid input!");
                }

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
//        initialDatabaseSetup conn = new initialDatabaseSetup("rohit@2002");
//        conn.initializeDatabase();
    }
}
