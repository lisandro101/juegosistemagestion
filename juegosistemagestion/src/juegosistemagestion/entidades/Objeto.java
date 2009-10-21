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
    private boolean disponibleUsuario;//es parte de la soluciòn
    private boolean disponibleFuerzaBruta;
    private boolean disponibleHormiga;

    private double feromonaAcumulada = 0.05;
    private double rastroFeromona;
    private double probabilidad;
    private double probabilidadAcumulada;
    private double numAleatorioMin;
    private double numAleatorioMax;


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
    public boolean isDisponibleUsuario() {
        return disponibleUsuario;
    }

    /**
     * @param disponible the disponible to set
     */
    public void setDisponibleUsuario(boolean disponible) {
        this.disponibleUsuario = disponible;
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
     * @return the probabilidad
     */
    public double getProbabilidad() {
        return probabilidad;
    }

    /**
     * @param probabilidad the probabilidad to set
     */
    public void setProbabilidad(double probabilidad) {
        this.probabilidad = probabilidad;
    }

    /**
     * @return the probabilidadAcumulada
     */
    public double getProbabilidadAcumulada() {
        return probabilidadAcumulada;
    }

    /**
     * @param probabilidadAcumulada the probabilidadAcumulada to set
     */
    public void setProbabilidadAcumulada(double probabilidadAcumulada) {
        this.probabilidadAcumulada = probabilidadAcumulada;
    }

    /**
     * @return the numAleatorioMin
     */
    public double getNumAleatorioMin() {
        return numAleatorioMin;
    }

    /**
     * @param numAleatorioMin the numAleatorioMin to set
     */
    public void setNumAleatorioMin(double numAleatorioMin) {
        this.numAleatorioMin = numAleatorioMin;
    }

    /**
     * @return the numAleatorioMax
     */
    public double getNumAleatorioMax() {
        return numAleatorioMax;
    }

    /**
     * @param numAleatorioMax the numAleatorioMax to set
     */
    public void setNumAleatorioMax(double numAleatorioMax) {
        this.numAleatorioMax = numAleatorioMax;
    }

    /**
     * @return the disponibleFuerzaBruta
     */
    public boolean isDisponibleFuerzaBruta() {
        return disponibleFuerzaBruta;
    }

    /**
     * @param disponibleFuerzaBruta the disponibleFuerzaBruta to set
     */
    public void setDisponibleFuerzaBruta(boolean disponibleFuerzaBruta) {
        this.disponibleFuerzaBruta = disponibleFuerzaBruta;
    }

    /**
     * @return the disponibleHormiga
     */
    public boolean isDisponibleHormiga() {
        return disponibleHormiga;
    }

    /**
     * @param disponibleHormiga the disponibleHormiga to set
     */
    public void setDisponibleHormiga(boolean disponibleHormiga) {
        this.disponibleHormiga = disponibleHormiga;
    }
    
}
