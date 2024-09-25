package DesignPattern.Structural.Flyweight;

public class Pattern {
    private final String shape;

    public Pattern(String shape){
        this.shape=shape;
    }

    public String addToPage(String page,int x, int y, String size, int rotation){
        page="("+shape+", "+String.valueOf(x)+", "+String.valueOf(y)+", "+size+", "+String.valueOf(rotation)+")\n";
        return page;
    }

}