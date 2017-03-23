import org.junit.*;
import static org.junit.Assert.*;

public class JobOpeningTest {

  @After
  public void tearDown() {
    JobOpening.clear();
  }

  @Test
  public void TestObject_instances(){
    JobOpening newJob = new JobOpening("work","janitor", "cleaner", "me@me.com");
    assertEquals(true, newJob instanceof JobOpening);
  }

  @Test
  public void jobOpening_getters_returnInfo() {
    JobOpening newJob = new JobOpening("work","janitor", "cleaner", "me@me.com");
    assertEquals("work", newJob.getName());
    assertEquals("janitor", newJob.getTitle());
    assertEquals("cleaner", newJob.getDescription());
    assertEquals("me@me.com", newJob.getContactInfo());
  }

  @Test
  public void all_returnsAllInstancesOfJobOpening_true() {
    JobOpening firstJob = new JobOpening("work","janitor", "cleaner", "me@me.com");
    JobOpening secondJob = new JobOpening("place", "worker", "work stuff", "stuff@stuff");
    assertTrue(JobOpening.all().contains(firstJob));
    assertTrue(JobOpening.all().contains(secondJob));
  }

  @Test
  public void clear_emptiesJobsFromList_0() {
    JobOpening newJob = new JobOpening("work","janitor", "cleaner", "me@me.com");
    JobOpening.clear();
    assertEquals(JobOpening.all().size(), 0);
  }

  @Test
  public void getId_returnsId_1() {
    JobOpening newJob = new JobOpening("work","janitor", "cleaner", "me@me.com");
    assertEquals(1, newJob.getId());
  }

}
