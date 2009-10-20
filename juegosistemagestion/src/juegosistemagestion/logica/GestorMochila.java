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
            valor.setDisponible(false);
            valor.setFeromonaAcumulada(0.1);

            objetos.add(valor);
        }
        return objetos;
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------

    public void calcularPorHormiga(Mochila mochila) {

       // System.out.println("=============================================================================================");
       // System.out.println("======================================Metodo calcular Por Hormiga============================");
       // System.out.println("=============================================================================================");

        //System.out.println("mochila = " + mochila.getObjetos().size());

        mochila.noDisponibleTodosLosObjetos();
        List<Colonia> colonias = generarColonias(5);
        List<Hormiga> hormigas = generarHormigas(5);
        for (Colonia colonia : colonias) {
            colonia.setListaHormigas(hormigas);
        }

        //System.out.println("Colonias");



        for (int j = 0; j < colonias.size(); j++) {
            //System.out.println("=====================================Colonia " + j + "=============================");



            for (int k = 0; k < colonias.get(j).getListaHormigas().size(); k++) {
               // System.out.println("=====================================Hormiga " + k + "=============================");


                //System.out.println("mochila2 = "+mochila2.getObjetos().size());
                double probAcumulada = 0;

                Mochila mochila2 = new Mochila();//clon de la mochila
                mochila2.setObjetos(mochila.getObjetos());
                mochila2.noDisponibleTodosLosObjetos();
                double capacidad = mochila.getCapacidad();
                mochila2.setCapacidad(capacidad);

                List<Mochila> objHorm = new ArrayList<Mochila>();

                List<Objeto> objetos = new ArrayList<Objeto>();
                Mochila mochilaPorHormiga = new Mochila();
                mochilaPorHormiga.setObjetos(objetos);
                mochilaPorHormiga.setCapacidad(mochila.getCapacidad());

                for (int z = 0; z < mochila.getObjetos().size(); z++) {


                    if (((mochila2.getVolumenOcupado() <= capacidad))) {

                        double numAleatorio = Math.random();
                        colonias.get(j).getListaHormigas().get(k).setNroAleatorio(numAleatorio);



                        for (int i = 0; i < mochila2.getObjetos().size(); i++) {
                           // System.out.println("=====================================Objeto " + i + "=============================");
                            double prob = 0;

                            prob = calcularProbabilidad(mochila2.getObjetos(), i);
                            probAcumulada = probAcumulada + prob;
                            mochila2.getObjetos().get(i).setProbabilidad(prob);
                            mochila2.getObjetos().get(i).setProbabilidadAcumulada(probAcumulada);
                            mochila2.getObjetos().get(i).setNumAleatorioMin((mochila2.getObjetos().get(i).getProbabilidadAcumulada()) - (mochila2.getObjetos().get(i).getProbabilidad()));
                            mochila2.getObjetos().get(i).setNumAleatorioMax(mochila2.getObjetos().get(i).getProbabilidadAcumulada());



                            double numAlminObj = mochila2.getObjetos().get(i).getNumAleatorioMin();
                            double numAlmaxObj = mochila2.getObjetos().get(i).getNumAleatorioMax();
                            double numAlHormiga = (colonias.get(j).getListaHormigas().get(k).getNroAleatorio());
                            //System.out.println("   numAlmin  " + numAlminObj + "   numAlmax  " + numAlmaxObj);

                            if ((numAlminObj <= numAlHormiga && numAlmaxObj > numAlHormiga)) {

                                double feromonaAcum = colonias.get(j).getListaHormigas().get(k).getFeromonaInicial() + mochila.getObjetos().get(i).getFeromonaAcumulada();
                                mochila2.getObjetos().get(i).setFeromonaAcumulada(feromonaAcum);
                                mochila2.getObjetos().get(i).setDisponible(true);

                                //System.out.println("valida if de probabilidad");

                                if ((mochilaPorHormiga.getVolumenOcupado() + mochila2.getObjetos().get(i).getVolumen()) <= capacidad) {
                                    mochila2.getObjetos().get(i).setDisponible(true);
                                    Objeto obj = new Objeto();
                                    obj = mochila2.getObjetos().get(i);
                                    mochilaPorHormiga.getObjetos().add(obj);
                                    mochila2.getObjetos().remove(i);
                                   // System.out.println("El objeto " + i + " esta asignado");



                                } else {
                                    //System.out.println("Se lleno la mochila");

                                }
                            }
                        }//i

                    }//if
                    probAcumulada = 0;
                }//z
               

                objHorm.add(mochilaPorHormiga);

                colonias.get(j).getListaHormigas().get(k).setCaminoHormiga(objHorm);

                colonias.get(j).getListaHormigas().get(k).getCaminoHormiga().add(mochilaPorHormiga);
               

            }//k


        }   //j



        }//method


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

    public double actualizarFeromona(Hormiga obj){
        double ferFinal =0;
        for(int i=0;i<obj.getCaminoHormiga().size();i++){
        double evaporacionFeromona=obj.getFactorEvaporacionFeromona();
        double fer=obj.getCaminoHormiga().get(i).getObjetos().get(i).getFeromonaAcumulada() + obj.getFeromonaInicial();
        ferFinal = fer * evaporacionFeromona;
        }
        return ferFinal;
    };


//============================================================================================================================================
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

            for (int paso = 1; paso < (cantidadObjetos / 3); paso++) { //paso=+(cantidadObjetos/3)) {

                for (int j = (i + 1); j < cantidadObjetos;) {
                    objeto = mochila.getObjetos().get(j);
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

