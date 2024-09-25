package DesignPattern.Structural.Flyweight;

import java.util.ArrayList;
import java.util.*;

public class Page {
    private static List<Doodle> doodles=new ArrayList<Doodle>();

    public static void addToDoodles(String shape, int x, int y, String size,int rotation){
        Pattern pattern=PatternFactory.getPattern(shape);
        Doodle doodle=new Doodle(x, y, size, rotation, pattern);
        doodles.add(doodle);

    }

    public static String addToPage(String page){
        for(Doodle doodle:doodles){
            page=page+doodle.addToPage(page);
        }
        return page;
    }

    
}
