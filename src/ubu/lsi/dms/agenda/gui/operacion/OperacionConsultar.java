package ubu.lsi.dms.agenda.gui.operacion;

import ubu.lsi.dms.agenda.gui.JPanelDato;

/**
 * Operación que debe ejecutar un panel de formulario al que le corresponde Consultar.
 * 
 * @author Álvaro Ruiz Molledo
 * @author Javier de la Fuente Barrios
 * @author Jorge Alonso Márquez
 *
 */
public class OperacionConsultar implements Operacion {
	
	/**
	 * Método que ordena la realización la operación correspondiente a Consultar al panel de formulario dado.
	 * 
	 * @param panelDato	Panel que ejecutará la operación.
	 */
	@Override
	public void realizarOperacion(JPanelDato panelDato) {
		panelDato.consultar();
	}

	}
