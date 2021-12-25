/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.View.AddProduct;

import challenge5.Controller.ConcreteActions.AddProductActionDriver;
import challenge5.Controller.CancelButtonDriver;
import challenge5.Utilities.Utilities;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 * Clase con la vista del formulario para el agregado de productos a la Base de 
 * datos.
 */
public class FormAddProduct extends JPanel{

    // ATTRIBUTES
    private JFrame window;
    private JPanel mainPanel;
    private JLabel nameProduct;
    private JTextField inputNameProduct;
    private JLabel priceProduct;
    private JTextField inputPriceProduct;
    private JLabel stockProduct;
    private JTextField inputStockProduct;
    private JPanel btnsPanel;
    private JButton submitBtn;
    private JButton closeBtn;

    // CONSTRUCTOR
    public FormAddProduct(JFrame window) {
        this.window = window;
        this.mainPanel = new JPanel();
        this.btnsPanel = new JPanel();
        this.nameProduct = new JLabel("Producto: ");
        this.priceProduct = new JLabel("Precio: ");
        this.stockProduct = new JLabel("Unidades: ");
        this.inputNameProduct = new JTextField();
        this.inputPriceProduct = new JTextField();
        this.inputStockProduct = new JTextField();
        this.submitBtn = new JButton();
        this.closeBtn = new JButton();
    }

    // INIT PANEL
    public JPanel initFormAddProduct() throws Exception {

        // MAIN PANEL
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(new CompoundBorder(new CompoundBorder(), new EmptyBorder(0, 100, Utilities.getPixelValue(0.03, "VERTICAL"), 100)));

        // PRODUCT NAME AREA
        // JLABEL        
        nameProduct.setFont(Utilities.DATAFONT);
        nameProduct.setForeground(Utilities.MAINCOLOR);
        nameProduct.setHorizontalAlignment(JLabel.RIGHT);
        mainPanel.add(nameProduct, Utilities.getConstraints(0, 0, 1, 1, 0, 0, 0, 0));
        // TEXTFIELD
        inputNameProduct = Utilities.getTextField(inputNameProduct);
        mainPanel.add(inputNameProduct, Utilities.getConstraints(1, 0, 1, 1, 0, 0, 0, 0));

        // FILLER
        Utilities.addBoxFiller(mainPanel, 0.032, 0.032, 1);

        // PRODUCT PRICE AREA
        // JLABEL
        priceProduct.setFont(Utilities.DATAFONT);
        priceProduct.setForeground(Utilities.MAINCOLOR);
        priceProduct.setHorizontalAlignment(JLabel.RIGHT);
        mainPanel.add(priceProduct, Utilities.getConstraints(0, 2, 1, 1, 0, 0, 0, 0));
        // TEXTFIELD
        inputPriceProduct = Utilities.getTextField(inputPriceProduct);
        mainPanel.add(inputPriceProduct, Utilities.getConstraints(1, 2, 1, 1, 0, 0, 0, 0));

        // FILLER
        Utilities.addBoxFiller(mainPanel, 0.032, 0.032, 3);

        // PRODUCT STOCK AREA
        // JLABEL
        stockProduct.setFont(Utilities.DATAFONT);
        stockProduct.setForeground(Utilities.MAINCOLOR);
        stockProduct.setHorizontalAlignment(JLabel.RIGHT);
        mainPanel.add(stockProduct, Utilities.getConstraints(0, 4, 1, 1, 0, 0, 0, 0));
        // TEXTFIELD
        inputStockProduct = Utilities.getTextField(inputStockProduct);
        mainPanel.add(inputStockProduct, Utilities.getConstraints(1, 4, 1, 1, 0, 0, 0, 0));

        // FILLER
        Utilities.addBoxFiller(mainPanel, 0.033, 0.033, 5);

        // BUTTONS PANEL
        btnsPanel.setBackground(Color.WHITE);
        mainPanel.add(btnsPanel, Utilities.getConstraints(0, 6, 2, 0, 0, 0, 0, 0));;

        // SUBMIT BUTTON
        submitBtn.setIcon(Utilities.iconFactory("Add-Button", 120, 38));
        submitBtn.setContentAreaFilled(false);
        submitBtn.setOpaque(true);
        submitBtn.setBorderPainted(false);
        submitBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submitBtn.setFocusPainted(false);
        submitBtn.setBackground(Color.WHITE);
        submitBtn.setHorizontalAlignment(JLabel.RIGHT);
////        submitBtn.addActionListener(new AddProductActionDriver(inputNameProduct, inputPriceProduct, inputStockProduct, window));
        submitBtn.addActionListener(new AddProductActionDriver(window));
        btnsPanel.add(submitBtn);

        // CLOSE BUTTON
        closeBtn.setIcon(Utilities.iconFactory("Cancel-Button", 120, 38));
        closeBtn.setContentAreaFilled(false);
        closeBtn.setOpaque(true);
        closeBtn.setBorderPainted(false);
        closeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeBtn.setFocusPainted(false);
        closeBtn.setBackground(Color.WHITE);
        closeBtn.setHorizontalAlignment(JLabel.LEFT);
        closeBtn.addActionListener(new CancelButtonDriver(window));
        btnsPanel.add(closeBtn);

        return mainPanel;
    }
    
    // GETTERS
    public JFrame getWindow() {
        return window;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JLabel getNameProduct() {
        return nameProduct;
    }

    public JTextField getInputNameProduct() {
        return inputNameProduct;
    }

    public JLabel getPriceProduct() {
        return priceProduct;
    }

    public JTextField getInputPriceProduct() {
        return inputPriceProduct;
    }

    public JLabel getStockProduct() {
        return stockProduct;
    }

    public JTextField getInputStockProduct() {
        return inputStockProduct;
    }

    public JPanel getBtnsPanel() {
        return btnsPanel;
    }

    public JButton getSubmitBtn() {
        return submitBtn;
    }

    public JButton getCloseBtn() {
        return closeBtn;
    }
    
}
