/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.View.Notifications;

import challenge5.Controller.AcceptButtonDriver;
import challenge5.View.MainWindow;
import challenge5.Utilities.Utilities;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 * Clase encargada de mostrar notificaciones al usuario.
 */
public class Notifications {

    private JPanel mainView;
    private JDialog frame;
    private JPanel headerRowColor;
    private JLabel logoCompany;
    private JPanel mainPanel;
    private JLabel message;
    private JButton acceptBtn;
    private JPanel footerRowColor;

    public Notifications(String message, JPanel mainView) throws Exception {
        this.mainView = mainView;
        this.frame = new JDialog();
        this.headerRowColor = new JPanel();
        this.mainPanel = new JPanel();
        this.footerRowColor = new JPanel();
        this.logoCompany = new JLabel();
        this.message = new JLabel(message);
        this.acceptBtn = new JButton();
        initiNotification();
    }

    public void initiNotification() throws Exception {

        // MAIN PANEL
        mainPanel.setBackground(new Color(255, 255, 255));
        mainPanel.setLayout(new BorderLayout(0, 0));
        frame.add(mainPanel);

        // HEADER PANEL
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        Integer marginHeader = Math.round(Utilities.getPixelValue(0.025, "VERTICAL"));

        // HEADER ROW COLOR
        headerRowColor.setBackground(Utilities.MAINCOLOR);
        headerRowColor.setLayout(new BorderLayout());
        headerPanel.add(headerRowColor);

        // LOGO COMPNAY
        logoCompany.setIcon(Utilities.iconFactory("Logo Company B-W", 100, 30));
        logoCompany.setAlignmentX(JLabel.LEFT);
        logoCompany.setBorder(new CompoundBorder(new CompoundBorder(), new EmptyBorder(5, 15, 5, 0)));
        headerRowColor.add(logoCompany, BorderLayout.WEST);

        // CENTRAL PANEL
        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
        centralPanel.setBackground(Color.WHITE);
        centralPanel.setBorder(new EmptyBorder(25, 50, 25, 50));
        mainPanel.add(centralPanel, BorderLayout.CENTER);

        // MESSAGE
        message.setFont(Utilities.NOTIFICATIONSFONT);
        message.setBackground(Color.WHITE);
        message.setAlignmentX(0.5f);
        message.setBorder(new EmptyBorder(0, 0, 20, 0));
        centralPanel.add(message);

        // BUTTON
        acceptBtn.setIcon(Utilities.iconFactory("Accept-Button", 120, 38));
        acceptBtn.setContentAreaFilled(false);
        acceptBtn.setBorderPainted(false);
        acceptBtn.setFocusPainted(false);
        acceptBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        acceptBtn.setAlignmentX(0.5f);
        acceptBtn.addActionListener(new AcceptButtonDriver(frame));
        centralPanel.add(acceptBtn);

        // FOOTER ROW COLOR
        footerRowColor.setBackground(Utilities.MAINCOLOR);
        footerRowColor.setMinimumSize(new Dimension(550, 40));
        footerRowColor.setPreferredSize(new Dimension(550, 20));
        mainPanel.add(footerRowColor, BorderLayout.SOUTH);

        // FRAME DIALOG
        frame.setModal(true);
        frame.setAlwaysOnTop(true);
        frame.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        frame.setUndecorated(true);
        frame.pack();
        frame.setLocationRelativeTo(mainView);
        frame.setVisible(true);
    }

    public static void sendNotification(String message) throws Exception {
        Notifications notification;
        notification = new Notifications(message, MainWindow.getInstance().getDataPanel());
    }

}
