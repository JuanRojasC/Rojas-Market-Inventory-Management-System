/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.View.ModifyProduct;

import challenge5.Controller.CancelButtonDriver;
import challenge5.Controller.ConcreteActions.FindProductActionDriver;
import challenge5.Utilities.Utilities;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author juand
 */
public class FormFindProduct {

    // ATTRIBUTES
    private ModifyProductView view;
    private JPanel mainPanel;
    private JLabel title;
    private JButton findIcon;
    private JTextField inputFind;
    private String textToFind;

    // CONSTRUCTOR
    public FormFindProduct(ModifyProductView view,String title) {
        this.view = view;
        this.mainPanel = new JPanel();
        this.title = new JLabel(title);
        this.findIcon = new JButton();
        this.inputFind = new JTextField();
        this.textToFind = "codigo del producto";
    }

    // INIT COMPONENTS
    public JPanel initFormFindProduct() throws Exception {
        // PANEL
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new GridBagLayout());

        // TITLE
        title.setFont(Utilities.TITLEFONT);
        title.setForeground(Utilities.MAINCOLOR);
        title.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(title, Utilities.getConstraints(0, 0, 2, 1, 0, 0, 0, 25));

        // FIND ICON
        findIcon.setContentAreaFilled(false);
        findIcon.setFocusPainted(false);
        findIcon.setBorderPainted(false);
        findIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        findIcon.setIcon(Utilities.iconFactory("Find-Icon", 24, 24));
        findIcon.setHorizontalAlignment(JLabel.RIGHT);
        findIcon.addActionListener(new FindProductActionDriver(view, this));
        mainPanel.add(findIcon, Utilities.getConstraints(0, 1, 1, 1, 0, 0, 0, 0));

        // INPUT FIND
        if (this.textToFind.equals("codigo del producto")) {
            inputFind = getPlaceHolder(inputFind, this.textToFind);
        } else {
            inputFind.setText(this.textToFind);
            inputFind.setFont(new Font("Helvetic", Font.PLAIN, 18));
            inputFind.setForeground(Color.BLACK);
            inputFind.setPreferredSize(new Dimension(300, 23));
        }
        inputFind.setBorder(new CompoundBorder(new LineBorder(Color.GRAY, 1),new EmptyBorder(3, 5, 3, 5)));
        inputFind.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                JTextField input = (JTextField) e.getSource();
                input.setText("");
                input.setFont(new Font("Helvetic", Font.PLAIN, 18));
                input.setForeground(Color.BLACK);
                input.setPreferredSize(new Dimension(300, 23));
            }

            @Override
            public void focusLost(FocusEvent e) {
                JTextField input = (JTextField) e.getSource();
                if (input.getText().equals("") || input.getText() == null) {
                    input = getPlaceHolder(input, "codigo del producto");
                }
            }
        });
        mainPanel.add(inputFind, Utilities.getConstraints(1, 1, 1, 1, 0, 0, 0, 0));

        return mainPanel;
    }

    // GET JTEXTFIELD WITH PLACEHOLDER
    public JTextField getPlaceHolder(JTextField input, String placeholder) {
        input.setText(placeholder);
        input.setFont(new Font("Serif", Font.ITALIC, 18));
        input.setForeground(new Color(184, 184, 184));
        input.setPreferredSize(new Dimension(300, 23));
        return input;
    }

    // GETTERS
    public JTextField getInputFind() {
        return this.inputFind;
    }

    // SETTERS
    public void setTextToFind(String text) {
        this.textToFind = text;
    }
}
