package DesignPattern.Structural.Proxy;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Webfetcher browserCache=new Cache();
        while (true) {
            
            System.out.print("Enter the request URl: ");
            String Url=sc.next().toLowerCase();

            System.out.println(browserCache.fetchUrl(Url));
            System.out.println("If you wish to close the browser(yes/no):");
            String choice=sc.next().toLowerCase();
            if(choice.equals("yes")){
                sc.close();
                return;
            }
          
        }
    }
}
