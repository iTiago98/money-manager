package Testing.CuentaTest;

import Testing.Cuenta.*;
import Testing.Exceptions.CuentaException;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq;

public class CuentaTest
{
	private String id;
	private Cuenta c;
	private HistorialCuenta hc;
	private IAdminCuenta admin;
	
	@Before
	public void inicializar() {
		id = "001";
		admin = mock(IAdminCuenta.class);
		c = new Cuenta(id, admin);
		hc = new HistorialCuenta();
	}
	
	@Test
	public void constructorCreaUnaCuentaCorrectamente() {
		when(admin.calcularUmbral(any(), eq(0))).thenReturn(0);
		
		assertEquals(hc.getGastos(), c.getHistorial().getGastos());
		assertEquals(hc.getIngresos(), c.getHistorial().getIngresos());
		assertEquals(id, c.getID());
		assertEquals(0, c.getFondosDisponibles());
		assertEquals(0, c.getUmbral());
	}
	
	@Test
	public void ingresarIncrementaFondosDisponiblesCorrectamente() {
		when(admin.calcularUmbral(any(), eq(100))).thenReturn(30);	
		c.ingresar("TODAY", 100);
		hc.addIngreso("TODAY", 100);
				
		assertEquals(hc.getGastos(), c.getHistorial().getGastos());
		assertEquals(hc.getIngresos(), c.getHistorial().getIngresos());
		assertEquals(id, c.getID());
		assertEquals(100, c.getFondosDisponibles());
		assertEquals(30, c.getUmbral());
	}
	
	@Test
	public void retirarDecrementaFondosDisponiblesCorrectamente() {
		when(admin.calcularUmbral(any(), eq(100))).thenReturn(30);
		when(admin.calcularUmbral(any(), eq(50))).thenReturn(15);
		c.ingresar("TODAY", 100);
		c.retirar("TODAY", 50);
		hc.addIngreso("TODAY", 100);
		hc.addGasto("TODAY", 50);
		
		assertEquals(hc.getGastos(), c.getHistorial().getGastos());
		assertEquals(hc.getIngresos(), c.getHistorial().getIngresos());
		assertEquals(id, c.getID());
		assertEquals(50, c.getFondosDisponibles());
		assertEquals(15, c.getUmbral());
	}
	
	@Test
	public void intentarRetirarMasDeLoQueHaySoloRetiraHastaCero() {
		when(admin.calcularUmbral(any(), eq(100))).thenReturn(30);
		when(admin.calcularUmbral(any(), eq(0))).thenReturn(0);
		c.ingresar("TODAY", 100);
		c.retirar("TODAY", 200);
		hc.addIngreso("TODAY", 100);
		hc.addGasto("TODAY", 100);
		
		assertEquals(hc.getGastos(), c.getHistorial().getGastos());
		assertEquals(hc.getIngresos(), c.getHistorial().getIngresos());
		assertEquals(id, c.getID());
		assertEquals(0, c.getFondosDisponibles());
		assertEquals(0, c.getUmbral());
	}
	
	@Test (expected = CuentaException.class)
	public void ingresarConValorNegativoLanzaCuentaException() {
		c.ingresar("TODAY", -1);
	}
	
	@Test (expected = CuentaException.class)
	public void retirarConValorNegativoLanzaCuentaException() {
		c.retirar("TODAY", -1);
	}
}
