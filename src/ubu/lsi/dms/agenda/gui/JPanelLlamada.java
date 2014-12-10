package ubu.lsi.dms.agenda.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import ubu.lsi.dms.agenda.gui.campoTexto.*;
import ubu.lsi.dms.agenda.gui.mediador.Mediador;

@SuppressWarnings("serial")
public class JPanelLlamada extends JPanelDato {
	private JLabel[] etiquetas = new JLabel[5];
	private JButton botonAceptar = new JButton("Aceptar");
	
	public JPanelLlamada(Mediador mediador){
		super(mediador);
		etiquetas[0] = new JLabel("IdLlamada");
		etiquetas[1] = new JLabel("IdContacto");
		etiquetas[2] = new JLabel("FechaLlamada");
		etiquetas[3] = new JLabel("Asunto");
		etiquetas[4] = new JLabel("Notas");
		
		campoTexto.add(new Campo_SoloDigitos("IdContacto"));
		campoTexto.add(new Campo_Fecha("FechaLlamada"));
		campoTexto.add(new Campo_SoloLetras("Asunto"));
		campoTexto.add(new Campo_Notas("Notas"));
		
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
