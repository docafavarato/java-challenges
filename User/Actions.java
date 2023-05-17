package entities;

public interface Actions {
	public void follow(User user);
	public void unfollow(User user);
	public void post(String title, String content);
	public void like(Integer id, User user);
	public void unlike(Integer id, User user);
	public void comment(User user, Integer id, String content);
}
