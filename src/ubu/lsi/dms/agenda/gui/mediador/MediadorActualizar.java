package ubu.lsi.dms.agenda.gui.mediador;

import ubu.lsi.dms.agenda.gui.campoTexto.CampoTexto;

public class MediadorActualizar extends Mediador {

	@Override
	public void actualizarColegas() {
		boolean todosLosCamposEstanCorrectos = true;
		
//		if(getComboId().hayAlgoSeleccionado()){
//			getBotonAceptar().setEnabled(true);
//		} else {
//			getBotonAceptar().setEnabled(false);
//		}
		
		for(CampoTexto campo : getCamposTexto()){
			if(!campo.estaCorrecto()){
				todosLosCamposEstanCorrectos = false;
			}
		}
		
		getBotonAceptar().setEnabled(todosLosCamposEstanCorrectos);
		
	}

}
