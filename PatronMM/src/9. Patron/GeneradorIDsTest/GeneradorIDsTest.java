package Patron.GeneradorIDsTest;

import Patron.GeneradorIDs.*;

import org.junit.*;
import static org.junit.Assert.*;


public class GeneradorIDsTest {
	
	private GeneradorIDs generador;
	
	@Before
	public void inicializar() {
		generador = GeneradorIDs.getInstancia();
	}
	
	@Test
	public void generadorIDsSeComportaComoSingleton() {
		GeneradorIDs generador2 = GeneradorIDs.getInstancia();
		assertEquals(generador, generador2);
	}
	
	@Test
	public void generadorIDsGeneraIDsDeFormaSecuencial() {
		String user, user2, acc_supervisor, gen_supervisor, gen_supervisor_generador2;
		
		/******/
		
		// El mismo generador genera IDs de forma secuencial
		user = generador.generateID(Rol.USUARIO);
		user2 = generador.generateID(Rol.USUARIO);
		assertFalse(user.equals(user2));
		acc_supervisor = generador.generateID(Rol.SUPERVISOR_CUENTAS);
		assertFalse(user2.equals(acc_supervisor));
		gen_supervisor = generador.generateID(Rol.SUPERVISOR_GENERAL);
		assertFalse(acc_supervisor.equals(gen_supervisor));
		
		/******/
		
		// Otro generador (realmente el mismo) debe seguir esa secuencialidad
		// al tratarse de un singleton.
		GeneradorIDs generador2 = GeneradorIDs.getInstancia();
		gen_supervisor_generador2 = generador2.generateID(Rol.SUPERVISOR_GENERAL);
		assertFalse(gen_supervisor.equals(gen_supervisor_generador2));
		
		/*
		System.out.println(
			user + "\n" +
			user2 + "\n" +
			acc_supervisor + "\n" +
			gen_supervisor + "\n" +
			gen_supervisor_generador2
		);
		*/
	}
}