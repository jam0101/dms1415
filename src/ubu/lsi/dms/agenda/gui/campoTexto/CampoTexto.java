package ubu.lsi.dms.agenda.gui.campoTexto;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public abstract class CampoTexto extends JTextField {
	
	public CampoTexto(String texto){
		super(texto);
	}
	
	public abstract boolean estaCorrecto();
}
