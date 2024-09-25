package DesignPattern.Behavioural.Mediator;

import java.util.*;

public class Computer implements Device{
    protected SwitchMediator mediator;
    protected String IPAddress;
    protected String macAddress;
    public Map<String,String> ARPCache=new HashMap<>();

    

    public Computer(SwitchMediator mediator, String iPAddress, String macAddress) {
        this.mediator = mediator;
        IPAddress = iPAddress;
        this.macAddress = macAddress;
    }

    public String sendARP(String IPAddress){
        return mediator.forwardARP(this, IPAddress);
    }

    public String receiveARP(String ip){
        if(ip.equals(this.IPAddress)){
            return this.macAddress;
        }
        return null;
    }

    public void send(String destinationIP, String msg){
        String destMac;
        if(!ARPCache.containsKey(destinationIP)){
            destMac=sendARP(destinationIP);
            ARPCache.put(destinationIP, destMac);
        }
        else{
            destMac=ARPCache.get(destinationIP);
        }
        System.out.println(destMac);
        mediator.forwardMessage(this, destMac, msg);
    }

    public void receive(String msg){
        System.out.println("Message Received at "+this.getMacAddress()+": "+msg);
    }

    public String getDeviceType(){
        return "Computer";
    }
    public String getMacAddress(){
        return macAddress;
    }
    public String getIPAddress(){
        return IPAddress;
    }
}
