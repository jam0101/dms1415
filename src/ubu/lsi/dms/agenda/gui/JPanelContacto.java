package ubu.lsi.dms.agenda.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ubu.lsi.dms.agenda.gui.campoTexto.Campo_CodPostal;
import ubu.lsi.dms.agenda.gui.campoTexto.Campo_Direccion;
import ubu.lsi.dms.agenda.gui.campoTexto.Campo_Email;
import ubu.lsi.dms.agenda.gui.campoTexto.Campo_Notas;
import ubu.lsi.dms.agenda.gui.campoTexto.Campo_SoloDigitos;
import ubu.lsi.dms.agenda.gui.campoTexto.Campo_SoloLetras;
import ubu.lsi.dms.agenda.gui.mediador.Mediador;
import ubu.lsi.dms.agenda.gui.modeloDeLaTabla.ModeloDeLaTablaContacto;
import ubu.lsi.dms.agenda.gui.operacion.Operacion;
import ubu.lsi.dms.agenda.modelo.Contacto;
import ubu.lsi.dms.agenda.modelo.ModeloDeDatos;

/**
 * Panel perteneciente al panel tabulado de los formularios. Éste corresponde a los Contactos.
 * 
 * @author Álvaro Ruiz Molledo
 * @author Javier de la Fuente Barrios
 * @author Jorge Alonso Márquez
 *
 */
@SuppressWarnings("serial")
public class JPanelContacto extends JPanelDato {
	
	/**
	 * Matriz con los nombres de las distinas columnas.
	 * Cada uno corresponde a uno de los campos de Contacto.
	 */
	private final String[] columnNames = {"Id", "Nombre", "Apellidos", "Estimado",
			"Direccion", "Ciudad", "Prov", "Codigo postal", "Region",
			"Pais", "Nombre de la compania", "Cargo",
			"Telefono del trabajo", "Extension del trabajo",
			"Telefono movil", "Numero de fax", "E-mail",
			"Tipo de Contacto", "Notas"};
	
	
	/**
	 * Constructor de la clase.
	 * 
	 * @param mediador		Clase que se encarga de mediar entre los distintos "colegas" del panel.
	 * @param operacion		Operación a realizar (que puede ser Insertar, Consultar o Actualizar según corresponda).
	 * @param modeloDeDatos	Clase de datos que contiene los datos sobre los que trabaja la aplicación.
	 */
	public JPanelContacto(Mediador mediador, Operacion operacion, ModeloDeDatos modeloDeDatos) {
		super(mediador, operacion, modeloDeDatos);

		setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10, 10, 10, 10);
		c.fill = GridBagConstraints.HORIZONTAL;

		etiquetas.add(crearLabel("Id"));
		etiquetas.add(crearLabel("Nombre"));
		etiquetas.add(crearLabel("Apellidos"));
		etiquetas.add(crearLabel("Estimado"));
		etiquetas.add(crearLabel("Direccion"));
		etiquetas.add(crearLabel("Ciudad"));
		etiquetas.add(crearLabel("Prov"));
		etiquetas.add(crearLabel("Codigo postal"));
		etiquetas.add(crearLabel("Region"));
		etiquetas.add(crearLabel("Pais"));
		etiquetas.add(crearLabel("Nombre de la compania"));
		etiquetas.add(crearLabel("Cargo"));
		etiquetas.add(crearLabel("Telefono del trabajo"));
		etiquetas.add(crearLabel("Extension del trabajo"));
		etiquetas.add(crearLabel("Telefono movil"));
		etiquetas.add(crearLabel("Numero de fax"));
		etiquetas.add(crearLabel("E-mail"));
		etiquetas.add(crearLabel("Tipo de Contacto"));
		etiquetas.add(crearLabel("Notas"));

		mediador.setEtiquetas(etiquetas);

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
		
		
		modeloDeTabla = new ModeloDeLaTablaContacto(columnNames, getModeloDeDatos().getContactos());
		tabla = new JTable(modeloDeTabla);
	    scrollPaneTabla = new JScrollPane(tabla);
	    scrollPaneTabla.setVisible(false);
	    mediador.setScrollPaneTabla(scrollPaneTabla);
		
		c.gridx = 0;
		c.gridy++;
		c.gridwidth = 4;
		add(scrollPaneTabla, c);

		mediador.actualizarColegas();
	}
	
	
	/**
	 * Añade a la base de datos un Contacto a partir de los datos introducidos en los textBox.
	 */
	@Override
	public void insertar() {
		getModeloDeDatos().addContacto(campoTexto.get(0).getText(),
				campoTexto.get(1).getText(), campoTexto.get(2).getText(),
				campoTexto.get(3).getText(), campoTexto.get(4).getText(),
				campoTexto.get(5).getText(), campoTexto.get(6).getText(),
				campoTexto.get(7).getText(), campoTexto.get(8).getText(),
				campoTexto.get(9).getText(), campoTexto.get(10).getText(),
				campoTexto.get(11).getText(), campoTexto.get(12).getText(),
				campoTexto.get(13).getText(), campoTexto.get(14).getText(),
				campoTexto.get(15).getText(), campoTexto.get(16).getText(),
				campoTexto.get(17).getText(), campoTexto.get(18).getText());
	}
	
	
	/**
	 * Muestra los datos de los Contactos cuyos apellidos correspondan a los introducidos en el textBox correspondiente.
	 */
	@Override
	public void consultar() {
		ArrayList<Contacto> contactosAMostrar = new ArrayList<Contacto>();
		
		for(Contacto c : getModeloDeDatos().getContactos()){
			
			if(c.getApellidos().equals(campoTexto.get(1).getText())){
				System.out.println(c.getApellidos() + " existe");
				contactosAMostrar.add(c);
			} else {
				System.out.println("No existe: " + c.getApellidos() + " es distinto de " + campoTexto.get(2).getText());
			}
			
			//TODO: Actualizar la tabla para que muestre los contactos existentes en contactosAMostrar
		}
		
		
	}
	
	
	/**
	 * Actualiza en la base de datos el Contacto correspondiente a los datos introducidos en los textBox.
	 */
	@Override
	public void actualizar() {
		getModeloDeDatos().addContacto(campoTexto.get(0).getText(),
				campoTexto.get(1).getText(), campoTexto.get(2).getText(),
				campoTexto.get(3).getText(), campoTexto.get(4).getText(),
				campoTexto.get(5).getText(), campoTexto.get(6).getText(),
				campoTexto.get(7).getText(), campoTexto.get(8).getText(),
				campoTexto.get(9).getText(), campoTexto.get(10).getText(),
				campoTexto.get(11).getText(), campoTexto.get(12).getText(),
				campoTexto.get(13).getText(), campoTexto.get(14).getText(),
				campoTexto.get(15).getText(), campoTexto.get(16).getText(),
				campoTexto.get(17).getText(), campoTexto.get(18).getText());
	}

}
