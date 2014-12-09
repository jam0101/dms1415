package ubu.lsi.dms.agenda.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class JPanelContacto extends JPanelDato {
	
	private JLabel[] etiquetas = new JLabel[19];
	
	
	public JPanelContacto(){
		super();
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
		
		campoTexto.add(new JTextField("Id"));
		campoTexto.add(new JTextField("Nombre"));
		campoTexto.add(new JTextField("Apellidos"));
		campoTexto.add(new JTextField("Estimado"));
		campoTexto.add(new JTextField("Direccion"));
		campoTexto.add(new JTextField("Ciudad"));
		campoTexto.add(new JTextField("Prov"));
		campoTexto.add(new JTextField("Codigo postal"));
		campoTexto.add(new JTextField("Region"));
		campoTexto.add(new JTextField("Pais"));
		campoTexto.add(new JTextField("Nombre de la compania"));
		campoTexto.add(new JTextField("Cargo"));
		campoTexto.add(new JTextField("Telefono del trabajo"));
		campoTexto.add(new JTextField("Extension del trabajo"));
		campoTexto.add(new JTextField("Telefono movil"));
		campoTexto.add(new JTextField("Numero de fax"));
		campoTexto.add(new JTextField("E-mail"));
		campoTexto.add(new JTextField("Tipo de Contacto"));
		campoTexto.add(new JTextField("Notas"));
		
		add(etiquetas[0]);
		add(comboId);
		for(int i = 1; i < etiquetas.length; i++){
			this.add(etiquetas[i]);
			add(campoTexto.get(i - 1));
		}
		add(botonAceptar);
		setLayout(new GridLayout(10,2));
	}
	
}
