

package juegosistemagestion.entidades;

import java.util.List;

public class Hormiga {
    private String nombre;
    private double feromonaInicial = 0.1;// es la probabilidad del objeto dividido la suma de las probabilidades de todos
    private double factorEvaporacionFeromona = 0.5;
    private double probAcumulada;
    private double probNormal;
    List<Objeto> camino;

    public double getFeromonaInicial() {
        return feromonaInicial;
    }

    public void setFeromonaInicial(double feromonaInicial) {
        this.feromonaInicial = feromonaInicial;
    }

    public double getFactorEvaporacionFeromona() {
        return factorEvaporacionFeromona;
    }

    public void setFactorEvaporacionFeromona(double factorEvaporacionFeromona) {
        this.factorEvaporacionFeromona = factorEvaporacionFeromona;
    }

    public double getProbAcumulada() {
        return probAcumulada;
    }

    public void setProbAcumulada(double probAcumulada) {
        this.probAcumulada = probAcumulada;
    }

    public double getProbNormal() {
        return probNormal;
    }

    public void setProbNormal(double probNormal) {
        this.probNormal = probNormal;
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
