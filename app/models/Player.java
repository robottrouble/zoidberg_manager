package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class Player extends Model {
	public String fullname;
    public int score;

    
	public Player(String username) {
		fullname=username;
	}
    
    public void incrementScore (int score){
        this.score += score;
    }
    
}


