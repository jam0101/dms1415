package ubu.lsi.dms.agenda.cliente;

import ubu.lsi.dms.agenda.gui.JFrameMenu;
import ubu.lsi.dms.agenda.modelo.ModeloDeDatos;

public class Cliente {
	
	public static final void main (String[] args){
		ModeloDeDatos modeloDeDatos = new ModeloDeDatos();
		new JFrameMenu("Agenda", modeloDeDatos);
	}
	
}
