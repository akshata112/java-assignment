package DesignPattern.Behavioural.Iterator.Iterable;

import DesignPattern.Behavioural.Iterator.Song;

public interface Iterator {
    public boolean hasNext();
    public Song getNext();
}
