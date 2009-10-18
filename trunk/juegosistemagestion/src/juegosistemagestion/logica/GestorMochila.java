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

    private GestorMochila() {
    }

    private double generarNroAleatorio(double min, double max) {
        double uno;
//        Random r;
//        r=new Random();
//        r.setSeed(new Date().getTime());
//        r.nextDouble();
        uno = ((max - min + 1) * Math.random() + min);
        return redondear(uno);

    }

    public List<Objeto> generarObjetos(double beneMin, double beneMax, double volMin, double volMax, int cantObj) {
        List<Objeto> objetos = new ArrayList<Objeto>();
        Objeto valor;
        for (int i = 0; i < cantObj; i++) {
            valor = new Objeto();
            valor.setNombre("" + (i + 1));
            valor.setBeneficio(generarNroAleatorio(beneMin, beneMax));
            valor.setVolumen(generarNroAleatorio(volMin, volMax));
            valor.setDisponible(false);

            objetos.add(valor);
        }
        return objetos;
    }

    public void calcularPorHormiga(Mochila mochila) {
        int cantidadObjetos = mochila.getObjetos().size();
        Objeto objeto;

        List<Objeto> listaObjetos = inicializarSubMochila(mochila);//new ArrayList<Objeto>();
        double capacidad = mochila.getCapacidad();
        Mochila mejorMochila = new Mochila();
        mejorMochila.setCapacidad(capacidad);
        mejorMochila.setObjetos(listaObjetos);

/*
        //Mochila A
        List<Objeto> objetosA = new ArrayList<Objeto>();

        Mochila mochilaA = new Mochila();
        mochilaA.setCapacidad(capacidad);
        mochilaA.setObjetos(objetosA);
*/

        
    }

    public void calcularPorFuerzaBruta(Mochila mochila) {
        int cantidadObjetos = mochila.getObjetos().size();
        Objeto objeto;
        //Mejor Mochila
        List<Objeto> mejoresObjetos = inicializarSubMochila(mochila);//new ArrayList<Objeto>();
        double capacidad = mochila.getCapacidad();
        Mochila mejorMochila = new Mochila();
        mejorMochila.setCapacidad(capacidad);
        mejorMochila.setObjetos(mejoresObjetos);

        //Mochila A
        List<Objeto> objetosA = new ArrayList<Objeto>();

        Mochila mochilaA = new Mochila();
        mochilaA.setCapacidad(capacidad);
        mochilaA.setObjetos(objetosA);

        for (int i = 0; i < cantidadObjetos; i++) {
            objeto = mochila.getObjetos().get(i);
            objeto.setDisponible(true);
            mochilaA.getObjetos().add(objeto);

            System.out.println("bucle uno");
            for (int paso = 1; paso < (cantidadObjetos / 3); paso++) { //paso=+(cantidadObjetos/3)) {

                System.out.println("bucle dos");
                for (int j = (i + 1); j < cantidadObjetos;) {
                    objeto = mochila.getObjetos().get(j);
                    System.out.println("bucle tres");
                    System.out.println("valor de j: " + j);
                    if (mochilaA.isVolumenOcupadoCorrecto() && !mochilaA.estaEnLaMochila(objeto)) {
                        if ((mochilaA.getVolumenOcupado() +
                                mochila.getObjetos().get(j).getVolumen()) <= capacidad) {

                            objeto.setDisponible(true);
                            mochilaA.getObjetos().add(objeto);
                        }
                    }
                    j += paso;
                }
                if (mochilaA.getBeneficioObtenido() > mejorMochila.getBeneficioObtenido()) {
                    mejorMochila = mochilaA.clonarMochila();
                }
                if (!(i == cantidadObjetos - 1)) {
                    mochila.noDisponibleTodosLosObjetos();
                    mochilaA.vaciarMochila();
                }

            }

        }

        // Borrar lineas siguientes
        mejorMochila.mostrarObjetosMochilaDisponibles();

    }

    private double redondear(double valor) {
        return (Math.floor(valor * 100) / 100);
    }

    /**
     * Debuelve la mochila completa, pero con los primeros objetos como disponibles (hasta q cubran la capacidad)
     * @param mochila
     * @return
     */
    public Mochila inicializarMochila(Mochila mochila) {
        double ocupado = mochila.getVolumenOcupado(); //calcularVolumen(mochila);
        for (Objeto objeto : mochila.getObjetos()) {
            if ((ocupado) + objeto.getVolumen() <= mochila.getCapacidad()) {
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
    public List<Objeto> inicializarSubMochila(Mochila mochila) {
        List<Objeto> objetos = new ArrayList<Objeto>();
        double ocupado = mochila.getVolumenOcupado();//calcularVolumen(mochila);
        for (Objeto objeto : mochila.getObjetos()) {
            if ((ocupado) + objeto.getVolumen() <= mochila.getCapacidad()) {
                objeto.setDisponible(true);
                objetos.add(objeto);
                ocupado += objeto.getVolumen();
            }
        }

        return objetos;
    }
}

