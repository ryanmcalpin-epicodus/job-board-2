import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("jobs", request.session().attribute("jobs"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/jobs", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      ArrayList<JobOpening> jobs = request.session().attribute("jobs");
      if (jobs == null) {
        jobs = new ArrayList<JobOpening>();
        request.session().attribute("jobs", jobs);
      }

      String name = request.queryParams("name");
      String title = request.queryParams("title");
      String description = request.queryParams("description");
      String contactInfo = request.queryParams("contactInfo");
      JobOpening newJob = new JobOpening(name, title, description, contactInfo);
      jobs.add(newJob);

      model.put("template", "templates/result.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
