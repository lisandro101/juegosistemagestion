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
        objetos.get(i).setProbabilidad(probabilidad);
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
        List<Colonia> colonias = generarColonias(10);
        List<Hormiga> hormigas = generarHormigas(10);

        Mochila mejorMochila = mochila.clonarMochila();
        Mochila mochila2 = mochila.clonarMochila();
        Mochila mejorMochilaPorColonia = mochila.clonarMochila();
        Mochila mejorMochilaPorHormiga = mochila.clonarMochila();
        //List<Objeto> objetosMejorMochilaPorHormiga = new ArrayList<Objeto>();
        //mejorMochilaPorHormiga.setObjetos(objetosMejorMochilaPorHormiga);
        mejorMochila = mochila.clonarMochila();

        int cantidadColonias = colonias.size();
        int cantidadHormigas = colonias.get(0).getCantidadHormigas();
        int cantidadObjetos = mochila.getObjetos().size();
        double capacidad = mochila.getCapacidad();
        double probabilidadAcumulada = 0;
        double probabilidad = 0;
        double beneficio = 0;
        double volumen = 0;
       // System.out.println("capacidad "+ mochila.getCapacidad());

        for (Colonia colonia : colonias) {
            colonia.setListaHormigas(hormigas);
        }


        for (int j = 0; j < cantidadColonias; j++) {
            //System.out.println("================================Colonia " + colonias.get(j).getNombre() +"=============================");


            for (int k = 0; k < cantidadHormigas; k++) {
                //System.out.println("=====================================Hormiga " + hormigas.get(k).getNombre() + "=============================");

                double nroAleatorio = Math.random();
                colonias.get(j).getListaHormigas().get(k).setNroAleatorio(nroAleatorio);
                //mejorMochilaPorHormiga.vaciarMochila();
                mochila.noDisponibleTodosLosObjetosCHormiga();
                mochila2 = mochila.clonarMochila();
                mochila2.noDisponibleTodosLosObjetosCHormiga();

                double capMochi =0;

                for(int w = 0;capMochi <= mochila.getCapacidad() && w < mochila.getObjetos().size();w++) {

                    for (int i = 0; i < mochila2.getObjetos().size(); i++) {
                        //System.out.println("=====================================Objeto " + mochila2.getObjetos().get(i).getNombre() + "=============================");
                        probabilidad = calcularProbabilidad(mochila2.getObjetos(), i);
                        probabilidadAcumulada = probabilidadAcumulada + probabilidad;
                        mochila2.getObjetos().get(i).setProbabilidad(probabilidad);
                        mochila2.getObjetos().get(i).setProbabilidadAcumulada(probabilidadAcumulada);
                        mochila2.getObjetos().get(i).setNumAleatorioMin(probabilidadAcumulada - probabilidad);
                        mochila2.getObjetos().get(i).setNumAleatorioMax(probabilidadAcumulada);
                    
                         

                        //si el nro aleatorio coincide con el rango de probabilidad del objeto
                        if ((mochila2.getObjetos().get(i).getNumAleatorioMin() <= nroAleatorio && mochila2.getObjetos().get(i).getNumAleatorioMax() > nroAleatorio)) {
                            //System.out.println("Elegido!!!");
                            mochila2.getObjetos().remove(i);
                            mochila.getObjetos().get(i).setDisponibleHormiga(true);
                            capMochi = capMochi + mochila.getObjetos().get(i).getVolumen();
                            beneficio =+ mochila.getObjetos().get(i).getBeneficio();
                            volumen =+ mochila.getObjetos().get(i).getVolumen();


                        //Actualizar el rastro de feromona para los objetos seleccionados
                        }
                     

                    }//i
                    volumen = 0;
                    beneficio = 0;
                    probabilidad = 0;
                    probabilidadAcumulada = 0;

                }//while
                capMochi=0;
               // System.out.println("mochila: "+ mochila.getObjetos().size());
               // System.out.println("mochila2: "+ mochila2.getObjetos().size());
                
                //valida la mejor mochila de la hormiga
                
                validarAsignarMejorMchilaCHormiga(mochila, mejorMochilaPorHormiga);
                colonias.get(j).getListaHormigas().get(k).setMejorMochilaHormiga(mejorMochilaPorHormiga);

            }//k


            for (Hormiga hormiga : colonias.get(j).getListaHormigas()) {
                validarAsignarMejorMchilaCHormiga(hormiga.getMejorMochilaHormiga(), mejorMochilaPorColonia);
                colonias.get(j).setMejorMochilaPorColonia(mejorMochilaPorColonia);
            }


        }   //j

        for (Colonia colonia : colonias) {
            Mochila mejor = colonia.getMejorMochilaPorColonia();
            validarAsignarMejorMchilaCHormiga(mejor, mejorMochila);

        }
        return mejorMochila;
    }

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

//         //fuerza bruta probando con un solo elemento a la vez
//         for (int j = 0; j < cantObjetos; j++) {
//
//             mochilaNueva.getObjetos().get(j).setDisponibleFuerzaBruta(true);
//             validarAsignarMejorMchilaFBruta(mochilaNueva, mejorMochila);
//             mochilaNueva.getObjetos().get(j).setDisponibleFuerzaBruta(false);
//
//         }
//
//         mochilaNueva.noDisponibleTodosLosObjetosFBruta();
//         //fuerza bruta probando con las combinaciones de dos elementos
//         for (int i = 0; i < cantObjetos; i++) {
//             mochilaNueva.getObjetos().get(i).setDisponibleFuerzaBruta(true);
//
//             for (int j = i + 1; j < cantObjetos; j++) {
//
//                 mochilaNueva.getObjetos().get(j).setDisponibleFuerzaBruta(true);
//
//                 validarAsignarMejorMchilaFBruta(mochilaNueva, mejorMochila);
//
//                 mochilaNueva.getObjetos().get(j).setDisponibleFuerzaBruta(false);
//
//             }
//
//             mochilaNueva.noDisponibleTodosLosObjetosFBruta();
//
//         }
//
//
//         mochilaNueva.noDisponibleTodosLosObjetosFBruta();
//         //fuerza bruta probando con las combinaciones de tres elementos
//         for (int k = 0; k < cantObjetos; k++) {
//             mochilaNueva.getObjetos().get(k).setDisponibleFuerzaBruta(true);
//             for (int i = k+1; i < cantObjetos; i++) {
//                 mochilaNueva.getObjetos().get(i).setDisponibleFuerzaBruta(true);
//
//                 for (int j = i+1; j < cantObjetos; j++) {
//
//                     mochilaNueva.getObjetos().get(j).setDisponibleFuerzaBruta(true);
//
//                     validarAsignarMejorMchilaFBruta(mochilaNueva, mejorMochila);
//
//                     mochilaNueva.getObjetos().get(j).setDisponibleFuerzaBruta(false);
//
//                 }
//                 mochilaNueva.getObjetos().get(i).setDisponibleFuerzaBruta(false);
//             }
//             mochilaNueva.noDisponibleTodosLosObjetosFBruta();
//         }
//
//
//         mochilaNueva.noDisponibleTodosLosObjetosFBruta();
//         //fuerza bruta probando con las combinaciones de cuatro elementos
//
//         for (int m = 0; m < cantObjetos; m++) {
//             mochilaNueva.getObjetos().get(m).setDisponibleFuerzaBruta(true);
//
//             for (int k = m + 1; k < cantObjetos; k++) {
//                 mochilaNueva.getObjetos().get(k).setDisponibleFuerzaBruta(true);
//                 for (int i = k + 1; i < cantObjetos; i++) {
//                     mochilaNueva.getObjetos().get(i).setDisponibleFuerzaBruta(true);
//
//                     for (int j = i + 1; j < cantObjetos; j++) {
//
//                         mochilaNueva.getObjetos().get(j).setDisponibleFuerzaBruta(true);
//
//                         validarAsignarMejorMchilaFBruta(mochilaNueva, mejorMochila);
//
//                         mochilaNueva.getObjetos().get(j).setDisponibleFuerzaBruta(false);
//
//                     }
//                     mochilaNueva.getObjetos().get(i).setDisponibleFuerzaBruta(false);
//                 }
//                 mochilaNueva.getObjetos().get(k).setDisponibleFuerzaBruta(false);
//             }
//             mochilaNueva.noDisponibleTodosLosObjetosFBruta();
//         }



        //Test

        int ultimoElem;
        mochilaNueva.noDisponibleTodosLosObjetosFBruta();

        for (int cantElem = 1; cantElem < cantObjetos; cantElem++) {

            for (int primerElem = 0; primerElem < cantObjetos; primerElem++) {

                //mochilaNueva.getObjetos().get(primerElem).setDisponibleFuerzaBruta(true);

                //for (int indice = primerElem; indice < (cantElem+primerElem); indice++) {
                //mochilaNueva.getObjetos().get(i).setDisponibleFuerzaBruta(true);


                if ((cantElem + primerElem) <= cantObjetos) {
                    mochilaNueva.getObjetos().get(primerElem).setDisponibleFuerzaBruta(true);


                    if (cantElem == 2) {
                        ultimoElem = (primerElem + cantElem - 1);
                        mochilaNueva.getObjetos().get(ultimoElem).setDisponibleFuerzaBruta(true);
                        validarAsignarMejorMchilaFBruta(mochilaNueva, mejorMochila);
                        mochilaNueva.getObjetos().get(ultimoElem).setDisponibleFuerzaBruta(false);

                    }

                    if (cantElem > 2) {
//                        for (int indice = (primerElem + 1); indice < cantObjetos; indice++) {
                        ultimoElem = (primerElem + cantElem - 1);

                        if (ultimoElem < cantObjetos) {


                            for (int i = (primerElem + 1); i < (cantElem - 1); i++) {
                                mochilaNueva.getObjetos().get(i).setDisponibleFuerzaBruta(true);

                            }
                            for (int variador = ultimoElem; variador < cantObjetos; variador++) {
                                mochilaNueva.getObjetos().get(variador).setDisponibleFuerzaBruta(true);
                                validarAsignarMejorMchilaFBruta(mochilaNueva, mejorMochila);
                                mochilaNueva.getObjetos().get(variador).setDisponibleFuerzaBruta(false);

                            }


                            for (int i = (primerElem + 1); i < (cantElem - 1); i++) {
                                mochilaNueva.getObjetos().get(i).setDisponibleFuerzaBruta(false);

                            }
                        }
                    //}



                    }

                }

                validarAsignarMejorMchilaFBruta(mochilaNueva, mejorMochila);
                mochilaNueva.noDisponibleTodosLosObjetosFBruta();

            }

        }

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

    private void validarAsignarMejorMchilaCHormiga(Mochila mochilaNueva, Mochila mejorMochila) {
        if (mochilaNueva.isVolumenOcupadoCHormigaCorrecto() &&
                mochilaNueva.getBeneficioObtenidoCHormiga() > mejorMochila.getBeneficioObtenidoCHormiga()) {

            copiarElementosDisponiblesCHormiga(mochilaNueva, mejorMochila);
        }

    }

    private void copiarElementosDisponiblesCHormiga(Mochila mochilaOrigen, Mochila mochilaDestino) {
        for (int i = 0; i < mochilaOrigen.getCantidadDeObjetos(); i++) {
            if (mochilaOrigen.getObjetos().get(i).isDisponibleHormiga()) {
                mochilaDestino.getObjetos().get(i).setDisponibleHormiga(true);
            } else {
                mochilaDestino.getObjetos().get(i).setDisponibleHormiga(false);
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

