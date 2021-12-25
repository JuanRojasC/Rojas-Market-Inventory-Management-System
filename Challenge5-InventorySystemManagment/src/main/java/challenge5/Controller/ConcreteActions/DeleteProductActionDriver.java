/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.Controller.ConcreteActions;

import challenge5.Model.Product;
import challenge5.Model.ProductService;
import challenge5.View.Inventory.TablePanel;
import challenge5.View.LateralMenu.LateralMenu;
import challenge5.View.ModifyProduct.FormModifyProduct;
import challenge5.View.Notifications.Notifications;
import challenge5.View.Report.ReportView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

/**
 * @author Juan David Rojas Cañizales
 */
public class DeleteProductActionDriver extends ActionDriver implements ActionListener {

    // ATTRIBUTES
    private static final Logger logger = Logger.getLogger(String.valueOf(DeleteProductActionDriver.class));
    private ProductService productsDB;
    private FormModifyProduct form;
    private Product product;

    public DeleteProductActionDriver() {
        this.form = null;
        this.product = null;
        this.productsDB = ProductService.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        configureDriver();
        try {
            // CODE
            Integer code = this.form.getProduct().getCode();
            // NAME PRODUCT
            String nameProduct = this.product.getName();
            // PRICE PRODUCT
            Double priceProduct = this.product.getPrice();
            // STOCK PRODUCT
            Integer stockProduct = this.product.getStock();

            // UPDATE DATA BASE
            Boolean deleteAchieved = productsDB.deleteProduct(code);

            try {
                if (deleteAchieved) {
                    // UPDATE TABLE
                    TablePanel.getInstance().updateTable();
                    // CLOSE WINDOW
                    view.getWindow().dispose();
                    // DESELECT BUTTON ON LATERAL MENU
                    LateralMenu.buttonFocus.deselect();
                    // SEND SUCCESSFULLY NOTIFICATION
                    Notifications.sendNotification("El producto ha sido eliminado");
                    ReportView.getInstance().updateData();
                } else {
                    Notifications.sendNotification("No se pudo eliminar el producto");
                }
            } catch (Exception ex) {
                logger.info("Error al enviar la notificacion");
            }
        } catch (Exception fail) {
            if (view != null) {
                try {
                    Notifications.sendNotification("Verifique los Datos Ingresados");
                    logger.info("Fallo la eliminacion del Producto" + fail);
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
        this.product = this.form.getProduct();
    }

}
