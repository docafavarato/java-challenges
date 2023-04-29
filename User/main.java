import entities.User;

public class app {
  public static void main(String[] args) {
    User user1 = new User("user1name", "user1password", "user1email", 0);
    User user2 = new User("user2name", "user2password", "user2email", 1);
    
    user1.follow(user2);
    user2.follow(user1);
    
    for (User user : user1.getFollowers()) {
      System.out.println(user.getUserName()); // user2name
    }
}
