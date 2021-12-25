/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.View.ModifyProduct.FormDeleteProduct;

import challenge5.View.ModifyProduct.FormModifyProduct;
import challenge5.Utilities.Utilities;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Clase con la vista de la informacion del producto que se ha buscado para ser
 * eliminado.
 */
public class FormDeleteProduct extends FormModifyProduct {

    private static final Logger logger = Logger.getLogger(String.valueOf(FormDeleteProduct.class));

    // ATTRIBUTES
    private JPanel mainPanel;
    private JLabel title;
    private JLabel codeProduct;
    private JLabel nameProduct;
    private JLabel priceProduct;
    private JLabel stockProduct;

    public FormDeleteProduct() {
        super(null);
        this.mainPanel = new JPanel();
        this.title = new JLabel();
        this.codeProduct = new JLabel();
        this.nameProduct = new JLabel();
        this.priceProduct = new JLabel();
        this.stockProduct = new JLabel();
    }

    // INIT COMPONENTS TROUGH CLASS PARENT
    @Override
    public void initFormModifyProduct() {
        try {
            super.view.deployDataProduct(initFormDeleteProduct(), "Delete-Button");
        } catch (Exception ex) {
            logger.info("Error al desplegar el formulario de eliminar producto\n\t" + ex.getMessage());
        }
    }

    // INIT COMPONENETS IN ITSELF CLASS
    public JPanel initFormDeleteProduct() {
        // MAIN PANEL
        mainPanel.removeAll();
        mainPanel.validate();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new GridBagLayout());

        // TITLE
        title.setText("Informacion");
        title.setFont(Utilities.TITLEFONT);
        title.setForeground(Utilities.MAINCOLOR);
        title.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(title, Utilities.getConstraints(0, 0, 2, 1, 0, 0, 0, 20));

        // PRODUCT CODE AREA
        codeProduct = buildLabel(codeProduct, "Codigo ", product.getCode().toString());
        mainPanel.add(codeProduct, Utilities.getConstraints(0, 1, 1, 1, 0, 0, 0, 15));

        // PRODUCT NAME AREA
        // LABEL
        nameProduct = buildLabel(nameProduct, "Producto ", product.getName());
        mainPanel.add(nameProduct, Utilities.getConstraints(0, 2, 1, 1, 0, 0, 0, 15));

        // PRODUCT PRICE AREA
        // LABEL
        priceProduct = buildLabel(priceProduct, "Precio ", product.getPrice().toString());
        mainPanel.add(priceProduct, Utilities.getConstraints(0, 3, 1, 1, 0, 0, 0, 15));

        // PRODUCT PRICE AREA
        // LABEL
        stockProduct = buildLabel(stockProduct, "Unidades ", product.getStock().toString());
        mainPanel.add(stockProduct, Utilities.getConstraints(0, 4, 1, 1, 0, 0, 0, 0));

        return mainPanel;
    }

    // BUILD LABEL
    /**
     * Setea la congiuracion de un etiqueta compuesta por dos textos, una
     * propiedad y su valor asgina colores diferentes a los textos.
     *
     * @param label etiqueta a configurar
     * @param prop Texto de la Propiedad
     * @param text Texto del valor de la propiedad
     */
    private JLabel buildLabel(JLabel label, String prop, String text) {
        label.setFont(Utilities.DATAFONT);
        label.setForeground(Utilities.MAINCOLOR);
        label.setText("<html><font color=rgb(186, 26, 26)>" + prop + ": </font> <font color=black font-style=italic> <i>" + " " + text + "</i> </font></html>");
        return label;
    }
}
