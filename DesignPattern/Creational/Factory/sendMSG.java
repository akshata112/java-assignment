package Factory;

public abstract class sendMSG{
    String msg;
    public abstract header createHeader();
    public abstract void createBody(String msg,String From,String To);
    public abstract void display();
    // public abstract void display();
}