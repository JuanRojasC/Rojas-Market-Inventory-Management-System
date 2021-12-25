/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.Controller.ConcreteActions;

import challenge5.View.ModifyProduct.ModifyProductView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author juand
 */
public abstract class ActionDriver implements ActionListener{
    
    // ATTRIBUTES
    ModifyProductView view;
    
    // CONSTRUCTOR
    public ActionDriver(ModifyProductView view){
        this.view = view;
    }
    
    public ActionDriver(){
        
    }
    
    // CONFIGURE CONCRETE DRIVER
    public abstract void configureDriver();
    
    // GETTERS
    public ModifyProductView getView(){
        return this.view;
    }
    
    // SETTERS
    public void setView(ModifyProductView view){
        this.view = view;
        configureDriver();
    }
    
}
