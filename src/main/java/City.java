import java.util.List;
import java.util.ArrayList;

public class City {
  private String mName;
  private static List<City> instances = new ArrayList<City>();

  public City(String name) {
    mName = name;
    instances.add(this);
  }

  public String getName() {
    return mName;
  }

  public static List<City> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }


}
