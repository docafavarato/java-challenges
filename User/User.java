package entities;
import java.util.ArrayList;
import java.util.List;

public class User {
	private String userEmail;
	private String userName;
	private String userPassword;
	private Integer userId;
	private Integer followersAmount = 0;
	private Integer followingAmount = 0;
	private List<User> followers = new ArrayList<>();
	private List<User> following = new ArrayList<>();
	
	
	public User(String userEmail, String userName, String userPassword, Integer userId) {
		this.userEmail = userEmail;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userId = userId;
	}
	
	public String getUserEmail() { return this.userEmail; }
	
	public String getUserName() { return this.userName; }
	
	public String getPassword() { return this.userPassword; }
	
	public Integer getUserId() { return this.userId; }
	
	public Integer getFollowersAmount() { return this.followersAmount; }
	
	public Integer getFollowingAmount() { return this.followingAmount; }
	
	public List<User> getFollowers() { return this.followers; }
	
	public List<User> getFollowing() { return this.following; }
	
	public void setUserName(String userName) { 
		this.userName = userName; 
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public void follow(User user_to) {
		this.followingAmount++;
		this.following.add(user_to);
		user_to.followersAmount++;
		user_to.followers.add(this);
	}
}
