
package Control;

import Model.*;
import View.*;
import java.util.*;

public class Kata6 {

    public static void main(String[] args) {
        String url = "jdbc:sqlite:C:\\Users\\J0RG3PD99\\Desktop\\Uni\\3º\\Primer semestre\\IS2\\proyec\\Kata6\\sqlite\\kata6.db";
        BaseDatos bd = new BaseDatos(url);
        bd.open();
        bd.select();
        HashMap<String,String> dataBaseMap = bd.componentes;
        Histograma histogram = DBHistogramBuilder.initHistograma(dataBaseMap);
        HistogramDisplay histogramdisplay = new HistogramDisplay(histogram);
        histogramdisplay.execute();
        bd.close();
    }
}

        

