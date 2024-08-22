package Factory;

public class emailHeader implements header{
    String From;
    String To;
    String Subject;
    public void setFrom(String From){
        this.From=From;
    }
    public void setTo(String To){
        this.To=To;
    }
    public void setSubject(String sub){
        this.Subject=sub;
    }

}
