import org.junit.*;
import static org.junit.Assert.*;

public class CityTest {
  @After
  public void tearDown(){
    City.clear();
  }

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

  @Test
  public void getId_citiesinstatiateWithId_1() {
    City testCity = new City("Saskatoon");
    assertEquals(1, testCity.getId());
  }

  @Test
  public void find_returnsCityWithSameId_secondCity() {
    City firstCity = new City("Saskatoon");
    City secondCity = new City("Mazatlan");
    assertEquals(City.find(secondCity.getId()), secondCity);
  }

  @Test
  public void getJobs_initiallyReturnsEmptyList_ArrayList() {
    City testCity = new City("Saskatoon");
    assertEquals(0, testCity.getJobs().size());
  }

  @Test
  public void addJob_addsJobToList_true() {
    City testCity = new City("Saskatoon");
    JobOpening testJob = new JobOpening("work","janitor", "cleaner", "me@me.com");
    testCity.addJob(testJob);
    assertTrue(testCity.getJobs().contains(testJob));
  }

}
