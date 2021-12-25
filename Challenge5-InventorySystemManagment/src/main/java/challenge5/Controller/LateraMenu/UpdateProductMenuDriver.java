/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.Controller.LateraMenu;

import challenge5.Controller.ConcreteActions.UpdateProductActionDriver;
import challenge5.View.LateralMenu.ButtonMenu;
import challenge5.View.ModifyProduct.FormUpdateProduct.FormUpdateProduct;
import challenge5.View.ModifyProduct.ModifyProductView;
import java.awt.event.*;
import java.util.logging.*;
import javax.swing.JFrame;

/**
 * @author Juan David Rojas Cañizales
 * Controlador encargado de activar el panel de busquedad de un producto para 
 * ser actualizado si dicho producto es encontrado
 */
public class UpdateProductMenuDriver implements ActionListener {

    // ATTRIBUTES
    private static Logger logger = Logger.getLogger(String.valueOf(UpdateProductMenuDriver.class));
    private ButtonMenu buttonMenu;

    public UpdateProductMenuDriver(ButtonMenu button) {
        this.buttonMenu = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // SELECT BUTTON
            buttonMenu.selected();
            // CREATE FORM UPDATE
            FormUpdateProduct formUpdate = new FormUpdateProduct();
            // CREATE MODIFY VIEW UPDATE SPECIALICIATION
            JFrame updateProductView = new ModifyProductView("Actualizar Producto", new UpdateProductActionDriver(), formUpdate).start();
            // CONFIRM CORRECT WORK
            logger.info("Panel para Actulizacion de Producto inciado");
        } catch (Exception ex) {
            logger.info("No se pudo inicializar el panel de actualizar producto " + ex.getMessage());
        }
    }

}
