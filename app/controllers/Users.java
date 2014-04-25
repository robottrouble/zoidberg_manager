package controllers;
 
import java.util.*;
 
import play.*;
import play.mvc.*;
 
import models.*;
 
public class Users extends Controller {
 
    public static void list() {
	renderJSON(User.findAll());
    }

    public static void add() {
	User newUser = new User("test").save();
        renderJSON(newUser);
    } 

    public static void get(Long id) {
        User user = User.findById(id);
	renderJSON(user);
    }

}
