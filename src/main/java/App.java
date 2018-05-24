import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("template", "templates/index.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());
  
    }

    post("/squads", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
  
        String name = request.queryParams("name");
        String cause = request.queryParams("cause");
        int size = Integer.parseInt.request.queryParams("size");
         Squad newSquad = new Squad(name,cause,size);
        request.session().attribute("squad", newSquad);
  
        model.put("template", "templates/squad-success.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());
  }


