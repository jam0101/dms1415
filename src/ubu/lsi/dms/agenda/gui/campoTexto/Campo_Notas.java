package ubu.lsi.dms.agenda.gui.campoTexto;

/**
 * TextField empleado por los formularios para los valores correspondientes a notas.
 * 
 * @author Álvaro Ruiz Molledo
 * @author Javier de la Fuente Barrios
 * @author Jorge Alonso Márquez
 *
 */
@SuppressWarnings("serial")
public class Campo_Notas extends CampoTexto {
	
	/**
	 * Constructor de la clase.
	 * 
	 * @param texto	Texto inicial del TextField.
	 */
	public Campo_Notas(String texto) {
		super(texto);
	}
	

	/**
	 * Comprueba si su texto corresponde a un valor válido.
	 * 
	 * @return El campo Notas está bien siempre. Incluso si no tiene nada.
	 */
	@Override
	public boolean estaCorrecto() {
		return true;
	}

}
