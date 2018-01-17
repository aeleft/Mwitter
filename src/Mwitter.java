package mwitter;

import java.util.Scanner;

public class Mwitter{
    
    public static UserList allUsers = new UserList();
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args){
        
        String userInput, username, password;
        
        System.out.println("Welcome to Mwitter!");
        
        while(true){
            
            System.out.println("\nMain Menu Options:");
            System.out.println("---------------------");
            System.out.println("1. Sign up");
            System.out.println("2. Log in");
            System.out.println("3. Exit");
            
            userInput = sc.nextLine();
            System.out.println();
            
            if(userInput.equals("1")){
                
                while(true){
                    System.out.println("Pick a username: ");
                    username = sc.nextLine();
                    if(allUsers.find(username) != null)
                        System.out.println("This username is already taken.");
                    else
                        break;
                }
                System.out.println("Pick a password: ");
                password = sc.nextLine();
                User u = new User(username, password);
                allUsers.add(u);
                
            }
            else if(userInput.equals("2")){
                
                System.out.println("Enter your username: ");
                username = sc.nextLine();
                System.out.println("Enter your password: ");
                password = sc.nextLine();
                User u = allUsers.find(username, password);
                if(u != null)
                    loggedInMenu(u);
                else{
                    System.out.println("Incorrect username or password.");
                    continue;
                }
                    
            }
            else if(userInput.equals("3")){
                
                System.out.println("Exiting Mwitter.");
                return;
                
            }
            else{
                
                System.out.println("Not a valid input. Please try again.");
                
            }
            
        }
        
    }
    
    
    public static void loggedInMenu(User u){
        
        String userInput;
        
        while(true){
            
            System.out.println("\nUser Menu Options:");
            System.out.println("---------------------");
            System.out.println("1. Show mweets");
            System.out.println("2. My mweets");
            System.out.println("3. Write a mweet");
            System.out.println("4. Show users I follow");
            System.out.println("5. Show users following me");
            System.out.println("6. Show all users");
            System.out.println("7. Log out");
            
            userInput = sc.nextLine();
            System.out.println();
            
            if(userInput.equals("1")){
                
                // WRITE CODE HERE
                
                System.out.print(u.getFollowedMweets());                   
                
            }
            else if(userInput.equals("2")){
                
                // WRITE CODE HERE
                System.out.print(u.getUserMweets());
                
            }
            else if(userInput.equals("3")){
                
                // WRITE CODE HERE
                System.out.println("Write your mweet:");
                userInput = sc.nextLine();
                if(userInput.length() >= 140)
                    System.out.println("Mweet has to be less than 140 characters. \nTry again.");
                else{
                    Mweet m = new Mweet(userInput, u.getUsername());
                    u.getUserMweets().add(m);          
                    System.out.println("Mweet added succesfully.");
                    u.getFollowers().addMweetToFollowedMweets(m);
                }
            }
            else if(userInput.equals("4")){
                System.out.println("User's I follow:");
                System.out.println(u.getFollowing());
                listOfFollowingMenu(u);
            }
            else if(userInput.equals("5")){
                System.out.println("User's that follow me:");
                System.out.println(u.getFollowers());
                listOfUsersMenu(u);
            }
            else if(userInput.equals("6")){
                System.out.println("List of all the users:");
                System.out.println(allUsers);
                listOfUsersMenu(u);
            }
            else if(userInput.equals("7")){
                System.out.println("Logging out.");
                return;
            }
            else{
                System.out.println("Not a valid input. Please try again.");
            }
        }
        
    }
    
    
    public static void listOfUsersMenu(User u){
        
        String userInput;
        
        while(true){
            
            System.out.println("1. Follow user");
            System.out.println("2. Show mweets of user");
            System.out.println("3. Go back");
            userInput = sc.nextLine();
            System.out.println();
            
            if(userInput.equals("1")){
                
                // WRITE CODE HERE
                System.out.println("Enter the username of the user you wish to follow.");
                userInput = sc.nextLine();
                User user = allUsers.find(userInput);
                if(user == u)
                    System.out.println("You cannot follow yourself.");
                
                //A User can only exist ONCE within the UserList "following".
                //This condition also prevents User "u" from being added twice to the "followers" UserList of User "user".
                else if(u.getFollowing().find(userInput) != null) 
                    System.out.println("You are already following this user.");
                else if(user != null){
                    u.getFollowing().add(user);
                    u.getFollowedMweets().add(user.getUserMweets());
                    user.getFollowers().add(u);
                    System.out.println("You are now following " + userInput);
                }
                else{
                    System.out.println("This user does not exist. Please try again.");
                }
                
            }
            else if(userInput.equals("2")){
                System.out.println("Enter the username you want to see the mweets of:");
                userInput = sc.nextLine();
                User user = allUsers.find(userInput);
                if(user != null){
                    System.out.println("The mweets of " + userInput + ":");
                    System.out.println(user.getUserMweets());
                }
                else{
                    System.out.println("Could not find user. Please try again.");
                }
            }
            else if(userInput.equals("3")){
                return;
            }
            else{
                System.out.println("Not a valid input. Please try again.");
            }
        }
            
    }
    
    
    public static void listOfFollowingMenu(User u){
        
        String userInput;
        
        while(true){
           
            System.out.println("1. Show mweets of user");
            System.out.println("2. Unfollow user");
            System.out.println("3. Go back");
            userInput = sc.nextLine();
            System.out.println();
            
            if(userInput.equals("1")){
                System.out.println("Enter the username you want to see the mweets of:");
                userInput = sc.nextLine();
                User user = allUsers.find(userInput);
                if(user != null){
                    System.out.println("The mweets of " + userInput + ":");
                    System.out.println(user.getUserMweets());
                }
                else{
                    System.out.println("This user does not exist. Please try again.");
                }
            }
            else if(userInput.equals("2")){
                
                // WRITE CODE HERE
                System.out.println("Enter the username of the user you wish to unfollow.");
                userInput = sc.nextLine();
                User user1 = u.getFollowing().find(userInput);
                User user2 = allUsers.find(userInput);
                if(user2 == null)
                    System.out.println("This user does not exist. Please try again.");                    
                else if(user1 != null){
                    u.getFollowing().remove(user1);
                    u.getFollowedMweets().remove(user1);
                    user1.getFollowers().remove(u);
                    System.out.println("You are no longer following " + userInput);                
                }
                else
                    System.out.println("You cannot unfollow someone whom you are not following. \nTry again.");
                
            }
            else if(userInput.equals("3")){
                return;
            }
            else{
                System.out.println("Not a valid input. Please try again.");
            }
        }
        
    }
    
}