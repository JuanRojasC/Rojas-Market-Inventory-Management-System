/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.View.Report;

import challenge5.Model.Product;
import challenge5.Model.ProductService;
import challenge5.Utilities.Utilities;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 * Clase responsable de mostrar al usuario, dos grafficos estadisticos, uno de
 * torta y otro de lines, respecto a la cantidad de productos y evolucion de
 * precios, ademas de tres paneles con los datos de los productos mas costosos
 * en el inventario.
 */
public class ReportView {

    // ATTRIBUTES
    private static ReportView instance;
    private JPanel mainPanel;
    private JLabel title;
    private ProductService productService;

    private ReportView() {
        this.mainPanel = new JPanel();
        this.title = new JLabel("Informe de Inventario");
        this.productService = ProductService.getInstance();
    }

    public static ReportView getInstance() {
        if (instance == null) {
            instance = new ReportView();
        }
        return instance;
    }

    public JPanel initReportView() {
        // MAIN PANEL
        this.mainPanel.removeAll();
        this.mainPanel.validate();
        this.mainPanel.setBackground(Color.WHITE);
        this.mainPanel.setLayout(new BorderLayout());
        this.mainPanel.setBorder(new EmptyBorder(0, 100, 50, 100));

        // TITLE PANEL
        this.title.setFont(Utilities.TITLEFONT);
        this.title.setForeground(Utilities.MAINCOLOR);
        this.title.setHorizontalAlignment(JLabel.CENTER);
        Double topMargin = Utilities.HEIGHTSCREEN * 0.039;
        this.title.setBorder(new CompoundBorder(new CompoundBorder(), new EmptyBorder(topMargin.intValue(), 0, Utilities.getPixelValue(0.026, "VERTICAL"), 0)));
        this.mainPanel.add(title, BorderLayout.NORTH);

        // STATTISTIC PANEL
        JPanel statisticPanel = new JPanel(new GridLayout(1, 2));
        statisticPanel.setBackground(Color.WHITE);
        this.mainPanel.add(statisticPanel, BorderLayout.CENTER);

        // ADD PIE CHART
        statisticPanel.add(PieChart.getInstance(productService.getProductList()).createChart());

        // ADD LINE CHART
        statisticPanel.add(XYLineChart.getInstance(productService.getProductList()).createChart());

        // PRODUCT PANELS
        JPanel productsPanel = new JPanel(new GridLayout(1, 3));
        productsPanel.setBackground(Color.WHITE);
        productsPanel.setBorder(new EmptyBorder(80, 0, 0, 0));
        this.mainPanel.add(productsPanel, BorderLayout.SOUTH);

        List products = productService.generateReportList();

        for (int i = 0; i < products.size() || i < 3; i++) {
            try {
                Product product = (Product) products.get(i);
                productsPanel.add(getDataPanelProduct(product));
            } catch (Exception e) {
                productsPanel.add(getDataPanelProduct(new Product(0, "", 0.0, 0)));
            }
        }

        return this.mainPanel;
    }

    /**
     * Crea un panel que refleja el codigo, nombre,precio y cantidad de unidades
     * de un producto, que es pasado como parametro.
     *
     * @param product Producto dueño de la informacion
     */
    private JPanel getDataPanelProduct(Product product) {
        JPanel productPanel = new JPanel();
        productPanel.setBackground(Color.WHITE);
        productPanel.setLayout(new GridBagLayout());

        // TITLE
        JLabel title = new JLabel();
        title.setText("Producto");
        title.setFont(Utilities.TITLEFONT);
        title.setForeground(Utilities.MAINCOLOR);
        title.setHorizontalAlignment(JLabel.CENTER);
        productPanel.add(title, Utilities.getConstraints(0, 0, 1, 1, 0, 0, 0, 15));

        // PRODUCT CODE AREA
        JLabel codeProduct = buildLabel("Codigo ", product.getCode().toString());
        productPanel.add(codeProduct, Utilities.getConstraints(0, 1, 1, 1, 0, 0, 0, 15));

        // PRODUCT NAME AREA
        // LABEL
        JLabel nameProduct = buildLabel("Producto ", product.getName());
        productPanel.add(nameProduct, Utilities.getConstraints(0, 2, 1, 1, 0, 0, 0, 15));

        // PRODUCT PRICE AREA
        // LABEL
        JLabel priceProduct = buildLabel("Precio ", product.getPrice().toString());
        productPanel.add(priceProduct, Utilities.getConstraints(0, 3, 1, 1, 0, 0, 0, 15));

        // PRODUCT PRICE AREA
        // LABEL
        JLabel stockProduct = buildLabel("Unidades ", product.getStock().toString());
        productPanel.add(stockProduct, Utilities.getConstraints(0, 4, 1, 1, 0, 0, 0, 0));

        return productPanel;
    }

    // BUILD LABEL
    /**
     * Contruye un etiqueta compuesta por dos textos, una propiedad y su valor
     * asgina colores diferentes a los textos.
     *
     * @param prop Texto de la Propiedad
     * @param text Texto del valor de la propiedad
     */
    private JLabel buildLabel(String prop, String text) {
        JLabel label = new JLabel();
        label.setFont(Utilities.DATAFONT);
        label.setForeground(Utilities.MAINCOLOR);
        label.setText("<html><font color=rgb(186, 26, 26)>" + prop + ": </font> <font color=black font-style=italic> <i>" + " " + text + "</i> </font></html>");
        return label;
    }

    
    /**
     * Metodo con la funcionalidad de actualizar los paneles de los graficos
     * estadisticos, llamando su metodo con el mismo nombre.
     */
    public void updateData() {
        this.mainPanel.removeAll();
        this.mainPanel = initReportView();
        this.mainPanel.validate();
    }

}
