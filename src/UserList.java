package mwitter;

public class UserList{
    
    private User[] array;
    private int numUsers;
    
    public UserList(){
        array = new User[2];
        numUsers = 0;
    }
    
    public String toString(){
       if(numUsers == 0)
            return "There are no users.";
        String s = "";
        for(int i = 0; i < numUsers; i++){
            s += array[i].getUsername() + "\n";
        }
        return s;
    }    
    
    public void add(User u){
        //Resizes the array if it is full.
        if(numUsers == array.length){
            User[] b = new User[2*array.length];
            System.arraycopy( array, 0, b, 0, array.length );
            array = b;              
        }
        //Adds the User u
        array[numUsers] = u;
        numUsers++;
    }
    
    public void remove(User u){
        for(int index = 0; index < numUsers; index++){
            if(u.getUsername().equals(array[index].getUsername())){
                for(int j = index; j < numUsers; j++){
                    if(j == numUsers-1)
                        array[j] = null;
                    else
                        array[j] = array[j+1];                    
                }
                numUsers--;
                break; //A User can only exist ONCE within a UserList, as shown in Mwitter.java.
                       //Therefore he only needs to be deleted once.
                //When the User is deleted, we break out of the outer for loop, and the method terminates.
            }
        }
    }
      
    public User find(String username){
        for(int index = 0; index < numUsers; index++){
            if(username.equals(array[index].getUsername()))
                return array[index];       
        }
        return null;
    }
    
    public User find(String username, String password){
        for(int index = 0; index < numUsers; index++){
            if(username.equals(array[index].getUsername()) && password.equals(array[index].getPassword()))
                return array[index];       
        }
        return null;
    }
    
    public void addMweetToFollowedMweets(Mweet m){
        for(int index = 0; index < numUsers; index++){
            array[index].getFollowedMweets().add(m);          
        }
    }
    
}