package DesignPattern.Behavioural.Iterator.Collection;
import java.util.*;

import DesignPattern.Behavioural.Iterator.Song;
import DesignPattern.Behavioural.Iterator.Iterable.ArtistIterator;
import DesignPattern.Behavioural.Iterator.Iterable.MovieIterator;

public class Spotify implements SongCollection {

    public List<Song> songs =new ArrayList<>();
    public List<String> artists=new ArrayList<>();
    public List<String> movies=new ArrayList<>();

    public void addSong(Song song){
        songs.add(song);
        if (!artists.contains(song.getArtist())){
            artists.add(song.getArtist());
        }
        if(!movies.contains(song.getMovie())){
            movies.add(song.getMovie());
        }
    }

    public ArtistIterator createArtistIterator(String artist){
        artists.add(artist);
        return new ArtistIterator(songs,artist);
    }

    public MovieIterator createMovieIterator(String movie){
        movies.add(movie);
        return new MovieIterator(songs, movie);
    }

}
