package View;

import Model.Histograma;
import java.util.*;

public class DBHistogramBuilder {

    public DBHistogramBuilder() {
        
    }
    
    public static Histograma initHistograma(Map<String,String> personList) {
        Histograma <String> histograma = new Histograma();
        for(String string : personList.keySet()){
            histograma.increment(personList.get(string));
        }
        return histograma;
    }
}
