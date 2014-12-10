package ubu.lsi.dms.agenda.gui.campoTexto;

@SuppressWarnings("serial")
public class Campo_Direccion extends CampoTexto {

	public Campo_Direccion(String texto) {
		super(texto);
	}

	@Override
	public boolean estaCorrecto() {
		char[] listaCaracteres = this.getText().toCharArray();

		return (listaCaracteres.length > 0);
	}

}
