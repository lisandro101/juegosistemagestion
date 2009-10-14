/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package juegosistemagestion;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import juegosistemagestion.igu.PantallaPrincipal;

/**
 *
 * @author stafoxter
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        PantallaPrincipal p = new PantallaPrincipal();

        p.setLocationRelativeTo(null);
        p.setVisible(true);
        p.setModal(true);
    }

}
