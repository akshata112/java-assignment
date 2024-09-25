package DesignPattern.Structural.Facade.Subsystems;
import java.util.*;;

public class Template {
    String content;
    public String createCertificate(Record record){
        content="\n     SPOT AWARD\n\n     "+record.awardee+"\n\n     "+record.citation+"\n     "+new Date()+"\n\n     Presented By\n     "+record.author+"\n";
        System.out.println("Certificate Preview");
        return content;
    }
}
