package ubu.lsi.dms.agenda.gui;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ubu.lsi.dms.agenda.gui.mediador.*;

@SuppressWarnings("serial")
public class JFrameMenu extends JFrame {

	public JFrameMenu(String nombre) {
		super(nombre);
		setVisible(true);
		setLayout(new FlowLayout());
		setSize(800, 600);
		setLocation(400, 200);
		setResizable(false);

		this.getContentPane().add(new JPanelBotones());

	}

	private class JPanelBotones extends JPanel {

		JButton botones[] = new JButton[3];

		public JPanelBotones() {
			for (int i = 0; i < 3; i++) {
				botones[i] = new JButton();
				botones[i].setVisible(true);
				this.add(botones[i]);
			}

			botones[0].setText("Insertar");
			botones[0].addMouseListener(new EscuchadorBotonInsertar());
			botones[1].setText("Consultar");
			botones[1].addMouseListener(new EscuchadorBotonConsultar());
			botones[2].setText("Actualizar");
			botones[2].addMouseListener(new EscuchadorBotonActualizar());
		}

		
		
		private class EscuchadorBotonInsertar extends MouseAdapter {

			@Override
			public void mouseClicked(MouseEvent evento) {
				JFrameMenu.this.dispose();
				new JFrameFormulario("Insertar", new MediadorInsertar());
			}

		}

		
		
		private class EscuchadorBotonConsultar extends MouseAdapter {

			@Override
			public void mouseClicked(MouseEvent evento) {
				JFrameMenu.this.dispose();
				new JFrameFormulario("Consultar", new MediadorConsulta());
			}

		}

		
		
		private class EscuchadorBotonActualizar extends MouseAdapter {

			@Override
			public void mouseClicked(MouseEvent evento) {
				JFrameMenu.this.dispose();
				new JFrameFormulario("Actualizar", new MediadorActualizar());
			}

		}

	}
}
