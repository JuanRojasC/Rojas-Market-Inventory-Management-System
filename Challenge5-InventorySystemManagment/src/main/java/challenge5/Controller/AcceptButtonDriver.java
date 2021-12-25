/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.Controller;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author juand
 */
public class AcceptButtonDriver implements ActionListener{
    
    private JDialog frameDialog;
    private JFrame frameWindow;
    
    public AcceptButtonDriver(JDialog frameDialog){
        this.frameDialog = frameDialog;
        this.frameWindow = null;
    }
    
    public AcceptButtonDriver(JFrame frameWindow){
        this.frameWindow = frameWindow;
        this.frameDialog = null;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(this.frameDialog != null) this.frameDialog.dispose();
       else if(this.frameWindow != null) this.frameWindow.dispose();
    }
    
    
    
}
