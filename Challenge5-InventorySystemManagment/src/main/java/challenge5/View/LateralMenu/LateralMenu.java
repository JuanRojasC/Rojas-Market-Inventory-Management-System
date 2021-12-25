/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.View.LateralMenu;

import challenge5.Controller.LateraMenu.AddProductMenuDriver;
import challenge5.Controller.LateraMenu.DeleteProductMenuDriver;
import challenge5.Controller.LateraMenu.GenerateReportDriver;
import challenge5.Controller.LateraMenu.InventoryMenuDriver;
import challenge5.Controller.LateraMenu.UpdateProductMenuDriver;
import challenge5.Utilities.Utilities;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

/**
 * Vista lateral de la ventana, que contiene los botones para acceder a los
 * diferentes formularios y acciones a ser ejecutados por el usuarios, esta 
 * vista nunca se oculta, ni varia estilo u estado.
 */
public class LateralMenu extends Utilities {

    // ATTRIBUTES
    // INSTANCE
    private static LateralMenu panel;
    
    // COMPONENTS
    private JPanel mainPanel;
    private JLabel logoCompany;
    private ButtonMenu inventoryButton;
    private ButtonMenu addProductButton;
    private ButtonMenu updateProductButton;
    private ButtonMenu deleteProductButton;
    private ButtonMenu reportButton;

    // VARIABLES
    public static ButtonMenu buttonFocus = null;
    
    // CONSTRUCTOR
    private LateralMenu() {}

    // GET INSTANCE OF LATERAL MENU
    public static LateralMenu getInstance() {
        if (panel == null) {
            panel = new LateralMenu();
        }
        return panel;
    }

    public JPanel initLateralMenu() throws Exception {
        // START PANEL
        panel = LateralMenu.getInstance();

        // BUILT PANEL
        mainPanel = new JPanel();
        mainPanel.setBackground(Utilities.MAINCOLOR);
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBorder(new CompoundBorder(new CompoundBorder(), new EmptyBorder(0, 0, 0, 0)));

        // LOGO
        logoCompany = new JLabel();
        logoCompany.setIcon(Utilities.iconFactory("Logo Company B-W", 163, 50));
        logoCompany.setAlignmentX(0.0f);
        Double topMargin = Utilities.HEIGHTSCREEN * 0.01953;
        logoCompany.setBorder(new CompoundBorder(new CompoundBorder(), new EmptyBorder(topMargin.intValue(),30,0,30)));
        mainPanel.add(logoCompany, Utilities.getConstraints(0, 0, 1, 1, 0, 0, 0, 0));
        Utilities.addBoxFiller(mainPanel, 0.15, 0.15, 1);

        // OPTIONS BUTTONS
        // INVENTORY
        inventoryButton = new ButtonMenu("  Inventario", "Inventory-Icon");
        inventoryButton.addActionListener(new InventoryMenuDriver(inventoryButton));
        mainPanel.add(inventoryButton.initButton(), Utilities.getConstraints(0, 2, 1, 1, 0, 0, 0, 0));
        Utilities.addBoxFiller(mainPanel, 0.12, 0.10, 3);
        
        // ADD PRODUCT
        addProductButton = new ButtonMenu("  Añadir Producto", "Add-Icon");
        addProductButton.addActionListener(new AddProductMenuDriver(addProductButton));
        mainPanel.add(addProductButton.initButton(), Utilities.getConstraints(0, 4, 1, 1, 0, 0, 0, 0));
        
        // UPDATE PRODUCT
        updateProductButton = new ButtonMenu("  Actualizar Producto", "Update-Icon");
        updateProductButton.addActionListener(new UpdateProductMenuDriver(updateProductButton));
        mainPanel.add(updateProductButton.initButton(), Utilities.getConstraints(0, 5, 1, 1, 0, 0, 0, 0));
        
        // DELETE PRODUCT
        deleteProductButton = new ButtonMenu("  Eliminar Producto", "Delete-Icon");
        deleteProductButton.addActionListener(new DeleteProductMenuDriver(deleteProductButton));
        mainPanel.add(deleteProductButton.initButton(), Utilities.getConstraints(0, 7, 1, 1, 0, 0, 0, 0));
        Utilities.addBoxFiller(mainPanel, 0.12, 0.10, 8);
        
        // GENERATE REPORT BUTTON
        reportButton = new ButtonMenu("  Informes", "Report-Icon");
        reportButton.addActionListener(new GenerateReportDriver(reportButton));
        mainPanel.add(reportButton.initButton(), Utilities.getConstraints(0, 9, 1, 1, 0, 0, 0, 0));
        Utilities.addBoxFiller(mainPanel, 0.03, 0.03, 10);

        return mainPanel;
    }
    
}
