package ubu.lsi.dms.agenda.gui.campoTexto;

@SuppressWarnings("serial")
public class Campo_Fecha extends CampoTexto {

	public Campo_Fecha(String texto) {
		super(texto);
	}

	@Override
	public boolean estaCorrecto() {
char[] listaCaracteres = this.getText().toCharArray();
		
		if (listaCaracteres.length != 10){
			return false;
		}
		
		if(	!Character.isDigit(listaCaracteres[0])	||	//Formato fecha:  DD/MM/AAAA
			!Character.isDigit(listaCaracteres[1])	||
			listaCaracteres[2] != '/'				||
			!Character.isDigit(listaCaracteres[3])	||
			!Character.isDigit(listaCaracteres[4])	||
			listaCaracteres[5] != '/'				||
			!Character.isDigit(listaCaracteres[6])	||
			!Character.isDigit(listaCaracteres[7])	||
			!Character.isDigit(listaCaracteres[8])	||
			!Character.isDigit(listaCaracteres[9])
				){
			return false;
		}
		
		return true;
	}

}
