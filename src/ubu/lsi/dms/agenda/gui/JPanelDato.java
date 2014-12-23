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

@SuppressWarnings("serial")
public abstract class JPanelDato extends JPanel {

	protected ArrayList<CampoTexto> campoTexto;
	protected ArrayList<JLabel> etiquetas;
	protected JButton botonAceptar;
	private Operacion operacion;
	private ModeloDeDatos modeloDeDatos;
	
	protected ModeloDeLaTabla modeloDeTabla;
	protected JTable tabla;
	protected JScrollPane scrollPaneTabla;
	
	protected Mediador mediador;

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

	public static JTextField crearTextField() {
		JTextField field = new JTextField("", 26);
		field.setBorder(BorderFactory.createCompoundBorder(new LineBorder(
				Color.white), new EmptyBorder(5, 16, 5, 16)));
		field.setMinimumSize(field.getPreferredSize());
		field.setSize(new Dimension(100, 50));
		return field;
	}

	public static JLabel crearLabel(String nombre) {
		JLabel label = new JLabel();
		label.setForeground(Color.WHITE);
		label.setText(nombre);
		label.setBorder(BorderFactory.createCompoundBorder(new LineBorder(
				Color.white), new EmptyBorder(5, 16, 5, 16)));
		return label;
	}

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
	
	
	public abstract void insertar();
	public abstract void consultar();
	public abstract void actualizar();
	
	

	public ModeloDeDatos getModeloDeDatos() {
		return modeloDeDatos;
	}

	public void setModeloDeDatos(ModeloDeDatos modeloDeDatos) {
		this.modeloDeDatos = modeloDeDatos;
	}



	protected class ListenerFormulario implements DocumentListener {

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			mediador.actualizarColegas();
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			mediador.actualizarColegas();
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			mediador.actualizarColegas();
		}
	}
	
	
	private class BotonAceptarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			operacion.realizarOperacion(JPanelDato.this);
		}
		
	}

}
