/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.View.ModifyProduct;

import challenge5.Controller.ConcreteActions.ActionDriver;
import challenge5.Controller.CancelButtonDriver;
import challenge5.Controller.ConcreteActions.FindProductActionDriver;
import challenge5.View.MainWindow;
import challenge5.Utilities.Utilities;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 * @author Juan David Rojas Cañizales Esta vista nos ofrece la plantilla general
 * para las vistas de actualizar y eliminar producto, con un atributo que hace
 * referencia al panel que contendra el formulario especifico.
 */
public class ModifyProductView extends JFrame{

    // ATTRIBUTES
    private JPanel mainView;
    private JDialog window;
    private JPanel mainPanel;
    private JPanel headerPanel;
    private JPanel centerPanel;
    private JPanel footerPanel;
    private JLabel logoCompany;
    private FormFindProduct findFormPanel;
    private ActionDriver driverAction;
    private ActionDriver driverFind;
    private FormModifyProduct formType;
    private String title;

    /**
     * Constructor de la Clase ModifyProductView
     *
     * @param title Titulo del Formulario
     * @param driverAction Driver de la accion a realizar Update-Delete etc.
     */
    public ModifyProductView(String title, ActionDriver driverAction, FormModifyProduct formType) {
        this.mainView = MainWindow.getInstance().getDataPanel();
        this.window = new JDialog();
        this.mainPanel = new JPanel();
        this.headerPanel = new JPanel();
        this.centerPanel = new JPanel();
        this.footerPanel = new JPanel();
        this.logoCompany = new JLabel();
        this.findFormPanel = new FormFindProduct(this, title);
        this.driverFind = new FindProductActionDriver(this, this.findFormPanel);
        this.driverAction = driverAction;
        this.formType = formType;
        this.title = title;
        this.driverAction.setView(this);
    }
    
    @Override
    public void dispose(){
        this.window.dispose();
    }
    
    public ModifyProductView start() throws Exception{
        initModifyProductView();
        return this;
    }

    public void initModifyProductView() throws Exception {
        // MAIN PANEL
        mainPanel.setBackground(new Color(255, 255, 255));
        mainPanel.setLayout(new BorderLayout(0, 0));
        window.add(mainPanel);

        // HEADER PANEL
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        Integer marginHeader = Math.round(Utilities.getPixelValue(0.025, "VERTICAL"));

        // ROW COLOR
        JPanel rowColor = new JPanel();
        rowColor.setBackground(Utilities.MAINCOLOR);
        rowColor.setLayout(new BorderLayout());
        headerPanel.add(rowColor);

        // LOGO COMPNAY
        logoCompany.setIcon(Utilities.iconFactory("Logo Company B-W", 100, 30));
        logoCompany.setAlignmentX(JLabel.LEFT);
        logoCompany.setBorder(new CompoundBorder(new CompoundBorder(), new EmptyBorder(5, 15, 5, 0)));
        rowColor.add(logoCompany, BorderLayout.WEST);

        // FORM PANEL
        this.centerPanel = builtFormPanel("Find-Button", this.driverFind, null);
        mainPanel.add(this.centerPanel, BorderLayout.CENTER);

        // FOOTER ROW COLOR
        JPanel footerRowColor = new JPanel();
        footerRowColor.setBackground(Utilities.MAINCOLOR);
        footerRowColor.setMinimumSize(new Dimension(550, 40));
        footerRowColor.setPreferredSize(new Dimension(550, 20));
        mainPanel.add(footerRowColor, BorderLayout.SOUTH);

        // WINDOW DIALOGUE
        window.setModal(true);
        window.setAlwaysOnTop(true);
        window.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        window.setUndecorated(true);
        window.pack();
        window.setLocationRelativeTo(mainView);
        window.setVisible(true);
    }

    // BUILT FORM PANEL
    private JPanel builtFormPanel(String nameFileButton, ActionDriver driver, JPanel addPanel) throws Exception {
        // VARIABLES
        Integer y = 0;

        // PANEL
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(new EmptyBorder(25, 100, Utilities.getPixelValue(0.03, "VERTICAL"), 100));
        mainPanel.setLayout(new GridBagLayout());

        // FIND PANEL
        JPanel findForm = this.findFormPanel.initFormFindProduct();
        mainPanel.add(findForm, Utilities.getConstraints(0, y, 1, 1, 0, 0, 0, 0));
        y++;

        // SPECIALIZED PANEL
        if (addPanel != null) {
            mainPanel.add(addPanel, Utilities.getConstraints(0, y, 1, 1, 0, 0, 30, 0));
            y++;
        }

        // BUTTONS PANEL
        JPanel btnsPanel = builtButtonsPanel(nameFileButton, driver);
        mainPanel.add(btnsPanel, Utilities.getConstraints(0, y, 1, 1, 0, 0, 25, 0));
        y++;

        return mainPanel;
    }

    // BUILT PANEL BUTTONS
    private JPanel builtButtonsPanel(String nameFileButton, ActionDriver driver) throws Exception {
        // BUTTONS PANEL
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        buttonsPanel.setBackground(Color.WHITE);

        // FIND BUTTON
        JButton findButton = new JButton();
        findButton.setContentAreaFilled(false);
        findButton.setFocusPainted(false);
        findButton.setBorderPainted(false);
        findButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        findButton.setIcon(Utilities.iconFactory(nameFileButton, 120, 38));
        findButton.addActionListener(driver);
        buttonsPanel.add(findButton);

        // CANCEL BUTTON
        JButton cancelButton = new JButton();
        cancelButton.setContentAreaFilled(false);
        cancelButton.setFocusPainted(false);
        cancelButton.setBorderPainted(false);
        cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancelButton.setIcon(Utilities.iconFactory("Cancel-Button", 120, 38));
        cancelButton.addActionListener(new CancelButtonDriver(this));
        buttonsPanel.add(cancelButton);

        return buttonsPanel;
    }

    /**
     * NOT MATCH COINCIDENCES Metodo encargado de actualizar el panel para
     * informar que no se han encontrado conincidencias.
     */
    public void notMatchCoincidences() throws Exception {

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setBackground(Color.WHITE);

        JLabel text = new JLabel("No Hay Coincidencias");
        Font font = Utilities.NOTIFICATIONSFONT.deriveFont(Utilities.sizeFontData.floatValue());
        text.setFont(font);
        text.setForeground(Color.BLACK);
        panel.add(text);

        updateUI(this.builtFormPanel("Find-Button", this.driverFind, panel));
    }

    /**
     * Metodo encargado de desplegar el panel con la informacion del producto
     *
     * @param panel El panel a ser agregado o actualizado
     * @param nameFileIcon Nombre de la imagen del boton a buscar
     */
    public void deployDataProduct(JPanel panel, String nameFileIcon) throws Exception {
        updateUI(this.builtFormPanel(nameFileIcon, this.driverAction, panel));
    }

    /**
     * Metodo con la funcion de actualizar la interfaz grafica
     */
    public void updateUI(JPanel panel) {
        this.mainPanel.remove(this.centerPanel);
        this.centerPanel.removeAll();
        this.centerPanel = panel;
        this.centerPanel.validate();
        this.mainPanel.add(centerPanel, BorderLayout.CENTER);
        this.mainPanel.validate();
        this.window.pack();
        this.window.setLocationRelativeTo(mainView);
        this.window.validate();
    }

    // GETTERS
    public JPanel getFormPanel() {
        return this.footerPanel;
    }

    public JDialog getWindow() {
        return this.window;
    }

    public FormModifyProduct getFormType() {
        return this.formType;
    }
}
