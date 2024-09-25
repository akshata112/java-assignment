package DesignPattern.Behavioural.Iterator.Iterable;
import java.util.*;

import DesignPattern.Behavioural.Iterator.Song;

public class ArtistIterator implements Iterator{
    public List<Song> songList;
    public String artist;
    public int currentPos=0;

    public ArtistIterator(List<Song> songlist, String artist){
        this.songList=songlist;
        this.artist=artist;
    }

    public boolean hasNext(){
        while(currentPos<songList.size()){
            Song song=songList.get(currentPos);
            if(song.getArtist().equals(artist)){
                return true;
            }
            currentPos++;
        }
        return false;
    }

    public Song getNext(){
        Song song=songList.get(currentPos);
        currentPos++;
        return song;
    }
}
