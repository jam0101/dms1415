package ubu.lsi.dms.agenda.gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class JFrameMenu extends JFrame {
	
	JButton botones[] = new JButton[3];
	
	public JFrameMenu(String nombre){
		super(nombre);
		setVisible(true);
		setLayout(new FlowLayout());
		setSize(800, 600);
		setResizable(false);
		
		for(int i = 0; i < 3; i++){
			botones[i] = new JButton();
			botones[i].setVisible(true);
			this.getContentPane().add(botones[i]);
		}
		
		botones[0].setText("Insertar");
		botones[1].setText("Consultar");
		botones[2].setText("Actualizar");
	}
	
}
