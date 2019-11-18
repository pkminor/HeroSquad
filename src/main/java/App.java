import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {

        //GET : home:
        get("/",(res,req)->home(), new HandlebarsTemplateEngine());
    }

    private static ModelAndView home(){
        return new ModelAndView(new HashMap<String,Object>(), "index.hbs");
    }
}
