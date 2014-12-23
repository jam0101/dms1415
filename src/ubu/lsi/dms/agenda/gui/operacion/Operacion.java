package ubu.lsi.dms.agenda.gui.operacion;

import ubu.lsi.dms.agenda.gui.JPanelDato;

/**
 * Operación que debe ejecutar un panel de formulario en función de si le corresponde Actualizar, Consultar o Insertar.
 * 
 * @author Álvaro Ruiz Molledo
 * @author Javier de la Fuente Barrios
 * @author Jorge Alonso Márquez
 *
 */
public interface Operacion {
	
	/**
	 * Método que ordena la realización la operación correspondiente a Actualizar, Consultar o Insertar según corresponda.
	 * 
	 * @param panelDato
	 *            Panel que ejecutará la operación.
	 */
	public void realizarOperacion(JPanelDato panelDato);
}
