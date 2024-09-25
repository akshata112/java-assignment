package DesignPattern.Structural.Bridge;

import java.util.Scanner;

import DesignPattern.Structural.Bridge.Operation.AdvancedOperation;
import DesignPattern.Structural.Bridge.Operation.BasicOperation;
import DesignPattern.Structural.Bridge.Operation.OperateStorage;
import DesignPattern.Structural.Bridge.Store.CloudStorage;
import DesignPattern.Structural.Bridge.Store.LocalStorage;

public class Main {
    enum Choices {LOCAL, CLOUD};
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.print("What type of storage would you like to have?(local/cloud):");
        String type=sc.next().toUpperCase();
        Choices userChoice;

        try {
            userChoice=Choices.valueOf(type);
        } catch (Exception e) {
            System.out.println("Invalid Choice");
            return;
        }
        if(userChoice==Choices.LOCAL){
            LocalStorage local=new LocalStorage();
            BasicOperation operator=new BasicOperation(local);
            operateLocal(operator);
        }
        else{
            CloudStorage cloud=new CloudStorage();
            AdvancedOperation operator=new AdvancedOperation(cloud);
            operateCloud(operator);
        }
    }

    public static void operateLocal(OperateStorage operator){
        enum Op {CREATE,READ,UPDATE,DELETE,DISPLAY,EXIT};
        System.out.print("Enter your choice. \n1.Create\n2.Read\n3.Update\n4.Delete\5.Display\n6.Exit\nCHOICE");
        String type=sc.next().toUpperCase();
        Op userChoice;

        try {
            userChoice=Op.valueOf(type);
        } catch (Exception e) {
            System.out.println("Invalid Choice");
            return;
        }

        String filename;
        String content;

        while(true){
            switch (userChoice) {
                case CREATE:
                    System.out.print("Enter filename:");
                    filename=sc.next().toLowerCase();
                    System.out.print("Enter Content of the file:");
                    content=sc.next().toLowerCase();
                    operator.create(filename, content);
                    break;
                
                case READ:
                    System.out.print("Enter filename:");
                    filename=sc.next().toLowerCase();
                    operator.read(filename);
                    break;
    
                case UPDATE:
                    System.out.print("Enter filename:");
                    filename=sc.next().toLowerCase();
                    System.out.print("Enter new content for the file:");
                    content=sc.next().toLowerCase();
                    operator.update(filename, content);
                    break;
    
                case DELETE:
                    System.out.print("Enter filename to be deleted:");
                    filename=sc.next().toLowerCase();
                    operator.delete(filename);
                    break;
    
                case DISPLAY:
                    operator.display();
    
                case EXIT:
                    return;
                default:
                    break;
            }
        }

    }



    public static void operateCloud(AdvancedOperation operator){
        enum Op {CREATE,READ,UPDATE,DELETE,DISPLAY,RENAME,DOWNLOAD,EXIT};
        System.out.print("Enter your choice. \n1.Create\n2.Read\n3.Update\n4.Delete\5.Display\n6.Rename\7.Download\n8.Exit\nCHOICE");
        String type=sc.next().toUpperCase();
        Op userChoice;

        try {
            userChoice=Op.valueOf(type);
        } catch (Exception e) {
            System.out.println("Invalid Choice");
            return;
        }

        String filename;
        String content;

        while(true){
            switch (userChoice) {
                case CREATE:
                    System.out.print("Enter filename:");
                    filename=sc.next().toLowerCase();
                    System.out.print("Enter Content of the file:");
                    content=sc.next().toLowerCase();
                    operator.create(filename, content);
                    break;
                
                case READ:
                    System.out.print("Enter filename:");
                    filename=sc.next().toLowerCase();
                    operator.read(filename);
                    break;
    
                case UPDATE:
                    System.out.print("Enter filename:");
                    filename=sc.next().toLowerCase();
                    System.out.print("Enter new content for the file:");
                    content=sc.next().toLowerCase();
                    operator.update(filename, content);
                    break;
    
                case DELETE:
                    System.out.print("Enter filename to be deleted:");
                    filename=sc.next().toLowerCase();
                    operator.delete(filename);
                    break;
    
                case DISPLAY:
                    operator.display();
                    break;
                
                case RENAME:
                    System.out.print("Enter existing filename:");
                    String oldfilename=sc.next().toLowerCase();
                    System.out.print("Enter new name to be given:");
                    filename=sc.next().toLowerCase();
                    operator.rename(oldfilename, filename);
                    break;

                case DOWNLOAD:
                    System.out.print("Enter filename:");
                    filename=sc.next().toLowerCase();
                    operator.download(filename);
                    break;
    
                case EXIT:
                    return;
                default:
                    break;
            }
        }

    }
}
