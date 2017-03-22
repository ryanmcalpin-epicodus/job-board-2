import org.junit.*;
import static org.junit.Assert.*;

public class CityTest {

  @Test
  public void city_instantiatesCorrectly_true() {
    City testCity = new City("Saskatoon");
    assertEquals(true, testCity instanceof City);
  }

}
