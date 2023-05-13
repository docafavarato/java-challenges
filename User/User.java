package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class User {
	private String userName;
	private String email;
	private String password;
	private String creationDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
	private List<Post> posts = new ArrayList<>();
	private List<Post> likedPosts = new ArrayList<>();
	private List<Comment> comments = new ArrayList<>();
	private List<User> followers = new ArrayList<>();
	
	public User(String userName, String email, String password) {
		this.userName = userName;
		this.email = email;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public List<Post> getPosts() {
		return posts;
	}
	
	public List<Post> getLikedPosts() {
		return likedPosts;
	}
	
	public List<Comment> getComments() {
		return comments;
	}
	
	public List<User> getFollowers() {
		return followers;
	}
	 
	public void like(Post post) {
		post.getUsersThatLiked().add(this);
		this.likedPosts.add(post);
		post.likes++;
	}
	
	public void unlike(Post post) {
		post.getUsersThatLiked().remove(this);
		this.likedPosts.remove(post);
	}
	
	public void follow(User user) {
		user.followers.add(this);
	}
	
	public void unfollow(User user) {
		user.followers.remove(this);
	}
	
	public boolean follows(User user) {
		if (user.getFollowers().contains(this)) {
			return true;
		} else {
			return false;
		}
	}
}
