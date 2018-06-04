package Notificaciones;

import java.util.ArrayList;

/*
 * Clase Notificaciones:
 * Se trata de una colección que hace referencia a las diferentes
 * notificaciones del usuario.
 * 
 * Se comporta igual que un patrón Singleton.
 */
public class Notificaciones {
	private ArrayList<Notificacion> notificaciones;
	private static Notificaciones instanciaNotificaciones;
	
	/*
	 * Constructores.
	 * Privados para mantener la naturaleza del Singleton.
	 */
	private Notificaciones(ArrayList<Notificacion> notificaciones) {
		this.notificaciones = notificaciones;
	}
	
	private Notificaciones() {
		this(new ArrayList<Notificacion>());
	}
	
	/*
	 * Devuelve la instancia, si no existe se crea con el
	 * constructor por defecto.
	 */
	public static Notificaciones getInstancia() {
		if(instanciaNotificaciones == null)
			instanciaNotificaciones = new Notificaciones();
		return instanciaNotificaciones;
	}
	
	/****/
	// Están en el diagrama
	
	/*
	 * addNotificacion():
	 * Añade la notificación si ésta tiene texto.
	 */
	public void addNotificacion(Notificacion not) {
		if(not.getTexto() != null)
			this.notificaciones.add(not);
	}
	
	/*
	 * getNotificacion(indx):
	 * Devuelve la notificación especificada por el indice (indx).
	 * Si no se encuentra, devuelve la última notificación guardada.
	 * No elimina la notificación.
	 */
	public Notificacion getNotificacion(int indx) throws NotificacionException {
		if(notificaciones.isEmpty()) throw new NotificacionException("Array de notificaciones vacío");
		else
			return (indx >= notificaciones.size() || indx < 0)?
				notificaciones.get(notificaciones.size() - 1):
				notificaciones.get(indx);
	}
	
	/*
	 * getNotificacion():
	 * Por defecto devuelve la última notificación guardada
	 * sin eliminarla.
	 */
	public Notificacion getNotificacion() {
		return this.getNotificacion(notificaciones.size() - 1);
	}
	
	/*
	 * deleteNotificacion():
	 * Elimina la notificación en la posición indx, si no
	 * existe lanza una excepción.
	 */
	public void deleteNotificacion(int indx) throws NotificacionException {
		try {
			notificaciones.remove(indx);
		} catch(IndexOutOfBoundsException e) {
			throw new NotificacionException(e.getMessage());
		}
	}
	
	public void deleteNotificacion() throws NotificacionException {
		this.deleteNotificacion(notificaciones.size() - 1);
	}
	/****/
	
	/*
	 * numeroNotificaciones()
	 * Devuelve el número de notificaciones almacenadas.
	 */
	public int numeroNotificaciones() {
		return this.notificaciones.size();
	}
}
