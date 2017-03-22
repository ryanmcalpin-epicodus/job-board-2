import org.junit.*;
import static org.junit.Assert.*;

public class CityTest {

  @Test
  public void city_instantiatesCorrectly_true() {
    City testCity = new City("Saskatoon");
    assertEquals(true, testCity instanceof City);
  }

  @Test
  public void getName_cityInstantiatesWithName_Saskatoon() {
    City testCity = new City("Saskatoon");
    assertEquals("Saskatoon", testCity.getName());
  }

  @Test
  public void all_returnsAllInstancesOfCity_true() {
    City firstCity = new City("Saskatoon");
    City secondCity = new City("Mazatlan");
    assertEquals(true, City.all().contains(firstCity));
    assertEquals(true, City.all().contains(secondCity));
  }

  @Test
  public void clear_emptiesAllCitiesFromList_0() {
    City firstCity = new City("Saskatoon");
    City.clear();
    assertEquals(City.all().size(), 0);
  }

}
