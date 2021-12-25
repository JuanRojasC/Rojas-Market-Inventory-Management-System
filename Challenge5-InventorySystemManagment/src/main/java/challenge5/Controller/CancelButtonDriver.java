/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.Controller;

import challenge5.Controller.ConcreteActions.ActionDriver;
import challenge5.View.AddProduct.AddProductView;
import challenge5.View.LateralMenu.LateralMenu;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author juand
 */
public class CancelButtonDriver extends ActionDriver implements ActionListener{
    
    private JFrame windowToClose;
      
    public CancelButtonDriver(JFrame window){
        this.windowToClose = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        LateralMenu.buttonFocus.deselect();
        windowToClose.dispose();
    }

    @Override
    public void configureDriver() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
