package ubu.lsi.dms.agenda.gui;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import ubu.lsi.dms.agenda.gui.mediador.Mediador;

@SuppressWarnings("serial")
public class JFrameFormulario extends JFrame {
	
	JTabbedPane tabbedPane = new JTabbedPane();
	JPanelContacto panelContacto;
	JPanelLlamada panelLlamada;
	JPanelTipoContacto panelTipoContacto;
	
	
	public JFrameFormulario(String nombre, Mediador mediador){
		super(nombre);
		setVisible(true);
		setLayout(new FlowLayout());
		setSize(800, 600);
		setLocation(400, 200);
		//setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		System.out.println("JFrameFormulario: " + mediador.getClass().getCanonicalName());
		panelContacto = new JPanelContacto(mediador.clone());
		panelLlamada = new JPanelLlamada(mediador.clone());
		panelTipoContacto = new JPanelTipoContacto(mediador.clone());
		
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
