package DesignPattern.Structural.Facade.Subsystems;
import java.util.*;

public class Record {
    public int ID;
    public String awardee;
    String citation;
    String author;
    Template template;

    public Record(int ID,UserInterface ui){
        this.ID=ID;
        this.awardee=ui.awardee;
        this.citation=ui.citation;
        this.author=ui.author;
    }

    public List<Record> addRecord(List<Record> records, Record userRecord){
        records.add(userRecord);
        return records;
    }
}
