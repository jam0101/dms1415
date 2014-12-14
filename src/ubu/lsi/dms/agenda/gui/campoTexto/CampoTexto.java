package ubu.lsi.dms.agenda.gui.campoTexto;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public abstract class CampoTexto extends JTextField {

	public CampoTexto(String texto) {
		super(texto, 10);

		setBorder(BorderFactory.createCompoundBorder(
				new LineBorder(Color.white), new EmptyBorder(5, 16, 5, 16)));

	}

	public abstract boolean estaCorrecto();
}
