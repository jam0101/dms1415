package ubu.lsi.dms.agenda.gui.mediador;

import javax.swing.JTextField;

import ubu.lsi.dms.agenda.gui.campoTexto.CampoTexto;

public class MediadorConsulta extends Mediador {

	private final static String LABEL_APELLIDO = "Apellidos";
	private final static String LABEL_IDTIPO = "IdTipoContacto";
	private final static String LABEL_CONTACTO = "IdContacto";

	@Override
	public void actualizarColegas() {

		for (int i = 0; i < etiquetas.size(); i++) {
			if (etiquetas.get(i).getText() != LABEL_APELLIDO
					&& etiquetas.get(i).getText() != LABEL_IDTIPO
					&& etiquetas.get(i).getText() != LABEL_CONTACTO) {
				etiquetas.get(i).setVisible(false);
				etiquetas.get(i).setEnabled(false);
				camposTexto.get(i).setEnabled(false);
				camposTexto.get(i).setVisible(false);
			}
		}

		boolean todosLosCamposEstanCorrectos = true;
		for (CampoTexto campo : getCamposTexto()) {
			if (campo.isEnabled() && !campo.estaCorrecto()) {
				todosLosCamposEstanCorrectos = false;
			}
		}
		getBotonAceptar().setEnabled(todosLosCamposEstanCorrectos);
	}

	@Override
	public Mediador clone() {
		return new MediadorConsulta();
	}

}
