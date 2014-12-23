package ubu.lsi.dms.agenda.gui.modeloDeLaTabla;

import java.util.ArrayList;
import ubu.lsi.dms.agenda.modelo.TipoContacto;

@SuppressWarnings({ "serial", "unchecked" })
public class ModeloDeLaTablaTipoContacto extends ModeloDeLaTabla {
	
	ArrayList<TipoContacto> tiposContacto;
	
	public ModeloDeLaTablaTipoContacto(String[] columnNames, ArrayList<TipoContacto> tiposContacto) {
		super(columnNames);
		this.tiposContacto = tiposContacto;
	}

	@Override
	public Object getValueAt(int row, int col) {
		switch(col){
		case 0:
			return tiposContacto.get(row).getIdTipoContacto();
		case 1:
			return tiposContacto.get(row).getTipoContacto();
		default:
			return "";
		}		
	}

	@Override
	public int getRowCount() {
		return tiposContacto.size();
	}

}
