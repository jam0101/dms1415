package ubu.lsi.dms.agenda.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import ubu.lsi.dms.agenda.gui.campoTexto.CampoTexto;
import ubu.lsi.dms.agenda.gui.mediador.Mediador;
import ubu.lsi.dms.agenda.gui.modeloDeLaTabla.ModeloDeLaTabla;
import ubu.lsi.dms.agenda.gui.operacion.Operacion;
import ubu.lsi.dms.agenda.modelo.ModeloDeDatos;

/**
 * Panel perteneciente al panel tabulado de los formularios.
 * 
 * @author Álvaro Ruiz Molledo
 * @author Javier de la Fuente Barrios
 * @author Jorge Alonso Márquez
 *
 */
@SuppressWarnings("serial")
public abstract class JPanelDato extends JPanel {
	
	/**
	 * Campos de texto del formulario.
	 */
	protected ArrayList<CampoTexto> campoTexto;
	
	/**
	 * Etiquetas con los nombres de los campos del formlario.
	 */
	protected ArrayList<JLabel> etiquetas;
	
	/**
	 * Botón que ejecuta la operación.
	 */
	protected JButton botonAceptar;
	
	/**
	 * Operación a realizar (que puede ser Insertar, Consultar o Actualizar según corresponda)
	 */
	private Operacion operacion;
	
	/**
	 * Clase de datos que contiene los datos sobre los que trabaja la aplicación.
	 */
	private ModeloDeDatos modeloDeDatos;
	
	/**
	 * Modelo de datos que contiene los datos que se mostrarán en la tabla de los formularios de Consulta.
	 */
	protected ModeloDeLaTabla modeloDeTabla;
	
	/**
	 * Tabla que se mostrará en los formularios de Consulta.
	 */
	protected JTable tabla;
	
	/**
	 * Clase que se encarga de mediar entre los distintos "colegas" del panel.
	 */
	protected Mediador mediador;
	
	
	/**
	 * Constructor de la clase.
	 * 
	 * @param mediador		Clase que se encarga de mediar entre los distintos "colegas" del panel.
	 * @param operacion		Operación a realizar (que puede ser Insertar, Consultar o Actualizar según corresponda).
	 * @param modeloDeDatos	Clase de datos que contiene los datos sobre los que trabaja la aplicación.
	 */
	public JPanelDato(Mediador mediador, Operacion operacion, ModeloDeDatos modeloDeDatos) {
		this.operacion = operacion;
		this.setModeloDeDatos(modeloDeDatos);
		
		etiquetas = new ArrayList<>();
		campoTexto = new ArrayList<>();	
		botonAceptar = crearButton("Aceptar");
		
		setBackground(new Color(32, 90, 130));

		this.mediador = mediador;
		this.mediador.setCamposTexto(campoTexto);
		this.mediador.setBotonAceptar(botonAceptar);
		
		botonAceptar.addActionListener(new BotonAceptarListener());
	}
	
	
	/** Método estático que crea un nuevo label
	 *  
	 * @param nombre	Texto del label
	 * @return label	Label creado
	 */
	public static JLabel crearLabel(String nombre) {
		JLabel label = new JLabel();
		label.setForeground(Color.WHITE);
		label.setText(nombre);
		label.setBorder(BorderFactory.createCompoundBorder(new LineBorder(
				Color.white), new EmptyBorder(5, 16, 5, 16)));
		return label;
	}
	
	
	/** Método estático que crea un nuevo botón
	 *  
	 * @param nombre	Texto del botón
	 * @return button	Botón creado
	 */
	public static JButton crearButton(String nombre) {
		JButton button = new JButton();
		button.setBackground(new Color(54, 152, 217));
		button.setForeground(Color.WHITE);
		button.setText(nombre);
		// LineBorder te permite cambiar el color y Empty border el
		// padding
		button.setBorder(BorderFactory.createCompoundBorder(new LineBorder(
				Color.white), new EmptyBorder(5, 16, 5, 16)));
		return button;
	}
	
	
	/**
	 * Realiza las acciones correspondientes a la acción de Inserción.
	 */
	public abstract void insertar();

	
	/**
	 * Realiza las acciones correspondientes a la acción de Consulta.
	 */
	public abstract void consultar();

	
	/**
	 * Realiza las acciones correspondientes a la acción de Actualización.
	 */
	public abstract void actualizar();
	
	
	/**
	 * Devuelve el Modelo de Datos
	 * 
	 * @return modeloDeDatos
	 */
	public ModeloDeDatos getModeloDeDatos() {
		return modeloDeDatos;
	}
	
	
	/**
	 * Asigna el Modelo de Datos
	 * 
	 * @param modeloDeDatos
	 */
	public void setModeloDeDatos(ModeloDeDatos modeloDeDatos) {
		this.modeloDeDatos = modeloDeDatos;
	}


	
	/**
	 *	Listener correspondiente a los elementos del formulario
	 */
	protected class ListenerFormulario implements DocumentListener {
		
		/**
		 * Ordena al mediador actualizar los "colegas".
		 */
		@Override
		public void changedUpdate(DocumentEvent arg0) {
			mediador.actualizarColegas();
		}
		
		
		/**
		 * Ordena al mediador actualizar los "colegas".
		 */
		@Override
		public void insertUpdate(DocumentEvent arg0) {
			mediador.actualizarColegas();
		}
		
		
		/**
		 * Ordena al mediador actualizar los "colegas".
		 */
		@Override
		public void removeUpdate(DocumentEvent arg0) {
			mediador.actualizarColegas();
		}
	}
	

	
	/**
	 *	Listener correspondiente al botón Aceptar
	 */
	private class BotonAceptarListener implements ActionListener {
		
		/**
		 * Ejecuta la operación que fue asignada al panel.
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			operacion.realizarOperacion(JPanelDato.this);
		}
		
	}

}
