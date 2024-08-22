package Factory;
import java.util.*;

public class Main {
    private static sendMSG obj;
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter message to be sent: ");
        String msg=sc.next();
        sc.nextLine();

        System.out.println("Enter From address: ");
        String from=sc.next();

        System.out.println("Enter To address: ");
        String to=sc.next();

        System.out.println("Enter your choice:(SMS/Email)");
        String choice=sc.next();

        if(choice.equalsIgnoreCase("SMS")){
            obj=new sendSMS();
        }
        else if(choice.equalsIgnoreCase("Email")){
            System.out.print("Enter Subject: ");
            String subject=sc.next();
            sendEmail.sub=subject;
            obj=new sendEmail();
        }
        else{
            System.out.println("Invalid choice");
        }
        sc.close();

        obj.createBody(msg,from,to);
        obj.display();

    }

    static void display(){
        System.out.println("Message Sent!");
    }
    
}


// use of enums, realtime usecases
