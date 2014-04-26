package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class Player extends Model {
	@Column(unique = true) 
	public String fullname;
	public int score;

   	public String avatarUrl;
 
	public Player(String username, String avatarUrl) {
		this.fullname=username;
		this.score=0;
		this.avatarUrl=avatarUrl;
	}
    
	public void incrementScore (int score){
		this.score += score;
	}
    
}


