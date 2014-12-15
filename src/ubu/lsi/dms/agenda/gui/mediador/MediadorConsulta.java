package ubu.lsi.dms.agenda.gui.mediador;

import javax.swing.JTextField;

public class MediadorConsulta extends Mediador {

	@Override
	public void actualizarColegas() {
		
		for(JTextField campo : getCamposTexto()){
			campo.setEnabled(false);
			campo.setVisible(false);
		}
		
		getBotonAceptar().setText("Consultar");
	}
	
	
	@Override
	 public Mediador clone()   {
	      return new MediadorConsulta();
	 }

}
