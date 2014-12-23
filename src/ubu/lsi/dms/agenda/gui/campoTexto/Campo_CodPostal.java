package ubu.lsi.dms.agenda.gui.campoTexto;

/**
 * TextField empleado por los formularios para los valores correspondientes a códigos postales.
 * 
 * @author Álvaro Ruiz Molledo
 * @author Javier de la Fuente Barrios
 * @author Jorge Alonso Márquez
 *
 */
@SuppressWarnings("serial")
public class Campo_CodPostal extends CampoTexto {
	
	/**
	 * Constructor de la clase.
	 * 
	 * @param texto	Texto inicial del TextField.
	 */
	public Campo_CodPostal(String texto) {
		super(texto);
	}
	

	/**
	 * Comprueba si su texto corresponde a un valor válido.
	 * 
	 * @return True si el texto tiene 5 caracteres y todos son dígitos. False si no.
	 */
	@Override
	public boolean estaCorrecto() {
		char[] listaCaracteres = this.getText().toCharArray();

		if (listaCaracteres.length != 5) {
			return false;
		}

		for (Character c : this.getText().toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}

		return true;
	}

}
