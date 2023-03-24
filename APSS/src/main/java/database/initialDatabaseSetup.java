package database;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


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
                if((result.getString(1).toUpperCase()).equals("APSS")) {
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
        commands = "create table PASSENGER" +
                "(Id int primary key , username varchar(30), password varchar(20))";
        statement.executeUpdate(commands);
        addToPassenger(1001, "rohit", "rohit@2002");

        commands = "create table AllFlights" +
                "(FlightId varchar(20) primary key , Departure varchar(30), Arrival varchar(20), " +
                "Fare decimal(10,2), DepartureTime DATETIME, ArrivalTime DATETIME)";
        statement.executeUpdate(commands);
        LocalDateTime temp = LocalDateTime.now();
        addToAllFlights("MH01", "Fredericton", "Toronto", 100.20, temp, temp);
    }

    public void addToPassenger(int uniqueId, String user, String pass) throws SQLException {
        Connection conn = setConnection();
        String commands = "use APSS";
        PreparedStatement preparedStatement = conn.prepareStatement(commands);
        preparedStatement.execute();
        commands = "insert into PASSENGER(Id, username, password) values(?, ?, ?)";
        preparedStatement = conn.prepareStatement(commands);
        preparedStatement.setInt(1,uniqueId);
        preparedStatement.setString(2, user);
        preparedStatement.setString(3, pass);
        preparedStatement.execute();

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

    }

    public void resetDataBase() throws SQLException {
        Connection conn = setConnection();
        Statement statement = conn.createStatement();
        String commands = "use APSS";
        PreparedStatement preparedStatement = conn.prepareStatement(commands);
        preparedStatement.execute();
        commands = "drop table passenger";
        statement.executeUpdate(commands);
        commands = "drop table allflights";
        statement.executeUpdate(commands);
    }

}
