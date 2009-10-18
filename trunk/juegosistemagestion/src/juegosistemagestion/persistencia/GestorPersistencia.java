/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegosistemagestion.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    private static String file;
    private static String separador;

    private GestorPersistencia() {
    }

    public synchronized static GestorPersistencia getInstancia() {
        if (instancia == null) {
            instancia = new GestorPersistencia();
            file = Parametros.getInstancia().getParametro("file");
            separador = Parametros.getInstancia().getParametro("separador");
        }
        return instancia;
    }

    private void abrirArchivoEscritura(String nombre) {

        try {
            out = new BufferedWriter(new FileWriter(nombre));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


    }

    private void abrirArchivoLectura(String nombre) {

        try {
            in = new BufferedReader(new FileReader(nombre));
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void cerrarArchivoEscritura() {

        try {
            out.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void cerrarArchivoLectura() {

        try {
            in.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void escribirArchivo(String datos) {

        try {
            out.write(datos);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private String leerArchivo() {

        String salida = null;

        try {

            salida = in.readLine();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return salida;

    }

    private boolean noEsFinArchivo() {

        boolean salida = false;

        try {

            salida = in.ready();

        } catch (IOException e) {

            System.err.println("Error: " + e.getMessage());

        }

        return salida;
    }

    public void guardarMochila(double capacidad, List<Objeto> objetos) {

        abrirArchivoEscritura(file); //TODO: deshardcodear
        escribirArchivo("" + capacidad + "\n");

        for (Objeto objecto : objetos) {
            escribirArchivo("" + objecto.getBeneficio() + separador +
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

        abrirArchivoLectura(file);

        String capacidad = leerArchivo();
        System.out.println("Capacidad (String): " + capacidad); //TODO: Eliminar
        mochila.setCapacidad(Double.parseDouble(capacidad));
        System.out.println("Capacidad (Double): " +  Double.parseDouble(capacidad)); //TODO: Eliminar

        while (noEsFinArchivo()) {

            cantidad++;

            linea = leerArchivo();

            beneficio = linea.substring(0, linea.lastIndexOf(separador));
            System.out.println("Beneficio (String): " +  + Double.parseDouble(beneficio)); //TODO: Eliminar
            System.out.println("Beneficio (Double): " +  Double.parseDouble(beneficio)); //TODO: Eliminar
            volumen = linea.substring(linea.lastIndexOf(separador) + 1, linea.length());
            System.out.println("Volumen (String): " +  + Double.parseDouble(volumen)); //TODO: Eliminar
            System.out.println("Volumen (Double): " +  Double.parseDouble(volumen)); //TODO: Eliminar

            objeto.setBeneficio(Double.parseDouble(beneficio));
            objeto.setVolumen(Double.parseDouble(volumen));
            objeto.setNombre("" + cantidad);
            objeto.setDisponible(false);

            objetos.add(objeto);
        }

        mochila.setObjetos(objetos);

        cerrarArchivoLectura();

        return mochila;

    }
}
