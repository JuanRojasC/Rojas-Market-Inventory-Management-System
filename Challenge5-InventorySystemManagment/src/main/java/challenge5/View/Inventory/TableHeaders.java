/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.View.Inventory;

import challenge5.Utilities.Utilities;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;

/**
 * @author juand
 * Table Headers es la clase encargada de estilizar los headers de la tabla.
 */
public class TableHeaders implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        JComponent component = null;
        
        /**
         * Verifica si el header es de tipo String, y alinea horizontalmente de forma centrada, establece un width de 50
         * y un height de 50.
         */
        if (value instanceof String) {
            component = new JLabel((String) value);
            ((JLabel) component).setHorizontalAlignment(SwingConstants.CENTER);
            ((JLabel) component).setSize(50, component.getWidth());
            ((JLabel) component).setPreferredSize(new Dimension(6, component.getWidth()));
        }

        
        /**
         * Si es la ultima columna al header no le coloca border
         */
        if (value.equals("Unidades")) {
            component.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(211, 211, 211)));
        } else {
            component.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(211, 211, 211)));
        }
        
        
        /**
         * Configuraciones generales
         */
        component.setOpaque(true);
        component.setBackground(Utilities.MAINCOLOR);
        component.setForeground(Color.white);
        component.setFont(new Font("Arial", Font.BOLD, Utilities.sizeFontTable.intValue()));

        return component;
    }
}
