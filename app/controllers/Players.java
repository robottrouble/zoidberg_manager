package controllers;
 
import java.util.*;
 
import play.*;
import play.mvc.*;
 
import models.*;
 
public class Players extends Controller {
 
    public static void list() {
	renderJSON(Player.findAll());
    }

    public static void add(String name) {
	Player newUser = new Player(name).save();
        renderJSON(newUser);
    } 

    public static void get(Long id) {
        Player user = Player.findById(id);
	renderJSON(user);
    }

}
