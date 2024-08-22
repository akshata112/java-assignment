package Factory;

public class sendEmail extends sendMSG{
    static String sub;
    header head;
    public void createBody(String msg,String From,String To){

        head=createHeader();
        this.msg=msg;
        head.setFrom(From);
        head.setTo(To);
    }
    public header createHeader(){
        return new emailHeader();
    }

    public void display(){
        System.out.println("Email sent successfully!");
    }

}
