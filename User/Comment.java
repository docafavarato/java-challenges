package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class Comment {
	private Integer id;
	private User user;
	private Post post;
	private String content;
	private String creationDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
	
	public Comment(User user, Post post, String content) {
		this.user = user;
		this.post = post;
		this.content = content;
		this.id = ThreadLocalRandom.current().nextInt(0, 999999999 + 1);
	}
	
	public Integer getId() {
		return this.id;
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
