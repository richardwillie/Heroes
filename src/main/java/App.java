import java.util.ArrayList;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.xml.ws.Response;

import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    ProcessBuilder process = new ProcessBuilder();
     Integer port;
     if (process.environment().get("PORT") != null) {
         port = Integer.parseInt(process.environment().get("PORT"));
     } else {
         port = 4567;
     }

    setPort(port);
    
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("squads", Squad.all());
      model.put("heroes", Hero.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/squad/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Squad squadMembers = Squad.find(Integer.parseInt(request.params(":id")));
      model.put("squadMembers", squadMembers);
      model.put("template", "templates/squad.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  post("/squads", (request, Response)->{
    Map<String, Object> model = new HashMap<String, Object>();

    String name = request.queryParams("name");
    int size = Integer.parseInt(request.queryParams("size"));
    String cause = request.queryParams("cause");
    Squad newSquad = new Squad(name, cause, size);
    model.put("template", "templates/squad-success.vtl");
    return new ModelAndView(model, layout);  
  }, new VelocityTemplateEngine());

post("/hero", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();

  String name = request.queryParams("name");
  String age = request.queryParams("age");
  String power = request.queryParams("power");
  String weakness = request.queryParams("weakness");
  String heroSquad = request.queryParams("heroSquad");
  Squad squad = Squad.find(Integer.parseInt(heroSquad));
  Hero newHero = new Hero(name, age, power, weakness, heroSquad);
  squad.addHero(newHero);

  model.put("template", "templates/hero-success.vtl");
  return new ModelAndView(model, layout);
 }, new VelocityTemplateEngine());

 
  }
}