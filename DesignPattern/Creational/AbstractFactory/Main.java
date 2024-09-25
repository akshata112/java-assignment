package AbstractFactory;
import java.util.*;
import AbstractFactory.builder.*;
import AbstractFactory.content.*;
import AbstractFactory.pkg_footer.*;
import AbstractFactory.pkg_header.*;

public class Main {
    private static documentBuilder doc;
    public static void main(String[] args) {
        enum Choice {HTML,WORD_DOC};
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter your choice(HTML/WORD_DOC) :");
        String choice=sc.nextLine().toUpperCase();

        Choice userChoice;

        try {
            userChoice=Choice.valueOf(choice);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid choice");
            sc.close();
            return;
        }

        switch (userChoice) {
            case HTML:
                doc=new htmlBuilder();
                break;
        
            case WORD_DOC:
                doc=new wordDocBuilder();
                break;

            default:
                break;
        }

        header head=doc.defineHeader();
        footer foot=doc.defineFooter();
        content cont=doc.defineContent();

        head.addHeader();
        cont.addContent();
        foot.addFooter();
        sc.close();
    }
}
