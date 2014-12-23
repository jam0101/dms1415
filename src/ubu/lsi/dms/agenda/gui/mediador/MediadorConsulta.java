package ubu.lsi.dms.agenda.gui.mediador;

import ubu.lsi.dms.agenda.gui.campoTexto.CampoTexto;

public class MediadorConsulta extends Mediador {

	private final static String LABEL_APELLIDO = "Apellidos";
	private final static String LABEL_IDTIPO = "IdTipoContacto";
	private final static String LABEL_CONTACTO = "IdContacto";

	@Override
	public void actualizarColegas() {

		for (int i = 0; i < getEtiquetas().size(); i++) {
			if (getEtiquetas().get(i).getText() != LABEL_APELLIDO
					&& getEtiquetas().get(i).getText() != LABEL_IDTIPO
					&& getEtiquetas().get(i).getText() != LABEL_CONTACTO) {
				getEtiquetas().get(i).setVisible(false);
				getEtiquetas().get(i).setEnabled(false);
				getCamposTexto().get(i).setEnabled(false);
				getCamposTexto().get(i).setVisible(false);
			}
		}
		getScrollPaneTabla().setVisible(true);
		
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
