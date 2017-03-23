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

    // post("/jobs", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //
    //   ArrayList<JobOpening> jobs = request.session().attribute("jobs");
    //   if (jobs == null) {
    //     jobs = new ArrayList<JobOpening>();
    //     request.session().attribute("jobs", jobs);
    //   }
    //
    //   String name = request.queryParams("name");
    //   String title = request.queryParams("title");
    //   String description = request.queryParams("description");
    //   String contactInfo = request.queryParams("contactInfo");
    //   JobOpening newJob = new JobOpening(name, title, description, contactInfo);
    //   jobs.add(newJob);
    //
    //   model.put("template", "templates/result.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());

    get("/cities/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/city-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/cities", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String cityName = request.queryParams("name");
      City newCity = new City(cityName);
      model.put("cities", City.all());
      model.put("template", "templates/cities.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cities", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("cities", City.all());
      model.put("template", "templates/cities.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cities/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      City city = City.find(Integer.parseInt(request.params(":id")));
      model.put("city", city);
      model.put("template", "templates/city.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cities/:id/jobs/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      City city = City.find(Integer.parseInt(request.params(":id")));
      model.put("city", city);
      model.put("template", "templates/city-jobs-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/jobs", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      City city = City.find(Integer.parseInt(request.queryParams("cityId")));
      String name = request.queryParams("name");
      String title = request.queryParams("title");
      String description = request.queryParams("description");
      String contactInfo = request.queryParams("contactInfo");
      JobOpening job = new JobOpening(name, title, description, contactInfo);
      city.addJob(job);
      model.put("city", city);
      model.put("template", "templates/city.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cities/:id/jobs/:jId",(request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      City city = City.find(Integer.parseInt(request.params(":id")));
      JobOpening job = JobOpening.find(Integer.parseInt(request.params(":jId")));
      model.put("city", city);
      model.put("job", job);
      model.put("template", "templates/job.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
