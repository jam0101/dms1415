package ubu.lsi.dms.agenda.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Observable;

import javax.swing.JLabel;

import ubu.lsi.dms.agenda.gui.JPanelDato.ListenerFormulario;
import ubu.lsi.dms.agenda.gui.campoTexto.Campo_Fecha;
import ubu.lsi.dms.agenda.gui.campoTexto.Campo_Notas;
import ubu.lsi.dms.agenda.gui.campoTexto.Campo_SoloDigitos;
import ubu.lsi.dms.agenda.gui.campoTexto.Campo_SoloLetras;
import ubu.lsi.dms.agenda.gui.mediador.Mediador;
import ubu.lsi.dms.agenda.modelo.ModeloDeDatos;

@SuppressWarnings("serial")
public class JPanelLlamada extends JPanelDato {
	
	private Comando comando;
	
	public JPanelLlamada(Mediador mediador, ModeloDeDatos modeloDeDatos) {
		super(mediador, modeloDeDatos);

		setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10, 10, 10, 10);
		c.fill = GridBagConstraints.HORIZONTAL;

		etiquetas.add(crearLabel("IdLlamada"));
		etiquetas.add(crearLabel("IdContacto"));
		etiquetas.add(crearLabel("FechaLlamada"));
		etiquetas.add(crearLabel("Asunto"));
		etiquetas.add(crearLabel("Notas"));

		campoTexto.add(new Campo_SoloDigitos(""));
		campoTexto.add(new Campo_SoloDigitos(""));
		campoTexto.add(new Campo_Fecha(""));
		campoTexto.add(new Campo_SoloLetras(""));
		campoTexto.add(new Campo_Notas(""));

		c.gridx = 0;
		c.gridy = 0;
		add(etiquetas.get(0), c);
		c.gridx++;
		add(comboId, c);
		campoTexto.get(0).getDocument()
				.addDocumentListener(new ListenerFormulario());
		add(campoTexto.get(0), c);
		c.gridx++;
		for (int i = 1; i < etiquetas.size(); i++) {
			add(etiquetas.get(i), c);
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
		add(botonAceptar, c);

		mediador.actualizarColegas();
	}

	@Override
	public void rellenarEnInsercion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rellenarEnConsulta() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rellenarEnActualizacion() {
		// TODO Auto-generated method stub
		
	}

}
