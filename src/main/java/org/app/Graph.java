package org.app;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

public class Graph {
    private final double v0;
    private final double angle;

    public Graph(double v0, double angle) {
        this.v0 = v0;
        this.angle = angle;
    }

    public void drawGraph(){
        WorkWithParams workWithParams = new WorkWithParams(v0, angle);

        XYSeries series = new XYSeries("Params");

        for (int i=0; i<workWithParams.getAllX().size(); i++){
            series.add(workWithParams.getAllX().get(i),
                    workWithParams.getAllY().get(i));
        }

        XYDataset dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart("Graph", "X", "Y",
                dataset, PlotOrientation.VERTICAL, true, true, true);
        
        JFrame frame = new JFrame("Graph");
        frame.getContentPane().add(new ChartPanel(chart));

        frame.setSize(1500, 500);
        frame.show();
    }
}
