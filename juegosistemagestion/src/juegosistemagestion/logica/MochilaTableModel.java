/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package juegosistemagestion.logica;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import juegosistemagestion.entidades.Objeto;

/**
 *
 * @author stafoxter
 */

public class MochilaTableModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private static final String[] NOMBRE_COLUMNAS = {"Objeto", "Beneficio", "Volumen","F.Bruta", "C.Hormiga","Usuario"};
    private static final boolean[] COLUMNAS_EDITABLES = {false, false, false, false, false, true};
    private static final Class[] CLASE_COLUMNAS =
        {String.class, double.class, double.class, String.class, String.class, Boolean.class};
    
    private List<Objeto> objetos;

    /**
     * Constructor
     * 
     * @param filas Cantidad de filas iniciales
     */
    public MochilaTableModel(int filas) {
        this.objetos = new ArrayList<Objeto>(filas > 0 ? filas : 0);
    }

    /**
     * Devuelve el nombre de la columna
     * 
     * @param columna Indice de la columna
     * @return El nombre de la columna
     */
    @Override
    public String getColumnName(int columna) {
        return NOMBRE_COLUMNAS[columna];
    }
    
    /**
     * Devuelve la clase de la columna indicada
     * 
     * @param columna Indice de la columna de la que se quiere averiguar la clase
     * @return La clase de la columna indicada
     */
    @Override
    public Class<?> getColumnClass(int columna) {
        return CLASE_COLUMNAS[columna];
    }

    /**
     * Devuelve si la celda es o no editable
     * 
     * @param fila Indice de la fila
     * @param columna Indice de la columna
     * @return True si la celda es editable
     */
    @Override
    public boolean isCellEditable(int fila, int columna) {
        return COLUMNAS_EDITABLES[columna];
    }
    
    /**
     * Devuelve la cantidad de filas
     * 
     * @return La cantidad de filas
     */
    @Override
    public int getRowCount() {
        return objetos.size();
    }

    /**
     * Devuelve la cantidad de columnas
     * 
     * @return La cantidad de columnas
     */
    @Override
    public int getColumnCount() {
        return NOMBRE_COLUMNAS.length;
    }

    /**
     * Devuelve el valor de la celda indicada
     * 
     * @param fila Indice de la fila
     * @param columna Indice de la columna
     * @return Devuelve el valor de la celda indicada
     */
    @Override
    public Object getValueAt(int fila, int columna) {
        Object resultado = null;
        
        switch(columna) {
            case 0:
                resultado = objetos.get(fila).getNombre();
                break;
            case 1:
                resultado = objetos.get(fila).getBeneficio();
                break;
            case 2:
                resultado = objetos.get(fila).getVolumen();
                break;
            case 3:

                if(objetos.get(fila).isDisponibleFuerzaBruta()){
                    resultado = "Si";
                }else{
                    resultado = "No";
                }
                //resultado = objetos.get(fila).isDisponibleFuerzaBruta();
                break;
            case 4:

                if(objetos.get(fila).isDisponibleHormiga()){
                    resultado = "Si";
                }else{
                    resultado = "No";
                }
                //resultado = objetos.get(fila).isDisponibleHormiga();
                break;
            case 5:
                resultado = objetos.get(fila).isDisponibleUsuario();
                break;
        }
        return resultado;
    }

    @Override
    public void setValueAt(Object valor, int fila, int columna) {

        if(columna == 5) {
            objetos.get(fila).setDisponibleUsuario((Boolean)valor);
        }
    }

    

    /**
     * Agrega Proveedor al modelo
     * 
     * @param objeto

     */
    public void agregarFila(Objeto objeto) {
        objetos.add(objeto);
        
        fireTableRowsInserted(objetos.size(), objetos.size());
    }
    
    
    public void agregarFilas(List<Objeto> obj) {
        if(obj != null){
            objetos.addAll(obj);
            fireTableRowsInserted(objetos.size()-obj.size(), objetos.size());
        }
    }
    
    /**
     * Limita la cantidad de elementos del modelo al indicado
     * 
     * @param cantidad Cantidad a la que se quiere limitar el numero de filas
     */
    public void limitarCantidad(int cantidad) {
        int cantidadAnterior = objetos.size();
        
        objetos = objetos.subList(0, cantidad);
        
        fireTableRowsDeleted(cantidad, cantidadAnterior);
    }
    
    /**
     * Devuelve todas las filas del modelo
     * 
     * @return Todas las filas del modelo
     */
    public List<Objeto> getFilas() {
        return objetos;
    }
    
    public Objeto getFila(int indice){
        return objetos.get(indice);
        
    }
    
    public void eliminarFila(int indice){        
        objetos.remove(indice);
        fireTableRowsDeleted(indice, indice);       
    }
    
    public void limpiarTableModel(){
        int tamanio = objetos.size();
        objetos.clear();
        
        fireTableRowsDeleted(0, tamanio);
    }
    
}