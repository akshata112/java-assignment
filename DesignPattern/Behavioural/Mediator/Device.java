package DesignPattern.Behavioural.Mediator;

public interface Device {
    public String sendARP(String IPAddress);
    public String receiveARP(String IPAddress);
    public void send(String destination, String msg);
    public void receive(String msg);
    public String getDeviceType();
    public String getMacAddress();
    public String getIPAddress();
}
