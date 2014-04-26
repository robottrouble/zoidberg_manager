package controllers;
 
import java.util.*;
import play.*;
import play.mvc.*;
import models.*;
import java.io.InputStream;

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

    public static void finish(Long gameId, int scoreplayer1, int scoreplayer2) {
       	Game finishedGame = Game.findById(gameId);
        finishedGame.player1.incrementScore(scoreplayer1);
        finishedGame.player2.incrementScore(scoreplayer2);
        finishedGame.player1.save();
        finishedGame.player2.save();
		finishedGame.gameStatusId = Status.FINISHED.getId();
		finishedGame.save();
		renderJSON(finishedGame);
    }


	public static void updateData(Long id) {
		Game updateGame = Game.findById(id);
		updateGame.setData(request.body, request.contentType);
		updateGame.save();
		renderJSON(updateGame);
	}

	public static void get(Long id) {
		renderJSON(Game.findById(id));
	}

	public static void getData(Long id) {
		Game game = Game.findById(id);
		response.setContentTypeIfNotSet(game.data.type());
		java.io.InputStream binaryData = game.data.get();
		renderBinary(binaryData);
	}


}
