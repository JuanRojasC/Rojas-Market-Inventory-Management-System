/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.View.Inventory;

import challenge5.Model.ProductService;
import challenge5.Model.Product;
import challenge5.Utilities.Utilities;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import javax.swing.border.*;
import javax.swing.table.JTableHeader;

/**
 *
 * @author juand
 */
public class TablePanel {

    // ATTRIBUTES
    private static TablePanel instance;
    private JScrollPane scrollTable;
    private JTable table;
    private ProductService productService;
    private TableData tableData;
    private Integer lastRowAvailable;

    // CONSTRUCTOR
    private TablePanel() {
        productService = ProductService.getInstance();
    }

    // GET INSTANCE
    public static TablePanel getInstance() {
        if (instance == null) {
            instance = new TablePanel();
        }
        return instance;
    }

    /**
     * JScrollPanel es un panel con scroll que contendra la table.
     */
    public JScrollPane initTablePanel() {
        scrollTable = new JScrollPane();
        scrollTable.setPreferredSize(new Dimension(900, 400));
        scrollTable.setMaximumSize(new Dimension(32000, 32000));
        scrollTable.setBorder(new CompoundBorder(new CompoundBorder(), new EmptyBorder(0, 100, 0, 100)));
        scrollTable.setBackground(Color.WHITE);
        scrollTable.setOpaque(true);
        scrollTable.getViewport().setBackground(Color.WHITE);

        table = new JTable();
        table.setBackground(Color.WHITE);
        table.setOpaque(true);
        table.setBorder(BorderFactory.createLineBorder(Color.black));
        table.setShowVerticalLines(true);
        table.setShowHorizontalLines(true);
        scrollTable.setViewportView(table);

        builtTable();

        return scrollTable;
    }

    /**
     * Apartir de los datos contenidos en la clase ProductDataBase, se genera un
     * array de strings con todos estos, para ser insertados en la tabla. Define
     * tambien la cantidad de celdas que tendra la tabla, que podria variar de
     * la cantidad de datos registrados, siempre siendo mas o igual.
     */
    public Object[][] getData() {
        List<Product> productsList = (List<Product>)productService.getProductList() ;
        Integer length = productsList.size();
        Integer sizeResponsive
                = length < 18 && Utilities.HEIGHTSCREEN > 850 ? 18
                        : length < 11 && Utilities.HEIGHTSCREEN < 850 ? 10 : length;

        lastRowAvailable = sizeResponsive;

        Object[][] data = new String[sizeResponsive][getHeaders().length];
        int i = 0;

        for (Product product : productsList) {
            data[i][0] = product.getCode().toString();
            data[i][1] = product.getName();
            data[i][2] = product.getPrice().toString();
            data[i][3] = product.getStock().toString();
            i++;
        }

        return data;
    }

    /**
     * Este método construye un array de strings con los encabezados que
     * contendra la tabla.
     */
    public String[] getHeaders() {
        String columnOne = "Codigo";
        String columnTwo = "Producto";
        String columnThree = "Precio";
        String columnFour = "Unidades";
        return new String[]{columnOne, columnTwo, columnThree, columnFour};
    }

    /**
     * Metodo encargado de cargar las datos en la tabla, especificar el tsipo de
     * de dato almacenado en cada columna, setear medidas y colores tantos a las
     * celdas como a los encabezados.
     */
    private void builtTable() {
        tableData = new TableData(getData(), getHeaders());
        table.setModel(tableData);

        table.getColumnModel().getColumn(0).setCellRenderer(new TableCell("numeric"));
        table.getColumnModel().getColumn(1).setCellRenderer((new TableCell("text")));
        table.getColumnModel().getColumn(2).setCellRenderer(new TableCell("numeric"));
        table.getColumnModel().getColumn(3).setCellRenderer(new TableCell("numeric"));

        table.getTableHeader().setReorderingAllowed(false);
        table.setRowHeight(35);
        table.setGridColor(Color.black);

        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(250);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(150);

        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setDefaultRenderer(new TableHeaders());
        table.setTableHeader(tableHeader);
    }

    /**
     * Metodo publico que invoca a builTable() con el fin de reconstruir la
     * tabla y asi actualizar la informacion de esta.
     */
    public void updateTable(){
        builtTable();
    }

}
