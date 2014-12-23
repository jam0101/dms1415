package ubu.lsi.dms.agenda.gui.modeloDeLaTabla;

import java.util.ArrayList;
import ubu.lsi.dms.agenda.modelo.Llamada;

@SuppressWarnings({ "serial", "unchecked" })
public class ModeloDeLaTablaLlamada extends ModeloDeLaTabla {
	
	ArrayList<Llamada> llamadas;
	
	public ModeloDeLaTablaLlamada(String[] columnNames, ArrayList<Llamada> llamadas) {
		super(columnNames);
		this.llamadas = llamadas;
	}

	@Override
	public Object getValueAt(int row, int col) {
		switch(col){
		case 0:
			return llamadas.get(row).getIdLlamada();
		case 1:
			return llamadas.get(row).getContacto().getApellidos();
		case 2:
			return llamadas.get(row).getFechaLlamada();
		case 3:
			return llamadas.get(row).getAsunto();
		case 4:
			return llamadas.get(row).getNotas();
		default:
			return "";
		}		
	}

	@Override
	public int getRowCount() {
		return llamadas.size();
	}

}
