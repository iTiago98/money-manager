package Patron.GeneradorIDs;

/*
 * La clase GeneradorIDs funciona como un patrón Singleton porque
 * sólo puede existir una clase que proporcione las IDs únicas a
 * los usuarios. De existir varias, podrían producirse problemas
 * a la hora de asignar las IDs, por ejemplo colisiones.
 */

public class GeneradorIDs {
	private static GeneradorIDs generador;
	private int id_count;
	
	private GeneradorIDs() {
		this.id_count = 0;
	}
	
	/*
	 * getInstancia(): GeneradorIDs
	 * 		Devuelve la instancia asociada con la clase GeneradorIDs.
	 * 		Si todavía no existe, se crea una nueva.
	 */
	public static GeneradorIDs getInstancia() {
		if(generador == null)
			generador = new GeneradorIDs();
		return generador;
	}
	
	/*
	 * generateID(Rol): String
	 * 		Dado un enum Rol, devuelve un ID único que incluye tanto
	 * 		el orden en el que se creó con respecto a otros usuarios
	 * 		como el rol que posee. 
	 * 
	 *		Por ejemplo, si ya se han creado 20 usuarios y se quiere
	 *		crear un supervisor de cuentas (valor 1), devolverá:
	 *		1 - 21
	 */
	public String generateID(Rol rol) {
		String id = new String();
		id += rol.getValue() + "-" + id_count++;
		return id;
	}
}
