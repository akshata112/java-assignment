package DesignPattern.Structural.Adapter;

public class HtmlAdapter extends Pdf{
    private Html htmldoc;

    public HtmlAdapter(Html htmldoc){
        this.htmldoc=htmldoc;
    }

    public Pdf htmltopdfconverter(){
        System.out.println("The input content is in "+htmldoc.getFormat()+" format. Rendering html code into Pdf document.");
        Pdf newpdf=new Pdf("pdf");
        return newpdf;
    }

}
