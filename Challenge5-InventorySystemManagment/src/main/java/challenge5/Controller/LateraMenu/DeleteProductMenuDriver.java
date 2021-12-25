/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.Controller.LateraMenu;

import challenge5.View.LateralMenu.ButtonMenu;
import challenge5.Controller.ConcreteActions.DeleteProductActionDriver;
import challenge5.View.ModifyProduct.FormDeleteProduct.FormDeleteProduct;
import challenge5.View.ModifyProduct.ModifyProductView;
import challenge5.Utilities.Utilities;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

/**
 *
 * @author juand
 */
public class DeleteProductMenuDriver implements ActionListener {

    // ATTRIBUTES
    private static Logger logger = Logger.getLogger(String.valueOf(DeleteProductMenuDriver.class));
    private ButtonMenu buttonMenu;

    public DeleteProductMenuDriver(ButtonMenu button) {
        this.buttonMenu = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // SELECT BUTTON
            buttonMenu.selected();
            // CREATE FORM UPDATE
            FormDeleteProduct deleteForm = new FormDeleteProduct();
            // CREATE MODIFY VIEW UPDATE SPECIALICIATION
            ModifyProductView deleteProductView = new ModifyProductView("Eliminar Producto", new DeleteProductActionDriver(), deleteForm);
            // START THE FIND FORM
            deleteProductView.initModifyProductView();
            logger.info("Panel para Eliminacion de Producto inciado");
        } catch (Exception ex) {
            logger.info("No se pudo inicializar el panel de eliminacion producto " + ex);
        }
    }
}
