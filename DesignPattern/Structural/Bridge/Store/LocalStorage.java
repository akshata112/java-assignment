package DesignPattern.Structural.Bridge.Store;
import java.util.*;

public class LocalStorage implements Storage{
    private Map<String, String> files = new HashMap<String, String>();
    private final double storageCapacity=100;
    private int memoryOccupied=0;

    public boolean ifExists(String filename){
        if(files.containsKey(filename)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isFull(int size){
        if(memoryOccupied+size>storageCapacity){
            System.out.println("You can get extra storage now.");
            return true;
        }
        else{
            return false;
        }
    }

    public String read(String filename){
        return files.get(filename);
    }

    public void create(String filename, String content){
        memoryOccupied=memoryOccupied+content.length();
        files.put(filename, content);
    }

    public void update(String filename, String content){
        memoryOccupied=memoryOccupied-files.get(filename).length();
        if(memoryOccupied+content.length()>storageCapacity){
            System.out.println("New content cannot be fit in storage.");
        }
        else{
            files.put(filename, content);
        }

    }

    public void delete(String filename){
        memoryOccupied=memoryOccupied-files.get(filename).length();
        files.remove(filename);
    }

    public void display(){
        System.out.println("Maximum capacity of the storage is "+storageCapacity);
        System.out.println(storageCapacity-memoryOccupied+" % of storage is left for use.");
        Set<String> keys = files.keySet();
        for(String file: keys){
            System.out.println(file+" - " +files.get(file));
        }
    }


}
