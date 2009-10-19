/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package juegosistemagestion.entidades;

/**
 *
 * @author Seba
 */
public class Error {

    private double errorAbsoluto;
    private double errorRelativo;
    private double errorRelativoMenor;
    private double errorRelativoMayor;
    private double errorRelativoPromedio;
    private double s;
    private double intervaloDeConfianza;

    /**
     * @return the errorAbsoluto
     */
    public double getErrorAbsoluto() {
        return errorAbsoluto;
    }

    /**
     * @param errorAbsoluto the errorAbsoluto to set
     */
    public void setErrorAbsoluto(double errorAbsoluto) {
        this.errorAbsoluto = errorAbsoluto;
    }

    /**
     * @return the errorRelativo
     */
    public double getErrorRelativo() {
        return errorRelativo;
    }

    /**
     * @param errorRelativo the errorRelativo to set
     */
    public void setErrorRelativo(double errorRelativo) {
        this.errorRelativo = errorRelativo;
    }

    /**
     * @return the errorRelativoMenor
     */
    public double getErrorRelativoMenor() {
        return errorRelativoMenor;
    }

    /**
     * @param errorRelativoMenor the errorRelativoMenor to set
     */
    public void setErrorRelativoMenor(double errorRelativoMenor) {
        this.errorRelativoMenor = errorRelativoMenor;
    }

    /**
     * @return the errorRelativoMayor
     */
    public double getErrorRelativoMayor() {
        return errorRelativoMayor;
    }

    /**
     * @param errorRelativoMayor the errorRelativoMayor to set
     */
    public void setErrorRelativoMayor(double errorRelativoMayor) {
        this.errorRelativoMayor = errorRelativoMayor;
    }

    /**
     * @return the errorRelativoPromedio
     */
    public double getErrorRelativoPromedio() {
        return errorRelativoPromedio;
    }

    /**
     * @param errorRelativoPromedio the errorRelativoPromedio to set
     */
    public void setErrorRelativoPromedio(double errorRelativoPromedio) {
        this.errorRelativoPromedio = errorRelativoPromedio;
    }

    /**
     * @return the s
     */
    public double getS() {
        return s;
    }

    /**
     * @param s the s to set
     */
    public void setS(double s) {
        this.s = s;
    }

    /**
     * @return the intervaloDeConfianza
     */
    public double getIntervaloDeConfianza() {
        return intervaloDeConfianza;
    }

    /**
     * @param intervaloDeConfianza the intervaloDeConfianza to set
     */
    public void setIntervaloDeConfianza(double intervaloDeConfianza) {
        this.intervaloDeConfianza = intervaloDeConfianza;
    }

    
}
