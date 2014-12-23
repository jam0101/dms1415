package ubu.lsi.dms.agenda.gui.modeloDeLaTabla;

import javax.swing.table.AbstractTableModel;

/**
 * Modelo de datos que contiene los datos que se mostrarán en la tabla de los
 * formularios de Consulta.
 * 
 * @author Álvaro Ruiz Molledo
 * @author Javier de la Fuente Barrios
 * @author Jorge Alonso Márquez
 *
 */
@SuppressWarnings("serial")
public abstract class ModeloDeLaTabla extends AbstractTableModel {

	/**
	 * Array con los nombres de las distintas columnas.
	 */
	private String[] columnNames;

	/**
	 * Constructor de la clase.
	 * 
	 * @param columnNames
	 *            Array con los nombres de las distintas columnas.
	 */
	public ModeloDeLaTabla(String[] columnNames) {
		this.columnNames = columnNames;
	}

	/**
	 * Devuelve el número de columnas que tendrá la tabla.
	 */
	public int getColumnCount() {
		return columnNames.length;
	}

	/**
	 * Devuelve el número de filas que tendrá la tabla.
	 */
	public abstract int getRowCount();

	/**
	 * Devuelve el nombre de la columna indicada.
	 * 
	 * @param col
	 *            Columna cuyo nombre se quiere conocer.
	 */
	public String getColumnName(int col) {
		return columnNames[col];
	}

	/**
	 * Devuelve el valor que irá en la fila y la columna indicadas.
	 * 
	 * @param row
	 *            Fila indicada.
	 * @param col
	 *            Columna indicada.
	 */
	public abstract Object getValueAt(int row, int col);

	/**
	 * Devuelve la clase correspondiente al valor que irá en la fila y la
	 * columna indicadas.
	 * 
	 * @param row
	 *            Fila indicada.
	 * @param col
	 *            Columna indicada.
	 */
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

}
