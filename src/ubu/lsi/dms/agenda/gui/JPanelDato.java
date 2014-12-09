package ubu.lsi.dms.agenda.gui;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class JPanelDato extends JPanel{
	protected ArrayList<JTextField> campoTexto = new ArrayList<>();
	protected JButton botonAceptar = new JButton("Aceptar");
	protected JComboBox<Integer> comboId = new JComboBox<>();
	
	public JPanelDato(){
		
	}
}
