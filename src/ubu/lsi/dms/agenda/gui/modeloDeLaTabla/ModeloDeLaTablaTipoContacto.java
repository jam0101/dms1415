package ubu.lsi.dms.agenda.gui.modeloDeLaTabla;

import java.util.ArrayList;
import ubu.lsi.dms.agenda.modelo.TipoContacto;

/**
 * Modelo de datos que contiene los datos que se mostrarán en la tabla de los formularios de Consulta de Tipos de Contacto.
 * 
 * @author Álvaro Ruiz Molledo
 * @author Javier de la Fuente Barrios
 * @author Jorge Alonso Márquez
 *
 */
@SuppressWarnings({ "serial", "unchecked" })
public class ModeloDeLaTablaTipoContacto extends ModeloDeLaTabla {
	
	/**
	 * Lista con todos los tipos de contacto que se deben mostrar.
	 */
	ArrayList<TipoContacto> tiposContacto;
	
	
	/**
	 * Constructor de la clase.
	 * 
	 * @param columnNames	Array con los nombres de las distintas columnas.
	 * @param contactos		Lista con todos los contactos que se deben mostrar.
	 */
	public ModeloDeLaTablaTipoContacto(String[] columnNames, ArrayList<TipoContacto> tiposContacto) {
		super(columnNames);
		this.tiposContacto = tiposContacto;
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
			return tiposContacto.get(row).getIdTipoContacto();
		case 1:
			return tiposContacto.get(row).getTipoContacto();
		default:
			return "";
		}		
	}
	
	
	/**
	 * Devuelve el número de filas que tendrá la tabla.
	 */
	@Override
	public int getRowCount() {
		return tiposContacto.size();
	}

}
