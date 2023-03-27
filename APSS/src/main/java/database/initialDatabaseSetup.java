package database;
import java.sql.*;
import java.io.*;
import java.util.Scanner;


public class initialDatabaseSetup {
    private final String url = "jdbc:mysql://localhost/";
    private final String user = "root";
    private String pass;

    public initialDatabaseSetup(String pass) {
        this.pass = pass;
    }


    public Connection setConnection() throws SQLException {
        Connection connection;

        connection = DriverManager.getConnection(url, user, pass);
        Statement stm = connection.createStatement();
        String showDatabase = "show databases";
        PreparedStatement preparedStatement = connection.prepareStatement(showDatabase);
        ResultSet result = preparedStatement.executeQuery();
        boolean exist = false;
        while(result.next()) {
            if((result.getString(1)).equalsIgnoreCase("APSS")) {
                exist = true;
            }
        }
        if(!exist) {
            String createDb = "create database APSS";
            stm.executeUpdate(createDb);
        }
        return connection;

    }

    public void initializeDatabase() throws SQLException, FileNotFoundException {
        File passenger = new File("APSS/src/main/java/database/passengerCSV.csv");
        Scanner sc = new Scanner(passenger);
        Connection conn = setConnection();
        Statement statement = conn.createStatement();
        String commands = "use APSS";
        PreparedStatement preparedStatement = conn.prepareStatement(commands);
        preparedStatement.execute();
        commands = "create table  if NOT EXISTS PASSENGER" +
                "(PassengerId int primary key , username varchar(30), password varchar(20))";
        statement.executeUpdate(commands);
        while(sc.hasNext()) {
            String line = sc.nextLine();
            Scanner sc2 = new Scanner(line).useDelimiter(",");
            int passId = sc2.nextInt();
            String name = sc2.next();
            String passwd = sc2.next();
            addToPassenger(passId, name, passwd);
        }

        commands = "create table if NOT EXISTS AllFlights" +
                "(FlightId varchar(20) primary key , Departure varchar(30), Arrival varchar(20), " +
                "Fare decimal(10,2), DepartureTime DATETIME, ArrivalTime DATETIME)";
        statement.executeUpdate(commands);
        sc = new Scanner(new File("APSS/src/main/java/database/allFlightsCSV.csv"));
        while(sc.hasNext()) {
            String line = sc.nextLine();
            Scanner sc2 = new Scanner(line).useDelimiter(",");
            String flightId = sc2.next();
            String dep = sc2.next();
            String arr = sc2.next();
            double fare = sc2.nextDouble();
            String depTime = sc2.next();
            String arrTime = sc2.next();
            addToAllFlights(flightId, dep, arr, fare, depTime, arrTime);
        }

        commands = "create table if NOT EXISTS FlightBooked " +
                "(PassengerId int, ItenaryNo varchar(10), FlightId varchar(20), Delay TIME, CheckIn smallint," +
                "PRIMARY KEY (PassengerId, ItenaryNo), FOREIGN KEY (PassengerId) REFERENCES Passenger(PassengerId)," +
                "FOREIGN KEY (FlightId) REFERENCES AllFlights(FlightId))";
        statement.executeUpdate(commands);
        sc = new Scanner(new File("APSS/src/main/java/database/FlightBookedCSV.csv"));
        while(sc.hasNext()) {
            String line = sc.nextLine();
            Scanner sc2 = new Scanner(line).useDelimiter(",");
            int passId = sc2.nextInt();
            String itenaryNo = sc2.next();
            String flightId = sc2.next();
            String delay = sc2.next();
            int checkIn = sc2.nextInt();
            addToFlightBooked(passId, itenaryNo, flightId, delay, checkIn);
        }

        commands = "create table if NOT EXISTS Luggage " +
                "(TokenNum int, PassengerId int , ItenaryNo varchar(10), Weight int, Name " +
                "varchar(10), LuggageFare decimal(10,2), " +
                "PRIMARY KEY (TokenNum)," +
                "FOREIGN KEY (PassengerId, ItenaryNo) REFERENCES FlightBooked(PassengerId, ItenaryNo))";
        statement.executeUpdate(commands);
        sc = new Scanner(new File ("APSS/src/main/java/database/luggageCSV.csv"));
        while(sc.hasNext()) {
            String line = sc.nextLine();
            Scanner sc2 = new Scanner(line).useDelimiter(",");
            int tokenNo = sc2.nextInt();
            int passId = sc2.nextInt();
            String itenaryNo = sc2.next();
            int weight = sc2.nextInt();
            String name = sc2.next();
            double luggFare = sc2.nextDouble();
            addToLuggage(tokenNo, passId, itenaryNo, weight, name, luggFare);
        }
        conn.close();
    }

    public void addToPassenger(int uniqueId, String user, String pass) throws SQLException {
        Connection conn = setConnection();
        String commands = "use APSS";
        PreparedStatement preparedStatement = conn.prepareStatement(commands);
        preparedStatement.execute();
        commands = "insert into PASSENGER(PassengerId, username, password) values(?, ?, ?)";
        preparedStatement = conn.prepareStatement(commands);
        preparedStatement.setInt(1,uniqueId);
        preparedStatement.setString(2, user);
        preparedStatement.setString(3, pass);
        preparedStatement.execute();
        conn.close();
    }

    public void addToAllFlights(String FlightId, String departure, String arrival, double fare, String depTime,
                                String arrTime) throws SQLException {
        Connection conn = setConnection();
        String commands = "use APSS";
        PreparedStatement preparedStatement = conn.prepareStatement(commands);
        preparedStatement.execute();
        commands = "insert into ALLFLIGHTS(FlightId, Departure, Arrival," +
                    "Fare, DepartureTime, ArrivalTime) values(?, ?, ?, ?, ?, ?)";
        preparedStatement = conn.prepareStatement(commands);
        preparedStatement.setString(1, FlightId);
        preparedStatement.setString(2, departure);
        preparedStatement.setString(3, arrival);
        preparedStatement.setDouble(4, fare);
        preparedStatement.setString(5, depTime);
        preparedStatement.setString(6, arrTime);

        preparedStatement.execute();
        conn.close();
    }

    public void addToFlightBooked(int passId, String itenaryNo, String flightId, String delay,
                                   int checkIn) throws SQLException {
        Connection conn = setConnection();
        String commands = "use APSS";
        PreparedStatement preparedStatement = conn.prepareStatement(commands);
        preparedStatement.execute();
        commands = "insert into FLIGHTBOOKED(PassengerId, ItenaryNo, FlightId," +
                "Delay, CheckIn) values(?, ?, ?, ?, ?)";
        preparedStatement = conn.prepareStatement(commands);
        preparedStatement.setInt(1, passId);
        preparedStatement.setString(2, itenaryNo);
        preparedStatement.setString(3, flightId);
        preparedStatement.setString(4, delay);
        preparedStatement.setInt(5, checkIn);

        preparedStatement.execute();
        conn.close();
    }

    public void addToLuggage(int tokenNo, int passId, String itenaryNo, int weight, String name,
                                  double luggFare) throws SQLException {
        Connection conn = setConnection();
        String commands = "use APSS";
        PreparedStatement preparedStatement = conn.prepareStatement(commands);
        preparedStatement.execute();
        commands = "insert into LUGGAGE(TokenNum, PassengerId, ItenaryNo, Weight, Name, LuggageFare)" +
                " values(?, ?, ?, ?, ?, ?)";
        preparedStatement = conn.prepareStatement(commands);
        preparedStatement.setInt(1, tokenNo);
        preparedStatement.setInt(2, passId);
        preparedStatement.setString(3, itenaryNo);
        preparedStatement.setInt(4, weight);
        preparedStatement.setString(5, name);
        preparedStatement.setDouble(6, luggFare);

        preparedStatement.execute();
        conn.close();
    }

    public void resetDataBase() throws SQLException {
        Connection conn = setConnection();
        Statement statement = conn.createStatement();
        String commands = "use APSS";
        PreparedStatement preparedStatement = conn.prepareStatement(commands);
        preparedStatement.execute();
        commands = "drop table IF EXISTS luggage";
        statement.executeUpdate(commands);
        commands = "drop table IF EXISTS flightbooked";
        statement.executeUpdate(commands);
        commands = "drop table IF EXISTS passenger";
        statement.executeUpdate(commands);
        commands = "drop table IF EXISTS allflights";
        statement.executeUpdate(commands);
        conn.close();
    }

    public ResultSet passengerTable() throws SQLException {
        Connection conn = setConnection();
        Statement statement = conn.createStatement();
        String commands = "use APSS";
        PreparedStatement preparedStatement = conn.prepareStatement(commands);
        preparedStatement.execute();
        commands = "select * from passenger";
        preparedStatement = conn.prepareStatement(commands);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }
    public ResultSet allFlightsTable() throws SQLException {
        Connection conn = setConnection();
        Statement statement = conn.createStatement();
        String commands = "use APSS";
        PreparedStatement preparedStatement = conn.prepareStatement(commands);
        preparedStatement.execute();
        commands = "select * from allFlights";
        preparedStatement = conn.prepareStatement(commands);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    public ResultSet flightBookedTable() throws SQLException {
        Connection conn = setConnection();
        Statement statement = conn.createStatement();
        String commands = "use APSS";
        PreparedStatement preparedStatement = conn.prepareStatement(commands);
        preparedStatement.execute();
        commands = "select * from flightBooked";
        preparedStatement = conn.prepareStatement(commands);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    public ResultSet luggageTable() throws SQLException {
        Connection conn = setConnection();
        Statement statement = conn.createStatement();
        String commands = "use APSS";
        PreparedStatement preparedStatement = conn.prepareStatement(commands);
        preparedStatement.execute();
        commands = "select * from luggage";
        preparedStatement = conn.prepareStatement(commands);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

}
