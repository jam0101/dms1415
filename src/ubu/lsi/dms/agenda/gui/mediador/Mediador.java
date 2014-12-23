package ubu.lsi.dms.agenda.gui.mediador;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import ubu.lsi.dms.agenda.gui.campoTexto.CampoTexto;

public abstract class Mediador implements Cloneable {

	private ArrayList<CampoTexto> camposTexto;
	private ArrayList<JLabel> etiquetas;
	private JButton botonAceptar;
	private JScrollPane scrollPaneTabla;
	
	
	public ArrayList<JLabel> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(ArrayList<JLabel> etiquetas) {
		this.etiquetas = etiquetas;
	}

	
	public ArrayList<CampoTexto> getCamposTexto() {
		return camposTexto;
	}

	public void setCamposTexto(ArrayList<CampoTexto> camposTexto) {
		this.camposTexto = camposTexto;
	}
	

	public JButton getBotonAceptar() {
		return botonAceptar;
	}

	public void setBotonAceptar(JButton botonAceptar) {
		this.botonAceptar = botonAceptar;
	}
	
	
	public JScrollPane getScrollPaneTabla() {
		return scrollPaneTabla;
	}

	public void setScrollPaneTabla(JScrollPane scrollPaneTabla) {
		this.scrollPaneTabla = scrollPaneTabla;
	}
	

	public abstract void actualizarColegas();

	
	@Override
	public abstract Mediador clone();

	
}
