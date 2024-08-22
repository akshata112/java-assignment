package AbstractFactory;
import java.util.*;

public class Main {
    private static documentBuilder object;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter your choice(HTML/Word Document) :");
        String choice=in.nextLine();

        if(choice.equalsIgnoreCase("HTML")){
            object=new htmlBuilder();
        }
        else if (choice.equalsIgnoreCase("Word Document")){
            object=new wordDocBuilder();
        }

        header head=object.defineHeader();
        footer foot=object.defineFooter();
        content cont=object.defineContent();

        head.addHeader();
        cont.addContent();
        foot.addFooter();
        in.close();
    }
}
