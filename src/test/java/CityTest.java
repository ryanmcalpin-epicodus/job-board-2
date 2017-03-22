import org.junit.*;
import static org.junit.Assert.*;

public class CityTest {
  @Test
  public void newCity_instantiatesCorrectly() {
    JobOpening testJobOpening = new JobOpening("Chulo Co", "Developer", "make techy stuff", "chulo@chuloco");
    City testCity = new City(testJobOpening);
    assertEquals(true, testCity instanceof City);
  }
}
