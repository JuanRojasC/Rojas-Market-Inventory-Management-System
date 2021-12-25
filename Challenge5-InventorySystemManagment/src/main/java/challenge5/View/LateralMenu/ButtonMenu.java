/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.View.LateralMenu;

import challenge5.Utilities.Utilities;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author juand
 */
public class ButtonMenu extends JButton {

    private static final Logger logger = Logger.getLogger(String.valueOf(ButtonMenu.class));

    // attributes
    private Boolean state;
    private JButton btn;
    private String nameFileIcon;
    private Integer widthButton;
    private Integer heightButton;

    public ButtonMenu(String text, String nameFileIcon) {
        this.state = false;
        this.btn = new JButton(text);
        this.nameFileIcon = nameFileIcon;
        widthButton = 24;
        heightButton = 24;
    }

    public ButtonMenu() {
    }

    public JButton initButton() throws Exception {
        btn.setFont(new Font("Arial", Font.BOLD, 15));
        btn.setForeground(new Color(255, 255, 255));
        btn.setBackground(Utilities.MAINCOLOR);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setContentAreaFilled(false);
        btn.setFocusPainted(false);
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setBorder(new CompoundBorder(new CompoundBorder(), new EmptyBorder(10, 30, 10, 30)));
        btn.setIcon(Utilities.iconFactory(nameFileIcon, widthButton, heightButton));
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setContentAreaFilled(true);
                btn.setBackground(new Color(255, 255, 255));
                btn.setForeground(new Color(0, 0, 0));
                try {
                    btn.setIcon(Utilities.iconFactory(nameFileIcon + "-Black", widthButton, heightButton));
                } catch (Exception ex) {
                    logger.info("Error al cargar el icono del boton");
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!state) {
                    deselect();
                }
            }

        });

        return btn;
    }

    // BUTTON SELECTED
    public void selected() {
        if (LateralMenu.buttonFocus == null) {
            LateralMenu.buttonFocus = this;
        } else {
            LateralMenu.buttonFocus.deselect();
            LateralMenu.buttonFocus.setState(false);
            LateralMenu.buttonFocus = this;
        }
        this.setState(true);
        this.getBtn().setContentAreaFilled(true);
        this.getBtn().setBackground(new Color(255, 255, 255));
        this.getBtn().setForeground(new Color(0, 0, 0));
        try {
            this.getBtn().setIcon(Utilities.iconFactory(this.getNameFileIcon() + "-Black", this.getWidthButton(), this.getHeightButton()));
        } catch (Exception ex) {
            logger.info("Error al cargar el icono del boton");
        }
    }

    // BUTTON DESELECTED
    public void deselect() {
        this.btn.setContentAreaFilled(false);
        this.btn.setForeground(new Color(255, 255, 255));
        try {
            btn.setIcon(Utilities.iconFactory(nameFileIcon, widthButton, heightButton));
        } catch (Exception ex) {
            logger.info("Error al cargar el icono del boton");
        }
    }
    
    // ADD ACTION LISTENER
    @Override
    public void addActionListener(ActionListener driver){
        this.btn.addActionListener(driver);
    }
    

    // GETTERS
    public Boolean getState() {
        return this.state;
    }

    public JButton getBtn() {
        return this.btn;
    }

    public static Logger getLogger() {
        return logger;
    }

    public String getNameFileIcon() {
        return nameFileIcon;
    }

    public Integer getWidthButton() {
        return widthButton;
    }

    public Integer getHeightButton() {
        return heightButton;
    }

    // SETTERS
    public void setState(Boolean s) {
        this.state = s;
    }
}
