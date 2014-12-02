package ubu.lsi.dms.agenda.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JPanelContacto extends JPanel {
	
	JLabel[] etiquetas = new JLabel[19]; 
	
	public JPanelContacto(){
		etiquetas[0] = new JLabel("Id");
		etiquetas[1] = new JLabel("Nombre");
		etiquetas[2] = new JLabel("Apellidos");
		etiquetas[3] = new JLabel("Estimado");
		etiquetas[4] = new JLabel("Direccion");
		etiquetas[5] = new JLabel("Ciudad");
		etiquetas[6] = new JLabel("Prov");
		etiquetas[7] = new JLabel("Codigo postal");
		etiquetas[8] = new JLabel("Region");
		etiquetas[9] = new JLabel("Pais");
		etiquetas[10] = new JLabel("Nombre de la compania");
		etiquetas[11] = new JLabel("Cargo");
		etiquetas[12] = new JLabel("Telefono del trabajo");
		etiquetas[13] = new JLabel("Extension del trabajo");
		etiquetas[14] = new JLabel("Telefono movil");
		etiquetas[15] = new JLabel("Numero de fax");
		etiquetas[16] = new JLabel("E-mail");
		etiquetas[17] = new JLabel("Tipo de Contacto");
		etiquetas[18] = new JLabel("Notas");
		
		for(int i = 0; i < etiquetas.length; i++){
			this.add(etiquetas[i]);
		}
	}
}
