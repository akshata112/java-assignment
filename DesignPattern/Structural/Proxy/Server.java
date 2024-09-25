package DesignPattern.Structural.Proxy;

public class Server implements Webfetcher{
    public String fetchUrl(String url){
        System.out.println("Fetching from server.");
        return "Response includes HTML, CSS, Javascript components for the requested url :"+url;
    }
}
