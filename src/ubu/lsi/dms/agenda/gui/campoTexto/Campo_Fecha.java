package ubu.lsi.dms.agenda.gui.campoTexto;

@SuppressWarnings("serial")
public class Campo_Fecha extends CampoTexto {

	public Campo_Fecha(String texto) {
		super(texto);
	}

	@Override
	public boolean estaCorrecto() {
		String cadenaCorrectaParaUnaFecha = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)?\\d\\d)";
		return getText().matches(cadenaCorrectaParaUnaFecha);
	}

}
