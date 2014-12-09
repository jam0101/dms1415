package ubu.lsi.dms.agenda.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class JPanelTipoContacto extends JPanelDato {
	private JLabel[] etiquetas = new JLabel[2];
	private JButton botonAceptar = new JButton("Aceptar");
	
	public JPanelTipoContacto(){
		super();
		etiquetas[0] = new JLabel("IdTipoContacto");
		etiquetas[1] = new JLabel("TipoContacto");
		
		campoTexto.add(new JTextField("IdTipoContacto"));
		campoTexto.add(new JTextField("TipoContacto"));
		
		add(etiquetas[0]);
		add(comboId);
		for(int i = 1; i < etiquetas.length; i++){
			this.add(etiquetas[i]);
			add(campoTexto.get(i - 1));
		}
		add(botonAceptar);
		setLayout(new GridLayout(2,2));
	}
}
