package ubu.lsi.dms.agenda.gui.mediador;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;

import ubu.lsi.dms.agenda.gui.campoTexto.CampoTexto;

/**
 * Clase que se encarga de mediar entre los distintos "colegas" de los paneles
 * de los formularios.
 * 
 * @author Álvaro Ruiz Molledo
 * @author Javier de la Fuente Barrios
 * @author Jorge Alonso Márquez
 *
 */
public abstract class Mediador implements Cloneable {
	private JComboBox<Integer> comboId;

	public JComboBox<Integer> getComboId() {
		return comboId;
	}

	public void setComboId(JComboBox<Integer> comboId) {
		this.comboId = comboId;
	}

	/**
	 * Primer colega: Los campos de texto del panel del formulario.
	 */
	private ArrayList<CampoTexto> camposTexto;

	/**
	 * Segundo colega: Las etiquetas de texto del panel del formulario.
	 */
	private ArrayList<JLabel> etiquetas;

	/**
	 * Tercer colega: El botón de Aceptar del panel del formulario.
	 */
	private JButton botonAceptar;

	/**
	 * Cuarto colega: La tabla los resultados de una consulta.
	 */
	private JTable tabla;

	/**
	 * Devuelve el atributo etiquetas.
	 * 
	 * @return etiquetas
	 */
	public ArrayList<JLabel> getEtiquetas() {
		return etiquetas;
	}

	/**
	 * Asigna el atributo etiquetas.
	 * 
	 * @param etiquetas
	 */
	public void setEtiquetas(ArrayList<JLabel> etiquetas) {
		this.etiquetas = etiquetas;
	}

	/**
	 * Devuelve el atributo camposTexto.
	 * 
	 * @return camposTexto
	 */
	public ArrayList<CampoTexto> getCamposTexto() {
		return camposTexto;
	}

	/**
	 * Asigna el atributo camposTexto.
	 * 
	 * @param camposTexto
	 */
	public void setCamposTexto(ArrayList<CampoTexto> camposTexto) {
		this.camposTexto = camposTexto;
	}

	/**
	 * Devuelve el atributo botonAceptar.
	 * 
	 * @return botonAceptar
	 */
	public JButton getBotonAceptar() {
		return botonAceptar;
	}

	/**
	 * Asigna el atributo botonAceptar.
	 * 
	 * @param botonAceptar
	 */
	public void setBotonAceptar(JButton botonAceptar) {
		this.botonAceptar = botonAceptar;
	}

	public JTable getTabla() {
		return tabla;
	}

	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}

	/**
	 * Actualiza la visibilidad y demás estados de los distintos colegas.
	 */
	public abstract void actualizarColegas();

	/**
	 * Devuelve un clon de este objeto.
	 * 
	 * @return Mediador
	 */
	@Override
	public abstract Mediador clone();

}
