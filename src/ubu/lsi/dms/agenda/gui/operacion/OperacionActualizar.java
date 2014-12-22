package ubu.lsi.dms.agenda.gui.operacion;

import ubu.lsi.dms.agenda.gui.JPanelDato;

public class OperacionActualizar implements Operacion {

		@Override
		public void realizarOperacion(JPanelDato panelDato) {
			panelDato.actualizar();
		}

	}
