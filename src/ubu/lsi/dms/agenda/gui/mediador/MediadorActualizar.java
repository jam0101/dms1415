package ubu.lsi.dms.agenda.gui.mediador;

import ubu.lsi.dms.agenda.gui.campoTexto.CampoTexto;

public class MediadorActualizar extends Mediador {

	private static int POSICION_ID = 0;
	@Override
	public void actualizarColegas() {
		boolean todosLosCamposEstanCorrectos = true;
		
//		if(getComboId().hayAlgoSeleccionado()){
//			getBotonAceptar().setEnabled(true);
//		} else {
//			getBotonAceptar().setEnabled(false);
//		}
		
		getCamposTexto().get(POSICION_ID).setVisible(false);
		getBotonAceptar().setText("Actualizar");
		
		for(CampoTexto campo : getCamposTexto()){
			if(!campo.estaCorrecto()){
				todosLosCamposEstanCorrectos = false;
			}
		}
		
		getBotonAceptar().setEnabled(todosLosCamposEstanCorrectos);
	}
	
	
	@Override
	 public Mediador clone()   {
	      return new MediadorActualizar();
	 }
}
