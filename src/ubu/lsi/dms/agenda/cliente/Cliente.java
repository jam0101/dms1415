package ubu.lsi.dms.agenda.cliente;

import ubu.lsi.dms.agenda.gui.JFrameMenu;
import ubu.lsi.dms.agenda.modelo.ModeloDeDatos;

/**
 * Clase cliente que contiene el main del programa.
 * 
 * @author Álvaro Ruiz Molledo
 * @author Javier de la Fuente Barrios
 * @author Jorge Alonso Márquez
 *
 */
public class Cliente {
	
	/**
	 * Función mail del programa.
	 *  
	 * @param args Argumentos de entrada del programa.
	 */
	public static final void main (String[] args){
		ModeloDeDatos modeloDeDatos = new ModeloDeDatos();
		new JFrameMenu("Agenda", modeloDeDatos);
	}
	
}
