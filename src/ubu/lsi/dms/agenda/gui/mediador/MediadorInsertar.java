package ubu.lsi.dms.agenda.gui.mediador;

import ubu.lsi.dms.agenda.gui.campoTexto.CampoTexto;

public class MediadorInsertar extends Mediador {

	@Override
	public void actualizarColegas() {
		boolean todosLosCamposEstanCorrectos = true;
		
		getComboId().setEnabled(false);
		
		for(CampoTexto campo : getCamposTexto()){
			if(!campo.estaCorrecto()){
				todosLosCamposEstanCorrectos = false;
			}
		}
		
		getBotonAceptar().setEnabled(todosLosCamposEstanCorrectos);
	}
	
	
	@Override
	 public Mediador clone()   {
	      return new MediadorInsertar();
	 }
}
