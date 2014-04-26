package controllers;
 
import java.util.*;
import java.io.*;
 
import play.*;
import play.mvc.*;
 
import models.*;
 
public class Players extends Controller {
 
	public static void list() {
		renderJSON(Player.findAll());
	}

	public static void add(String name) {
		String avatarUrl = getAvatar();
		Player newUser = new Player(name, avatarUrl).save();
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

	public static String getAvatar() {
		String AVATAR_PATH = "public/images/avatars/png/";
		List<File> avatars = new ArrayList<File>(Arrays.asList(Play.getFile(AVATAR_PATH).listFiles()));
		Random random = new Random();
		int randomNumber = random.nextInt(avatars.size());
		String avatarFileName = avatars.get(randomNumber).getName();
		return AVATAR_PATH + avatarFileName;
	}
 
	public static void scores() {
		List<Player> allPlayers = Player.findAll();
		render(allPlayers);
	}
}
