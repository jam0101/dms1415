package ubu.lsi.dms.agenda.gui.mediador;

import ubu.lsi.dms.agenda.gui.campoTexto.CampoTexto;

/**
 * Clase que se encarga de mediar entre los distintos "colegas" de los paneles de los formularios Actualizar.
 * 
 * @author Álvaro Ruiz Molledo
 * @author Javier de la Fuente Barrios
 * @author Jorge Alonso Márquez
 *
 */
public class MediadorConsulta extends Mediador {
	
	/**
	 * Valor del contenido de la etiqueta correspondiente al apellido
	 */
	private final static String LABEL_APELLIDO = "Apellidos";
	
	/**
	 * Valor del contenido de la etiqueta correspondiente a la id del tipo de contacto
	 */
	private final static String LABEL_IDTIPO = "IdTipoContacto";
	
	/**
	 * Valor del contenido de la etiqueta correspondiente a la id del contacto
	 */
	private final static String LABEL_CONTACTO = "IdContacto";
	
	
	/**
	 * Oculta las etiquetas y textfields que no corresponden a una Consulta.
	 * Muestra la tabla que contendrá los resultados de las consultas.
	 * Si todos los campos de texto activos están correctamente rellenados, habilita el botón Aceptar.
	 */
	@Override
	public void actualizarColegas() {

		for (int i = 0; i < getEtiquetas().size(); i++) {
			if (getEtiquetas().get(i).getText() != LABEL_APELLIDO
					&& getEtiquetas().get(i).getText() != LABEL_IDTIPO
					&& getEtiquetas().get(i).getText() != LABEL_CONTACTO) {
				getEtiquetas().get(i).setVisible(false);
				getEtiquetas().get(i).setEnabled(false);
				getCamposTexto().get(i).setEnabled(false);
				getCamposTexto().get(i).setVisible(false);
			}
		}
		
		boolean todosLosCamposEstanCorrectos = true;
		for (CampoTexto campo : getCamposTexto()) {
			if (campo.isEnabled() && !campo.estaCorrecto()) {
				todosLosCamposEstanCorrectos = false;
			}
		}
		getBotonAceptar().setEnabled(todosLosCamposEstanCorrectos);
	}
	
	
	/**
	 * Devuelve un nuevo MediadorActualizar.
	 * 
	 * @return Mediador
	 */
	@Override
	public Mediador clone() {
		return new MediadorConsulta();
	}

}
