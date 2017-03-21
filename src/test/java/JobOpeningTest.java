import org.junit.*;
import static org.junit.Assert.*;

public class JobOpeningTest {

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

}
