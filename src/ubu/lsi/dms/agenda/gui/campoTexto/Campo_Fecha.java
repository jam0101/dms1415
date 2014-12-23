package ubu.lsi.dms.agenda.gui.campoTexto;

/**
 * TextField empleado por los formularios para los valores correspondientes a
 * fechas.
 * 
 * @author Álvaro Ruiz Molledo
 * @author Javier de la Fuente Barrios
 * @author Jorge Alonso Márquez
 *
 */
@SuppressWarnings("serial")
public class Campo_Fecha extends CampoTexto {

	/**
	 * Constructor de la clase.
	 * 
	 * @param texto
	 *            Texto inicial del TextField.
	 */
	public Campo_Fecha(String texto) {
		super(texto);
	}

	/**
	 * Comprueba si su texto corresponde a un valor válido.
	 * 
	 * @return True si el texto corresponde al formato válido de las fechas.
	 *         False si no.
	 */
	@Override
	public boolean estaCorrecto() {
		String cadenaCorrectaParaUnaFecha = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)?\\d\\d)";

		return getText().matches(cadenaCorrectaParaUnaFecha);
	}

}
