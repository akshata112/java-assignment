package Factory.createmsg;

import Factory.values.Message;
import Factory.values.SMS;

public class sendSMS extends sendMSG{
    public Message createMSG(){
        Message msg=new SMS();
        msg.setHeader();
        msg.setBody();
        return msg;
    }

    public void display(){
        System.out.println("SMS sent successfully!");
    }
}