package ubu.lsi.dms.agenda.gui.campoTexto;

/**
 * TextField empleado por los formularios para los valores correspondientes a campos de exclusivamente dígitos.
 * 
 * @author Álvaro Ruiz Molledo
 * @author Javier de la Fuente Barrios
 * @author Jorge Alonso Márquez
 *
 */
@SuppressWarnings("serial")
public class Campo_SoloDigitos extends CampoTexto {
	
	/**
	 * Constructor de la clase.
	 * 
	 * @param texto	Texto inicial del TextField.
	 */
	public Campo_SoloDigitos(String texto) {
		super(texto);
	}
	

	/**
	 * Comprueba si su texto corresponde a un valor válido.
	 * 
	 * @return True si el texto tiene al menos un carácter y todos son dígitos. False si no.
	 */
	@Override
	public boolean estaCorrecto() {
		char[] listaCaracteres = this.getText().toCharArray();

		if (listaCaracteres.length == 0) {
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
