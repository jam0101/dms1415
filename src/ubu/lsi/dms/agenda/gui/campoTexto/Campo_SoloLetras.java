package ubu.lsi.dms.agenda.gui.campoTexto;

@SuppressWarnings("serial")
public class Campo_SoloLetras extends CampoTexto {

	public Campo_SoloLetras(String texto) {
		super(texto);
	}

	@Override
	public boolean estaCorrecto() {
		char[] listaCaracteres = this.getText().toCharArray();
		
		if (listaCaracteres.length == 0){
			return false;
		}
		
		for(Character c : listaCaracteres){
			if(!Character.isAlphabetic(c)){
				return false;
			}
		}
		
		return true;
	}

}
