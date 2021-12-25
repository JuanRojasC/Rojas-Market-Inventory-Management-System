/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.Controller.ConcreteActions;

import challenge5.Model.ProductService;
import challenge5.View.AddProduct.AddProductView;
import challenge5.View.Inventory.TablePanel;
import challenge5.View.LateralMenu.LateralMenu;
import challenge5.View.Notifications.Notifications;
import challenge5.View.Report.ReportView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * Driver encargado de recibir los campos del formulario para agregar producto,
 * y el frame en que esta contenido el formulario, para agregarlos a la Base de
 * Datos y a la tabla de Inventario, ademas de limpiar sus valores y cerrar la
 * ventana una vez hecho lo anterior.
 *
 * @param nameProduct JTextField del nombre de producto
 * @param priceProduct JTextField del precio del producto
 * @param stockProduct JTextField de la cant de unidades del producto
 * @param window JDialog en donde esta contenido el formulario
 */
public class AddProductActionDriver implements ActionListener {

    private JFrame view;
    private ProductService productDB;
    private JTextField nameProduct;
    private JTextField priceProduct;
    private JTextField stockProduct;

    public AddProductActionDriver(JFrame view) {
        this.view = view;
        this.productDB = ProductService.getInstance();
        this.nameProduct = ((AddProductView) view).getInputNameProduct();
        this.priceProduct = ((AddProductView) view).getInputPriceProduct();
        this.stockProduct = ((AddProductView) view).getInputStockProduct();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // ADD DATABASE
            Boolean insertAchieved = productDB.addProduct(
                    nameProduct.getText(),
                    Double.parseDouble(priceProduct.getText()),
                    Integer.parseInt(stockProduct.getText()));

            if (insertAchieved) {
                // ADD TABLE
                TablePanel.getInstance().updateTable();

                // CLEAN TEXTFIELDS
                nameProduct.setText("");
                priceProduct.setText("");
                stockProduct.setText("");

                // CLOSE THE WINDOW OR FRAME OR DIALOG
                view.dispose();
                LateralMenu.buttonFocus.deselect();

                // SEND SUCCESSFULLY NOTIFICATION
                Notifications.sendNotification("El producto ha sido agregado");
                ReportView.getInstance().updateData();
            }else{
                Notifications.sendNotification("No se pudo agregar el producto");
            }
        } catch (Exception ex) {
            // SEND FAILLED NOTIFICATION
            try {
                Notifications.sendNotification("Verifique los datos Ingresados");
            } catch (Exception exc) {
                Logger.getLogger(AddProductActionDriver.class.getName()).log(Level.SEVERE, "Error al enviar la notificacion " + exc, ex);
            }
        }
    }
}
