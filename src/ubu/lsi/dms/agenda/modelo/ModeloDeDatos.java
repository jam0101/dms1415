package ubu.lsi.dms.agenda.modelo;

import java.util.ArrayList;

/**
 * Clase de datos que contiene los datos sobre los que trabaja la aplicación.
 * 
 * @author Álvaro Ruiz Molledo
 * @author Javier de la Fuente Barrios
 * @author Jorge Alonso Márquez
 *
 */
public class ModeloDeDatos {
	
	/**
	 * Lista con los Contactos que estarían en la base de datos.
	 */
	private ArrayList<Contacto> contactos;

	/**
	 * Lista con las Llamadas que estarían en la base de datos.
	 */
	private ArrayList<Llamada> llamadas;

	/**
	 * Lista con los Tipos de Contacto que estarían en la base de datos.
	 */
	private ArrayList<TipoContacto> tiposContacto;
	
	
	/**
	 * Constructor de la clase.
	 */
	public ModeloDeDatos() {
		contactos = new ArrayList<Contacto>();
		llamadas = new ArrayList<Llamada>();
		tiposContacto = new ArrayList<TipoContacto>();
		inicializarValores();
	}
	

	/**
	 * Añade un Contacto, o, si la id ya existe, lo actualiza.
	 *
	 * @param id 				Id del Contacto.
	 * @param nombre			Nombre del Contacto.
	 * @param apellidos			Apellidos del Contacto.
	 * @param estimado			Estimado.
	 * @param direccion			Dirección del Contacto.
	 * @param ciudad			Ciudad del Contacto.
	 * @param prov				Provincia del Contacto.
	 * @param codPostal			Código Postal del Contacto.
	 * @param region			Región del Contacto.
	 * @param pais				País del Contacto.
	 * @param nombreCompania	Nombre de la compañía del Contacto.
	 * @param cargo				Cargo del Contacto.
	 * @param telfTrabajo		Teléfono de trabajo del Contacto.
	 * @param extensionTrabajo	Extensión del trabajo del Contacto.
	 * @param telfMovil			Teléfono móvil del Contacto.
	 * @param numFax			Número de fax del Contacto.
	 * @param email				E-mail del Contacto.
	 * @param idTipoContacto	Id del Tipo de Contacto del Contacto.
	 * @param notas				Otras notas.
	 */
	public void addContacto(String id, String nombre, String apellidos,
			String estimado, String direccion, String ciudad, String prov,
			String codPostal, String region, String pais,
			String nombreCompania, String cargo, String telfTrabajo,
			String extensionTrabajo, String telfMovil, String numFax,
			String email, String idTipoContacto, String notas) {

		TipoContacto tc = null;
		for (TipoContacto c : tiposContacto) {
			if (c.getIdTipoContacto() == Integer.parseInt(idTipoContacto)) {
				tc = c;
				break;
			}
		}

		// Comprobar si ya existe el contacto
		for (Contacto c : contactos) {
			if (Integer.parseInt(id) == c.getIdContacto()) {
				// Actualizar
				c.setNombre(nombre);
				c.setApellidos(apellidos);
				c.setEstimado(estimado);
				c.setDireccion(direccion);
				c.setCiudad(ciudad);
				c.setProv(prov);
				c.setCodPostal(codPostal);
				c.setRegion(region);
				c.setPais(pais);
				c.setNombreCompania(nombreCompania);
				c.setCargo(cargo);
				c.setTelefonoTrabajo(telfTrabajo);
				c.setExtensionTrabajo(extensionTrabajo);
				c.setTelefonoMovil(telfMovil);
				c.setNumFax(numFax);
				c.setNomCorreoElectronico(email);
				c.setTipoContacto(tc);
				c.setNotas(notas);
				return;
			}
		}

		// Insertar
		Contacto contacto = new Contacto(Integer.parseInt(id), nombre,
				apellidos, estimado, direccion, ciudad, prov, codPostal,
				region, pais, nombreCompania, cargo, telfTrabajo,
				extensionTrabajo, telfMovil, numFax, email, notas, tc);
		contactos.add(contacto);
	}
	
	
	/**
	 *  Añade una Llamada, o, si la id ya existe, lo actualiza.
	 *  
	 * @param id			Id de la Llamada.
	 * @param idContacto	Id del Contacto asociado a la Llamada.
	 * @param fechaLlamada	Fecha de la Llamada.
	 * @param asunto		Asunto de la Llamada.
	 * @param notas			Otras notas.
	 */
	public void addLlamada(String id, String idContacto, String fechaLlamada,
			String asunto, String notas) {
		Contacto contacto = null;
		for (Contacto c : contactos) {
			if (c.getIdContacto() == Integer.parseInt(idContacto)) {
				contacto = c;
				break;
			}
		}

		// Actualizar llamada
		for (Llamada l : llamadas) {
			if (Integer.parseInt(id) == l.getIdLlamada()) {
				l.setContacto(contacto);
				l.setFechaLlamada(fechaLlamada);
				l.setAsunto(asunto);
				l.setNotas(notas);
				return;
			}
		}

		// Insertar
		Llamada llamada = new Llamada(Integer.parseInt(id), contacto,
				fechaLlamada, asunto, notas);
		llamadas.add(llamada);
	}
	
	
	/**
	 * Añade un Tipo de Contacto, o, si la id ya existe, lo actualiza.
	 * 
	 * @param id	Id del Tipo de Contacto.
	 * @param tipo	Tipo.
	 */
	public void addTipoContacto(String id, String tipo) {
		for (TipoContacto tc : tiposContacto) {
			if (Integer.parseInt(id) == tc.getIdTipoContacto()) {
				tc.setTipoContacto(tipo);
				return;
			}
		}
		
		// Insertar
		TipoContacto tipoContacto = new TipoContacto(Integer.parseInt(id), tipo);
		tiposContacto.add(tipoContacto);
	}
	
	
	/**
	 * Devuelve la lista de Contactos.
	 * 
	 * @return contactos
	 */
	public ArrayList<Contacto> getContactos() {
		return contactos;
	}
	
	
	/**
	 * Devuelve la lista de Llamadas.
	 * 
	 * @return llamadas
	 */
	public ArrayList<Llamada> getLlamadas() {
		return llamadas;
	}
	
	
	/**
	 * Devuelve la lista de Tipos de Contacto.
	 * 
	 * @return tiposContacto
	 */
	public ArrayList<TipoContacto> getTiposContacto() {
		return tiposContacto;
	}
	
	
	/**
	 * Crea unos valores por defectos para la base de datos con los que poder trabajar.
	 */
	private void inicializarValores() {
		TipoContacto tc1 = new TipoContacto(1, "alumno");
		TipoContacto tc2 = new TipoContacto(2, "profesor");
		TipoContacto tc3 = new TipoContacto(3, "director");
		TipoContacto tc4 = new TipoContacto(4, "obrero");
		TipoContacto tc5 = new TipoContacto(5, "ayudante");
		tiposContacto.add(tc1);
		tiposContacto.add(tc2);
		tiposContacto.add(tc3);
		tiposContacto.add(tc4);
		tiposContacto.add(tc5);

		Contacto c1 = new Contacto(1, "juan", "martin", "sr",
				"calle madrid, nº 20, 4ºB", "Burgos", "Burgos", "09003",
				"Castilla y leon", "españa", "BBVA", "cajero", "953452185",
				"43", "673123452", "923452156", "jm5@bbva.es",
				"cumpleaños: 5 de enero", tc1);
		Contacto c2 = new Contacto(2, "pepe", "fernandez", "sr",
				"calle gijon, nº 55, 1ºB", "madrid", "madrid", "09082",
				"madrid", "españa", "vodafone", "Rrhh", "643326212", "41",
				"633243236", "983948393", "pf99@vf.es", "2 hijos", tc2);
		Contacto c3 = new Contacto(3, "maria", "gonzalez", "srta",
				"avda cantabria, 15, 9ºA", "burgos", "burgos", "09001", "cyl",
				"españa", "apple", "atencion al publico", "952528690", "51",
				"623452127", "952596432", "mg333@apple.es", "-", tc3);
		Contacto c4 = new Contacto(4, "jose", "perez", "sr",
				"calle valladolid, nº 5, 4ºE", "Burgos", "burgos", "09001",
				"cyl", "españa", "zara", "director", "923454961", "92",
				"622352151", "952521190", "jp21@zara.com",
				"cumpleaños:  5 de junio", tc4);
		Contacto c5 = new Contacto(5, "sofia", "martinez", "srta",
				"calle barcelona, nº 15, 4ºA", "Valadolid", "valladolid",
				"32134", "cyl", "españa", "diario de burgos", "periodista",
				"962032156", "962345212", "634452102", "953212562",
				"sfm23@db.com", "-", tc5);
		contactos.add(c1);
		contactos.add(c2);
		contactos.add(c3);
		contactos.add(c4);
		contactos.add(c5);

		Llamada l1 = new Llamada(1, c1, "2014-10-18 01:30:00", "ventas",
				"futura reunion en 7 dias");
		Llamada l2 = new Llamada(2, c2, "2014-1-12 14:15:00", "stock", "-");
		Llamada l3 = new Llamada(3, c3, "2014-8-3 13:24:00", "personal",
				"todo bien");
		Llamada l4 = new Llamada(4, c2, "2014-7-22 22:33:00", "interes",
				"no hay interes");
		Llamada l5 = new Llamada(5, c4, "2014-1-15 15:45:00", "acciones",
				"vender");
		Llamada l6 = new Llamada(6, c5, "2014-3-30 10:66:00", "reunion",
				"lunes 15 a las 10:00");

		Llamada l7 = new Llamada(8, c5, "2001-3-30 10:66:00", "reunion",
				"lunes 15 a las 10:00");
		Llamada l8 = new Llamada(9, c5, "2002-3-30 10:66:00", "reunion",
				"lunes 15 a las 10:00");
		Llamada l9 = new Llamada(10, c5, "2003-3-30 10:66:00", "reunion",
				"lunes 15 a las 10:00");
		Llamada l10 = new Llamada(11, c5, "2004-3-30 10:66:00", "reunion",
				"lunes 15 a las 10:00");
		Llamada l11 = new Llamada(12, c5, "2005-3-30 10:66:00", "reunion",
				"lunes 15 a las 10:00");
		Llamada l12 = new Llamada(7, c5, "2000-3-30 10:66:00", "reunion",
				"lunes 15 a las 10:00");

		llamadas.add(l1);
		llamadas.add(l2);
		llamadas.add(l3);
		llamadas.add(l4);
		llamadas.add(l5);
		llamadas.add(l6);
		llamadas.add(l7);
		llamadas.add(l8);
		llamadas.add(l9);
		llamadas.add(l10);
		llamadas.add(l11);
		llamadas.add(l12);
	}

}
