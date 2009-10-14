/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package juegosistemagestion.logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
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

    public void prueba(double min, double max){
        for (int i = 0; i < 10; i++) {
            System.out.println("numero :"+ generarNroAleatorio(min, max));
        }
    }

    private double generarNroAleatorio(double min, double max){
        double uno;

//        Random r;
//        r=new Random();
//        r.setSeed(new Date().getTime());
//        r.nextDouble();

        uno=((max - min + 1) * Math.random() + min);
        return uno;

    }

    public List<Objeto> armarObjetos(double beneMin, double beneMax, double volMin, double volMax, int cantObj){
        List<Objeto> objetos = new ArrayList<Objeto>(cantObj);

        for (Objeto objeto : objetos) {
            
        }

        return objetos;
    }
}

