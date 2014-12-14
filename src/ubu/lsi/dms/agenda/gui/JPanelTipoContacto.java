package ubu.lsi.dms.agenda.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;

import ubu.lsi.dms.agenda.gui.campoTexto.Campo_SoloDigitos;
import ubu.lsi.dms.agenda.gui.mediador.Mediador;

@SuppressWarnings("serial")
public class JPanelTipoContacto extends JPanelDato {
	private JLabel[] etiquetas = new JLabel[2];

	public JPanelTipoContacto(Mediador mediador) {
		super(mediador);

		setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10, 10, 10, 10);
		c.fill = GridBagConstraints.HORIZONTAL;

		c.gridx = 0;
		c.gridy = 0;
		etiquetas[0] = crearLabel("IdTipoContacto");
		add(etiquetas[0], c);
		
		c.gridx = 0;
		c.gridy = 1;
		etiquetas[0] = crearLabel("TipoContacto");
		add(etiquetas[0], c);

		campoTexto.add(new Campo_SoloDigitos(""));
		campoTexto.add(new Campo_SoloDigitos(""));
		
		c.gridx = 1;
		c.gridy = 0;
		add(campoTexto.get(0), c);
		
		c.gridx = 1;
		c.gridy = 1;
		add(campoTexto.get(1), c);

		// add(comboId);
		
		c.gridx = 1;
		c.gridy = 2;
		add(botonAceptar, c);

		mediador.actualizarColegas();
	}
}
