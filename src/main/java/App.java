import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.Request;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {

        staticFileLocation("/public");

        //GET : home:
        get("/",(req,res)->home(req), new HandlebarsTemplateEngine());

        post("hero/new", (req,res)->newHero(req), new HandlebarsTemplateEngine());
        post("squad/new", (req,res)->newSquad(req), new HandlebarsTemplateEngine());
    }

    private static ModelAndView home(Request request){

        Map<String,Object> model = new HashMap<>();
        model.put("heroes", request.session().attribute("heroes"));
        model.put("squads", request.session().attribute("squads"));

        return new ModelAndView(model, "index.hbs");
    }

    private  static ModelAndView newHero(Request request){
        String name = request.queryParams("name");
        String power = request.queryParams("power");
        String weakness = request.queryParams("weakness");
        int age = Integer.parseInt(request.queryParams("age"));

        Hero h = new Hero(name,age,power,weakness);

        request.session().attribute("heroes", Hero.getInstances());

        Map<String, Object> model = new HashMap<>();
        model.put("heroes", request.session().attribute("heroes"));
        model.put("squads", request.session().attribute("squads"));

        return new ModelAndView(model,"index.hbs");
    }

    private static ModelAndView newSquad(Request request){
        String name = request.queryParams("name");
        String cause = request.queryParams("cause");
        int max_size = Integer.parseInt(request.queryParams("size"));
        int hero_id = Integer.parseInt(request.queryParams("hero"));

        Hero h = Hero.findById(hero_id);
        Squad s = new Squad(name,cause,max_size,h);

        request.session().attribute("squads", Squad.getInstances());

        Map<String, Object> model = new HashMap<>();
        model.put("squads", request.session().attribute("squads"));
        model.put("heroes", request.session().attribute("heroes"));

        return new ModelAndView(model,"index.hbs");
    }
}
