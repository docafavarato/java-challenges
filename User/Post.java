package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Post {
	private User user;
	private String title;
	private String content;
	private String creationDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));;
	protected int likes;
	private List<User> usersThatLiked = new ArrayList<>();
	private List<Comment> comments = new ArrayList<>();
	
	public Post(User user, String title, String content) {
		this.user = user;
		this.title = title;
		this.content = content;
		this.user.getPosts().add(this);
	}

	public User getUser() {
		return user;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public List<User> getUsersThatLiked() {
		return usersThatLiked;
	}
	
	public List<Comment> getComments() {
		return comments;
	}
	
	public int getLikes() {
		return likes;
	}
}
