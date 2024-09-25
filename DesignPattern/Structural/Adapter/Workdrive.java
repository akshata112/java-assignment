package DesignPattern.Structural.Adapter;
public class Workdrive{
    private final String docFormat="pdf";

    public String getFormat(){
        return this.docFormat;
    }

    public boolean feasible(Pdf doc){
        return this.getFormat().equalsIgnoreCase(doc.getFormat());
    }
}


