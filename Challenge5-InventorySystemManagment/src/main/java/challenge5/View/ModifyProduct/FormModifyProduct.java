/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.View.ModifyProduct;

import challenge5.Model.Product;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author juand
 */
public abstract class FormModifyProduct {

    // ATTRIBUTES
    protected Product product;
    protected ModifyProductView view;
    
    // CONSTRUCTOR
    public FormModifyProduct(Product product){
        this.product = product;
    }
    
    // INIT FORM
    public abstract void initFormModifyProduct();
    
    // GETTERS
    public Product getProduct(){
        return this.product;
    }
    
    // SETTERS
    public void setProduct(Product product){
        this.product = product;
    }

    public void setView(ModifyProductView view){
        this.view = view;
    }
}
