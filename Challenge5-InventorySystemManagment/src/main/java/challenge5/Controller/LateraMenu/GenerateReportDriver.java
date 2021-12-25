/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.Controller.LateraMenu;

import javax.swing.*;
import challenge5.View.LateralMenu.ButtonMenu;
import challenge5.View.MainWindow;
import challenge5.View.Report.ReportView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

/**
 * @author juand
 */
public class GenerateReportDriver implements ActionListener{
    
    // ATTRIBUTES
    private static Logger logger = Logger.getLogger(String.valueOf(GenerateReportDriver.class));
    private ButtonMenu buttonMenu;

    public GenerateReportDriver(ButtonMenu button) {
        this.buttonMenu = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // SLECTED BUTTON
            buttonMenu.selected();
            // START REPORT VIEW CLASS
            ReportView reportView = ReportView.getInstance();
            // START PANEL
            JPanel reportPanel = reportView.initReportView();
            // UPDATE DATA PANEL IN MAIN WINDOW
            MainWindow.getInstance().setDataPanel(reportPanel);
            logger.info("Panel de Informe de Inventario inciado");
        } catch (Exception ex) {
            logger.info("No se pudo inicializar el panel de Informe de Inventario " + ex);
        }
    }
    
}
