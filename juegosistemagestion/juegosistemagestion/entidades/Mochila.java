/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package juegosistemagestion.entidades;

import java.util.List;

/**
 *
 * @author stafoxter
 */
public class Mochila {

    private double capacidad;
    private List<Objeto> objetos;

    /**
     * @return the capacidad
     */
    public double getCapacidad() {
        return capacidad;
    }

    /**
     * @param capacidad the capacidad to set
     */
    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * @return the objetos
     */
    public List<Objeto> getObjetos() {
        return objetos;
    }

    /**
     * @param objetos the objetos to set
     */
    public void setObjetos(List<Objeto> objetos) {
        this.objetos = objetos;
    }
    
}
