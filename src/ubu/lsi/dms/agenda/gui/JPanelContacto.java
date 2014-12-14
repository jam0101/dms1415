package ubu.lsi.dms.agenda.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;

import ubu.lsi.dms.agenda.gui.campoTexto.Campo_CodPostal;
import ubu.lsi.dms.agenda.gui.campoTexto.Campo_Direccion;
import ubu.lsi.dms.agenda.gui.campoTexto.Campo_Email;
import ubu.lsi.dms.agenda.gui.campoTexto.Campo_Notas;
import ubu.lsi.dms.agenda.gui.campoTexto.Campo_SoloDigitos;
import ubu.lsi.dms.agenda.gui.campoTexto.Campo_SoloLetras;
import ubu.lsi.dms.agenda.gui.mediador.Mediador;

@SuppressWarnings("serial")
public class JPanelContacto extends JPanelDato {

	private JLabel[] etiquetas = new JLabel[19];

	public JPanelContacto(Mediador mediador) {
		super(mediador);

		setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10, 10, 10, 10);
		c.fill = GridBagConstraints.HORIZONTAL;


		etiquetas[0] = crearLabel("Id");
		etiquetas[1] = crearLabel("Nombre");
		etiquetas[2] = crearLabel("Apellidos");
		etiquetas[3] = crearLabel("Estimado");
		etiquetas[4] = crearLabel("Direccion");
		etiquetas[5] = crearLabel("Ciudad");
		etiquetas[6] = crearLabel("Prov");
		etiquetas[7] = crearLabel("Codigo postal");
		etiquetas[8] = crearLabel("Region");
		etiquetas[9] = crearLabel("Pais");
		etiquetas[10] = crearLabel("Nombre de la compania");
		etiquetas[11] = crearLabel("Cargo");
		etiquetas[12] = crearLabel("Telefono del trabajo");
		etiquetas[13] = crearLabel("Extension del trabajo");
		etiquetas[14] = crearLabel("Telefono movil");
		etiquetas[15] = crearLabel("Numero de fax");
		etiquetas[16] = crearLabel("E-mail");
		etiquetas[17] = crearLabel("Tipo de Contacto");
		etiquetas[18] = crearLabel("Notas");

		campoTexto.add(new Campo_SoloDigitos(""));
		campoTexto.add(new Campo_SoloLetras(""));
		campoTexto.add(new Campo_SoloLetras(""));
		campoTexto.add(new Campo_SoloLetras(""));
		campoTexto.add(new Campo_Direccion(""));
		campoTexto.add(new Campo_SoloLetras(""));
		campoTexto.add(new Campo_SoloLetras(""));
		campoTexto.add(new Campo_CodPostal(""));
		campoTexto.add(new Campo_SoloLetras(""));
		campoTexto.add(new Campo_SoloLetras(""));
		campoTexto.add(new Campo_SoloLetras(""));
		campoTexto.add(new Campo_SoloLetras(""));
		campoTexto.add(new Campo_SoloDigitos(""));
		campoTexto.add(new Campo_SoloLetras(""));
		campoTexto.add(new Campo_SoloDigitos(""));
		campoTexto.add(new Campo_SoloDigitos(""));
		campoTexto.add(new Campo_Email(""));
		campoTexto.add(new Campo_SoloDigitos(""));
		campoTexto.add(new Campo_Notas(""));

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
