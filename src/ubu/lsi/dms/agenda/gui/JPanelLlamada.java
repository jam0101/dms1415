package ubu.lsi.dms.agenda.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JTable;

import ubu.lsi.dms.agenda.gui.campoTexto.Campo_Fecha;
import ubu.lsi.dms.agenda.gui.campoTexto.Campo_Notas;
import ubu.lsi.dms.agenda.gui.campoTexto.Campo_SoloDigitos;
import ubu.lsi.dms.agenda.gui.campoTexto.Campo_SoloLetras;
import ubu.lsi.dms.agenda.gui.mediador.Mediador;
import ubu.lsi.dms.agenda.gui.modeloDeLaTabla.ModeloDeLaTablaContacto;
import ubu.lsi.dms.agenda.gui.modeloDeLaTabla.ModeloDeLaTablaLlamada;
import ubu.lsi.dms.agenda.gui.operacion.Operacion;
import ubu.lsi.dms.agenda.modelo.Llamada;
import ubu.lsi.dms.agenda.modelo.ModeloDeDatos;

/**
 * Panel perteneciente al panel tabulado de los formularios. Éste corresponde a
 * las Llamadas.
 * 
 * @author Álvaro Ruiz Molledo
 * @author Javier de la Fuente Barrios
 * @author Jorge Alonso Márquez
 *
 */
@SuppressWarnings("serial")
public class JPanelLlamada extends JPanelDato {

	/**
	 * Matriz con los nombres de las distinas columnas. Cada uno corresponde a
	 * uno de los campos de Llamada.
	 */
	private final String[] columnNames = { "Id", "Contacto", "Fecha", "Asunto",
			"Notas" };

	/**
	 * Constructor de la clase.
	 * 
	 * @param mediador
	 *            Clase que se encarga de mediar entre los distintos "colegas"
	 *            del panel.
	 * @param operacion
	 *            Operación a realizar (que puede ser Insertar, Consultar o
	 *            Actualizar según corresponda).
	 * @param modeloDeDatos
	 *            Clase de datos que contiene los datos sobre los que trabaja la
	 *            aplicación.
	 */
	public JPanelLlamada(Mediador mediador, Operacion operacion,
			ModeloDeDatos modeloDeDatos) {
		super(mediador, operacion, modeloDeDatos);

		setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10, 10, 10, 10);
		c.fill = GridBagConstraints.HORIZONTAL;

		etiquetas.add(crearLabel("IdLlamada"));
		etiquetas.add(crearLabel("IdContacto"));
		etiquetas.add(crearLabel("FechaLlamada"));
		etiquetas.add(crearLabel("Asunto"));
		etiquetas.add(crearLabel("Notas"));

		mediador.setEtiquetas(etiquetas);

		campoTexto.add(new Campo_SoloDigitos(""));
		campoTexto.add(new Campo_SoloDigitos(""));
		campoTexto.add(new Campo_Fecha(""));
		campoTexto.add(new Campo_SoloLetras(""));
		campoTexto.add(new Campo_Notas(""));

		// add(comboId);
		c.gridx = 0;
		c.gridy = 0;
		for (int i = 0; i < etiquetas.size(); i++) {
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

		modeloDeTabla = new ModeloDeLaTablaLlamada(columnNames,
				getModeloDeDatos().getLlamadas());
		tabla = new JTable(modeloDeTabla);
		tabla.getColumnModel().getColumn(0).setMaxWidth(35);
		tabla.getColumnModel().getColumn(1).setPreferredWidth(60);
		tabla.getColumnModel().getColumn(2).setPreferredWidth(120);
		tabla.getColumnModel().getColumn(3).setMaxWidth(60);
		tabla.getColumnModel().getColumn(4).setPreferredWidth(150);

		c.gridx = 0;
		c.gridy++;
		c.gridwidth = 4;
		add(tabla, c);

		mediador.actualizarColegas();
	}

	/**
	 * Añade a la base de datos una Llamada a partir de los datos introducidos
	 * en los textBox.
	 */
	@Override
	public void insertar() {
		getModeloDeDatos().addLlamada(campoTexto.get(0).getText(),
				campoTexto.get(1).getText(), campoTexto.get(2).getText(),
				campoTexto.get(3).getText(), campoTexto.get(4).getText());
	}

	/**
	 * Muestra los datos de las Llamadas cuyos apellidos correspondan a los
	 * introducidos en el textBox correspondiente.
	 */
	@Override
	public void consultar() {
		ArrayList<Llamada> llamadasAMostrar = new ArrayList<Llamada>();

		for (Llamada c : getModeloDeDatos().getLlamadas()) {

			if (c.getContacto().getIdContacto() == Integer.parseInt(campoTexto
					.get(1).getText())) {
				System.out.println(c.getContacto().getIdContacto() + " existe");
				llamadasAMostrar.add(c);
			} else {
				System.out.println("No existe: "
						+ c.getContacto().getIdContacto() + " es distinto de "
						+ campoTexto.get(1).getText());
			}
		}
		modeloDeTabla = new ModeloDeLaTablaLlamada(columnNames,
				llamadasAMostrar);
		tabla.setModel(modeloDeTabla);
		tabla.getColumnModel().getColumn(0).setMaxWidth(35);
		tabla.getColumnModel().getColumn(1).setPreferredWidth(60);
		tabla.getColumnModel().getColumn(2).setPreferredWidth(120);
		tabla.getColumnModel().getColumn(3).setMaxWidth(60);
		tabla.getColumnModel().getColumn(4).setPreferredWidth(150);

		modeloDeTabla.fireTableDataChanged();

	}

	/**
	 * Actualiza en la base de datos la Llamada correspondiente a los datos
	 * introducidos en los textBox.
	 */
	@Override
	public void actualizar() {
		getModeloDeDatos().addLlamada(campoTexto.get(0).getText(),
				campoTexto.get(1).getText(), campoTexto.get(2).getText(),
				campoTexto.get(3).getText(), campoTexto.get(4).getText());
	}
}
