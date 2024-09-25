package DesignPattern.Behavioural.Iterator.Iterable;

import java.util.List;

import DesignPattern.Behavioural.Iterator.Song;

public class MovieIterator implements Iterator{
    public List<Song> songList;
    public String movie;
    public int currentPos=0;

    public MovieIterator(List<Song> songlist, String movie){
        this.songList=songlist;
        this.movie=movie;
    }

    public boolean hasNext(){
        while(currentPos<songList.size()){
            Song song=songList.get(currentPos);
            if(song.getMovie().equals(movie)){
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
