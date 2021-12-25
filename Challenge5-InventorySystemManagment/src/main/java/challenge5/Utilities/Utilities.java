/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.Utilities;

import java.awt.*;
import java.net.URL;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author juand
 */
public class Utilities {

    // CONSTANTS && VARIABLES
    public static final Dimension SCREENSIZE = Toolkit.getDefaultToolkit().getScreenSize();
    public static final Double WIDTHSCREEN = SCREENSIZE.getWidth();
    public static final Double HEIGHTSCREEN = SCREENSIZE.getHeight();
    public static Double sizeFontTitle = Utilities.WIDTHSCREEN > 1500 ? 30.0 : 25.0;
    public static Double sizeFontData = Utilities.WIDTHSCREEN > 1500 ? 20.0 : 17.0;
    public static Double sizeFontTable = (Utilities.WIDTHSCREEN * 0.00878) + 1;
    public static final Font TITLEFONT = new Font("Helvetic", Font.BOLD, sizeFontTitle.intValue());
    public static final Font DATAFONT = new Font("Helvetic", Font.BOLD, sizeFontData.intValue());
    public static final Font INPUTFONT = new Font("Helvetic", Font.PLAIN, sizeFontData.intValue() - 1);
    public static final Font NOTIFICATIONSFONT = new Font("Helvetic", Font.BOLD, sizeFontTitle.intValue() - 2);
    public static final Color MAINCOLOR = new Color(186, 26, 26); //#ba1a1a
    public static final Dimension DIMENSIONTEXTFIELD = new Dimension(250, 33);

    // VARIABLES
    // GRID CONSTRAINTS
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
        constraints.insets = new Insets(0, 0, 0, 0);

        return constraints;
    }

    public static GridBagConstraints getConstraints(int x, int y, int width, int height, int padIntR, int padIntL, int padIntTop, int padIntBottom) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = width;
        constraints.gridheight = height;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.fill = 1;
        constraints.insets = new Insets(padIntTop, padIntL, padIntBottom, padIntR);

        return constraints;
    }

    // ICON FACTORY
    public static ImageIcon iconFactory(String nameFileIcon, Integer width, Integer height) throws Exception {
        ClassLoader classLoader = Utilities.class.getClassLoader();
        ImageIcon iconImg = new ImageIcon(classLoader.getResource(nameFileIcon+".png").toURI().toURL());
        Image image = iconImg.getImage();
        Image resizeImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizeImage);
    }

    // CREATE FILLER
    private static Box.Filler getBoxFiller(double greater, double lesser) {
        Double fillerHeight = Utilities.HEIGHTSCREEN * (Utilities.HEIGHTSCREEN > 850 ? greater : lesser);
        Dimension d = new Dimension(0, fillerHeight.intValue());
        return new Box.Filler(d, d, d);
    }

    // ADD FILLER IN GRIDBAGLAYOUT
    /**
     * Añade un Filler que funciona como espacio entre elementos, se calcula su
     * altura en base a la altura de la pantalla.
     *
     * @param panel El panel en donde se añadira el filler
     * @param greater Proporcion de la altura para pantallas mayores a 850
     * @param lesser Proporcion de la altura para pantallas menores a 850
     * @param indexY Posicion en GridBagLayout a ser agregado en el eje y
     */
    public static void addBoxFiller(JPanel panel, double greater, double lesser, int indexY) {
        panel.add(getBoxFiller(greater, lesser), Utilities.getConstraints(0, indexY, 1, 1, 0, 0, 0, 0));
    }

    // ADD FILLER IN BOXLAYOUT
    public static void addBoxFiller(JPanel panel, double greater, double lesser) {
        panel.add(getBoxFiller(greater, lesser));
    }

    // GET BORDER VALUE
    /**
     * Con un valor entre 0 y 100 devuelve el entero que corresponde al valor de
     * como porcentaje de la longitud horizontal de la pantalla o vertical,
     * segun el segundo parametro
     *
     * @param relation porcentaje del viewport
     * @param size vertical u horizontal longitud vertical u horizontal de la
     * pantalla como referencia
     */
    public static int getPixelValue(double relation, String size) {
        Double proportion;
        if (size.equalsIgnoreCase("VERTICAL")) {
            proportion = Utilities.HEIGHTSCREEN * relation;
        } else if (size.equalsIgnoreCase("DB")) {
            proportion = Utilities.HEIGHTSCREEN * relation;
            int cellNumbers = (int) Math.round(proportion / 35) - 1;
            proportion = (cellNumbers * 35.0) + 50;
        } else {
            proportion = Utilities.WIDTHSCREEN * relation;
        }

        return proportion.intValue();
    }

    /**
     * Get TextField Todos los campos inputs manejan la misma plantilla general
     */
    public static JTextField getTextField(JTextField input) {
        input.setPreferredSize(Utilities.DIMENSIONTEXTFIELD);
        input.setBorder(new CompoundBorder(input.getBorder(), new EmptyBorder(3, 5, 3, 5)));
        input.setFont(Utilities.INPUTFONT);
        return input;
    }
}
