package NotificacionesTest;

import Notificaciones.*;

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.eq;

public class NotificacionTest {
	
	private TipoNotificacion tipo_mock;
	
	@Before
	public void inicializar() {
		//tipo_mock = mock(TipoNotificacion.class);
	}
	
	@Test
	public void notificacionesSeComportaComoSingleton() {
		// Se comportará como un singleton si cuando se vuelva a intentar
		// crear una instancia de una clase ya instanciada sobre otro objeto
		// no se devuelva una referencia nueva.
		Notificaciones arrayNotif = Notificaciones.getInstancia();
		Notificaciones arrayNotif2 = Notificaciones.getInstancia();
		
		assertTrue(arrayNotif.equals(arrayNotif2));
	}
	
	@Test
	public void lasNotificacionesSinMensajeNoSeAgregan() {
		Notificaciones arrayNotif = Notificaciones.getInstancia();
		int tam = arrayNotif.numeroNotificaciones();
		
		arrayNotif.addNotificacion(new Notificacion(TipoNotificacion.ADVERTENCIA));
		
		assertEquals(tam, arrayNotif.numeroNotificaciones());
	}
	
}
