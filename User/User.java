package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class User implements Actions {
	private String userName;
	private String email;
	private String password;
	private String creationDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
	private List<Post> posts = new ArrayList<>();
	private List<Post> likedPosts = new ArrayList<>();
	private List<Comment> comments = new ArrayList<>();
	private List<User> followers = new ArrayList<>();
	private int followersAmount = 0;
	
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
	
	public int getFollowersAmount() {
		return this.followersAmount;
	}
	
	public void setFollowersAmount(int amount) {
		this.followersAmount = amount;
	}
	 
	@Override
	public void like(Integer id, User user) {
		for (Post post : user.getPosts()) {
			if (post.getId().equals(id)) {
				post.setLikes(post.getLikes() + 1);
				post.getUsersThatLiked().add(this);
				this.getLikedPosts().add(post);
			}
		}
	}
	
	@Override
	public void unlike(Integer id, User user) {
		for (Post post : user.getPosts()) {
			if (post.getId().equals(id)) {
				post.setLikes(post.getLikes() - 1);
				post.getUsersThatLiked().remove(this);
				this.getLikedPosts().remove(post);
			}
		}
	}
	
	@Override
	public void follow(User user) {
		user.getFollowers().add(this);
		user.setFollowersAmount(user.getFollowersAmount() + 1);
	}
	
	@Override
	public void unfollow(User user) {
		user.getFollowers().remove(this);
		user.setFollowersAmount(user.getFollowersAmount() - 1);
	}
	
	@Override
	public void post(String title, String content) {
		this.getPosts().add(new Post(this, title, content));
	}
	
	@Override
	public void comment(User user, Integer id, String content) {
		for (Post post : user.getPosts()) {
			if (post.getId().equals(id)) {
				Comment c = new Comment(user, post, content);
				this.getComments().add(c);
				post.getComments().add(c);
			}
		}
	}
	
	public boolean follows(User user) {
		if (user.getFollowers().contains(this)) {
			return true;
		} else {
			return false;
		}
	}
}
