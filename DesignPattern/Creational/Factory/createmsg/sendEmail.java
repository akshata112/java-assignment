package Factory.createmsg;

import Factory.values.Email;
import Factory.values.Message;

public class sendEmail extends sendMSG{
    public Message createMSG(){
        Message msg=new Email();
        msg.setHeader();
        msg.setBody();
        return msg;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    
}
