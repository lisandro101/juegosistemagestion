package juegosistemagestion.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Lisandro
 */
public class Parametros {

    private static Parametros instancia;
    private Properties propiedades;
    
    private Parametros() {
        try {
            propiedades = new java.util.Properties();
            propiedades.load(new FileInputStream("config.ini"));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static synchronized Parametros getInstancia() {
        if(instancia == null) {
            instancia = new Parametros();
        }
        
        return instancia;
    }
    
    public String getParametro(String valor) {
        return propiedades.getProperty(valor);
    }

    public void setParametro(String nombre, String valor){
        propiedades.setProperty(nombre, valor);
    }
}
