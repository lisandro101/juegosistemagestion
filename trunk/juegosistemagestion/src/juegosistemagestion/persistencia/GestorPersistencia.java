/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegosistemagestion.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import juegosistemagestion.entidades.Mochila;
import juegosistemagestion.entidades.Objeto;

/**
 *
 * @author lisandro101
 */
public class GestorPersistencia {

    private static GestorPersistencia instancia;
    private BufferedWriter out;
    private BufferedReader in;

    private GestorPersistencia() {
    }

    public synchronized static GestorPersistencia getInstancia() {
        if (instancia == null) {
            instancia = new GestorPersistencia();
        }
        return instancia;
    }

    private void abrirArchivoEscritura(String nombre) {
        try {

            out = new BufferedWriter(new FileWriter(nombre));

        } catch (Exception e) {

            System.err.println("Error: " + e.getMessage());

        }
    }

    private void abrirArchivoLectura(String nombre) {
        try {

            in = new BufferedReader(new FileReader(nombre));

        } catch (Exception e) {

            System.err.println("Error: " + e.getMessage());

        }
    }

    private void cerrarArchivoEscritura() {
        try {

            out.close();

        } catch (Exception e) {

            System.err.println("Error: " + e.getMessage());

        }
    }

    private void cerrarArchivoLectura() {
        try {

            in.close();

        } catch (Exception e) {

            System.err.println("Error: " + e.getMessage());

        }
    }

    private void escribirArchivo(String datos) {
        try {

            out.write(datos);

        } catch (Exception e) {

            System.err.println("Error: " + e.getMessage());

        }
    }

    private String leerArchivo() {

        String salida = null;

        try {

            salida = in.readLine();

        } catch (Exception e) {

            System.err.println("Error: " + e.getMessage());

        }

        return salida;
    }

    private boolean noEsFinArchivo() {

        boolean salida = false;

        try {

            salida = in.ready();

        } catch (Exception e) {

            System.err.println("Error: " + e.getMessage());

        }

        return salida;
    }

    public void guardarMochila(double capacidad, List<Objeto> objetos) {

        abrirArchivoEscritura("out.txt"); //TODO: deshardcodear
        escribirArchivo("" + capacidad + "\n");

        for (Objeto objecto : objetos) {
            escribirArchivo("" + objecto.getBeneficio() + "," +
                    objecto.getVolumen() + "\n");
        }

        cerrarArchivoEscritura();

    }

    public Mochila cargarMochila() {

        Mochila mochila = new Mochila();
        List<Objeto> objetos = new ArrayList<Objeto>();
        Objeto objeto = new Objeto();
        String linea;
        String beneficio;
        String volumen;
        int cantidad = 0;

        abrirArchivoLectura("out.txt"); //TODO: deshardcodear
        String capacidad = leerArchivo();
        System.out.println(capacidad);
        mochila.setCapacidad(Double.parseDouble(capacidad));

        while (noEsFinArchivo()) {

            cantidad++;

            linea = leerArchivo();

            beneficio = linea.substring(0, linea.lastIndexOf(","));
            volumen = linea.substring(linea.lastIndexOf(",") + 1, linea.length());

            System.out.println(beneficio);
            System.out.println(volumen);

            objeto.setBeneficio(Double.parseDouble(beneficio));
            objeto.setVolumen(Double.parseDouble(volumen));
            objeto.setNombre(""+cantidad);
            objeto.setDisponible(false);

            objetos.add(objeto);
        }

        mochila.setObjetos(objetos);

        cerrarArchivoLectura();

        return mochila;
    }
}
