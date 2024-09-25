package DesignPattern.Behavioural.Mediator;

public interface SwitchMediator {
    public void addDevice(String macAddress,Device device);
    public void forwardMessage(Device source, String destinationMac, String msg);
    public String forwardARP(Device source,String IPAddress);
}
