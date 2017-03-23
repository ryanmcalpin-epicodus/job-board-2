import java.util.List;
import java.util.ArrayList;

public class JobOpening {
  private String mName;
  private String mTitle;
  private String mDescription;
  private String mContactInfo;
  private static List<JobOpening> instances = new ArrayList<JobOpening>();
  private int mId;

  public JobOpening(String name, String title, String description, String contactInfo ) {
    mName = name;
    mTitle = title;
    mDescription = description;
    mContactInfo = contactInfo;
    instances.add(this);
    mId = instances.size();
  }

  public String getName() {
    return mName;
  }

  public String getTitle() {
    return mTitle;
  }

  public String getDescription() {
    return mDescription;
  }

  public String getContactInfo() {
    return mContactInfo;
  }

  public int getId() {
    return mId;
  }

  public static JobOpening find (int id) {
    return instances.get(id - 1);
  }

  public static List<JobOpening> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

}
