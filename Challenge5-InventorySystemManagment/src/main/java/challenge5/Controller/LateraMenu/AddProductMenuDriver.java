/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.Controller.LateraMenu;

import challenge5.View.LateralMenu.ButtonMenu;
import challenge5.View.AddProduct.AddProductView;
import challenge5.View.MainWindow;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author juand
 */
public class AddProductMenuDriver implements ActionListener {
    
    // ATTRIBUTES
    private static final Logger logger = Logger.getLogger(String.valueOf(AddProductMenuDriver.class));
    private ButtonMenu buttonMenu;
    
    public AddProductMenuDriver(ButtonMenu btnMenu){
        this.buttonMenu = btnMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // SELECT BUTTON
            buttonMenu.selected();
            // CREATE AND START ADDPRODUCT VIEW
            JFrame addProduct = AddProductView.getInstance().start();
        } catch (Exception ex) {
            logger.info("Error al inicializar la pestaña Añadir Producto\n      " + ex.getMessage());
        }
    }
    
}
