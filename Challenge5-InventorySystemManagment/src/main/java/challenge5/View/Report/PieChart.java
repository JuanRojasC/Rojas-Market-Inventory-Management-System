/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.View.Report;

import challenge5.Model.Product;
import challenge5.Utilities.Utilities;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;
import org.jfree.chart.*;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.labels.*;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 * Clase responsable por el Grafico de torta con cantidad de unidades por
 * producto.
 */
public class PieChart {

    private static PieChart instance;
    private List data;
    private Integer width;
    private Integer height;

    private PieChart() {
        this.width = Utilities.getPixelValue(0.2562, "");
        this.height = Utilities.getPixelValue(0.2342, "");
    }

    public static PieChart getInstance(List data) {
        if (instance == null) {
            instance = new PieChart();
        }
        instance.setData(data);
        return instance;
    }

    public ChartPanel createChart() {
        DefaultPieDataset dataset = new DefaultPieDataset();

        for (int i = 0; i < data.size(); i++) {
            Product product = ((Product) data.get(i));
            if (product == null) {
                continue;
            }
            dataset.setValue(product.getName(), product.getStock());
        }

        // CHART
        JFreeChart chart = ChartFactory.createPieChart("Unidades en Inventarios", dataset);
        // BACKGROUND COMPLETE
        chart.getPlot().setBackgroundPaint(null);
        ((PiePlot) chart.getPlot()).setShadowPaint(null);
        // BORDERS LINES
        chart.getPlot().setOutlineVisible(false);
        // REMOVE LABELS
        ((PiePlot) chart.getPlot()).setLabelGenerator(null);
        // REMOVE EXTERNAL BORDERS
        chart.setBorderVisible(false);
        // STYLE TITLE
        chart.getTitle().setFont(new Font("Arial", Font.BOLD, 17));
        chart.getTitle().setPaint(Color.BLACK);
        // STYLE LABELS
        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
                "{1}", new DecimalFormat("0"), new DecimalFormat("0%"));
        ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);
        ((PiePlot) chart.getPlot()).setSimpleLabels(true);
        ((PiePlot) chart.getPlot()).setLabelBackgroundPaint(null);
        ((PiePlot) chart.getPlot()).setLabelOutlinePaint(null);
        ((PiePlot) chart.getPlot()).setLabelShadowPaint(null);
        ((PiePlot) chart.getPlot()).setLabelPaint(Color.white);
        // STYLE LEGEND
        chart.getLegend().setBackgroundPaint(null);
        chart.getLegend().setBorder(BlockBorder.NONE);

        ChartPanel panel = new ChartPanel(chart);
        panel.setBackground(Color.white);
        panel.setMaximumSize(new Dimension(width, height));
        panel.setPreferredSize(new Dimension(350, 320));

        return panel;
    }
    
    // SETTER
    public void setData(List data){
        this.data = data;
    }
}
