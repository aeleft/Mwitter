package mwitter;

public class MweetList{
    
    private Mweet[] array;
    private int numElements;
    
    public MweetList(){
        array = new Mweet[2];
        numElements = 0;
    }
    
    public String toString(){
        if(numElements == 0)
            return "There are no mweets.";
        String s = "";
        for(int i = numElements-1; i >= 0; i--){
            s += array[i].toString() + "\n" + "\n";
        }
        return s;
    }
          
    public void add(Mweet m){
        
        //First it checks if the array if full, and resizes it if it is.
        if(numElements == array.length){
            Mweet[] b = new Mweet[2*array.length];
            System.arraycopy( array, 0, b, 0, array.length );
            array = b;              
        }
        
        //If the array is empty, it adds the first element, in this case, Mweet m.        
        if(numElements == 0){
            array[numElements] = m;
            numElements++;
        }
        //Otherwise, it adds the mweet m according to its Date.
        else{        
            for(int index = 0; index < numElements; index++){
                if(m.getDate().before(array[index].getDate())){
                    for(int j = numElements; j > index; j--)
                        array[j] = array[j-1];
                    array[index] = m;
                    numElements++;
                    break;
                }           
                if(array[index+1] == null){
                    array[index+1] = m;
                    numElements++;
                    break;
                }
            }    
        }
    }
    
    
    public void add(MweetList ml){
        for(int i = 0; i < ml.numElements; i++){
            add(ml.array[i]);    
        }
    }
    
    public void remove(User u){
        for(int index = 0; index < numElements; index++){
            if(u.getUsername().equals(array[index].getAuthor())){
                for(int j = index; j < numElements; j++){
                    if(j == numElements-1)
                        array[j] = null;                    
                    else
                        array[j] = array[j+1];                    
                }
                numElements--;
                index--; //counteracts the index++ of the for loop.
            }
        }
    }
    
}