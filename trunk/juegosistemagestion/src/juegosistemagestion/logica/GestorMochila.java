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
        int cantidadObjetos= mochila.getObjetos().size();
        Objeto objeto;
        //Mochila A
        List<Objeto> mejoresObjetos = inicializarSubMochila(mochila);//new ArrayList<Objeto>();
        double capacidad = mochila.getCapacidad();
        Mochila mejorMochila = new Mochila();
        mejorMochila.setCapacidad(capacidad);
        mejorMochila.setObjetos(mejoresObjetos);

        //no hacen falta
  //      double mejorBeneficio = calcularBeneficio(mejorMochila);
        double volumen =0.0;

        //Mejor Mochila
        List<Objeto> objetosA = new ArrayList<Objeto>();
        capacidad = mochila.getCapacidad();
        Mochila mochilaA = new Mochila();
        mochilaA.setCapacidad(capacidad);
        mochilaA.setObjetos(objetosA);

        for (int i = 0; i < cantidadObjetos; i++) {
            objeto = mochila.getObjetos().get(i);
            objeto.setDisponible(true);
            mochilaA.getObjetos().add(objeto);

            for (int paso = 1; paso < cantidadObjetos; paso=+(cantidadObjetos/3)) {

                for (int j = (i+1); j < cantidadObjetos; j=+paso) {

                    if( true){ //volumenOcupadoCorrecto(mochilaA)){
                        if(true){

                        }
                    }

                }
            }

        }
       

    }

    

    private double redondear(double valor){
        return (Math.floor(valor*100)/100);
    }

   /**
     * Debuelve la mochila completa, pero con los primeros objetos como disponibles (hasta q cubran la capacidad)
     * @param mochila
     * @return
     */
    public Mochila inicializarMochila(Mochila mochila){
        double ocupado = mochila.getVolumenOcupado(); //calcularVolumen(mochila);
        for (Objeto objeto : mochila.getObjetos()) {
            if((ocupado)+ objeto.getVolumen() <= mochila.getCapacidad()){
                objeto.setDisponible(true);
                ocupado += objeto.getVolumen();
            }
        }

        return mochila;
    }
    /**
     * Devuelve una nueva List de Objetos disponibles (disponible=true)cuyo volumen no supero la capacidad de la mochila
     * @param mochila
     * @return
     */

    public List<Objeto> inicializarSubMochila(Mochila mochila){
        List<Objeto> objetos = new ArrayList<Objeto>();
        double ocupado = mochila.getVolumenOcupado();//calcularVolumen(mochila);
        for (Objeto objeto : mochila.getObjetos()) {
            if((ocupado)+ objeto.getVolumen() <= mochila.getCapacidad()){
                objeto.setDisponible(true);
                objetos.add(objeto);
                ocupado += objeto.getVolumen();
            }
        }

        return objetos;
    }
}

