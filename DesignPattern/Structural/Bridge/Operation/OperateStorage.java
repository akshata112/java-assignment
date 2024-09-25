package DesignPattern.Structural.Bridge.Operation;

public interface OperateStorage {
    public void create(String filename,String content);
    public void read(String filename);
    public void update(String filename, String content);
    public void delete(String filename);
    public void display();
}
