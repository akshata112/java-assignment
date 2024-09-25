package DesignPattern.Structural.Facade;

import DesignPattern.Structural.Facade.Subsystems.Cliq;
import DesignPattern.Structural.Facade.Subsystems.Download;
import DesignPattern.Structural.Facade.Subsystems.UserInterface;
import DesignPattern.Structural.Facade.Subsystems.Record;
import DesignPattern.Structural.Facade.Subsystems.Template;

import java.util.*;

public class SpotAward {
    private UserInterface spotAwardUI=new UserInterface();
    private List<Record> records= new ArrayList<>();
    private Record currentRecord;
    private Download downloader=new Download();
    private Cliq cliq=new Cliq("Appreciation Channel"); 

    Scanner sc=new Scanner(System.in);

    public void create(){
        System.out.print("Name of the awardee: ");
        String awardee=sc.next();
        System.out.print("Citation: ");
        String citation=sc.next();
        spotAwardUI.putDetails(awardee, citation);
    }

    public void createCertificate(){
        System.out.println("\nOn successfull submission");
        int id=records.size()+1;
        Record newRecord = new Record(id,spotAwardUI);
        records.add(newRecord);
        currentRecord=newRecord;
        System.out.println("New record added.");
        System.out.println("\nOpening certificate preview");
        Template temp=new Template();
        System.out.println(temp.createCertificate(newRecord));
    }

    public void downloadAndSend(){
        String link="CertificateTemplate?name="+currentRecord.awardee+"&ID="+String.valueOf(currentRecord.ID);
        downloader.downloadTemplate(link);

        String message="\n\nHi "+currentRecord.awardee+",\nCongratulations on your Spot Award\nYou have done great job.";
        cliq.sendMessage(message);
    }





}
