package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class User extends Model {
	public String fullname;

	public User(String username) {
		fullname=username;
	}
}
