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
	
	Notificaciones notificaciones;
	
	@Before
	public void inicializar() {
		notificaciones = Notificaciones.getInstancia();
	}
	
	@Test
	public void notificacionesActuaComoSingleton() {
		Notificaciones test = Notificaciones.getInstancia();
	}
	
}
