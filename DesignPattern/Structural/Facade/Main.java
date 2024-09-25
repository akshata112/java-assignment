package DesignPattern.Structural.Facade;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        enum proceed {YES,NO};
        System.out.println("Welcome to SPOT AWARD Application.");
        System.out.println("Enter the details.");
        SpotAward application=new SpotAward();
        application.create();

        System.out.print("Do you want to Submit(YES/NO):");
        String ch=sc.next().toUpperCase();

        proceed choice;
        try {
            choice=proceed.valueOf(ch);
        } catch (Exception e) {
            System.out.println("Invalid entry.");
            sc.close();
            return;
        }
        if(choice==proceed.YES){
            application.createCertificate();
        }
        else{
            sc.close();
            return;
        }


        System.out.print("If you wish to Download and Send(YES/NO):");
        ch=sc.next().toUpperCase();

        try {
            choice=proceed.valueOf(ch);
        } catch (Exception e) {
            System.out.println("Invalid entry.");
            sc.close();
            return;
        }
        if(choice==proceed.YES){
            application.downloadAndSend();
        }
        else{
            sc.close();
            return;
        }

        sc.close();
        

    }
}
