/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package juegosistemagestion.logica;

import java.util.ArrayList;
import java.util.List;
import juegosistemagestion.entidades.Mochila;
import juegosistemagestion.entidades.Objeto;

/**
 *
 * @author stafoxter
 */
public class GestorMochila {
    private static GestorMochila instance;

    public synchronized static GestorMochila getInstancia() {
        if (instance == null) {
            instance = new GestorMochila();
        }
        return instance;
    }

    private GestorMochila(){
    }


    private double generarNroAleatorio(double min, double max){
        double uno;
//        Random r;
//        r=new Random();
//        r.setSeed(new Date().getTime());
//        r.nextDouble();
        uno=((max - min + 1) * Math.random() + min);
        return redondear(uno);

    }

    public List<Objeto> generarObjetos(double beneMin, double beneMax, double volMin, double volMax, int cantObj){
        List<Objeto> objetos = new ArrayList<Objeto>();
        Objeto valor;
        for (int i = 0; i < cantObj; i++) {
            valor = new Objeto();
            valor.setNombre(""+(i+1));
            valor.setBeneficio(generarNroAleatorio(beneMin, beneMax));
            valor.setVolumen(generarNroAleatorio(volMin, volMax));
            valor.setDisponible(false);

            objetos.add(valor);
        }
        return objetos;
    }

    public void calcularPorFuerzaBruta(Mochila mochila){
        List<Objeto> objetos = inicializarSubMochila(mochila);//new ArrayList<Objeto>();
        double capacidad = mochila.getCapacidad();
        Mochila mochilaTemp = new Mochila();
        mochilaTemp.setCapacidad(capacidad);
        mochilaTemp.setObjetos(objetos);

        double mejorBeneficio = calcularBeneficio(mochilaTemp);
        double volumen =0.0;



       

    }

    private boolean volumenOcupadoCorrecto(Mochila mochila){
        boolean resul;
        double total= 0.0;
        for (Objeto objeto : mochila.getObjetos()) {
            if(objeto.isDisponible()){
                total+= objeto.getVolumen();
            }
        }
        if(total<= mochila.getCapacidad()){
            resul = true;
        }else{
            resul= false;
        }
        return resul;
    }

    private double calcularBeneficio(Mochila mochila){
        double total= 0.0;
        for (Objeto objeto : mochila.getObjetos()) {
            if(objeto.isDisponible()){
                total+= objeto.getBeneficio();
            }
        }
        return total;
    }

    private double calcularVolumen(Mochila mochila){
        double total= 0.0;
        for (Objeto objeto : mochila.getObjetos()) {
            if(objeto.isDisponible()){
                total+= objeto.getVolumen();
            }
        }
        return total;
    }

    //tiene q ser private
    public Mochila inicializarMochila(Mochila mochila){
        double ocupado = calcularVolumen(mochila);
        for (Objeto objeto : mochila.getObjetos()) {
            if((ocupado)+ objeto.getVolumen() <= mochila.getCapacidad()){
                objeto.setDisponible(true);
                ocupado += objeto.getVolumen();
            }
        }

        return mochila;
    }
    /**
     * Devuelve una nueva List de Objetos cuyo volumen no supero la capacidad de la mochila
     * @param mochila
     * @return
     */

    private List<Objeto> inicializarSubMochila(Mochila mochila){
        List<Objeto> objetos = new ArrayList<Objeto>();
        double ocupado = calcularVolumen(mochila);
        for (Objeto objeto : mochila.getObjetos()) {
            if((ocupado)+ objeto.getVolumen() <= mochila.getCapacidad()){
                objeto.setDisponible(true);
                objetos.add(objeto);
                ocupado += objeto.getVolumen();
            }
        }

        return objetos;
    }

    private double redondear(double valor){
        return (Math.floor(valor*100)/100);
    }

    private Mochila clonarMochila(Mochila original){
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
}

