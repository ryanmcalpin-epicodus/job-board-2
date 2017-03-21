public class JobOpening {
  private String mName;
  private String mTitle;
  private String mDescription;
  private String mContactInfo;

  public JobOpening(String name, String title, String description, String contactInfo ) {
    mName = name;
    mTitle = title;
    mDescription = description;
    mContactInfo = contactInfo;
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

}
