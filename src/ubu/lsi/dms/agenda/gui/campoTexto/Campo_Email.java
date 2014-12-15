package ubu.lsi.dms.agenda.gui.campoTexto;

@SuppressWarnings("serial")
public class Campo_Email extends CampoTexto {

	public Campo_Email(String texto) {
		super(texto);
	}

	@Override
	public boolean estaCorrecto() {
		String cadenaCorrectaParaUnEmail = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return getText().matches(cadenaCorrectaParaUnEmail);
	}
}
