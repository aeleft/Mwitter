package mwitter;

import java.util.Date;

public class Mweet{
    
    private String content;
    private String author;
    private Date d;
    
    public Mweet(String content, String author){
        this.content = content;
        this.author = author;
        d = new Date();
    }

    public String toString(){
        return "content: " + content + "\nauthor: " + author + "\n" + d.toString();
    }
    
    public String getContent(){
        return content;
    }
    
    public String getAuthor(){
        return author;
    }
        
    public Date getDate(){
        return d;
    }
    
}