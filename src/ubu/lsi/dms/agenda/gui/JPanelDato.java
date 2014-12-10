package ubu.lsi.dms.agenda.gui;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import ubu.lsi.dms.agenda.gui.campoTexto.CampoTexto;
import ubu.lsi.dms.agenda.gui.mediador.Mediador;

@SuppressWarnings("serial")
public abstract class JPanelDato extends JPanel{
	
	protected JComboBox<Integer> comboId = new JComboBox<>();
	protected ArrayList<CampoTexto> campoTexto = new ArrayList<>();
	protected JButton botonAceptar = new JButton("Aceptar");
	
	protected Mediador mediador;
	
	public JPanelDato(Mediador mediador){
		this.mediador = mediador;
		this.mediador.setComboId(comboId);
		this.mediador.setCamposTexto(campoTexto);
		this.mediador.setBotonAceptar(botonAceptar);
	}
}
