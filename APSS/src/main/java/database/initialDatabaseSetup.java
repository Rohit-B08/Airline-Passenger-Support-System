package database;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class initialDatabaseSetup {
    private final String url = "jdbc:mysql://localhost/";
    private final String user = "root";
    private String pass;

    public initialDatabaseSetup(String pass) throws SQLException {
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

    public void initializeDatabase() throws SQLException {
        Connection conn = setConnection();
        Statement statement = conn.createStatement();
        String commands = "use APSS";
        PreparedStatement preparedStatement = conn.prepareStatement(commands);
        preparedStatement.execute();
        commands = "create table  if NOT EXISTS PASSENGER" +
                "(PassengerId int primary key , username varchar(30), password varchar(20))";
        statement.executeUpdate(commands);
        addToPassenger(1001, "rohit", "rohit@2002");

        commands = "create table if NOT EXISTS AllFlights" +
                "(FlightId varchar(20) primary key , Departure varchar(30), Arrival varchar(20), " +
                "Fare decimal(10,2), DepartureTime DATETIME, ArrivalTime DATETIME)";
        statement.executeUpdate(commands);
        addToAllFlights("MH01", "Fredericton", "Toronto", 100.20, LocalDateTime.now(), LocalDateTime.now());

        commands = "create table if NOT EXISTS FlightBooked " +
                "(PassengerId int, ItenaryNo varchar(10), FlightId varchar(20), Delay TIME, CheckIn smallint," +
                "PRIMARY KEY (PassengerId, ItenaryNo), FOREIGN KEY (PassengerId) REFERENCES Passenger(PassengerId)," +
                "FOREIGN KEY (FlightId) REFERENCES AllFlights(FlightId))";
        statement.executeUpdate(commands);
        addToFlightBooked(1001, "abcd1234", "MH01", LocalTime.of(01,00,00), 0);

        commands = "create table if NOT EXISTS Luggage " +
                "(TokenNum int, PassengerId int , ItenaryNo varchar(10), FlightId varchar(20), Weight int, Name " +
                "varchar(10), LuggageFare decimal(10,2), " +
                "PRIMARY KEY (TokenNum)," +
                "FOREIGN KEY (PassengerId, ItenaryNo) REFERENCES FlightBooked(PassengerId, ItenaryNo))";
        statement.executeUpdate(commands);
        addToLuggage(101, 1001, "abcd1234", "MH01", 20, "Bag1", 50.00);
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

    public void addToAllFlights(String FlightId, String departure, String arrival, double fare, LocalDateTime depTime,
                                LocalDateTime arrTime) throws SQLException {
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
        preparedStatement.setString(5, String.valueOf(depTime));
        preparedStatement.setString(6, String.valueOf(arrTime));

        preparedStatement.execute();
        conn.close();
    }

    public void addToFlightBooked(int passId, String itenaryNo, String flightId, LocalTime delay,
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
        preparedStatement.setString(4, String.valueOf(delay));
        preparedStatement.setInt(5, checkIn);

        preparedStatement.execute();
        conn.close();
    }

    public void addToLuggage(int tokenNo, int passId, String itenaryNo, String flightId, int weight, String name,
                                  double luggFare) throws SQLException {
        Connection conn = setConnection();
        String commands = "use APSS";
        PreparedStatement preparedStatement = conn.prepareStatement(commands);
        preparedStatement.execute();
        commands = "insert into LUGGAGE(TokenNum, PassengerId, ItenaryNo, FlightId, Weight, Name, LuggageFare)" +
                " values(?, ?, ?, ?, ?, ?, ?)";
        preparedStatement = conn.prepareStatement(commands);
        preparedStatement.setInt(1, tokenNo);
        preparedStatement.setInt(2, passId);
        preparedStatement.setString(3, itenaryNo);
        preparedStatement.setString(4, flightId);
        preparedStatement.setInt(5, weight);
        preparedStatement.setString(6, name);
        preparedStatement.setDouble(7, luggFare);

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

}
