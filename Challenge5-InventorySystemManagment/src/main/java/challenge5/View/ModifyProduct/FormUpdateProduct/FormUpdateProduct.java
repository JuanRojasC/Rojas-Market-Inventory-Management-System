/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.View.ModifyProduct.FormUpdateProduct;

import challenge5.Model.Product;
import challenge5.View.ModifyProduct.FormModifyProduct;
import challenge5.Utilities.Utilities;
import java.awt.*;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * Clase con la vista del formulario para actualizar la informacion de un 
 * producto especifico.
 */
public class FormUpdateProduct extends FormModifyProduct{

    private static final Logger logger = Logger.getLogger(String.valueOf(FormUpdateProduct.class));
    
    // ATTRIBUTES
    private JPanel mainPanel;
    private JLabel title;
    private JLabel codeProduct;
    private JLabel nameProduct;
    private JLabel priceProduct;
    private JLabel stockProduct;
    private JTextField inputNameProduct;
    private JTextField inputPriceProduct;
    private JTextField inputStockProduct;

    public FormUpdateProduct() {
        super(null);
        this.mainPanel = new JPanel();
        this.title = new JLabel();
        this.nameProduct = new JLabel();
        this.priceProduct = new JLabel();
        this.stockProduct = new JLabel();
        this.inputNameProduct = new JTextField();
        this.inputPriceProduct = new JTextField();
        this.inputStockProduct = new JTextField();
    }
    
    // INIT COMPONENTS TROUGH CLASS PARENT
    @Override
    public void initFormModifyProduct(){
        try {
            super.view.deployDataProduct(initFormUpdateProduct(), "Save-Button");
        } catch (Exception ex) {
            logger.info("Error al desplegar el formulario de actualizar producto\n\t" + ex.getMessage());
        }
    }
    
    // INIT COMPONENETS IN ITSELF CLASS
    public JPanel initFormUpdateProduct() {
        // MAIN PANEL
        mainPanel.removeAll();
        mainPanel.validate();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new GridBagLayout());

        // TITLE
        title.setText("Informacion");
        title.setFont(Utilities.TITLEFONT);
        title.setForeground(Utilities.MAINCOLOR);
        title.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(title, Utilities.getConstraints(0, 0, 2, 1, 0, 0, 0, 20));

        // PRODUCT CODE AREA
        codeProduct = buildLabel("Codigo: ");
        mainPanel.add(codeProduct, Utilities.getConstraints(0, 1, 1, 1, 0, 0, 0, 15));
        JLabel code = new JLabel(product.getCode().toString());
        code.setFont(Utilities.DATAFONT);
        code.setForeground(Color.BLACK);
        mainPanel.add(code, Utilities.getConstraints(1, 1, 1, 1, 0, 5, 0, 15));
        
        // PRODUCT NAME AREA
        // LABEL
        nameProduct = buildLabel("Producto: ");
        mainPanel.add(nameProduct, Utilities.getConstraints(0, 2, 1, 1, 0, 0, 0, 15));
        // INPUT
        inputNameProduct = buildTextField(super.product.getName());
        mainPanel.add(inputNameProduct, Utilities.getConstraints(1, 2, 1, 1, 0, 0, 0, 15));

        // PRODUCT PRICE AREA
        // LABEL
        priceProduct = buildLabel("Precio: ");
        mainPanel.add(priceProduct, Utilities.getConstraints(0, 3, 1, 1, 0, 0, 0, 15));
        // INPUT
        inputPriceProduct = buildTextField(super.product.getPrice().toString());
        mainPanel.add(inputPriceProduct, Utilities.getConstraints(1, 3, 1, 1, 0, 0, 0, 15));

        // PRODUCT STOCK AREA
        // LABEL
        stockProduct = buildLabel("Unidades: ");
        mainPanel.add(stockProduct, Utilities.getConstraints(0, 4, 1, 1, 0, 0, 0, 0));
        // INPUT
        inputStockProduct = buildTextField(super.product.getStock().toString());
        mainPanel.add(inputStockProduct, Utilities.getConstraints(1, 4, 1, 1, 0, 0, 0, 0));

        return mainPanel;
    }

    // BUILDERS 
    public JLabel buildLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(Utilities.DATAFONT);
        label.setForeground(Utilities.MAINCOLOR);
        label.setHorizontalAlignment(JLabel.RIGHT);
        return label;
    }

    public JTextField buildTextField(String text) {
        JTextField input = new JTextField();
        input = Utilities.getTextField(input);
        input.setPreferredSize(new Dimension(150, 33));
        input.setText(text);
        return input;
    }

    
    // GETTERS
    
    public JTextField getInputNameProduct() {
        return inputNameProduct;
    }

    public JTextField getInputPriceProduct() {
        return inputPriceProduct;
    }

    public JTextField getInputStockProduct() {
        return inputStockProduct;
    }
}
