package mwitter;

public class User{
    
    private String username;
    private String password;
    private MweetList userMweets;
    private MweetList followedMweets;
    private UserList followers;
    private UserList following;
    
    public User(String username, String password){
        this.username = username;
        this.password = password;
        userMweets = new MweetList();
        followedMweets = new MweetList();
        followers = new UserList();
        following = new UserList();
    }
    
    // Observer Methods:
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public UserList getFollowers(){
        return followers;
    }
    
    public UserList getFollowing(){
        return following;
    }
    
    public MweetList getUserMweets(){
        return userMweets;
    }

    public MweetList getFollowedMweets(){
        return followedMweets;
    }
    
    // End of observer methods
      
}