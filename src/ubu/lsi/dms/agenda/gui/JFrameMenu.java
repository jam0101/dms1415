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

@SuppressWarnings("serial")
public class JFrameMenu extends JFrame {

	private JButton botones[] = new JButton[3];
	
	private ModeloDeDatos modeloDeDatos;
	
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
	 * 
	 *
	 *
	 */
	private class EscuchadorBotonInsertar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JFrameMenu.this.dispose();
			new JFrameFormulario("Insertar", new MediadorInsertar(), new OperacionInsertar(), modeloDeDatos);
		}
	}

	/**
	 * 
	 * 
	 *
	 */
	private class EscuchadorBotonConsultar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JFrameMenu.this.dispose();
			new JFrameFormulario("Consultar", new MediadorConsulta(), new OperacionConsultar(), modeloDeDatos);
		}
	}

	/**
	 * 
	 * 
	 *
	 */
	private class EscuchadorBotonActualizar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JFrameMenu.this.dispose();
			new JFrameFormulario("Actualizar", new MediadorActualizar(), new OperacionActualizar(), modeloDeDatos);
		}
	}

}
