package DesignPattern.Behavioural.Mediator;

public class Main {
    public static void main(String[] args) {
        NetworkSwitch switch1=new NetworkSwitch();
        Device d1 =new Computer(switch1, "ip1", "mac1");
        Device d2=new Computer(switch1, "ip2", "mac2");
        switch1.addDevice(d1.getMacAddress(), d1);
        switch1.addDevice(d2.getMacAddress(), d2);
        d1.send("ip2", "hello");
    }
}
