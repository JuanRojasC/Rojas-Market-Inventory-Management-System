/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.Controller.ConcreteActions;

import challenge5.Controller.ConcreteActions.ActionDriver;
import challenge5.Model.Product;
import challenge5.Model.ProductService;
import challenge5.View.Inventory.TablePanel;
import challenge5.View.ModifyProduct.FormFindProduct;
import challenge5.View.ModifyProduct.ModifyProductView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.*;

/**
 *
 * @author juand
 */
public class FindProductActionDriver extends ActionDriver implements ActionListener {

    private static Logger logger = Logger.getLogger(String.valueOf(FindProductActionDriver.class));
    private ModifyProductView view;
    private FormFindProduct form;
    private ProductService productService;

    /**
     * Constructor de la clase FindProductDriver Incluye vista
     * @param view Ventana donde se encuentra el buscador
     * @param form Formulario del buscador
     */
    public FindProductActionDriver(ModifyProductView view, FormFindProduct form) {
        this.view = view;
        this.form = form;
        this.productService = ProductService.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // GUARDO EL VALOR A BUSCAR COMO UN ATRIBUTO
        form.setTextToFind(form.getInputFind().getText());
        // PARSEO EL CODIGO INGRESADO Y SETEO LOS ATRIBUTOS DEL FORMULARIO ESPECIALIZADO
        try{
            Integer code = Integer.parseInt(form.getInputFind().getText());
            if (productService.checkProduct(code)){
                logger.info("El producto ha sido encontrado");
                Product product = productService.getProduct(code);
                if(product != null){
                    view.getFormType().setProduct(product);
                    view.getFormType().setView(view);
                    view.getFormType().initFormModifyProduct();
                }else{
                    logger.info("El producto retornado fue nulo");
                }
            }else{
                logger.info("El producto no se encuentra registrado en la BD");
                view.notMatchCoincidences();
            }
        } catch (Exception ex) {
            logger.info(ex.getMessage());
        }
    }

    @Override
    public void configureDriver() {
        // NO NECESITA CONFIGURARSE DEPSUES DE CREADO
    }

}
