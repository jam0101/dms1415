package ubu.lsi.dms.agenda.gui.campoTexto;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 * TextField empleado por los formularios.
 * 
 * @author Álvaro Ruiz Molledo
 * @author Javier de la Fuente Barrios
 * @author Jorge Alonso Márquez
 *
 */
@SuppressWarnings("serial")
public abstract class CampoTexto extends JTextField {
	
	/**
	 * Constructor de la clase.
	 * 
	 * @param texto	Texto inicial del TextField.
	 */
	public CampoTexto(String texto) {
		super(texto, 10);

		setBorder(BorderFactory.createCompoundBorder(
				new LineBorder(Color.white), new EmptyBorder(5, 16, 5, 16)));

	}
	
	/**
	 * Comprueba si su texto corresponde a un valor válido.
	 * 
	 * @return True si el texto corresponde a un valor válido. False si no.
	 */
	public abstract boolean estaCorrecto();
}
