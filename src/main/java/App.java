import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("squad",request.session().attribute("squad"));
        model.put("template", "templates/index.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());
  
    }

    post("/squads", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();

        ArrayList<Squad> squads = request.session().attribute("squads");
        if (squads == null){
            squads = new ArrayList<Squad>();
            request.session().attribute("squads",squads);
        }
  
        String name = request.queryParams("name");
        String cause = request.queryParams("cause");
        int size = Integer.parseInt.request.queryParams("size");
         Squad newSquad = new Squad(name,cause,size);
          squads.add(newSquad); 
  
        model.put("template", "templates/squad-success.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());
  }


