package Factory.values;

import java.util.Scanner;

public class SMS implements Message{
    String from;
    String to;
    String subject;
    String msg;
    Scanner sc=new Scanner(System.in);
    public void setHeader(){
        System.out.println("Enter details for Email.");
        System.out.print("From:");
        this.from=sc.next();

        System.out.print("To:");
        this.to=sc.next();

    }

    public void setBody(){
        System.out.print("Message:");
        this.msg=sc.next();

    }

}

