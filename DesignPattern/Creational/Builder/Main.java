package Builder;
import java.util.*;

public class Main {
    enum Choice {YES, NO};
    public static void main(String[] args) {

        

        Scanner sc=new Scanner(System.in);

        System.out.print("If user wish to create new bank account(YES/NO):");
        String ch=sc.next().toUpperCase();

        Choice userChoice;

        try {
            userChoice=Choice.valueOf(ch);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid choice");
            sc.close();
            return;
        }

        switch (userChoice) {
            case YES:
                createAccount();
                break;
        
            case NO:
                sc.close();
                return;
        
        }
        sc.close();

    }

    public static void createAccount(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Creating new bank account.");
        System.out.print("Enter the account type:");
        String acctype=sc.next();
        System.out.print("Enter currency:");
        String currency=sc.next();

        Builder build=new AccountBuilder().setAccounttype(acctype).setCurrency(currency);

        String ch;
        System.out.print("If user wish to create UPI Id(YES/NO):");
        ch=sc.next().toUpperCase();

        Choice userChoice;
        try {
            userChoice=Choice.valueOf(ch);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid choice");
            sc.close();
            return;
        }
        
        if(userChoice==Choice.YES){
            System.out.print("Enter UPI Id for the account:");
            String upi=sc.next();
            build=build.setUpiAccount(upi);
        }


        System.out.print("If user wish to get additional services like Debit Card, Credit Card, Insurance.(Yes/No):");
        ch=sc.next().toUpperCase();
        try {
            userChoice=Choice.valueOf(ch);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid choice");
            sc.close();
            return;
        }
        
        if(userChoice==Choice.YES){
            System.out.print("Enter additoonal services required(Debit Card, Credit Card, Insurance):");
            String addservice=sc.next();
            build=build.setAdditionalServices(addservice);
        }


        BankAccount account=build.build();
        System.out.println(account);

        sc.close();


    }
}
//Mandatory type of paramters for each object