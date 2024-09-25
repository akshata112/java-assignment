package DesignPattern.Structural.Adapter;

public class Html {
    private String docFormat;

    public Html(String docFormat){
        this.docFormat=docFormat;
    }

    public String getFormat(){
        return docFormat;
    }

}
