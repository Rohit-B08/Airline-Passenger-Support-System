
import classes.FlightBookedTest;
import helperMethods.*;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectClasses({CancelFlightTest.class, CheckInTest.class, FlightBookedScreenTest.class, FlightBookedTest.class,
        FlightInfoScreenTest.class, LogInScreenTest.class, LuggageScreenTest.class})
public class AllTests {
}

