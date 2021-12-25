/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.Controller.ConcreteActions;

import challenge5.Model.ProductService;
import challenge5.View.Inventory.TablePanel;
import challenge5.View.LateralMenu.LateralMenu;
import challenge5.View.ModifyProduct.FormModifyProduct;
import challenge5.View.ModifyProduct.FormUpdateProduct.FormUpdateProduct;
import challenge5.View.Notifications.Notifications;
import challenge5.View.Report.ReportView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.*;
import javax.swing.*;

/**
 * @author Juan David Rojas Cañizales Clase encargada de actualizar la
 * informacion de un producto en la Base de Datos y en la Tabla de Inventario
 */
public class UpdateProductActionDriver extends ActionDriver implements ActionListener {

    // ATTRIBUTES
    private static final Logger logger = Logger.getLogger(String.valueOf(UpdateProductActionDriver.class));
    private ProductService productService;
    private FormModifyProduct form;
    private JTextField inputNameProduct;
    private JTextField inputPriceProduct;
    private JTextField inputStockProduct;

    public UpdateProductActionDriver() {
        this.form = null;
        this.inputNameProduct = null;
        this.inputPriceProduct = null;
        this.inputStockProduct = null;
        this.productService = ProductService.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        configureDriver();
        try {
            // CODE
            Integer code = this.form.getProduct().getCode();
            // NAME PRODUCT
            String nameProduct = this.inputNameProduct.getText();
            // PRICE PRODUCT
            Double priceProduct = Double.parseDouble(this.inputPriceProduct.getText());
            // STOCK PRODUCT
            Integer stockProduct = Integer.parseInt(this.inputStockProduct.getText());

            // UPDATE DATA BASE
            Boolean updatedAchieved = productService.updateProduct(code, nameProduct, priceProduct, stockProduct);

            try {
                if (updatedAchieved) {
                    // UPDATE TABLE
                    TablePanel.getInstance().updateTable();
                    // CLOSE WINDOW
                    view.getWindow().dispose();
                    // DESELECT BUTTON ON LATERAL MENU
                    LateralMenu.buttonFocus.deselect();
                    // SEND SUCCESSFULLY NOTIFICATION
                    Notifications.sendNotification("El producto ha sido actualizado");
                    ReportView.getInstance().updateData();
                } else {
                    Notifications.sendNotification("No se pudo actualizar el producto");
                }
            } catch (Exception ex) {
                logger.info("Error al enviar la notificacacion");
            }
        } catch (Exception fail) {
            if (view != null) {
                try {
                    Notifications.sendNotification("Verifique los Datos Ingresados");
                    logger.info("Fallo la actualizacion del Producto" + fail);
                } catch (Exception ex) {
                    logger.info("Erro al enviar la notificaion de fracaso");
                }
            } else {
                logger.info("Error el Driver no ha sido configurado, asegure el valor de los atributos");
            }

        }
    }

    /**
     * Metodo para configurar los atributos de la clase
     */
    @Override
    public void configureDriver() {
        this.form = super.view.getFormType();
        this.inputNameProduct = ((FormUpdateProduct) this.form).getInputNameProduct();
        this.inputPriceProduct = ((FormUpdateProduct) this.form).getInputPriceProduct();
        this.inputStockProduct = ((FormUpdateProduct) this.form).getInputStockProduct();
    }

}
