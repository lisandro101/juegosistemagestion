/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegosistemagestion.logica;

import java.util.ArrayList;
import java.util.List;
import juegosistemagestion.entidades.Colonia;
import juegosistemagestion.entidades.Hormiga;
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

    private double calcularProbabilidad(List<Objeto> objetos, int i) {
        int cantObjetos = objetos.size();
        double probabilidad = 1.0 / (double) cantObjetos;
        //objetos.get(i).setProbabilidad(probabilidad);
        //System.out.println("La probabilidad del Objeto "+ i + " es "+objetos.get(i).getProbabilidad());
        return probabilidad;
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
            valor.setDisponibleUsuario(false);
            valor.setDisponibleFuerzaBruta(false);
            valor.setDisponibleHormiga(false);
            valor.setFeromonaAcumulada(0.1);

            objetos.add(valor);
        }
        return objetos;
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------

    public Mochila calcularPorHormiga(Mochila mochila) {
        // System.out.println("=============================================================================================");
        // System.out.println("======================================Metodo calcular Por Hormiga============================");
        // System.out.println("=============================================================================================");
        List<Colonia> colonias = generarColonias(5);
        List<Hormiga> hormigas = generarHormigas(5);

        Mochila mejorMochila = mochila.clonarMochila();
        Mochila mochila2 = mochila.clonarMochila();

        Mochila mejorMochilaPorHormiga = new Mochila();

        int cantidadColonias = colonias.size();
        int cantidadHormigas = colonias.get(0).getCantidadHormigas();
        int cantidadObjetos = mochila.getCantidadDeObjetos();
        double capacidad = mochila.getCapacidad();
        


        for (Colonia colonia : colonias) {
            colonia.setListaHormigas(hormigas);
        }


        for (int j = 0; j < cantidadColonias; j++) {
            //System.out.println("=====================================Colonia " + j + "=============================");


            for (int k = 0; k < cantidadHormigas; k++) {
                // System.out.println("=====================================Hormiga " + k + "=============================");

                 double nroAleatorio = Math.random();
                colonias.get(j).getListaHormigas().get(k).setNroAleatorio(nroAleatorio);
                mejorMochilaPorHormiga.vaciarMochila();
                mochila2.noDisponibleTodosLosObjetosCHormiga();
                
                //for (int z = 0; z < cantidadObjetos; z++) {
               

                    for (int i = 0; i < cantidadObjetos; i++) {
                        // System.out.println("=====================================Objeto " + i + "=============================");



                    }//i

               // }//z

            }//k

        }   //j
        return mejorMochila;
    }
//===========================================================================================================================================

    public List<Hormiga> generarHormigas(int cantObj) {
        List<Hormiga> hormigas = new ArrayList<Hormiga>();
        Hormiga obj;
        for (int i = 0; i < cantObj; i++) {
            obj = new Hormiga();
            obj.setNombre("H" + (i + 1));
            double numAleatorio = Math.random();
            obj.setNroAleatorio(numAleatorio);
            hormigas.add(obj);
        }

        return hormigas;
    }

    public List<Colonia> generarColonias(int cantObj) {
        List<Colonia> colonias = new ArrayList<Colonia>();
        Colonia obj;
        for (int i = 0; i < cantObj; i++) {
            obj = new Colonia();
            obj.setNombre("C" + (i + 1));
            colonias.add(obj);
        }
        return colonias;
    }

    public double actualizarFeromona(Hormiga obj) {
        double ferFinal = 0;
        for (int i = 0; i < obj.getCaminoHormiga().size(); i++) {
            double evaporacionFeromona = obj.getFactorEvaporacionFeromona();
            double fer = obj.getCaminoHormiga().get(i).getObjetos().get(i).getFeromonaAcumulada() + obj.getFeromonaInicial();
            ferFinal = fer * evaporacionFeromona;
        }
        return ferFinal;
    }
    ;


//============================================================================================================================================
    public Mochila calcularPorFuerzaBruta(Mochila mochila) {
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
            objeto.setDisponibleFuerzaBruta(true);
            mochilaA.getObjetos().add(objeto);

            for (int paso = 1; paso < (cantidadObjetos / 3); paso++) { //paso=+(cantidadObjetos/3)) {

                for (int j = (i + 1); j < cantidadObjetos;) {
                    objeto = mochila.getObjetos().get(j);
                    if (mochilaA.isVolumenOcupadFBrutaoCorrecto() && !mochilaA.estaEnLaMochila(objeto)) {
                        if ((mochilaA.getVolumenOcupadoUsuario() +
                                mochila.getObjetos().get(j).getVolumen()) <= capacidad) {

                            objeto.setDisponibleUsuario(true);
                            mochilaA.getObjetos().add(objeto);
                        }
                    }
                    j += paso;
                }
                if (mochilaA.getBeneficioObtenidoUsuario() > mejorMochila.getBeneficioObtenidoUsuario()) {
                    mejorMochila = mochilaA.clonarMochila();
                }
                if (!(i == cantidadObjetos - 1)) {
                    mochila.noDisponibleTodosLosObjetosFBruta();
                    mochilaA.vaciarMochila();
                }

            }

        }

        // Borrar lineas siguientes
        //mejorMochila.mostrarObjetosMochilaDisponibles();

        return mejorMochila;

    }

    public Mochila calcularPorFuerzaBrutaBinaria(Mochila mochila) {
        Mochila mochilaNueva = mochila.clonarMochila();
        Mochila mejorMochila = mochila.clonarMochila();

        int cantObjetos = mochila.getCantidadDeObjetos();

        mejorMochila.noDisponibleTodosLosObjetosFBruta();
        mochilaNueva.noDisponibleTodosLosObjetosFBruta();

        //fuerza bruta probando con un solo elemento a la vez
        for (int j = 0; j < cantObjetos; j++) {

            mochilaNueva.getObjetos().get(j).setDisponibleFuerzaBruta(true);
            validarAsignarMejorMchilaFBruta(mochilaNueva, mejorMochila);
            mochilaNueva.getObjetos().get(j).setDisponibleFuerzaBruta(false);

        }

        mochilaNueva.noDisponibleTodosLosObjetosFBruta();
        //fuerza bruta probando con las combinaciones de dos elementos
        for (int i = 0; i < cantObjetos; i++) {
            mochilaNueva.getObjetos().get(i).setDisponibleFuerzaBruta(true);

            for (int j = i + 1; j < cantObjetos; j++) {

                mochilaNueva.getObjetos().get(j).setDisponibleFuerzaBruta(true);

                validarAsignarMejorMchilaFBruta(mochilaNueva, mejorMochila);

                mochilaNueva.getObjetos().get(j).setDisponibleFuerzaBruta(false);

            }

            mochilaNueva.noDisponibleTodosLosObjetosFBruta();

        }


        mochilaNueva.noDisponibleTodosLosObjetosFBruta();
        //fuerza bruta probando con las combinaciones de tres elementos
        for (int k = 0; k < cantObjetos; k++) {
            mochilaNueva.getObjetos().get(k).setDisponibleFuerzaBruta(true);
            for (int i = k + 1; i < cantObjetos; i++) {
                mochilaNueva.getObjetos().get(i).setDisponibleFuerzaBruta(true);

                for (int j = i + 1; j < cantObjetos; j++) {

                    mochilaNueva.getObjetos().get(j).setDisponibleFuerzaBruta(true);

                    validarAsignarMejorMchilaFBruta(mochilaNueva, mejorMochila);

                    mochilaNueva.getObjetos().get(j).setDisponibleFuerzaBruta(false);

                }
                mochilaNueva.getObjetos().get(i).setDisponibleFuerzaBruta(false);
            }
            mochilaNueva.noDisponibleTodosLosObjetosFBruta();
        }


        mochilaNueva.noDisponibleTodosLosObjetosFBruta();
        //fuerza bruta probando con las combinaciones de cuatro elementos

        for (int m = 0; m < cantObjetos; m++) {
            mochilaNueva.getObjetos().get(m).setDisponibleFuerzaBruta(true);

            for (int k = m + 1; k < cantObjetos; k++) {
                mochilaNueva.getObjetos().get(k).setDisponibleFuerzaBruta(true);
                for (int i = k + 1; i < cantObjetos; i++) {
                    mochilaNueva.getObjetos().get(i).setDisponibleFuerzaBruta(true);

                    for (int j = i + 1; j < cantObjetos; j++) {

                        mochilaNueva.getObjetos().get(j).setDisponibleFuerzaBruta(true);

                        validarAsignarMejorMchilaFBruta(mochilaNueva, mejorMochila);

                        mochilaNueva.getObjetos().get(j).setDisponibleFuerzaBruta(false);

                    }
                    mochilaNueva.getObjetos().get(i).setDisponibleFuerzaBruta(false);
                }
                mochilaNueva.getObjetos().get(k).setDisponibleFuerzaBruta(false);
            }
            mochilaNueva.noDisponibleTodosLosObjetosFBruta();
        }


//         for (int i = 0; i < cantObjetos; i++) {
//             if(mejorMochila.getObjetos().get(i).isDisponibleUsuario()){
//                mejorMochila.getObjetos().get(i).setDisponibleUsuario(false);
//                mejorMochila.getObjetos().get(i).setDisponibleFuerzaBruta(true);
//             }
//         }




//         for (int i = 0; i < cantObjetos; i++) {
//
//             for (int k = 0; k <= i; k++) {
//                 mochilaNueva.getObjetos().get(k).setDisponibleUsuario(true);
//
//             }
//             validarAsignarMejorMchila(mochilaNueva, mejorMochila);
//
//             for (int j = i+1; j < cantObjetos; j++) {
//
//                 mochilaNueva.getObjetos().get(j).setDisponibleUsuario(true);
//
//
//
//                 validarAsignarMejorMchila(mochilaNueva, mejorMochila);
//
//                 mochilaNueva.getObjetos().get(j).setDisponibleUsuario(false);
//
//             }
//
//             mochilaNueva.noDisponibleTodosLosObjetosFBruta();
//
//         }


        return mejorMochila;
    }

    private void validarAsignarMejorMchilaFBruta(Mochila mochilaNueva, Mochila mejorMochila) {
        if (mochilaNueva.isVolumenOcupadFBrutaoCorrecto() &&
                mochilaNueva.getBeneficioObtenidoFBruta() > mejorMochila.getBeneficioObtenidoFBruta()) {

            copiarElementosDisponiblesFBruta(mochilaNueva, mejorMochila);
        }

    }

    private void copiarElementosDisponiblesFBruta(Mochila mochilaOrigen, Mochila mochilaDestino) {
        for (int i = 0; i < mochilaOrigen.getCantidadDeObjetos(); i++) {
            if (mochilaOrigen.getObjetos().get(i).isDisponibleFuerzaBruta()) {
                mochilaDestino.getObjetos().get(i).setDisponibleFuerzaBruta(true);
            } else {
                mochilaDestino.getObjetos().get(i).setDisponibleFuerzaBruta(false);
            }
        }
    }

    public double redondear(double valor) {
        return (Math.floor(valor * 100) / 100);
    }

    /**
     * Debuelve la mochila completa, pero con los primeros objetos como disponibles (hasta q cubran la capacidad)
     * @param mochila
     * @return
     */
    @Deprecated
    public Mochila inicializarMochila(Mochila mochila) {
        double ocupado = mochila.getVolumenOcupadoUsuario(); //calcularVolumen(mochila);
        for (Objeto objeto : mochila.getObjetos()) {
            if ((ocupado) + objeto.getVolumen() <= mochila.getCapacidad()) {
                objeto.setDisponibleUsuario(true);
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
    @Deprecated
    public List<Objeto> inicializarSubMochila(Mochila mochila) {
        List<Objeto> objetos = new ArrayList<Objeto>();
        double ocupado = mochila.getVolumenOcupadoUsuario();//calcularVolumen(mochila);
        for (Objeto objeto : mochila.getObjetos()) {
            if ((ocupado) + objeto.getVolumen() <= mochila.getCapacidad()) {
                objeto.setDisponibleUsuario(true);
                objetos.add(objeto);
                ocupado += objeto.getVolumen();
            }
        }

        return objetos;
    }
}

