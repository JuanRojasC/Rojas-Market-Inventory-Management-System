/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.View.Inventory;

import challenge5.Utilities.Utilities;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author juand Panel encargado de mostrar los datos del producto seleccionado
 * en la tabla.
 */
public class DataProductPanel {

    private static DataProductPanel instance;

    // ATTRIBUTES
    private JPanel mainPanel;
    private JLabel title;
    private JLabel codeProduct;
    private JLabel productName;
    private JLabel productPrice;
    private JLabel productStock;
    private JLabel productValueStock;
    private JLabel lastOrder;
    private String codeProductText;
    private String productNameText;
    private String productPriceText;
    private String productStockText;
    private String productValueStockText;
    private String lastOrderText;

    private DataProductPanel() {
        mainPanel = new JPanel();
        title = new JLabel();
        codeProduct = new JLabel();
        productName = new JLabel();
        productPrice = new JLabel();
        productStock = new JLabel();
        productValueStock = new JLabel();
        lastOrder = new JLabel();
        codeProductText = "0";
        productNameText = "Sin seleccionar";
        productPriceText = "0.0";
        productStockText = "0";
        productValueStockText = "0.0";
        lastOrderText = "Sin seleccionar";
    }

    public static DataProductPanel getInstance() {
        if (instance == null) {
            instance = new DataProductPanel();
        }
        return instance;
    }

    public JPanel initDataProductPanel() {

        // MAIN PANEL
        this.mainPanel.removeAll();
        this.mainPanel.validate();
        this.mainPanel.setLayout(new BorderLayout());
        this.mainPanel.setBackground(Color.WHITE);
        int marginTopBottom = Utilities.getPixelValue(0.025, "VERTICAL");
        this.mainPanel.setBorder(new CompoundBorder(new CompoundBorder(), new EmptyBorder(marginTopBottom, 0, marginTopBottom, 0)));

        // TITLE
        this.title.setText("Informacion de Producto");
        this.title.setForeground(Utilities.MAINCOLOR);
        this.title.setFont(Utilities.TITLEFONT);
        this.title.setHorizontalAlignment(JLabel.CENTER);
        this.title.setBorder(new CompoundBorder(new CompoundBorder(), new EmptyBorder(0, 0, 20, 0)));
        this.mainPanel.add(title, BorderLayout.NORTH);

        // PANEL WEST
        JPanel panelWest = new JPanel();
        panelWest.setLayout(new BoxLayout(panelWest, BoxLayout.Y_AXIS));
        panelWest.setBackground(Color.WHITE);
        panelWest.setBorder(new CompoundBorder(new CompoundBorder(), new EmptyBorder(0,0,0,Utilities.getPixelValue(0.0632, ""))));

        // PRODUCT NAME
        panelWest.add(getLabel(productName, "Producto", productNameText));

        // PRODUCT CODE
        panelWest.add(getLabel(codeProduct, "Código", codeProductText));

        // PRODUCT PRICE
        panelWest.add(getLabel(productPrice, "Precio Unitario", productPriceText));

        // PANEL EAST
        JPanel panelEast = new JPanel();
        panelEast.setLayout(new BoxLayout(panelEast, BoxLayout.Y_AXIS));
        panelEast.setBackground(Color.WHITE);
        panelEast.setBorder(new CompoundBorder(new CompoundBorder(), new EmptyBorder(0,Utilities.getPixelValue(0.0632, ""),0,0)));
        
        // STOCK QUANTITY
        panelEast.add(getLabel(productStock, "Inventario", productStockText));

        // STOCK VALUE
        panelEast.add(getLabel(productValueStock, "Valor del Inventario", productValueStockText));

        // LAST ORDER
        panelEast.add(getLabel(lastOrder, "Ultimo Pedido", lastOrderText));
        
        // CENTRAL PANEL
        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new FlowLayout());
        centralPanel.setBackground(Color.WHITE);
        centralPanel.setBorder(new CompoundBorder(new CompoundBorder(), new EmptyBorder(0,120,0,120)));
        centralPanel.add(panelWest);
        centralPanel.add(panelEast);
        this.mainPanel.add(centralPanel, BorderLayout.CENTER);

        return this.mainPanel;
    }

    // LABEL FACTORY
    /**
     * Configura una etiqueta con la plantilla global.
     * @param label etiqueta a configurar
     * @param prop texto de la propiedad que mostrara la etiqueta
     * @param value texto del valor de la propiedad
     */
    private JLabel getLabel(JLabel label, String prop, String value) {
        label.setText("<html><font color=rgb(186, 26, 26)>" + prop + ": </font> <font color=black font-style=italic> <i>" + " " + value + "</i> </font></html>");
        label.setFont(Utilities.DATAFONT);
        label.setAlignmentX(0.0f);
        label.setBorder(new CompoundBorder(new CompoundBorder(), new EmptyBorder(0,0,10,0)));
        return label;
    }

    // SET TEXT LABEL
    /**
     * Setea el texto de la etiqueta con el fin de poderla actualizar.     
     * @param label etiqueta a configurar
     * @param prop texto de la propiedad que mostrara la etiqueta
     * @param value texto del valor de la propiedad
     */
    private void setTextLabel(JLabel label, String prop, String text) {
        label.setText("<html><font color=rgb(186, 26, 26)>" + prop + ": </font> <font color=black font-style=italic> <i>" + " " + text + "</i> </font></html>");
    }

    // TRANSLATE DATA FOR THE ROW SELECTED AT THE PRODUCT PANEL
    /**
     * Recepciona la tabla con la informacion desde TableCell~62~ y obtiene la informacion de cada columna
     * en la fila actual para actualizar los textos de las etiquetas del panel.
     * @param table tabla con la informacion
     * @param row fila seleccionada
     */
    public void insertData(JTable table, int row) {
        Double priceProduct = (Double) Double.parseDouble(table.getModel().getValueAt(row, 2).toString());
        Double stockProduct = (Double) Double.parseDouble(table.getModel().getValueAt(row, 3).toString());
        Double stockValue = priceProduct * stockProduct;
        setCodeProductText(table.getModel().getValueAt(row, 0).toString());
        setProductNameText(table.getModel().getValueAt(row, 1).toString());
        setProductPriceText(priceProduct.toString());
        setProductStockText(stockProduct.toString());
        setProductValueStockText(stockValue.toString());
        setLastOrderText("22/08/2021");
    }

    // GETTERS
    public String getCodeProductText() {
        return codeProductText;
    }

    public String getProductNameText() {
        return productNameText;
    }

    public String getProductPriceText() {
        return productPriceText;
    }

    public String getProductStockText() {
        return productStockText;
    }

    public String getProductValueStockText() {
        return productValueStockText;
    }

    public String getLastOrderText() {
        return lastOrderText;
    }

    // SETTERS
    public void setCodeProductText(String codeProductText) {
        this.codeProductText = codeProductText;
        setTextLabel(codeProduct, "Código", codeProductText);
    }

    public void setProductNameText(String productNameText) {
        this.productNameText = productNameText;
        setTextLabel(productName, "Producto", productNameText);
    }

    public void setProductPriceText(String productPriceText) {
        this.productPriceText = productPriceText;
        setTextLabel(productPrice, "Precio Unitario", productPriceText);
    }

    public void setProductStockText(String productStockText) {
        this.productStockText = productStockText;
        setTextLabel(productStock, "Unidades", productStockText);
    }

    public void setProductValueStockText(String productValueStockText) {
        this.productValueStockText = productValueStockText;
        setTextLabel(productValueStock, "Valor de Inventario", productValueStockText);
    }

    public void setLastOrderText(String lastOrderText) {
        this.lastOrderText = lastOrderText;
        setTextLabel(lastOrder, "Ultimo Pedido", lastOrderText);
    }

}
