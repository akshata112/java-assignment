package Factory;
import java.util.*;

import Factory.createmsg.sendEmail;
import Factory.createmsg.sendMSG;
import Factory.createmsg.sendSMS;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        enum Choice {SMS, EMAIL};
        System.out.print("Enter your choice(SMS/EMAIL) :");
        String choice=sc.nextLine().toUpperCase();

        Choice userChoice;

        try {
            userChoice=Choice.valueOf(choice);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid choice");
            sc.close();
            return;
        }
        sendMSG msg;

        switch (userChoice) {
            case SMS:
                msg=new sendSMS();
                msg.createMSG();
                break;

            case EMAIL:
                msg=new sendEmail();
                msg.createMSG();
                break;
        
            default:
                break;
        }

        sc.close();


    }

        
    
}


// use of enums, realtime usecases
