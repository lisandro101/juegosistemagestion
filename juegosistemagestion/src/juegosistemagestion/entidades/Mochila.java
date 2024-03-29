/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package juegosistemagestion.entidades;

import java.util.ArrayList;
import java.util.List;
import juegosistemagestion.logica.GestorMochila;

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
            objetoNuevo.setDisponibleUsuario(objeto.isDisponibleUsuario());
            objetoNuevo.setVolumen(objeto.getVolumen());
            objetoNuevo.setNombre(objeto.getNombre());
            objetosNuevos.add(objetoNuevo);
        }
        mochilaNueva.setObjetos(objetosNuevos);
        return mochilaNueva;
    }

    public boolean isVolumenOcupadFBrutaoCorrecto(){
        boolean resul;
        double total= 0.0;
        for (Objeto objeto : this.getObjetos()) {
            if(objeto.isDisponibleFuerzaBruta()){
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

    public boolean isVolumenOcupadoUsuarioCorrecto(){
        boolean resul;
        double total= 0.0;
        for (Objeto objeto : this.getObjetos()) {
            if(objeto.isDisponibleUsuario()){
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

    public boolean isVolumenOcupadoCHormigaCorrecto(){
        boolean resul;
        double total= 0.0;
        for (Objeto objeto : this.getObjetos()) {
            if(objeto.isDisponibleHormiga()){
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





    public double getBeneficioObtenidoUsuario(){
        double total= 0.0;
        for (Objeto objeto : this.getObjetos()) {
            if(objeto.isDisponibleUsuario()){
                total+= objeto.getBeneficio();
            }
        }
        return GestorMochila.getInstancia().redondear(total);
    }

    public double getVolumenOcupadoUsuario(){
        double total= 0.0;
        for (Objeto objeto : this.getObjetos()) {
            if(objeto.isDisponibleUsuario()){
                total+= objeto.getVolumen();
            }
        }
        return GestorMochila.getInstancia().redondear(total);
    }
        public double getBeneficioObtenidoFBruta(){
        double total= 0.0;
        for (Objeto objeto : this.getObjetos()) {
            if(objeto.isDisponibleFuerzaBruta()){
                total+= objeto.getBeneficio();
            }
        }
        return GestorMochila.getInstancia().redondear(total);
    }

    public double getVolumenOcupadoFBruta(){
        double total= 0.0;
        for (Objeto objeto : this.getObjetos()) {
            if(objeto.isDisponibleFuerzaBruta()){
                total+= objeto.getVolumen();
            }
        }
        return GestorMochila.getInstancia().redondear(total);
    }

        public double getBeneficioObtenidoCHormiga(){
        double total= 0.0;
        for (Objeto objeto : this.getObjetos()) {
            if(objeto.isDisponibleHormiga()){
                total+= objeto.getBeneficio();
            }
        }
        return GestorMochila.getInstancia().redondear(total);
    }

    public double getVolumenOcupadoCHormiga(){
        double total= 0.0;
        for (Objeto objeto : this.getObjetos()) {
            if(objeto.isDisponibleHormiga()){
                total+= objeto.getVolumen();
            }
        }
        return GestorMochila.getInstancia().redondear(total);
    }



    public void vaciarMochila(){
        for (int i = 0; i < this.getObjetos().size(); i++) {
            this.getObjetos().remove(i);
        }
    }

    public void noDisponibleTodosLosObjetosFBruta(){
        for (Objeto objeto : objetos) {
            objeto.setDisponibleFuerzaBruta(false);
        }
    }

    public void noDisponibleTodosLosObjetosCHormiga(){
        for (Objeto objeto : objetos) {
            objeto.setDisponibleHormiga(false);
        }
    }

    public void noDisponibleTodosLosObjetosUsuario(){
        for (Objeto objeto : objetos) {
            objeto.setDisponibleUsuario(false);
        }
    }

    public void mostrarObjetosMochilaDisponibles(){

        System.out.println("----------------------------------------");
        System.out.println("-----------Objetos Disponibles----------");
        System.out.println("----------------------------------------");
        for (Objeto objeto : objetos) {
            if(objeto.isDisponibleUsuario()){
                System.out.println("----------------------------------------");
                System.out.println("Nombre: "+objeto.getNombre());
                System.out.println("Beneficio: "+objeto.getBeneficio());
                System.out.println("Volumen: "+ objeto.getVolumen());
            }
        }
        System.out.println("\n----------------------------------------");
        System.out.println("----------------------------------------");
        System.out.println("Beneficio Total: "+ this.getBeneficioObtenidoUsuario());
        System.out.println("Volumen: "+ this.getVolumenOcupadoUsuario());
        System.out.println("----------------------------------------");
    }

    public boolean estaEnLaMochila(Objeto objeto){
        if(objetos.contains(objeto)){
            return true;
        }else{
            return false;
        }
    }

    public int getCantidadDeObjetos(){
        return this.getObjetos().size();
    }
}
