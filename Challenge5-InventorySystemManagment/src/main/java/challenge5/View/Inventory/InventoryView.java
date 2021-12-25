/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.View.Inventory;

import challenge5.Utilities.Utilities;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

/**
 *
 * @author juand
 */
public class InventoryView {
    
    private static InventoryView panel;
    private JPanel mainPanel;
    private JLabel title;
    
    private InventoryView(){
        this.mainPanel = new JPanel();
        this.title = new JLabel("Administrador de Inventario");
    }
    
    public static InventoryView getInstance() {
        if(panel == null){
            panel = new InventoryView();
        }
        return panel;
    }
    
    public JPanel initInventoryView(){
        // MAIN PANEL
        this.mainPanel.removeAll();
        this.mainPanel.validate();
        this.mainPanel.setBackground(new Color(255,255,255));
        this.mainPanel.setLayout(new BorderLayout(0,0));
        
        // TITLE
        this.title.setFont(Utilities.TITLEFONT);
        this.title.setForeground(Utilities.MAINCOLOR);
        this.title.setHorizontalAlignment(JLabel.CENTER);
        Double topMargin = Utilities.HEIGHTSCREEN * 0.039;
        this.title.setBorder(new CompoundBorder(new CompoundBorder(), new EmptyBorder(topMargin.intValue(),0,Utilities.getPixelValue(0.026, "VERTICAL"),0)));
        this.mainPanel.add(title, BorderLayout.NORTH);
        
        // TABLE
        this.mainPanel.add(TablePanel.getInstance().initTablePanel(), BorderLayout.CENTER);
        
        // DATA PRODUCT SELECTED
        this.mainPanel.add(DataProductPanel.getInstance().initDataProductPanel(), BorderLayout.SOUTH);
        
        return this.mainPanel;
    }
    
    // GETTERS
    public JPanel getMainPanel(){
        return this.mainPanel;
    }
}
