package DesignPattern.Structural.Flyweight;

public class Doodle {
    private int x;
    private int y;
    private String size;
    private int rotation;
    private Pattern pattern;

    public Doodle(int x, int y, String size, int rotation, Pattern pattern){
        this.x=x;
        this.y=y;
        this.size=size;
        this.rotation=rotation;
        this.pattern=pattern;
    }

    public String addToPage(String page){
        return pattern.addToPage(page, x, y, size, rotation);
    }
}
