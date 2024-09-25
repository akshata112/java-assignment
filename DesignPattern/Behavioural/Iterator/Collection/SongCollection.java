package DesignPattern.Behavioural.Iterator.Collection;

import DesignPattern.Behavioural.Iterator.Song;
import DesignPattern.Behavioural.Iterator.Iterable.ArtistIterator;
import DesignPattern.Behavioural.Iterator.Iterable.MovieIterator;

public interface SongCollection {
    public void addSong(Song song);
    public ArtistIterator createArtistIterator(String artist);
    public MovieIterator createMovieIterator(String movie);
    
}
