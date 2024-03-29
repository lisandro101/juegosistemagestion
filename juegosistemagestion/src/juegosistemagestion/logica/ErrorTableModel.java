/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package juegosistemagestion.logica;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import juegosistemagestion.entidades.Error;

/**
 *
 * @author stafoxter
 */

public class ErrorTableModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private static final String[] NOMBRE_COLUMNAS = {"Error Absoluto", "Error Relativo", "Error Relativo Menor",
        "Error Relativo Mayor", "Error Relativo Promedio", "   S  ", "Intervalo de Confianza"};
    private static final boolean[] COLUMNAS_EDITABLES = {false, false, false, false , false, false, false};
    private static final Class[] CLASE_COLUMNAS =
        {double.class, double.class, double.class, double.class, double.class, double.class, double.class};
    
    private List<Error> errores;

    /**
     * Constructor
     * 
     * @param filas Cantidad de filas iniciales
     */
    public ErrorTableModel(int filas) {
        this.errores = new ArrayList<Error>(filas > 0 ? filas : 0);
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
        return errores.size();
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
                resultado = errores.get(fila).getErrorAbsoluto();
                break;
            case 1:
                resultado = errores.get(fila).getErrorRelativo();
                break;
            case 2:
                resultado = errores.get(fila).getErrorRelativoMenor();
                break;
            case 3:
                resultado = errores.get(fila).getErrorRelativoMayor();
                break;
            case 4:
                resultado = errores.get(fila).getErrorRelativoPromedio();
                break;
            case 5:
                resultado = errores.get(fila).getS();
                break;
            case 6:
                resultado = errores.get(fila).getIntervaloDeConfianza();
                break;
        }
        return resultado;
    }
    
    /**
     * Agrega Proveedor al modelo
     * 
     * @param proveedor Proveedor a agregar

     */
    public void agregarFila(Error proveedor) {
        errores.add(proveedor);
        
        fireTableRowsInserted(errores.size(), errores.size());
    }
    
    
    public void agregarFilas(List<Error> objetos) {
        if(objetos != null){
            objetos.addAll(objetos);
            fireTableRowsInserted(objetos.size()-objetos.size(), objetos.size());
        }
    }
    
    /**
     * Limita la cantidad de elementos del modelo al indicado
     * 
     * @param cantidad Cantidad a la que se quiere limitar el numero de filas
     */
    public void limitarCantidad(int cantidad) {
        int cantidadAnterior = errores.size();
        
        errores = errores.subList(0, cantidad);
        
        fireTableRowsDeleted(cantidad, cantidadAnterior);
    }
    
    /**
     * Devuelve todas las filas del modelo
     * 
     * @return Todas las filas del modelo
     */
    public List<Error> getFilas() {
        return errores;
    }
    
    public Error getFila(int indice){
        return errores.get(indice);
        
    }
    
    public void eliminarFila(int indice){        
        errores.remove(indice);
        fireTableRowsDeleted(indice, indice);       
    }
    
    public void limpiarTableModel(){
        int tamanio = errores.size();
        errores.clear();
        
        fireTableRowsDeleted(0, tamanio);
    }

}