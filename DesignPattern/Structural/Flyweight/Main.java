package DesignPattern.Structural.Flyweight;
import java.util.*;

public class Main {
    enum Choice {YES,NO};
    static Scanner sc=new Scanner(System.in);
    private static String pageContent="";
    public static void main(String[] args) {


        while(true){
            System.out.print("Would you like to add some doodles to the page(yes/no):");
            String ch=sc.next().toUpperCase();

            Choice userChoice;
        try {
                userChoice=Choice.valueOf(ch);
            } catch (Exception e) {
                System.out.println("Invalid choice.");
                sc.close();
                return;
            }

        switch (userChoice) {
                case YES:
                    createDoodle();
                    break;
                
                case NO:
                    displayPage();
                    sc.close();
                    return;
            
                default:
                    break;
            }
        }

    }

    public static void createDoodle(){

        System.out.print("Name of shape:");
        String shape=sc.next();

        System.out.println("Enter Coordinates.");
        System.out.print("X coordinate:");
        int x=sc.nextInt();

        System.out.print("Y coordinate:");
        int y=sc.nextInt();

        System.out.print("Size(Small/Medium/Large):");
        String size=sc.next();

        System.out.print("Angle of rotation:");
        int rotation=sc.nextInt();
        
        Page.addToDoodles(shape, x, y, size, rotation);




    }

    public static void displayPage(){
        pageContent=Page.addToPage(pageContent);
        System.out.println(pageContent);
    }
}
