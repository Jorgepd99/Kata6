package Model;

import java.util.*;

public class Histograma<T> {
    private final Map<T,Integer> mapa = new HashMap<T,Integer>();
    
    public Integer get(T key) {
        return mapa.get(key);
    }
    
    public Set<T> KeySet() {
        return mapa.keySet();
    }
    
    public void increment(T key) {
        mapa.put(key, (mapa.containsKey(key)) ? mapa.get(key) + 1:1);
    }
}
