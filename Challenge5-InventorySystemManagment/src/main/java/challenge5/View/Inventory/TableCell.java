/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.View.Inventory;

import challenge5.Utilities.Utilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 * Esta clase es la responsable de las configuraciones de estilo y propiedades 
 * de las celdas de la tabla.
 */
public class TableCell extends DefaultTableCellRenderer {
    
    // ATTRIBUTES
    private String type = "text";
    private Font normal = new Font("Verdana", Font.PLAIN, Utilities.sizeFontTable.intValue());
    private Font bold = new Font("Verdana", Font.BOLD, Utilities.sizeFontTable.intValue());
    private int clearRow;
    private int clearCol;

    public TableCell() {
    }

    /**
     * Constructor con el tipo de dato que tendra la celda
     *
     * @param tipo de dato, "text", "numeric".
     */
    public TableCell(String typeData) {
        this.type = typeData;
    }

    /**
     * Este metodo controla el comportamiento y estilo de cada celda en la
     * tabla. Cada evento sobre la tabla invocará este metodo
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {

        /**
         * Definimos color por defecto de la celda, al ser seleccionada la fila,
         * y al ser seleccionada la celda, en este caso no varia.
         */
        Color backgroundColor = null;
        Color backgroundColorRowSelected = new Color(227, 113, 113);
        Color backgroundColorCellSelected = new Color(227, 113, 113);

        /**
         * Si la celda esta seleccionada color por defecto, de lo contrario sera
         * blanca
         */
        if (selected) {
            this.setBackground(backgroundColorRowSelected);
            DataProductPanel.getInstance().insertData(table, row);
        } else {
            this.setBackground(Color.WHITE);
        }

        /**
         * Basado en el tipo de dato que contendra la celda, se define su estilo
         * y configuración.
         */
        if (type.equals("text")) {

            if (focused) {
                backgroundColor = backgroundColorCellSelected;
            } else {
                backgroundColor = backgroundColorRowSelected;
            }

            this.setHorizontalAlignment(JLabel.LEFT);
            this.setText((String) value);
            this.setBackground(selected ? backgroundColorCellSelected : Color.WHITE);
            this.setForeground(selected ? Color.WHITE : Color.BLACK);
            this.setFont(selected? bold : normal);
            this.setBorder(new CompoundBorder(new CompoundBorder(), new EmptyBorder(0, 10, 0, 0)));
        }

        if (type.equals("numeric")) {
            if (focused) {
                backgroundColor = backgroundColorCellSelected;
            } else {
                backgroundColor = Color.WHITE;
            }

            this.setHorizontalAlignment(JLabel.CENTER);
            this.setText((String) value);
            this.setBackground(selected ? backgroundColorCellSelected : Color.WHITE);
            this.setForeground(selected ? Color.WHITE : Color.BLACK);
            this.setFont(selected? bold : normal);
        }
        
        /**
         * Customatizacion de border por celda y columna
         */

//        if (this.clearCol == column || this.clearCol == row) {
//            System.out.println("Entre");
//            this.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.white));
//        }

        return this;
    }

    public void eraseBorder(int col) {
        clearRow = 0;
        clearCol = col;
    }

}
