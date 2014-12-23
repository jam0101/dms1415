package ubu.lsi.dms.agenda.gui.operacion;

import ubu.lsi.dms.agenda.gui.JPanelDato;

/**
 * Operación que debe ejecutar un panel de formulario al que le corresponde
 * Insertar.
 * 
 * @author Álvaro Ruiz Molledo
 * @author Javier de la Fuente Barrios
 * @author Jorge Alonso Márquez
 *
 */
public class OperacionInsertar implements Operacion {

	/**
	 * Método que ordena la realización la operación correspondiente a Insertar
	 * al panel de formulario dado.
	 * 
	 * @param panelDato
	 *            Panel que ejecutará la operación.
	 */
	@Override
	public void realizarOperacion(JPanelDato panelDato) {
		panelDato.insertar();
	}

}
