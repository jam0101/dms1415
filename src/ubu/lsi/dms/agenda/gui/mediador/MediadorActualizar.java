package ubu.lsi.dms.agenda.gui.mediador;

import ubu.lsi.dms.agenda.gui.campoTexto.CampoTexto;

/**
 * Clase que se encarga de mediar entre los distintos "colegas" de los paneles
 * de los formularios Actualizar.
 * 
 * @author Álvaro Ruiz Molledo
 * @author Javier de la Fuente Barrios
 * @author Jorge Alonso Márquez
 *
 */
public class MediadorActualizar extends Mediador {

	/**
	 * Si todos los campos de texto están correctamente rellenados, habilita el
	 * botón Aceptar.
	 */
	@Override
	public void actualizarColegas() {
		boolean todosLosCamposEstanCorrectos = true;

		for (CampoTexto campo : getCamposTexto()) {
			if (!campo.estaCorrecto()) {
				if (!campo.getText().equals("")) {
					System.err.println(campo.getText()
							+ " no es un valor correcto.");
				}
				todosLosCamposEstanCorrectos = false;
			}
		}

		getTabla().setVisible(false);
		getComboId().setVisible(true);
		getCamposTexto().get(0).setVisible(false);
		getBotonAceptar().setEnabled(todosLosCamposEstanCorrectos);
	}

	/**
	 * Devuelve un nuevo MediadorActualizar.
	 * 
	 * @return Mediador
	 */
	@Override
	public Mediador clone() {
		return new MediadorActualizar();
	}
}
