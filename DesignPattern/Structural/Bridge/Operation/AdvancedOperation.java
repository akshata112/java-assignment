package DesignPattern.Structural.Bridge.Operation;

import DesignPattern.Structural.Bridge.Store.Storage;

public class AdvancedOperation extends BasicOperation{
    public AdvancedOperation(Storage storagetype){
        super(storagetype);
    }

    public void rename(String oldFileName, String newFileName){
        if(storagetype.ifExists(oldFileName)){
            String content=storagetype.read(oldFileName);
            storagetype.delete(oldFileName);
            storagetype.create(newFileName, content);
        }
        else{
            System.out.println("File does not exist.");
        }
    }

    public void download(String filename){
        if(storagetype.ifExists(filename)){
            System.out.println(filename+" downloaded successfully.");
        }
        else{
            System.out.println("Requested file does not exists.");
        }
    }
}
