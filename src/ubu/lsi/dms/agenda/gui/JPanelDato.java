package ubu.lsi.dms.agenda.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import ubu.lsi.dms.agenda.gui.campoTexto.CampoTexto;
import ubu.lsi.dms.agenda.gui.mediador.Mediador;
import ubu.lsi.dms.agenda.modelo.ModeloDeDatos;

@SuppressWarnings("serial")
public abstract class JPanelDato extends JPanel implements Observer {

	protected JComboBox<Integer> comboId;
	protected ArrayList<CampoTexto> campoTexto;
	protected ArrayList<JLabel> etiquetas;
	protected JButton botonAceptar;

	protected Mediador mediador;
	
	protected ModeloDeDatos modeloDeDatos;

	public JPanelDato(Mediador mediador, ModeloDeDatos modeloDeDatos) {
		this.modeloDeDatos = modeloDeDatos;
		
		etiquetas = new ArrayList<>();
		comboId = new JComboBox<>();
		comboId.setEditable(false);
		
		campoTexto = new ArrayList<>();
		botonAceptar = crearButton("Aceptar");

		setBackground(new Color(32, 90, 130));

		this.mediador = mediador;
		this.mediador.setComboId(comboId);
		this.mediador.setCamposTexto(campoTexto);
		this.mediador.setBotonAceptar(botonAceptar);
	}

//	public static JTextField crearTextField() {
//		JTextField field = new JTextField("", 26);
//		field.setBorder(BorderFactory.createCompoundBorder(new LineBorder(
//				Color.white), new EmptyBorder(5, 16, 5, 16)));
//		field.setMinimumSize(field.getPreferredSize());
//		field.setSize(new Dimension(100, 50));
//		return field;
//	}

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

	protected class ListenerFormulario implements DocumentListener {

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			mediador.actualizarColegas();
			// System.out.println("changedUpdate");
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			mediador.actualizarColegas();
			// System.out.println("insertUpdate");
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			mediador.actualizarColegas();
			// System.out.println("removeUpdate");
		}
	}
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
//		if(){
//			rellenarEnInsercion();
//		} else if() {
//			rellenarEnConsulta();
//		} else if() {
//			rellenarEnActualizacion();
//		}
			
	}
	
	public abstract void rellenarEnInsercion();
	
	public abstract void rellenarEnConsulta();
	
	public abstract void rellenarEnActualizacion();

}
