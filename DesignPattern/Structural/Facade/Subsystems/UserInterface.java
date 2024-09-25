package DesignPattern.Structural.Facade.Subsystems;
import java.util.*;

public class UserInterface {
    String awardee;
    String citation;
    String author;
    Scanner sc=new Scanner(System.in);
    
    public UserInterface putDetails(String awardee,String citation){
        if(this.validateCitation(citation)){
            this.citation=citation;
        }
        else{
            System.out.println("Enter new citation:");
            citation=sc.nextLine();
            putDetails(awardee, citation);
        }
        this.awardee=awardee;
        this.author=autoFillAuthor();
        return this;
    }

    private static String autoFillAuthor(){
        return System.getProperty("user.name");
    }

    private boolean validateCitation(String citation){
        if(citation.length()<=300){
            return true;
        }
        else{
            return false;
        }
    }
}
