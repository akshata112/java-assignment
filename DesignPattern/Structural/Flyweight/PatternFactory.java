package DesignPattern.Structural.Flyweight;

import java.util.HashMap;

import java.util.*;

public class PatternFactory {
    static Map<String, Pattern> allPatterns=new HashMap<String,Pattern>();

    public static Pattern getPattern(String shape){
        Pattern result=allPatterns.get(shape);
        if(result==null){
            result=new Pattern(shape);
            allPatterns.put(shape, result);
        }
        return result;
    }

}
