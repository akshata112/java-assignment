package Factory;

public class SMSHeader implements header{
    String From;
    String To;
    public void setFrom(String From){
        this.From=From;
    }
    public void setTo(String To){
        this.To=To;
    }

}

