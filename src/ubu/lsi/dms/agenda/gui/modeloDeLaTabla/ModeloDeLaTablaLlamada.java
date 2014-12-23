package ubu.lsi.dms.agenda.gui.modeloDeLaTabla;

import java.util.ArrayList;
import ubu.lsi.dms.agenda.modelo.Llamada;

/**
 * Modelo de datos que contiene los datos que se mostrarán en la tabla de los formularios de Consulta de Llamadas.
 * 
 * @author Álvaro Ruiz Molledo
 * @author Javier de la Fuente Barrios
 * @author Jorge Alonso Márquez
 *
 */
@SuppressWarnings({ "serial", "unchecked" })
public class ModeloDeLaTablaLlamada extends ModeloDeLaTabla {
	
	/**
	 * Lista con todas las llamadas que se deben mostrar.
	 */
	ArrayList<Llamada> llamadas;
	
	
	/**
	 * Constructor de la clase.
	 * 
	 * @param columnNames	Array con los nombres de las distintas columnas.
	 * @param contactos		Lista con todos los contactos que se deben mostrar.
	 */
	public ModeloDeLaTablaLlamada(String[] columnNames, ArrayList<Llamada> llamadas) {
		super(columnNames);
		this.llamadas = llamadas;
	}
	
    
    /**
     * Devuelve el valor que irá en la fila y la columna indicadas.
     * 
     * @param row Fila indicada.
     * @param col Columna indicada.
     */
	@Override
	public Object getValueAt(int row, int col) {
		switch(col){
		case 0:
			return llamadas.get(row).getIdLlamada();
		case 1:
			return llamadas.get(row).getContacto().getApellidos();
		case 2:
			return llamadas.get(row).getFechaLlamada();
		case 3:
			return llamadas.get(row).getAsunto();
		case 4:
			return llamadas.get(row).getNotas();
		default:
			return "";
		}		
	}
	
	
	/**
	 * Devuelve el número de filas que tendrá la tabla.
	 */
	@Override
	public int getRowCount() {
		return llamadas.size();
	}

}
