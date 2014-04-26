package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class Player extends Model {
	@Column(unique = true) 
	public String fullname;

	public Player(String username) {
		fullname=username;
	}
}
