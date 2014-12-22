package ubu.lsi.dms.agenda.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;

import ubu.lsi.dms.agenda.gui.campoTexto.Campo_SoloDigitos;
import ubu.lsi.dms.agenda.gui.mediador.Mediador;
import ubu.lsi.dms.agenda.gui.operacion.Operacion;
import ubu.lsi.dms.agenda.modelo.ModeloDeDatos;

@SuppressWarnings("serial")
public class JPanelTipoContacto extends JPanelDato {

	public JPanelTipoContacto(Mediador mediador, Operacion operacion,
			ModeloDeDatos modeloDeDatos) {
		super(mediador, operacion, modeloDeDatos);

		setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10, 10, 10, 10);
		c.fill = GridBagConstraints.HORIZONTAL;

		c.gridx = 0;
		c.gridy = 0;
		etiquetas.add(crearLabel("IdTipoContacto"));
		add(etiquetas.get(0), c);

		c.gridx = 0;
		c.gridy = 1;
		etiquetas.add(crearLabel("TipoContacto"));
		add(etiquetas.get(1), c);

		mediador.setEtiquetas(etiquetas);
		
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

		campoTexto.get(0).getDocument()
				.addDocumentListener(new ListenerFormulario());
		campoTexto.get(1).getDocument()
				.addDocumentListener(new ListenerFormulario());

		mediador.actualizarColegas();
	}

	@Override
	public void insertar() {
		getModeloDeDatos().addTipoContacto(campoTexto.get(0).getText(),
				campoTexto.get(1).getText());
	}

	@Override
	public void consultar() {
		getModeloDeDatos().getTiposContacto();
	}

	@Override
	public void actualizar() {
		getModeloDeDatos().addTipoContacto(campoTexto.get(0).getText(),
				campoTexto.get(1).getText());
	}
}
