package ubu.lsi.dms.agenda.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ubu.lsi.dms.agenda.gui.mediador.MediadorActualizar;
import ubu.lsi.dms.agenda.gui.mediador.MediadorConsulta;
import ubu.lsi.dms.agenda.gui.mediador.MediadorInsertar;
import ubu.lsi.dms.agenda.gui.operacion.OperacionActualizar;
import ubu.lsi.dms.agenda.gui.operacion.OperacionConsultar;
import ubu.lsi.dms.agenda.gui.operacion.OperacionInsertar;
import ubu.lsi.dms.agenda.modelo.ModeloDeDatos;

/**
 * Frame que contiene el menú principal de la aplicación.
 * 
 * @author Álvaro Ruiz Molledo
 * @author Javier de la Fuente Barrios
 * @author Jorge Alonso Márquez
 *
 */
@SuppressWarnings("serial")
public class JFrameMenu extends JFrame {
	
	/**
	 * Botones correspondientes a los tres tipos posibles de operación.
	 */
	private JButton botones[] = new JButton[3];
	
	/**
	 * Clase de datos que contiene los datos sobre los que trabaja la aplicación.
	 */
	private ModeloDeDatos modeloDeDatos;
	
	
	/**
	 * Constructor de la clase.
	 * 
	 * @param nombre		Nombre del frame.
	 * @param modeloDeDatos	Clase de datos que contiene los datos sobre los que trabaja la aplicación.
	 */
	public JFrameMenu(String nombre, ModeloDeDatos modeloDeDatos) {
		super(nombre);
		this.modeloDeDatos = modeloDeDatos;
		
		inicializacionComponentes();

		// Tamaño y tamaño mínimo
		setSize(350, 200);
		setMinimumSize(new Dimension(350, 200));
		// Para que aparezca centrado
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// pack();
		setVisible(true);
	}
	
	
	/**
	 * Inicializa los componentes gráficos del frame.
	 */
	private void inicializacionComponentes() {
		Container contentpane = getContentPane();

		// GridBag para que los botones siempre aparecan centrados
		setLayout(new GridBagLayout());
		// Margen entre los elementos
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 5, 5, 5);

		// Añadir los botones
		for (int i = 0; i < 3; i++) {
			botones[i] = new JButton();
			botones[i].setVisible(true);
			// Color de fondo y de la fuente
			botones[i].setBackground(new Color(54, 152, 217));
			botones[i].setForeground(Color.WHITE);
			// LineBorder te permite cambiar el color y Empty border el
			// padding
			botones[i]
					.setBorder(BorderFactory.createCompoundBorder(
							new LineBorder(Color.white), new EmptyBorder(5, 16,
									5, 16)));
			// Añadir botón con GridBagConstraints
			contentpane.add(botones[i], c);
		}
		// Añadir texto y escuchador
		botones[0].setText("Insertar");
		botones[0].addActionListener(new EscuchadorBotonInsertar());
		botones[1].setText("Consultar");
		botones[1].addActionListener(new EscuchadorBotonConsultar());
		botones[2].setText("Actualizar");
		botones[2].addActionListener(new EscuchadorBotonActualizar());

		contentpane.setBackground(new Color(32, 90, 130));

	}

	/**
	 *	Listener correspondiente al botón Insertar
	 */
	private class EscuchadorBotonInsertar implements ActionListener {
		
		/**
		 * Cierra el frame actual y abre un frame formulario de Inserción de datos.
		 * 
		 * @param e Evento
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrameMenu.this.dispose();
			new JFrameFormulario("Insertar", new MediadorInsertar(), new OperacionInsertar(), modeloDeDatos);
		}
	}

	/**
	 *	Listener correspondiente al botón Consultar
	 */
	private class EscuchadorBotonConsultar implements ActionListener {
		
		/**
		 * Cierra el frame actual y abre un frame formulario de Consulta de datos.
		 * 
		 * @param e Evento
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrameMenu.this.dispose();
			new JFrameFormulario("Consultar", new MediadorConsulta(), new OperacionConsultar(), modeloDeDatos);
		}
	}

	/**
	 *	Listener correspondiente al botón Actualizar
	 */
	private class EscuchadorBotonActualizar implements ActionListener {
		
		/**
		 * Cierra el frame actual y abre un frame formulario de Actualización de datos.
		 * 
		 * @param e Evento
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrameMenu.this.dispose();
			new JFrameFormulario("Actualizar", new MediadorActualizar(), new OperacionActualizar(), modeloDeDatos);
		}
	}

}
