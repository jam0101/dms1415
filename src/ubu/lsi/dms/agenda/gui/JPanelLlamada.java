package ubu.lsi.dms.agenda.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;

import ubu.lsi.dms.agenda.gui.campoTexto.Campo_Fecha;
import ubu.lsi.dms.agenda.gui.campoTexto.Campo_Notas;
import ubu.lsi.dms.agenda.gui.campoTexto.Campo_SoloDigitos;
import ubu.lsi.dms.agenda.gui.campoTexto.Campo_SoloLetras;
import ubu.lsi.dms.agenda.gui.mediador.Mediador;

@SuppressWarnings("serial")
public class JPanelLlamada extends JPanelDato {
	private JLabel[] etiquetas = new JLabel[5];

	public JPanelLlamada(Mediador mediador) {
		super(mediador);

		setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10, 10, 10, 10);
		c.fill = GridBagConstraints.HORIZONTAL;

		etiquetas[0] = crearLabel("IdLlamada");
		etiquetas[1] = crearLabel("IdContacto");
		etiquetas[2] = crearLabel("FechaLlamada");
		etiquetas[3] = crearLabel("Asunto");
		etiquetas[4] = crearLabel("Notas");

		campoTexto.add(new Campo_SoloDigitos(""));
		campoTexto.add(new Campo_SoloDigitos(""));
		campoTexto.add(new Campo_Fecha(""));
		campoTexto.add(new Campo_SoloLetras(""));
		campoTexto.add(new Campo_Notas(""));

		// add(comboId);
		c.gridx = 0;
		c.gridy = 0;
		for (int i = 0; i < etiquetas.length; i++) {
			add(etiquetas[i], c);
			c.gridx++;

			campoTexto.get(i).getDocument()
					.addDocumentListener(new ListenerFormulario());
			add(campoTexto.get(i), c);
			c.gridx++;

			if (i % 2 != 0) {
				c.gridy++;
				c.gridx = 0;
			}
		}

		c.gridx++;
		c.gridy++;
		botonAceptar.setText("Aceptar (Llamada)");
		add(botonAceptar, c);

		mediador.actualizarColegas();
	}
}
