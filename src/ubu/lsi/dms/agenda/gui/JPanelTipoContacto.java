package ubu.lsi.dms.agenda.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import ubu.lsi.dms.agenda.gui.campoTexto.Campo_SoloDigitos;
import ubu.lsi.dms.agenda.gui.mediador.Mediador;

@SuppressWarnings("serial")
public class JPanelTipoContacto extends JPanelDato {
	private JLabel[] etiquetas = new JLabel[2];
	private JButton botonAceptar = new JButton("Aceptar");
	
	public JPanelTipoContacto(Mediador mediador){
		super(mediador);
		etiquetas[0] = new JLabel("IdTipoContacto");
		etiquetas[1] = new JLabel("TipoContacto");
		
		campoTexto.add(new Campo_SoloDigitos("IdTipoContacto"));
		campoTexto.add(new Campo_SoloDigitos("TipoContacto"));
		
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
