package Factory;

public class sendSMS extends sendMSG{
    public void createBody(String msg,String From,String To){
        header head;
        head=createHeader();
        this.msg=msg;
        head.setFrom(From);
        head.setTo(To);
    }
    public header createHeader(){
        return new emailHeader();
    }

    public void display(){
        System.out.println("SMS sent successfully!");
    }
}