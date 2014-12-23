package ubu.lsi.dms.agenda.gui.modeloDeLaTabla;

import java.util.ArrayList;
import java.util.Collection;

import ubu.lsi.dms.agenda.modelo.Contacto;

@SuppressWarnings({ "serial", "unchecked" })
public class ModeloDeLaTablaContacto extends ModeloDeLaTabla {
	
	ArrayList<Contacto> contactos;
	
	public ModeloDeLaTablaContacto(String[] columnNames, ArrayList<Contacto> contactos) {
		super(columnNames);
		this.contactos = contactos;
	}

	@Override
	public Object getValueAt(int row, int col) {
		switch(col){
		case 0:
			return contactos.get(row).getIdContacto();
		case 1:
			return contactos.get(row).getNombre();
		case 2:
			return contactos.get(row).getApellidos();
		case 3:
			return contactos.get(row).getEstimado();
		case 4:
			return contactos.get(row).getDireccion();
		case 5:
			return contactos.get(row).getCiudad();
		case 6:
			return contactos.get(row).getProv();
		case 7:
			return contactos.get(row).getCodPostal();
		case 8:
			return contactos.get(row).getRegion();
		case 9:
			return contactos.get(row).getPais();
		case 10:
			return contactos.get(row).getNombreCompania();
		case 11:
			return contactos.get(row).getCargo();
		case 12:
			return contactos.get(row).getTelefonoTrabajo();
		case 13:
			return contactos.get(row).getExtensionTrabajo();
		case 14:
			return contactos.get(row).getTelefonoMovil();
		case 15:
			return contactos.get(row).getNumFax();
		case 16:
			return contactos.get(row).getNomCorreoElectronico();
		case 17:
			return contactos.get(row).getTipoContacto().getTipoContacto();
		case 18:
			return contactos.get(row).getNotas();
		default:
			return "";
		}		
	}

	@Override
	public int getRowCount() {
		return contactos.size();
	}

}
