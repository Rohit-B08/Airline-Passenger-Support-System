package helperMethods;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class LogInScreenTest {
    LogInScreen logIn;
    @BeforeEach
    void setUp() {
        logIn = new LogInScreen("welcomepm3");
    }

    @ParameterizedTest
    @CsvSource({"Jashan, 123Jashan##, true", "Gopika, 345Pika$$, true", "Rohit, 678Rohit@@, true",
                "Lam, 910Lam%%, true", "Josh, 346Jer&&, true", "Rose, 347Rose12, true", "George, 73Tell34, true"})
    void validLoginTest(String usrName, String pass, boolean expectedOutput) throws SQLException {
        boolean output = logIn.validateLogIn(usrName, pass);
        assertEquals(expectedOutput, output);
    }

    @ParameterizedTest
    @CsvSource({"Jashanpreet, 123Jashan##, false", "Pika, 345Pika$$, false", "Rohit, 999Rohit@@, false",
                "Anh, 910Anh%%, false", "Joshua, 346Jer&&, false", "Rose, 123Rose12, false", "George, 73George34, false"})
    void invalidLoginTest(String usrName, String pass, boolean expectedOutput) throws SQLException {
        boolean output = logIn.validateLogIn(usrName, pass);
        assertEquals(expectedOutput, output);
    }

    @ParameterizedTest
    @CsvSource({"Jashan, 123Jashan##, 12001", "Gopika, 345Pika$$, 12002", "Rohit, 678Rohit@@, 12003",
                "Lam, 910Lam%%, 12004", "Josh, 346Jer&&, 12005", "Rose, 347Rose12, 12006", "George, 73Tell34, 12007"})
    void getPassengerIdTestFromCorrectInput(String usrName, String pass, int expectedPassengerId) throws SQLException {
        int passengerId = logIn.getPassengerId(usrName, pass);
        assertEquals(expectedPassengerId, passengerId);
    }

    @ParameterizedTest
    @CsvSource({"Jashanpreet, 123Jashan##, 0", "Pika, 345Pika$$, 0", "Rohit, 999Rohit@@, 0",
            "Anh, 910Anh%%, 0", "Joshua, 346Jer&&, 0", "Rose, 123Rose12, 0", "George, 73George34, 0"})
    void getPassengerIdTestFromIncorrectInput(String usrName, String pass, int expectedPassengerId) throws SQLException {
        int passengerId = logIn.getPassengerId(usrName, pass);
        assertEquals(expectedPassengerId, passengerId);
    }
}