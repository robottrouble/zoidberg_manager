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

	public static void findByName(String name) {
		Player player = Player.find("byFullname", name).first();
		renderJSON(player);
	}

	public static void findGames(Long id) {
		Player player = Player.findById(id);
		Player player2 = Player.findById(id);
		List<Game> games = Game.find("player1 = ? or player2 = ?", player, player2).fetch();	
		renderJSON(games);
	}
    
    public static void scores() {
        List<Player> allPlayers = Player.findAll();
        render(allPlayers);
    }
}
