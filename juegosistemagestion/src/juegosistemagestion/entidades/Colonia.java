/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package juegosistemagestion.entidades;

import java.util.List;

/**
 *
 * @author martin
 */
public class Colonia {
    private String nombre;
    private int cantidadHormigas = 10;
    private double feromonaAcumulada;
    private double nivelBeneficio;
    private // beneficio acumulado
    List<Hormiga> listaHormigas;

    /**
     * @return the cantidadHormigas
     */
    public int getCantidadHormigas() {
        return cantidadHormigas;
    }

    /**
     * @param cantidadHormigas the cantidadHormigas to set
     */
    public void setCantidadHormigas(int cantidadHormigas) {
        this.cantidadHormigas = cantidadHormigas;
    }

    /**
     * @return the feromonaAcumulada
     */
    public double getFeromonaAcumulada() {
        return feromonaAcumulada;
    }

    /**
     * @param feromonaAcumulada the feromonaAcumulada to set
     */
    public void setFeromonaAcumulada(double feromonaAcumulada) {
        this.feromonaAcumulada = feromonaAcumulada;
    }

    /**
     * @return the nivelBeneficio
     */
    public double getNivelBeneficio() {
        return nivelBeneficio;
    }

    /**
     * @param nivelBeneficio the nivelBeneficio to set
     */
    public void setNivelBeneficio(double nivelBeneficio) {
        this.nivelBeneficio = nivelBeneficio;
    }

    /**
     * @return the listaHormigas
     */
    public List<Hormiga> getListaHormigas() {
        return listaHormigas;
    }

    /**
     * @param listaHormigas the listaHormigas to set
     */
    public void setListaHormigas(List<Hormiga> listaHormigas) {
        this.listaHormigas = listaHormigas;
    }

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

}
