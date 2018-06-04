package Notificaciones;

public class Notificacion {
	private TipoNotificacion tipoNotificacion;
	private String textoNotificacion;
	
	/*
	 * Constructores
	 */
	public Notificacion(TipoNotificacion tipo, String texto) {
		this.tipoNotificacion = tipo;
		this.textoNotificacion = texto;
	}
	
	public Notificacion(TipoNotificacion tipo) {
		this.tipoNotificacion = tipo;
	}
	
	/*****/
	// NO están en el diagrama pero son necesarios
	public String getTexto() {
		return this.textoNotificacion;
	}
	
	public TipoNotificacion getTipo() {
		return this.tipoNotificacion;
	}
	
	/*****/
	
	/*
	 * setNotificacion():
	 * Modifica el contenido (texto) de una notifiacion
	 */
	public void setNotificacion(String texto) {
		this.textoNotificacion = texto;
	}
	
}
