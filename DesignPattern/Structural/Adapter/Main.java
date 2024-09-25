package DesignPattern.Structural.Adapter;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the format of content to be uploaded.");
        String format=sc.next();
        Html newhtml=new Html(format);
        System.out.println("Html code needs to be converted to PDF format.");
        HtmlAdapter htmltopdf=new HtmlAdapter(newhtml);
        Pdf newpdf=htmltopdf.htmltopdfconverter();

        Workdrive folder=new Workdrive();
        if(folder.feasible(newpdf)){
            System.out.println("The pdf document can be uploaded in drive folder.");
        }
        else{
            System.out.println("Convert the content to pdf format.");
        }






        

        sc.close();
    }
}
