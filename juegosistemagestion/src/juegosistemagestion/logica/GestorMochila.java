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
//--------------------------------------------------------------------------------------------------------------------------------------------------

    public void calcularPorHormiga(Mochila mochila) {
        //int cantidadObjetos = mochila.getObjetos().size();
        System.out.println("=============================================================================================");
        System.out.println("======================================Metodo calcular Por Hormiga============================");
        System.out.println("=============================================================================================");
        List<Colonia> colonias = generarColonias(5);
        System.out.println("Colonias");
        //Objeto objeto;
        //Mejor Mochila


        //--------------------mochila armada del paso de las hormigas------------------------
        List<Objeto> objetosCaminoHormiga = new ArrayList<Objeto>();
        Mochila mochilaCaminoHormiga = new Mochila();

        


        for (int j = 0; j < colonias.size(); j++) {
            System.out.println("=====================================Colonia " + j + "=============================");

            for (int k = 0; k < colonias.get(j).getListaHormigas().size(); k++) {
                System.out.println("=====================================Hormiga " + k + "=============================");
                //colonias.get(j).getListaHormigas().get(k).setNroAleatorio(generarNroAleatorio(0.0, 1.0));
                Mochila mochilaTempClon = new Mochila();// para sacar objetos seleccionados por el número aleatorio
                mochilaTempClon.setObjetos(mochila.getObjetos());
                double capacidad = mochila.getCapacidad();
                mochilaTempClon.setCapacidad(capacidad);
                mochilaCaminoHormiga.setCapacidad(capacidad);
                mochilaCaminoHormiga.setObjetos(objetosCaminoHormiga);

                for (int i = 0; i < mochilaTempClon.getObjetos().size(); i++) {
                    System.out.println("=====================================Objeto " + i + "=============================");

                    for (Objeto obj : mochilaTempClon.getObjetos()) {

                        double cantObj = mochilaTempClon.getObjetos().size();
                        obj.setProbabilidad(1 / cantObj);
                        double probabilidadAcum =+ 1 / mochilaTempClon.getObjetos().size();
                        obj.setProbabilidadAcumulada(probabilidadAcum);


                    }


                    //System.out.println("Hay " + vuelta);
                    double numAleatorio = Math.random();
                    //System.out.println("El número Aleatorio es " + numAleatorio);
                    System.out.println("La probabilidad Acumulada es " + mochilaTempClon.getObjetos().get(i).getProbabilidadAcumulada());
                    //System.out.println("Antes del IF" + j + " " + k + " " + i);

                    if ((numAleatorio) < (mochilaTempClon.getObjetos().get(i).getProbabilidadAcumulada()) && ((mochilaTempClon.getObjetos().get(i).getProbabilidadAcumulada()) - mochilaTempClon.getObjetos().get(i).getProbabilidad()) >= (numAleatorio)) {

                        double feromonaAcum = colonias.get(j).getListaHormigas().get(k).getFeromonaInicial() + mochila.getObjetos().get(i).getFeromonaAcumulada();
                        mochilaTempClon.getObjetos().get(i).setFeromonaAcumulada(feromonaAcum);
                       
                        System.out.println("valida if de probabilidad");

                        if (mochilaCaminoHormiga.isVolumenOcupadoCorrecto()) {
                            mochilaCaminoHormiga.getObjetos().add(mochilaTempClon.getObjetos().get(i));
                            mochilaCaminoHormiga.getObjetos().get(i).setDisponible(true);
                            mochilaTempClon.getObjetos().remove(i);
                            System.out.println("LLEGA con  " + mochilaCaminoHormiga.getBeneficioObtenido() + "  de beneficio obtenido");
                        }else { }

                    }

                }

            }


        }



    }
//===========================================================================================================================================

    public List<Hormiga> generarHormigas(int cantObj) {
        List<Hormiga> hormigas = new ArrayList<Hormiga>();
        Hormiga obj;
        for (int i = 0; i < cantObj; i++) {
            obj = new Hormiga();
            obj.setNombre("H" + (i + 1));
            hormigas.add(obj);
        }

        return hormigas;
    }

    public List<Colonia> generarColonias(int cantObj) {
        List<Colonia> colonias = new ArrayList<Colonia>();

        Colonia obj;
        for (int i = 0; i < cantObj; i++) {
            List<Hormiga> hormigas = generarHormigas(cantObj);
            obj = new Colonia();
            obj.setNombre("C" + (i + 1));
            obj.setListaHormigas(hormigas);
            obj.setCantidadHormigas(hormigas.size());

            colonias.add(obj);
        }
        return colonias;
    }

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

