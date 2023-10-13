package classes;
import interfaces.Bethesda;
import interfaces.Nintendo;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UtilidadChart extends JPanel {

    private XYSeries seriesBethesda;
    private XYSeries seriesNintendo;
    private int tiempo = 0;

    public UtilidadChart() {
        seriesBethesda = new XYSeries("Empresa Bethesda");
        seriesBethesda.add(1.0, 0); // Inicializa con un valor de 0
        // Agrega más puntos de datos según tus necesidades

        seriesNintendo = new XYSeries("Empresa Nintendo");
        seriesNintendo.add(1.0, 0); // Inicializa con un valor de 0
        // Agrega más puntos de datos según tus necesidades

        final XYSeriesCollection dataset = new XYSeriesCollection(seriesBethesda);
        dataset.addSeries(seriesNintendo);

        final JFreeChart chart = ChartFactory.createXYLineChart(
                "Utilidad con respecto al tiempo", // Título del gráfico
                "Tiempo", // Etiqueta del eje X
                "Utilidad", // Etiqueta del eje Y
                dataset, // Datos
                PlotOrientation.VERTICAL,
                true, // Incluye leyenda
                true, // Utiliza tooltips
                false // URLs no son utilizados
        );

        final Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tiempo++; // Incrementa el tiempo
                int gananciaBethesda = Integer.parseInt(Bethesda.ganancia.getText());
                int gananciaNintendo = Integer.parseInt(Nintendo.ganancia.getText());
                seriesBethesda.add(tiempo, gananciaBethesda); // Utiliza el valor de ganancia de Bethesda
                seriesNintendo.add(tiempo, gananciaNintendo); // Utiliza el valor de ganancia de Nintendo
            }
        });
        timer.start(); // Inicia el temporizador

        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(430, 380));
        this.add(chartPanel);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gráfico Utilidad");
        JTabbedPane tabbedPane = new JTabbedPane();

        UtilidadChart chart = new UtilidadChart();
        tabbedPane.addTab("Gráfico Utilidad", chart);

        frame.add(tabbedPane);
        frame.setSize(430, 380);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
