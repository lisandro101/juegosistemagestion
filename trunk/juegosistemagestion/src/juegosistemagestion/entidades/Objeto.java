/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package juegosistemagestion.entidades;

/**
 *
 * @author stafoxter
 */
public class Objeto {

    private String nombre;
    private double beneficio;
    private double volumen;
    private boolean disponible;//es parte de la soluciòn
    double feromonaAcumulada;


    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the beneficio
     */
    public double getBeneficio() {
        return beneficio;
    }

    /**
     * @param beneficio the beneficio to set
     */
    public void setBeneficio(double beneficio) {
        this.beneficio = beneficio;
    }

    /**
     * @return the volumen
     */
    public double getVolumen() {
        return volumen;
    }

    /**
     * @param volumen the volumen to set
     */
    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    /**
     * @return the disponible
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * @param disponible the disponible to set
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
}
