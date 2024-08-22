package Prototype;
import java.util.*;
public class Main {
    public static int notebookCount=0;
    public static int diaryCount=0;
    static Scanner sc=new Scanner(System.in);
    static Map<Integer, commonNotebook> notebookDesigns=new HashMap<Integer, commonNotebook>();
    static Map<Integer, Diary> diaryDesigns=new HashMap<Integer, Diary>();

    public static void main(String[] args) {
        while(true){
            System.out.println("Prototype creation");
            System.out.println("Enter your choice");
            System.out.println("1. Creating new prototype");
            System.out.println("2. Display existing prototype");
            System.out.println("3. Create copies");
            System.out.println("4. Exit");
            int choice=sc.nextInt();

            switch (choice) {
                case 1:
                    createPrototype();
                    break;

                case 2:
                    display();
                    break;
                
                case 3:
                    createCopies();
                    break;
                case 4:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }

    }

    public static void display(){
        for(Map.Entry<Integer, commonNotebook> entry : notebookDesigns.entrySet()){
            System.out.println(entry.getValue());
        }

        for(Map.Entry<Integer, Diary> entry : diaryDesigns.entrySet()){
            System.out.println(entry.getValue());
        }
    }

    public static void createCopies(){
        notebookPrototype copy;
        int key;

        System.out.println("Choose\n1. Notebook\n2. Diary");
        int type=sc.nextInt();
        switch (type) {
            case 1:
                for(Map.Entry<Integer, commonNotebook> entry : notebookDesigns.entrySet()){
                    System.out.println(entry.getKey()+". "+entry.getValue());
                }
                System.out.print("Choose Prototype number:");
                key=sc.nextInt();
                copy=new commonNotebook(notebookDesigns.get(key));
                System.out.println("New copy created.");
                System.out.println(copy);
                break;
            
            case 2:
                for(Map.Entry<Integer, Diary> entry : diaryDesigns.entrySet()){
                    System.out.println(entry.getKey()+". "+entry.getValue());
                }
                System.out.print("Choose Prototype number:");
                key=sc.nextInt();
                copy=new Diary(diaryDesigns.get(key));
                System.out.println("New copy created.");
                System.out.println(copy);
                break;
        
            default:
                break;
        }

        
        

    }

    public static void createPrototype(){
        System.out.println("Type of Notebook:");
        System.out.println("1. Common Notebbok");
        System.out.println("2. Diary");
        int userChoice=sc.nextInt();

        switch (userChoice) {
            case 1:
                commonNotebook newCommonNotebook=new commonNotebook();
                createNotebook(newCommonNotebook);
                createCommonNotebook(newCommonNotebook);
                notebookDesigns.put(++notebookCount, newCommonNotebook);
                break;

            case 2:
                Diary newDiary=new Diary();
                createNotebook(newDiary);
                createDiary(newDiary);
                diaryDesigns.put(++diaryCount, newDiary);
                break;
        
            default:
                System.out.println("Invalid choice.");
                break;
        }

    }

    public static void createNotebook(notebookPrototype newNotebook){

        System.out.println("Enter details:");

        System.out.print("Prototype Name:"); 
        newNotebook.prototypeName=sc.next();
        sc.nextLine();

        System.out.print("Number of Pages:"); 
        newNotebook.numOfPages=sc.nextInt();

        System.out.print("Cover design:"); 
        newNotebook.coverDesign=sc.next();
        sc.nextLine();

        System.out.print("Binding Type:"); 
        newNotebook.bindingType=sc.next();
        sc.nextLine();

    }

    public static void createCommonNotebook(commonNotebook newNotebook){
        System.out.print("Index Page Design:"); 
        newNotebook.indexPageDesign=sc.next();
    }

    public static void createDiary(Diary newNotebook){
        System.out.print("Calendar Page Design:"); 
        newNotebook.calendarPageDesign=sc.next();
    }
}
