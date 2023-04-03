package driver;
import classes.Luggage;
import database.initialDatabaseSetup;
import helperMethods.*;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter your mysql password : ");
        String mysqlPass = sc.next();
        String username = "";
        String password = "";

        try {
            LogInScreen logIn = new LogInScreen(mysqlPass);
            while (true) {
                try{
                System.out.println("Enter enter 'exit' in username to exit the program.");
                System.out.print("Please enter your username : ");
                username = sc.next();
                if (username.equalsIgnoreCase("exit")) {
                    System.exit(0);
                }
                System.out.print("Please enter your password : ");
                password = sc.next();
                if (logIn.validateLogIn(username, password)) {
                    System.out.println("Successfully logged in!");
                    System.out.println("**************************************************************************");
                    while (true) {
                        String itineraryNum;
                        FlightBookedScreen bookedFlights = new FlightBookedScreen(mysqlPass);
                        System.out.println("Select from the options below :-");
                        System.out.println("1) Show Itinerary Number of upcoming booked flights");
                        System.out.println("2) Show all the scheduled flights");
                        System.out.println("3) Exit the program.");
                        System.out.print("Please enter the number related to the option above : ");
                        String input = sc.next();
                        if (input.equals("1")) {
                            while (true) {
                                int passId = logIn.getPassengerId(username, password);
                                System.out.println(bookedFlights.showAllBookedFlights(passId));
                                FlightInfoScreen flight = new FlightInfoScreen(mysqlPass);

                                System.out.print("Enter your Itineary Number for more details (enter 0 to go " +
                                        "back): ");
                                itineraryNum = sc.next();
                                if (itineraryNum.equals("0")) {
                                    break;
                                } else if (flight.validateItineraryNum(itineraryNum, passId)) {
                                    while (true) {
                                            System.out.println(flight.getFlightInfo(itineraryNum, flight.getFlightId(itineraryNum)));
                                            System.out.println("**************************************************************************");
                                            System.out.println("Select from the options below :-");
                                            System.out.println("1) Update my Luggage");
                                            System.out.println("2) CheckIn");
                                            System.out.println("3) Cancel the flight");
                                            System.out.println("4) To go back.");
                                            System.out.println("5) To exit");
                                            System.out.print("Please enter the number related to the option above : ");
                                            String input2 = sc.next();
                                            LuggageScreen lug = new LuggageScreen(mysqlPass);
                                            if (input2.equals("1")) {
                                                while (true) {
                                                        System.out.println(lug.getLuggageInfo(itineraryNum));
                                                        System.out.println("Select from the options below :-");
                                                        System.out.println("1) Add a new bag");
                                                        System.out.println("2) Remove a bag");
                                                        System.out.println("3) To go back.");
                                                        System.out.println("4) To exit");
                                                        System.out.print("Please enter the number related to the option above : ");
                                                        String input3 = sc.next();

                                                        if (input3.equals("1")) {

                                                                System.out.print("Please enter bag name : ");
                                                                String bagName = sc.next();
                                                                System.out.print("Please enter weight : ");
                                                                int weight = sc.nextInt();
                                                                lug.addBag(passId, itineraryNum, bagName, weight);

                                                        } else if (input3.equals("2")) {

                                                                System.out.print("Please enter the token number for your bag : ");
                                                                int tkNum = sc.nextInt();
                                                                lug.removeBag(tkNum);

                                                        } else if (input3.equals("3")) {
                                                            break;
                                                        } else if (input3.equals("4")) {
                                                            System.exit(0);
                                                        } else {
                                                            System.out.println("Invalid input!");
                                                            System.out.print("Please enter the number related to the option above : ");
                                                        }

                                                }

                                            } else if (input2.equals("2")) {
                                                CheckIn boarding = new CheckIn(mysqlPass);
                                                boarding.checkIn(itineraryNum);
                                            }

                                            else if(input2.equals("3")) {
                                                CancelFlight cancel = new CancelFlight(mysqlPass);
                                                cancel.cancelFlight(itineraryNum);
                                                break;
                                            }

                                            else if (input2.equals("4")) {
                                                break;
                                            } else if (input2.equals("5")) {
                                                System.exit(0);
                                            } else {
                                                System.out.print("Please enter a valid input!");

                                            }
                                    }
                                } else {
                                    System.out.println("Invalid Itinerary Number!");
                                }

                        }

                        } else if
                        (input.equals("2")) {
                            System.out.print(bookedFlights.showScheduledflights());
                        } else if
                        (input.equals("3")) {
                            System.exit(0);
                        } else {
                            System.out.print("Please enter a valid input!");
                        }

                }

                } else {
                    System.out.println("Please enter correct username and password!");
                }
            }
                catch(Exception e) {
                    System.out.println("Please enter correct input type!");
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
