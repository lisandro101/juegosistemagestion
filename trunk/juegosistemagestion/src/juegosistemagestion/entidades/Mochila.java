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
    private double BeneficioMenor;
    private double BeneficioMayor;
    private List<Objeto> objetos;

    /**
     * @return the capacidad
     */
       public void setBeneficioMenor(double capacidad) {
        this.capacidad = BeneficioMenor;
    }

    public double getBeneficioMayor() {
        return BeneficioMayor;
    }
       public void setBeneficioMayor(double capacidad) {
        this.capacidad = BeneficioMayor;
    }

    public double getBeneficioMenor() {
        return BeneficioMenor;
    }




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
     * Devuelve una nueva instacia Mochila identica
     * @param original
     * @return
     */
    public Mochila clonarMochila(){
        Mochila mochilaNueva = new Mochila();
        List<Objeto> objetosNuevos = new ArrayList<Objeto>();
        Objeto objetoNuevo;

        mochilaNueva.setCapacidad(this.getCapacidad());

        for (Objeto objeto : this.getObjetos()) {
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

    public boolean isVolumenOcupadoCorrecto(){
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

    public void vaciarMochila(){
        for (int i = 0; i < this.getObjetos().size(); i++) {
            this.getObjetos().remove(i);
        }
    }

    public void noDisponibleTodosLosObjetos(){
        for (Objeto objeto : objetos) {
            objeto.setDisponible(false);
        }
    }

    public void mostrarObjetosMochilaDisponibles(){

        System.out.println("----------------------------------------");
        System.out.println("-----------Objetos Disponibles----------");
        System.out.println("----------------------------------------");
        for (Objeto objeto : objetos) {
            if(objeto.isDisponible()){
                System.out.println("----------------------------------------");
                System.out.println("Nombre: "+objeto.getNombre());
                System.out.println("Beneficio: "+objeto.getBeneficio());
                System.out.println("Volumen: "+ objeto.getVolumen());
            }
        }
        System.out.println("\n----------------------------------------");
        System.out.println("----------------------------------------");
        System.out.println("Beneficio Total: "+ this.getBeneficioObtenido());
        System.out.println("Volumen: "+ this.getVolumenOcupado());
        System.out.println("----------------------------------------");
    }

    public boolean estaEnLaMochila(Objeto objeto){
        if(objetos.contains(objeto)){
            return true;
        }else{
            return false;
        }
    }
}
