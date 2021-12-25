/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.View.Inventory;

import javax.swing.table.DefaultTableModel;

/**
 * TableData es la clase encargada de recepcionar los datos y
 * nombres de columnas de la tabla, para aplicarlos a la tabla.
 */
public class TableData extends DefaultTableModel {

    // ATTRIBUTES
    private String[] headers;
    private Object[][] data;

    // CONSTRUCTOR
    /**
     * @param data, datos de la tabla
     * @param headers, titulos de las celdas
     */
    public TableData(Object[][] data, String[] headers) {
        super();
        this.headers = headers;
        this.data = data;
        setDataVector(this.data, this.headers);
    }

    /**
     * Establece que ninguna celda es editable de manera directa.
     */
    @Override
    public boolean isCellEditable(int row, int colum) {
        return false;
    }

}
