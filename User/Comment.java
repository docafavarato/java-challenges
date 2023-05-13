package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Comment {
	private User user;
	private Post post;
	private String content;
	private String creationDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
	
	public Comment(User user, Post post, String content) {
		this.user = user;
		this.post = post;
		this.content = content;
		this.user.getComments().add(this);
		this.post.getComments().add(this);
	}

	public User getUser() {
		return user;
	}

	public Post getPost() {
		return post;
	}

	public String getContent() {
		return content;
	}

	public String getCreationDate() {
		return creationDate;
	}
}
