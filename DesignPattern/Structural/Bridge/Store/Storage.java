package DesignPattern.Structural.Bridge.Store;

public interface Storage {
    public boolean ifExists(String filename);
    public boolean isFull(int size);
    public String read(String filename);
    public void create(String filename, String content);
    public void update(String filename, String content);
    public void delete(String filename);
    public void display();
}