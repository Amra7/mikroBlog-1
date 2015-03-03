package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints.MaxLength;
import play.data.validation.Constraints.MinLength;
import play.db.ebean.Model;

@Entity
public class Post extends Model {
	
	@Id
	public long id;
	
	@MinLength(1)
	@MaxLength(144)
	public String content;
	
	@ManyToOne
	public User author;
	
	public Post(String content, User author){
		this.content = content;
		this.author = author;
	}
	
	public static void create(String content, User author){
		new Post(content, author).save();
	}
	
}
