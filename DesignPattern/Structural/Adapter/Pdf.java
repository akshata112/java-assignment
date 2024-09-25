package DesignPattern.Structural.Adapter;

public class Pdf {
    private String docFormat;

    public Pdf(){

    }

    public Pdf(String docFormat){
        this.docFormat=docFormat;
    }

    public String getFormat(){
        return this.docFormat;
    }
}
