/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.View.Report;

import challenge5.Model.Product;
import challenge5.Utilities.Utilities;
import java.awt.*;
import java.util.List;
import java.util.Random;
import org.jfree.chart.*;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.*;

/**
 * Clase encargada de la vista del Grafico de lineas con la evolucion de los 
 * diferentes precios que han tenido los productos.
 */
public class XYLineChart {

    private static XYLineChart instance;
    private Integer width;
    private Integer height;
    private List data;
    
    private XYLineChart() {
        this.width = Utilities.getPixelValue(0.2928, "");
        this.height = Utilities.getPixelValue(0.2342, "");
    }

    public static XYLineChart getInstance(List data) {
        if (instance == null) {
            instance = new XYLineChart();
        }
        instance.setData(data);
        return instance;
    }

    public ChartPanel createChart() {
        XYSeriesCollection dataset = new XYSeriesCollection();

        for (int i = 0; i < data.size(); i++) {
            Product product = ((Product) data.get(i));
            if (product == null) {
                continue;
            }
            
            XYSeries s = new XYSeries(product.getName());

            for (int x = 0; x < 30; x += 5) {
                Random random = new Random();
                Integer percent = random.nextInt((x + 1) * 3);
                Double correctPrice = percent < (x * 3.33) ? percent * 3.33 : percent;
                Double price = product.getPrice() * (correctPrice / 100);
                s.add(x, price);
            }

            s.add(30, product.getPrice());
            dataset.addSeries(s);
        }

        JFreeChart chart = ChartFactory.createXYLineChart("Evolución de Precios", "Dias", "Precios", dataset);
        
        // CHART STYLE
        chart.getPlot().setBackgroundPaint(Color.white);
        chart.getPlot().setOutlineVisible(false);
        ((XYPlot) chart.getPlot()).setDomainGridlinePaint(Color.gray);
        ((XYPlot) chart.getPlot()).setRangeGridlinePaint(Color.gray);
        // TITLE STYLE
        chart.getTitle().setFont(new Font("Arial", Font.BOLD, 17));
        chart.getTitle().setPaint(new Color(40, 42, 61));
        // LEGEND STYLE
        chart.getLegend().setBackgroundPaint(null);
        chart.getLegend().setBorder(BlockBorder.NONE);
        // LINES STYLE
        XYLineAndShapeRenderer l4 = new XYLineAndShapeRenderer();
        l4.setSeriesPaint(0, new Color(0xff, 0x00, 0x00));
        l4.setSeriesPaint(1, new Color(0x00, 0xff, 0x00));
        l4.setSeriesShapesVisible(0, false);
        l4.setSeriesShapesVisible(1, false);
        ((XYPlot) chart.getPlot()).setRenderer(1, l4);

        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(400, 320));
        panel.setMaximumSize(new Dimension(width, height));

        return panel;
    }

    // SETTERS
    public void setData(List data){
        this.data = data;
    }
}
