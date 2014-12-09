package ubu.lsi.dms.agenda.gui;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class JFrameFormulario extends JFrame {
	
	JTabbedPane tabbedPane = new JTabbedPane();
	JPanelContacto panelContacto = new JPanelContacto();
	JPanelLlamada panelLlamada = new JPanelLlamada();
	JPanelTipoContacto panelTipoContacto = new JPanelTipoContacto();
	
	
	public JFrameFormulario(String nombre){
		super(nombre);
		setVisible(true);
		setLayout(new FlowLayout());
		setSize(800, 600);
		setLocation(400, 200);
		//setResizable(false);
		
		inicializarComponentes();
	}
	
	public JTabbedPane getTabbedPane(){
		return tabbedPane;
	}
	
	
	public void inicializarComponentes(){
		this.getContentPane().add(tabbedPane);
		
		tabbedPane.addTab("Contacto", panelContacto);
		tabbedPane.addTab("Llamada", panelLlamada);
		tabbedPane.addTab("Tipo de Contacto", panelTipoContacto);
	
		
		JButton botonCerrar = new JButton("Cerrar");
		this.add(botonCerrar);
		botonCerrar.addMouseListener(new EscuchadorBotonCerrar());
	}
	
	
	private class EscuchadorBotonCerrar extends MouseAdapter{
		
		@Override
		public void mouseClicked(MouseEvent evento) {
			JFrameFormulario.this.dispose();
			new JFrameMenu("Menu");
		}
		
	}
}
