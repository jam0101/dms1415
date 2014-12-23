package ubu.lsi.dms.agenda.gui.campoTexto;

/**
 * TextField empleado por los formularios para los valores correspondientes a emails.
 * 
 * @author Álvaro Ruiz Molledo
 * @author Javier de la Fuente Barrios
 * @author Jorge Alonso Márquez
 *
 */
@SuppressWarnings("serial")
public class Campo_Email extends CampoTexto {
	
	/**
	 * Constructor de la clase.
	 * 
	 * @param texto	Texto inicial del TextField.
	 */
	public Campo_Email(String texto) {
		super(texto);
	}

	/**
	 * Comprueba si su texto corresponde a un valor válido.
	 * 
	 * @return True si el texto corresponde al formato válido de las direcciones de email. False si no.
	 */
	@Override
	public boolean estaCorrecto() {
		String cadenaCorrectaParaUnEmail = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		
		return getText().matches(cadenaCorrectaParaUnEmail);
	}

}
