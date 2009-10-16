/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package juegosistemagestion.entidades;

import java.util.ArrayList;
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

    //metodos con lógica --------------------------------------------------------

    /**
     * Devuelve una nueva instacia Mochila identica a la enviada por parametro
     * @param original
     * @return
     */
    public Mochila clonarMochila(Mochila original){
        Mochila mochilaNueva = new Mochila();
        List<Objeto> objetosNuevos = new ArrayList<Objeto>();
        Objeto objetoNuevo;

        mochilaNueva.setCapacidad(original.getCapacidad());

        for (Objeto objeto : original.getObjetos()) {
            objetoNuevo = new Objeto();
            objetoNuevo.setBeneficio(objeto.getBeneficio());
            objetoNuevo.setDisponible(objeto.isDisponible());
            objetoNuevo.setVolumen(objeto.getVolumen());
            objetoNuevo.setNombre(objeto.getNombre());
            objetosNuevos.add(objetoNuevo);
        }
        mochilaNueva.setObjetos(objetosNuevos);
        return mochilaNueva;
    }

    public boolean volumenOcupadoCorrecto(){
        boolean resul;
        double total= 0.0;
        for (Objeto objeto : this.getObjetos()) {
            if(objeto.isDisponible()){
                total+= objeto.getVolumen();
            }
        }
        if(total<= this.getCapacidad()){
            resul = true;
        }else{
            resul= false;
        }
        return resul;
    }

    public double getBeneficioObtenido(){
        double total= 0.0;
        for (Objeto objeto : this.getObjetos()) {
            if(objeto.isDisponible()){
                total+= objeto.getBeneficio();
            }
        }
        return total;
    }

    public double getVolumenOcupado(){
        double total= 0.0;
        for (Objeto objeto : this.getObjetos()) {
            if(objeto.isDisponible()){
                total+= objeto.getVolumen();
            }
        }
        return total;
    }

}
