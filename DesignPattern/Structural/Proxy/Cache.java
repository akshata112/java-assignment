package DesignPattern.Structural.Proxy;
import java.util.*;

public class Cache implements Webfetcher{
    private Server serverRequest=new Server();
    private final int cacheSize=5;
    private Map<String, String> cachedUrls=new LinkedHashMap<String, String>();

    public String fetchUrl(String url){
        String response;
        if(cachedUrls.containsKey(url)){
            System.out.println("Fetching from cache.");
            response= cachedUrls.get(url);
        }
        else{
            response=serverRequest.fetchUrl(url);
            addToCache(url,response);
        }
        return response;
    }

    private void addToCache(String url,String response){
        if(cachedUrls.size()<cacheSize){
            cachedUrls.put(url,response);
        }
        else{
            String firstKey=cachedUrls.keySet().iterator().next();
            cachedUrls.remove(firstKey);
            cachedUrls.put(url,response);
        }
    }
}
