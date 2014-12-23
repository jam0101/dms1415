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

/**
 * Frame que contiene un panel tabulado de formulario.
 * 
 * @author Álvaro Ruiz Molledo
 * @author Javier de la Fuente Barrios
 * @author Jorge Alonso Márquez
 *
 */
@SuppressWarnings("serial")
public class JFrameFormulario extends JFrame {

	/**
	 * Panel tabulado de formulario.
	 */
	JTabbedPane tabbedPane = new JTabbedPane();

	/**
	 * Primera pestaña del panel tabulado, correspondiente a los Contactos.
	 */
	JPanelContacto panelContacto;

	/**
	 * Segunda pestaña del panel tabulado, correspondiente a las Llamadas.
	 */
	JPanelLlamada panelLlamada;

	/**
	 * Tercera pestaña del panel tabulado, correspondiente a los Tipos de
	 * Contacto.
	 */
	JPanelTipoContacto panelTipoContacto;

	/**
	 * Clase de datos que contiene los datos sobre los que trabaja la
	 * aplicación.
	 */
	private ModeloDeDatos modeloDeDatos;

	/**
	 * Constructor de la clase.
	 * 
	 * @param nombre
	 *            Nombre del frame.
	 * @param mediador
	 *            Mediador que corresponde a la clase de operación asignada a
	 *            este frame.
	 * @param operacion
	 *            Operación asignada a este frame.
	 * @param modeloDeDatos
	 *            Clase de datos que contiene los datos sobre los que trabaja la
	 *            aplicación.
	 */
	public JFrameFormulario(String nombre, Mediador mediador,
			Operacion operacion, ModeloDeDatos modeloDeDatos) {
		super(nombre);
		this.modeloDeDatos = modeloDeDatos;

		setVisible(true);
		setLayout(new FlowLayout());
		setSize(950, 610);
		setMinimumSize(new Dimension(950, 610));
		// setMinimumSize(new Dimension(950, 1020));
		// Para que aparezca centrado
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panelContacto = new JPanelContacto(mediador.clone(), operacion,
				modeloDeDatos);
		panelLlamada = new JPanelLlamada(mediador.clone(), operacion,
				modeloDeDatos);
		panelTipoContacto = new JPanelTipoContacto(mediador.clone(), operacion,
				modeloDeDatos);

		inicializacionComponentes();

	}

	/**
	 * Devuelve el panel tabulado.
	 * 
	 * @return tabbedPane
	 */
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	/**
	 * Inicializa los componentes gráficos del frame.
	 */
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

	/**
	 * Listener correspondiente al botón Cerrar
	 */
	private class EscuchadorBotonCerrar extends MouseAdapter {

		/**
		 * Cierra el frame actual y abre el frame del menú principal.
		 * 
		 * @param e
		 *            Evento
		 */
		@Override
		public void mouseClicked(MouseEvent evento) {
			JFrameFormulario.this.dispose();
			new JFrameMenu("Menu", modeloDeDatos);
		}

	}
}
