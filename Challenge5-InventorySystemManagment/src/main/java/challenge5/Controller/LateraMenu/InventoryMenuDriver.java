/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.Controller.LateraMenu;

import challenge5.View.Inventory.InventoryView;
import javax.swing.*;
import challenge5.View.LateralMenu.ButtonMenu;
import challenge5.View.LateralMenu.LateralMenu;
import challenge5.View.MainWindow;
import challenge5.Utilities.Utilities;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

/**
 *
 * @author juand
 */
public class InventoryMenuDriver implements ActionListener{
    
    // ATTRIBUTES
    private static Logger logger = Logger.getLogger(String.valueOf(InventoryMenuDriver.class));
    private ButtonMenu buttonMenu;

    public InventoryMenuDriver(ButtonMenu button) {
        this.buttonMenu = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // SELECTED BUTTON
            buttonMenu.selected();
            // START REPORT VIEW CLASS
            InventoryView inventoryView = InventoryView.getInstance();
            // START PANEL
            JPanel inventoryPanel = inventoryView.initInventoryView();
            // UPDATE PANEL IN MAIN WINDOW
            MainWindow.getInstance().setDataPanel(inventoryPanel);
            logger.info("Panel de Inventario inciado");
        } catch (Exception ex) {
            logger.info("No se pudo inicializar el panel de Inventario " + ex);
        }
    }
    
}
