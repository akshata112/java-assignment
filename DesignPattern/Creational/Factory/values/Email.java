package Factory.values;
import java.util.*;

public class Email implements Message{
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

        System.out.print("Subject:");
        this.subject=sc.next();

    }

    public void setBody(){
        System.out.print("Message:");
        this.msg=sc.next();

    }
}
