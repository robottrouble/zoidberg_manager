package controllers;
 
import java.util.*;
 
import play.*;
import play.mvc.*;
 
import models.*;
 
public class Games extends Controller {
    public enum Status {
        NEW(0L),
        STARTED(1L),
        FINISHED(2L),
        CANCELED(3L);

		private Long statusId;

		private Status(Long id) {
			statusId = id;
		}

		public Long getId() {
			return statusId;
		}
    }
 
    public static void list() {
		renderJSON(Game.findAll());
    }

    public static void create(Long player1_id, Long player2_id, Long gameId) {
		Player player1 = Player.findById(player1_id);
		Player player2 = Player.findById(player2_id);

		Game newGame = new Game(player1, player2, gameId, Status.STARTED.getId()).save();
        renderJSON(newGame);
    } 

    public static void finish(Long gameId, int Score) {
       	Game finishedGame = Game.findById(gameId);
		finishedGame.gameStatusId = Status.FINISHED.getId();
		finishedGame.save();
		renderJSON(finishedGame);
    }
}
