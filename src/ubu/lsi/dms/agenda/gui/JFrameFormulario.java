package ubu.lsi.dms.agenda.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ubu.lsi.dms.agenda.gui.mediador.Mediador;
import ubu.lsi.dms.agenda.gui.operacion.Operacion;
import ubu.lsi.dms.agenda.modelo.ModeloDeDatos;

@SuppressWarnings("serial")
public class JFrameFormulario extends JFrame {

	JTabbedPane tabbedPane = new JTabbedPane();
	JPanelContacto panelContacto;
	JPanelLlamada panelLlamada;
	JPanelTipoContacto panelTipoContacto;
	
	private ModeloDeDatos modeloDeDatos;

	public JFrameFormulario(String nombre, Mediador mediador, Operacion operacion, ModeloDeDatos modeloDeDatos) {
		super(nombre);
		this.modeloDeDatos = modeloDeDatos;
		
		setVisible(true);
		setLayout(new FlowLayout());
		setSize(950, 610);
		setMinimumSize(new Dimension(950, 610));
		// Para que aparezca centrado
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panelContacto = new JPanelContacto(mediador.clone(), operacion, modeloDeDatos);
		panelLlamada = new JPanelLlamada(mediador.clone(), operacion, modeloDeDatos);
		panelTipoContacto = new JPanelTipoContacto(mediador.clone(), operacion, modeloDeDatos);

		inicializacionComponentes();
		
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public void inicializacionComponentes() {
		Container contentpane = getContentPane();

		tabbedPane.addTab("Contacto", panelContacto);
		tabbedPane.addTab("Llamada", panelLlamada);
		tabbedPane.addTab("Tipo de Contacto", panelTipoContacto);

		// tabbedPane.setBackground(new Color(32, 90, 130));
		// tabbedPane.setForeground(Color.WHITE);
		contentpane.add(tabbedPane);

		JButton botonCerrar = new JButton("Cerrar");
		botonCerrar.addMouseListener(new EscuchadorBotonCerrar());
		botonCerrar.setBackground(new Color(54, 152, 217));
		botonCerrar.setForeground(Color.WHITE);
		// LineBorder te permite cambiar el color y Empty border el
		// padding
		botonCerrar.setBorder(BorderFactory.createCompoundBorder(
				new LineBorder(Color.white), new EmptyBorder(5, 16, 5, 16)));
		contentpane.add(botonCerrar);
		contentpane.setBackground(new Color(32, 90, 130));
	}

	private class EscuchadorBotonCerrar extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent evento) {
			JFrameFormulario.this.dispose();
			new JFrameMenu("Menu", modeloDeDatos);
		}

	}
}
