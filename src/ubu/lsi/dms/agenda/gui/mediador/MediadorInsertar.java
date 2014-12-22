package ubu.lsi.dms.agenda.gui.mediador;

import ubu.lsi.dms.agenda.gui.campoTexto.CampoTexto;

public class MediadorInsertar extends Mediador {

	@Override
	public void actualizarColegas() {
		boolean todosLosCamposEstanCorrectos = true;
		
		getComboId().setEnabled(false);
		
		for(CampoTexto campo : getCamposTexto()){
			if(!campo.estaCorrecto()){
				if(!campo.getText().equals("")){
					System.err.println(campo.getText() + " no es un valor correcto.");
				}
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
