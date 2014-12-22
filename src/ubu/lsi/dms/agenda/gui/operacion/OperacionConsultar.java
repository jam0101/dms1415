package ubu.lsi.dms.agenda.gui.operacion;

import ubu.lsi.dms.agenda.gui.JPanelDato;

public class OperacionConsultar implements Operacion {

		@Override
		public void realizarOperacion(JPanelDato panelDato) {
			panelDato.consultar();
		}

	}
