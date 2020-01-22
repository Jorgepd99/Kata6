package View;

import Model.Histograma;

import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Container;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame{
    private Histograma<String> histograma;

    public HistogramDisplay(Histograma histogram) {
        super("HISTOGRAMA");
        histograma = histogram;
        setContentPane(createPanel()); 
        pack();
    }

    private Container createPanel() {
        ChartPanel chartpanel = new ChartPanel(createChart(createDataSet()));
        chartpanel.setPreferredSize(new Dimension(500,400));
        return chartpanel;
    }
    
    private DefaultCategoryDataset createDataSet() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for(String key : histograma.KeySet()) {
            dataSet.addValue(histograma.get(key), "", key);
        }
        return dataSet;
    }

    private JFreeChart createChart(DefaultCategoryDataset createDataSet) {
        JFreeChart chart = ChartFactory.createBarChart("Histogram JFreeChart", "Jugadores", "Nº Jugadores", createDataSet);
        return chart;
    }
    
    public void execute() {
        setVisible(true);
    }
    
}
