package Testing.Cuenta;

import java.util.ArrayList;
import java.util.List;

public class HistorialCuenta {
	private List<String> ingresos;
	private List<String> gastos;
	
	public HistorialCuenta() {
		ingresos = new ArrayList<String>();
		gastos = new ArrayList<String>();
	}
	
	public List<String> getIngresos() {
		return ingresos;
	}
	
	public List<String> getGastos() {
		return gastos;
	}
	
	public void addIngreso(String fecha, int abs) {
		ingresos.add("Ingreso "+abs+" "+fecha);
	}
	
	public void addGasto(String fecha, int abs) {
		gastos.add("Gasto "+abs+" "+fecha);
	}
}
