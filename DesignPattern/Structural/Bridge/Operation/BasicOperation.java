package DesignPattern.Structural.Bridge.Operation;

import java.util.Scanner;

import DesignPattern.Structural.Bridge.Store.Storage;

public class BasicOperation implements OperateStorage{

    protected Storage storagetype;

    public BasicOperation(Storage storagetype){
        this.storagetype=storagetype;
    }
    
    public void create(String filename,String content){

        int filesize=content.length();
        if(storagetype.isFull(filesize)){
            System.out.println("Not enough space to store the file.");
            return;
        }
        Scanner sc=new Scanner(System.in);
        while(storagetype.ifExists(filename)){
            System.out.println("File with the name already exists.");
            System.out.print("Give uniq filename:");
            filename=sc.next();
        }
        sc.close();
        storagetype.create(filename, content);
    }

    public void read(String filename){
        if(storagetype.ifExists(filename)){
            System.out.println(storagetype.read(filename));
        }
        else{
            System.out.println("File does not exist.");
        }
    }
    public void update(String filename, String content){
        if(storagetype.ifExists(filename)){
            storagetype.update(filename, content);
        }
        else{
            System.out.println("File does not exists.");
        }
    }
    public void delete(String filename){
        if(storagetype.ifExists(filename)){
            storagetype.delete(filename);
        }
        else{
            System.out.println("File does not exists.");
        }
    }

    public void display(){
        storagetype.display();
    }
}
