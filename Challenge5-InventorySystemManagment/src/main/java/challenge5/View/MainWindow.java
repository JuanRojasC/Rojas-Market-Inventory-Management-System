/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.View;

import challenge5.View.Inventory.InventoryView;
import challenge5.View.LateralMenu.LateralMenu;
import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

/**
 *
 * @author juand
 */
public class MainWindow extends JFrame {

    //VARIABLES
    public static Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
    public int widthWindow = (int) (screenDimension.width * 0.75);
    public int heightWindow = (int) (screenDimension.height * 0.80);

    public static MainWindow instance;
    private JFrame window;
    private JPanel mainPanel;
    private JPanel dataPanel;

    private MainWindow() {
        window = new JFrame("Inventario de Productos");
        mainPanel = new JPanel();
        dataPanel = new JPanel();
    }

    public static MainWindow getInstance() {
        if (instance == null) {
            instance = new MainWindow();
        }
        return instance;
    }

    public void initWindow() throws URISyntaxException, MalformedURLException, Exception {
        // WINDOW
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // WINDOW PANEL
        mainPanel.setBackground(new Color(255, 255, 255));
        mainPanel.setLayout(new GridBagLayout());
        window.add(mainPanel);

        // OPTIONS PANEL
        GridBagConstraints constraints = getConstraints(0, 0, 1, 1, 0, 0, 0.01, 1.0);
        mainPanel.add(LateralMenu.getInstance().initLateralMenu(), constraints);

        // PANEL ON FOCUS
        dataPanel = InventoryView.getInstance().initInventoryView();
        constraints = getConstraints(1, 0, 3, 1, 0, 0, 1.0, 1.0);
        mainPanel.add(dataPanel, constraints);

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public static GridBagConstraints getConstraints(int x, int y, int width, int height, int padIntR, int padIntL, double weightx, double weighty) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = width;
        constraints.gridheight = height;
        constraints.weightx = weightx;
        constraints.weighty = weighty;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.fill = 1;
        constraints.insets = new Insets(0, padIntL, 0, padIntR);

        return constraints;
    }

    // GETTERS
    public JFrame getWindow() {
        return this.window;
    }

    public JPanel getMainPanel() {
        return this.mainPanel;
    }

    public JPanel getDataPanel() {
        return this.dataPanel;
    }
    
    // SETTERS
    public void setDataPanel(JPanel dataPanel) {
        this.mainPanel.remove(this.dataPanel);
        this.dataPanel = dataPanel;
        this.dataPanel.validate();
        this.mainPanel.add(this.dataPanel, getConstraints(1, 0, 3, 1, 0, 0, 1.0, 1.0));
        this.mainPanel.validate();
        this.mainPanel.repaint();
    }
}
