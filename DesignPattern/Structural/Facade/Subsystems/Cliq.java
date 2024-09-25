package DesignPattern.Structural.Facade.Subsystems;

public class Cliq {
    String channel;
    public Cliq(String channel){
        this.channel=channel;
    }
    public void sendMessage(String message){
        System.out.println("\nSending appreciation message on "+this.channel+message+"\n\nMessage sent succefully.");
    }
}
