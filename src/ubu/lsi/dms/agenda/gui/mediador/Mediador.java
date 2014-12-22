package ubu.lsi.dms.agenda.gui.mediador;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import ubu.lsi.dms.agenda.gui.campoTexto.CampoTexto;

public abstract class Mediador implements Cloneable {

	private JComboBox<Integer> comboId;
	protected ArrayList<CampoTexto> camposTexto;
	protected ArrayList<JLabel> etiquetas;

	public ArrayList<JLabel> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(ArrayList<JLabel> etiquetas) {
		this.etiquetas = etiquetas;
	}

	private JButton botonAceptar;

	public JComboBox<Integer> getComboId() {
		return comboId;
	}

	public void setComboId(JComboBox<Integer> comboId) {
		this.comboId = comboId;
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

	public abstract void actualizarColegas();

	@Override
	public abstract Mediador clone();

}
