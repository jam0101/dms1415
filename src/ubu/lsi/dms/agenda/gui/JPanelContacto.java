package ubu.lsi.dms.agenda.gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import ubu.lsi.dms.agenda.gui.campoTexto.*;
import ubu.lsi.dms.agenda.gui.mediador.Mediador;

@SuppressWarnings("serial")
public class JPanelContacto extends JPanelDato {
	
	private JLabel[] etiquetas = new JLabel[19];
	
	public JPanelContacto(Mediador mediador){
		super(mediador);
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
		
		campoTexto.add(new Campo_SoloDigitos("Id"));
		campoTexto.add(new Campo_SoloLetras("Nombre"));
		campoTexto.add(new Campo_SoloLetras("Apellidos"));
		campoTexto.add(new Campo_SoloLetras("Estimado"));
		campoTexto.add(new Campo_Direccion("Direccion"));
		campoTexto.add(new Campo_SoloLetras("Ciudad"));
		campoTexto.add(new Campo_SoloLetras("Prov"));
		campoTexto.add(new Campo_CodPostal("Codigo postal"));
		campoTexto.add(new Campo_SoloLetras("Region"));
		campoTexto.add(new Campo_SoloLetras("Pais"));
		campoTexto.add(new Campo_SoloLetras("Nombre de la compania"));
		campoTexto.add(new Campo_SoloLetras("Cargo"));
		campoTexto.add(new Campo_SoloDigitos("Telefono del trabajo"));
		campoTexto.add(new Campo_SoloLetras("Extension del trabajo"));
		campoTexto.add(new Campo_SoloDigitos("Telefono movil"));
		campoTexto.add(new Campo_SoloDigitos("Numero de fax"));
		campoTexto.add(new Campo_Email("E-mail"));
		campoTexto.add(new Campo_SoloDigitos("Tipo de Contacto"));
		campoTexto.add(new Campo_Notas("Notas"));
		
		add(etiquetas[0]);
		
		add(comboId);
//		comboId.add
		
		for(int i = 1; i < etiquetas.length; i++){
			add(etiquetas[i]);
			
			add(campoTexto.get(i - 1));
			campoTexto.get(i - 1).getDocument().addDocumentListener(new ListenerFormulario());
		}
		
		add(botonAceptar);
		botonAceptar.setText("Aceptar (Contacto)");
		
		setLayout(new GridLayout(10,2));
		
		mediador.actualizarColegas();
	}
	
	
}
