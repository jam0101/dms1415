package ubu.lsi.dms.agenda.modelo;

import java.util.Collection;
import java.util.Vector;

public class ModeloDeDatos {

	private Collection<Contacto> contactos;
	private Collection<Llamada> llamadas;
	private Collection<TipoContacto> tiposContacto;

	public ModeloDeDatos() {
		contactos = new Vector<Contacto>();
		llamadas = new Vector<Llamada>();
		tiposContacto = new Vector<TipoContacto>();
		inicializarValores();
	}

	public Collection<Contacto> getContactos() {
		return contactos;
	}

	public Collection<Llamada> getLlamadas() {
		return llamadas;
	}

	public Collection<TipoContacto> getTiposContacto() {
		return tiposContacto;
	}

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
