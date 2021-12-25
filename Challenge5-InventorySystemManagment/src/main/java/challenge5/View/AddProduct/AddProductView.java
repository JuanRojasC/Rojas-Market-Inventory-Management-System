/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.View.AddProduct;

import challenge5.View.MainWindow;
import challenge5.Utilities.Utilities;
import javax.swing.*;
import java.awt.*;
import java.awt.Dialog.ModalityType;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 * @author Juan David Rojas Cañizales Clase encarga de mostrar la vista del
 * formulario para agregar productos al inventario.
 */
public class AddProductView extends JFrame {

    private static AddProductView instance;

    // ATTRIBUTES
    private JPanel mainView;
    private JDialog window;
    private JPanel mainPanel;
    private JPanel headerPanel;
    private JPanel formPanel;
    private JPanel footerPanel;
    private JLabel logoCompany;
    private JLabel title;

    // CONSTRUCTOR
    private AddProductView() {
        this.mainView = MainWindow.getInstance().getDataPanel();
        this.window = new JDialog();
        this.mainPanel = new JPanel();
        this.headerPanel = new JPanel();
        this.formPanel = new JPanel();
        this.footerPanel = new JPanel();
        this.title = new JLabel("Añadir Producto");
        this.logoCompany = new JLabel();
    }

    public static AddProductView getInstance() {
        if (instance == null) {
            instance = new AddProductView();
        }
        instance.setMainView();
        return instance;
    }

    @Override
    public void dispose() {
        this.window.dispose();
    }

    public AddProductView start() throws Exception {
        initAddProductView();
        return this;
    }

    public JPanel initAddProductView() throws Exception {

        // MAIN PANEL
        mainPanel.setBackground(new Color(255, 255, 255));
        mainPanel.setLayout(new BorderLayout(0, 0));
        window.add(mainPanel);

        // HEADER PANEL
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        Integer marginHeader = Math.round(Utilities.getPixelValue(0.025, "VERTICAL"));

        // HEADER ROW COLOR
        JPanel headerRowColor = new JPanel();
        headerRowColor.setBackground(Utilities.MAINCOLOR);
        headerRowColor.setLayout(new BorderLayout());
        headerPanel.add(headerRowColor);

        // LOGO COMPNAY
        logoCompany.setIcon(Utilities.iconFactory("Logo Company B-W", 100, 30));
        logoCompany.setAlignmentX(JLabel.LEFT);
        logoCompany.setBorder(new CompoundBorder(new CompoundBorder(), new EmptyBorder(5, 15, 5, 0)));
        headerRowColor.add(logoCompany, BorderLayout.WEST);

        // TITLE
        title.setFont(Utilities.TITLEFONT);
        title.setForeground(Utilities.MAINCOLOR);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBorder(new CompoundBorder(new CompoundBorder(), new EmptyBorder(marginHeader, 0, marginHeader, 0)));
        title.setAlignmentX(0.55f);
        headerPanel.add(title);

        // FORM PANEL
        this.formPanel = new FormAddProduct(this);
        mainPanel.add(((FormAddProduct) formPanel).initFormAddProduct());

        // FOOTER ROW COLOR
        this.footerPanel = new JPanel();
        footerPanel.setBackground(Utilities.MAINCOLOR);
        footerPanel.setMinimumSize(new Dimension(550, 40));
        footerPanel.setPreferredSize(new Dimension(550, 20));
        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        // MODAL
        window.setModal(true);
        window.setAlwaysOnTop(true);
        window.setModalityType(ModalityType.APPLICATION_MODAL);
        window.setUndecorated(true);
        window.pack();
        window.setLocationRelativeTo(mainView);
        window.setVisible(true);

        return mainPanel;
    }

    /**
     * Metodo Propio que cierra el JDialog de esta clase
     */
    public void close() {
        this.window.dispose();
    }

    // GETTERS
    public JPanel getMainView() {
        return mainView;
    }

    public JDialog getWindow() {
        return window;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JPanel getFormPanel() {
        return formPanel;
    }

    public JTextField getInputNameProduct() {
        return ((FormAddProduct) this.formPanel).getInputNameProduct();
    }

    public JTextField getInputPriceProduct() {
        return ((FormAddProduct) this.formPanel).getInputPriceProduct();
    }

    public JTextField getInputStockProduct() {
        return ((FormAddProduct) this.formPanel).getInputStockProduct();
    }

    // SETTERS
    public void setMainView() {
        this.mainView = MainWindow.getInstance().getDataPanel();
    }
}
