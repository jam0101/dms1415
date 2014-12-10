package ubu.lsi.dms.agenda.gui;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import ubu.lsi.dms.agenda.gui.campoTexto.CampoTexto;
import ubu.lsi.dms.agenda.gui.mediador.Mediador;

@SuppressWarnings("serial")
public abstract class JPanelDato extends JPanel {
	
	protected JComboBox<Integer> comboId;
	protected ArrayList<CampoTexto> campoTexto;
	protected JButton botonAceptar;
	
	protected Mediador mediador;
	
	public JPanelDato(Mediador mediador){
		comboId = new JComboBox<>();
		campoTexto = new ArrayList<>();
		botonAceptar = new JButton("Aceptar");
		
		this.mediador = mediador;
		this.mediador.setComboId(comboId);
		this.mediador.setCamposTexto(campoTexto);
		this.mediador.setBotonAceptar(botonAceptar);
	}
	
	protected class ListenerFormulario implements DocumentListener { 

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			mediador.actualizarColegas();
//			System.out.println("changedUpdate");
		}
		
		
		@Override
		public void insertUpdate(DocumentEvent arg0) {
			mediador.actualizarColegas();
//			System.out.println("insertUpdate");
		}
		
		
		@Override
		public void removeUpdate(DocumentEvent arg0) {
			mediador.actualizarColegas();
//			System.out.println("removeUpdate");
		}
    }
	
}
