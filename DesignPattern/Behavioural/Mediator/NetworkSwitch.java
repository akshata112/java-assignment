package DesignPattern.Behavioural.Mediator;
import java.util.*;

public class NetworkSwitch implements SwitchMediator{
    Map<String,Device> addressMAP = new HashMap<>();
    Map<String,Device> devicesInNetwork=new HashMap<>();

    public NetworkSwitch(){

    }

    public void addDevice(String macAddress,Device device){
        devicesInNetwork.put(macAddress,device);
        System.out.println("New device of type "+device.getDeviceType()+" is added to the network.");
    }

    public String forwardARP(Device source,String IPAddress){
        if(!addressMAP.containsValue(source)){
            addressMAP.put(source.getMacAddress(), source);
        }
        for(Device d:devicesInNetwork.values()){
            if(!d.getIPAddress().equals(IPAddress)){
                String destMac=d.receiveARP(IPAddress);
                if(destMac!=null){
                    System.out.println(destMac);
                    return destMac;
                }
            }
        }
        return "IP address not found";
    }

    public void forwardMessage(Device sourceMac, String destinationMac, String msg){
        if(!addressMAP.containsValue(sourceMac)){
            addressMAP.put(sourceMac.getMacAddress(), sourceMac);
        }

        if(devicesInNetwork.containsKey(destinationMac)){
            devicesInNetwork.get(destinationMac).receive(msg);
        }
        else{
            System.out.println("Destination not available.");
        }
    }

}
