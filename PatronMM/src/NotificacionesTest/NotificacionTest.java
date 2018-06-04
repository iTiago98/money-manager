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
	public void elArrayDeNotificacionesSeComportaComoSingleton() {
		Notificaciones arrayNot = Notificaciones.getInstancia();
		Notificaciones arrayNot2 = Notificaciones.getInstancia();
		
		arrayNot.addNotificacion(new Notificacion(TipoNotificacion.ADVERTENCIA, "Hola"));
		
		assertTrue(arrayNot.getNotificacion(0).equals(arrayNot2.getNotificacion(0)));
	}
	
}
