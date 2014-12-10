package ubu.lsi.dms.agenda.gui.mediador;

import javax.swing.JTextField;

public class MediadorConsulta extends Mediador{

	@Override
	public void actualizarColegas() {
		
		for(JTextField campo : getCamposTexto()){
			campo.setEnabled(false);
		}
		
		getBotonAceptar().setVisible(false);
	}

}
