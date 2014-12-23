package ubu.lsi.dms.agenda.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import ubu.lsi.dms.agenda.gui.campoTexto.Campo_SoloDigitos;
import ubu.lsi.dms.agenda.gui.mediador.Mediador;
import ubu.lsi.dms.agenda.gui.modeloDeLaTabla.ModeloDeLaTablaContacto;
import ubu.lsi.dms.agenda.gui.modeloDeLaTabla.ModeloDeLaTablaTipoContacto;
import ubu.lsi.dms.agenda.gui.operacion.Operacion;
import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.ModeloDeDatos;
import ubu.lsi.dms.agenda.modelo.TipoContacto;

/**
 * Panel perteneciente al panel tabulado de los formularios. Éste corresponde a
 * los Tipos de Contacto.
 * 
 * @author Álvaro Ruiz Molledo
 * @author Javier de la Fuente Barrios
 * @author Jorge Alonso Márquez
 *
 */
@SuppressWarnings("serial")
public class JPanelTipoContacto extends JPanelDato {

	/**
	 * Matriz con los nombres de las distinas columnas. Cada uno corresponde a
	 * uno de los campos de Tipo de Contacto.
	 */
	private final String[] columnNames = { "Id", "Tipo" };

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

		modeloDeTabla = new ModeloDeLaTablaTipoContacto(columnNames,
				getModeloDeDatos().getTiposContacto());
		tabla = new JTable(modeloDeTabla);
		tabla.getColumnModel().getColumn(0).setMaxWidth(5);
		tabla.getColumnModel().getColumn(1).setPreferredWidth(25);

		c.gridx = 0;
		c.gridy++;
		c.gridwidth = 4;
		add(tabla, c);

		campoTexto.get(0).getDocument()
				.addDocumentListener(new ListenerFormulario());
		campoTexto.get(1).getDocument()
				.addDocumentListener(new ListenerFormulario());

		mediador.actualizarColegas();
	}

	/**
	 * Añade a la base de datos un Tipo de Contacto a partir de los datos
	 * introducidos en los textBox.
	 */
	@Override
	public void insertar() {
		getModeloDeDatos().addTipoContacto(campoTexto.get(0).getText(),
				campoTexto.get(1).getText());
	}

	/**
	 * Muestra los datos de los Tipos de Contacto cuyos apellidos correspondan a
	 * los introducidos en el textBox correspondiente.
	 */
	@Override
	public void consultar() {
		ArrayList<TipoContacto> tipoContactosAMostrar = new ArrayList<TipoContacto>();

		for (TipoContacto c : getModeloDeDatos().getTiposContacto()) {

			if (c.getIdTipoContacto() == Integer.parseInt(campoTexto.get(0)
					.getText())) {
				System.out.println(c.getIdTipoContacto() + " existe");
				tipoContactosAMostrar.add(c);
			} else {
				System.out.println("No existe: " + c.getIdTipoContacto()
						+ " es distinto de " + campoTexto.get(0).getText());
			}
		}
		modeloDeTabla = new ModeloDeLaTablaTipoContacto(columnNames,
				tipoContactosAMostrar);
		tabla.setModel(modeloDeTabla);

		tabla.getColumnModel().getColumn(0).setMaxWidth(5);
		tabla.getColumnModel().getColumn(1).setPreferredWidth(25);
		modeloDeTabla.fireTableDataChanged();
	}

	/**
	 * Actualiza en la base de datos el Tipo de Contacto correspondiente a los
	 * datos introducidos en los textBox.
	 */
	@Override
	public void actualizar() {
		getModeloDeDatos().addTipoContacto(campoTexto.get(0).getText(),
				campoTexto.get(1).getText());
	}
}
