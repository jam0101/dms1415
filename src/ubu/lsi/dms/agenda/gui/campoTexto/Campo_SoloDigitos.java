package ubu.lsi.dms.agenda.gui.campoTexto;

@SuppressWarnings("serial")
public class Campo_SoloDigitos extends CampoTexto {

	public Campo_SoloDigitos(String texto) {
		super(texto);
	}

	@Override
	public boolean estaCorrecto() {
		char[] listaCaracteres = this.getText().toCharArray();

		if (listaCaracteres.length == 0) {
			return false;
		}

		for (Character c : this.getText().toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}

		return true;
	}

}
