package ubu.lsi.dms.agenda.gui.campoTexto;

@SuppressWarnings("serial")
public class Campo_CodPostal extends CampoTexto {

	public Campo_CodPostal(String texto) {
		super(texto);
	}

	@Override
	public boolean estaCorrecto() {
		char[] listaCaracteres = this.getText().toCharArray();

		if (listaCaracteres.length != 5) {
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
