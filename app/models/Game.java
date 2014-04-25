package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class Game extends Model {

	@OneToOne
	public Player player1;

	@OneToOne
	public Player player2;

	public Long gameTypeId;

	public Long gameStatusId;

	public Game(Player player1, Player player2, Long gameTypeId, Long status) {
		this.player1 = player1;
		this.player2 = player2;
		this.gameTypeId = gameTypeId;
		this.gameStatusId = status;
	}
}
