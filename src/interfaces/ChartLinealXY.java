package interfaces;

import java.awt.BasicStroke;
import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class ChartLinealXY {

    public static ChartPanel createGananciaChart(String chartTitle, double[] gananciaNintendo, double[] gananciaBethesda) {
        XYDataset dataset = createDoubleDataset(gananciaNintendo, gananciaBethesda);
        JFreeChart xyChart = createChart(dataset, chartTitle);
        ChartPanel chartPanel = new ChartPanel(xyChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 400));

        final XYPlot plot = xyChart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED); // Color para Nintendo
        renderer.setSeriesPaint(1, Color.BLUE); // Color para Bethesda

        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        renderer.setSeriesStroke(1, new BasicStroke(2.0f));
        plot.setRenderer(renderer);

        return chartPanel;
    }

    public static XYDataset createDoubleDataset(int gananciaNintendo, int gananciaBethesda) {
        final XYSeries serie1 = new XYSeries("Nintendo");
        final XYSeries serie2 = new XYSeries("Bethesda");

        for (int i = 0; i < gananciaNintendo.length; i++) {
            if (i != 0 && gananciaNintendo[i] == 0) {
                break;
            }

            serie1.add(i, gananciaNintendo[i]);
        }

        for (int i = 0; i < gananciaBethesda.length; i++) {
            if (i != 0 && gananciaBethesda[i] == 0) {
                break;
            }

            serie2.add(i, gananciaBethesda[i]);
        }

        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(serie1);
        dataset.addSeries(serie2);

        return dataset;
    }

    public static JFreeChart createChart(XYDataset dataset, String title) {
        JFreeChart chart = ChartFactory.createXYLineChart(title, "Tiempo (Días)", "Ganancia (Millones $)", dataset, PlotOrientation.VERTICAL, true, true, false);
        return chart;
    }
}
