package ubu.lsi.dms.agenda.gui.campoTexto;

/**
 * TextField empleado por los formularios para los valores correspondientes a
 * direcciones.
 * 
 * @author Álvaro Ruiz Molledo
 * @author Javier de la Fuente Barrios
 * @author Jorge Alonso Márquez
 *
 */
@SuppressWarnings("serial")
public class Campo_Direccion extends CampoTexto {

	/**
	 * Constructor de la clase.
	 * 
	 * @param texto
	 *            Texto inicial del TextField.
	 */
	public Campo_Direccion(String texto) {
		super(texto);
	}

	/**
	 * Comprueba si su texto corresponde a un valor válido.
	 * 
	 * @return True si el texto contiene al menos un carácter. False si no.
	 */
	@Override
	public boolean estaCorrecto() {
		char[] listaCaracteres = this.getText().toCharArray();

		return (listaCaracteres.length > 0);
	}

}
