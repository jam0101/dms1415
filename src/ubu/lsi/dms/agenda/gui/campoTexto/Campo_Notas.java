package ubu.lsi.dms.agenda.gui.campoTexto;


@SuppressWarnings("serial")
public class Campo_Notas extends CampoTexto {

	public Campo_Notas(String texto) {
		super(texto);
	}

	@Override
	public boolean estaCorrecto() {
		return true;	//El campo Notas está bien siempre. Incluso si no tiene nada.
	}

}
