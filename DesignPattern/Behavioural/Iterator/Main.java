package DesignPattern.Behavioural.Iterator;

import java.util.*;
import DesignPattern.Behavioural.Iterator.Collection.Spotify;
import DesignPattern.Behavioural.Iterator.Iterable.ArtistIterator;
import DesignPattern.Behavioural.Iterator.Iterable.MovieIterator;

public class Main {
    public static void main(String[] args) {
        enum choice {ARTIST,MOVIE};
        Scanner sc=new Scanner(System.in);
        System.out.println("Adding some songs to the collection.");
        
        Spotify mySpotify=new Spotify();
        mySpotify.addSong(new Song("aaaaaa", "a", "ma"));
        mySpotify.addSong(new Song("bbbbbb", "b", "ma"));
        mySpotify.addSong(new Song("cccccc", "c", "ma"));
        mySpotify.addSong(new Song("dddddd", "a", "mb"));
        mySpotify.addSong(new Song("eeeeee", "b", "mb"));
        mySpotify.addSong(new Song("ffffff", "c", "mb"));

        System.out.print("Enter if yiu wish to go by your Artist or Movie choice: ");
        String ch=sc.next().toUpperCase();

        choice choose;
        try {
            choose=choice.valueOf(ch);
        } catch (Exception e) {
            System.out.println("Invalid entry.");
            sc.close();
            return;
        }
        List<String> mylist;
        switch (choose) {
            case ARTIST:
                System.out.println("You can find below artists.");
                mylist=mySpotify.artists;
                for (String artist: mylist) {
                    System.out.println(artist);
                }
                System.out.print("Your choice:");
                String artist=sc.next().toLowerCase();
                ArtistIterator artistIterator=mySpotify.createArtistIterator(artist);

                while (artistIterator.hasNext()) {
                    System.out.println(artistIterator.getNext().getTitle());
                }
                break;
        
            case MOVIE:
                System.out.println("You can find below movie albums.");
                mylist=mySpotify.movies;
                for (String movie: mylist) {
                    System.out.println(movie);
                }
                System.out.print("Your choice:");
                String movie=sc.next().toLowerCase();
                MovieIterator movieIterator=mySpotify.createMovieIterator(movie);

                while (movieIterator.hasNext()) {
                    System.out.println(movieIterator.getNext().getTitle());
                }
                break;
            default:
                break;
        }

        sc.close();

    }
}
