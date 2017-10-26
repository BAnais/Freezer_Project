import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.DynamicTimeSeriesCollection;
import org.jfree.data.time.Second;
import java.util.Date;
import javax.swing.*;

import java.awt.Color;
import java.text.SimpleDateFormat;

public class JFChart extends JPanel{

    private final DynamicTimeSeriesCollection dataset;
    private final JFreeChart chart;

    private ValueMarker marker;
    private final XYPlot plot;

    public JFChart(final String title) {
    	// Création de l'ensemble de données
        dataset = new DynamicTimeSeriesCollection(1, 2000, new Second());
        dataset.setTimeBase(new Second(new Date()));
        dataset.addSeries(new float[1], 0, title);
        
        // Création du graphique
        chart = ChartFactory.createTimeSeriesChart(title, "Temps", title, dataset, true, true, false);
        plot = chart.getXYPlot();
        
        // Dessiner une ligne horizontale
        marker = new ValueMarker(0);
        marker.setPaint(Color.yellow);
        plot.addRangeMarker(marker);
        
        // Configuration de l'axe des ordonnées
        ValueAxis ordAxis = (ValueAxis) plot.getRangeAxis();
        ordAxis.setRange(5, 30); // Plage de 5 à 30
        
        // Configuration de l'axe des abscisses
        DateAxis absAxis = (DateAxis) plot.getDomainAxis();
        absAxis.setFixedAutoRange(20000); // Plage de 20 secondes
        absAxis.setDateFormatOverride(new SimpleDateFormat("ss.SS"));
        
        
        final ChartPanel chartPanel = new ChartPanel(chart);
        add(chartPanel);
    }

    public void update(double value) {
        float[] newData = new float[1];
        newData[0] = (float) value;
        dataset.advanceTime();
        dataset.appendData(newData);
    }
    
    public void updateConsigne(double value) {
    	this.marker.setValue(value);
    }
}
