package Testing.Cuenta;

import Testing.Exceptions.CuentaException;

public class Cuenta
{
	private IAdminCuenta admin;
	private HistorialCuenta hist;
	
	private String IDCliente;
	private int fondosDisponibles;
	private int umbral;
	
	public Cuenta(String id, IAdminCuenta admin) {
		this.admin = admin;
		IDCliente = id;
		fondosDisponibles = 0;
		hist = new HistorialCuenta();
		umbral = admin.calcularUmbral(hist, fondosDisponibles);
}
	
	public void ingresar(String fecha, int cantidad) {
		if(cantidad <= 0) throw new CuentaException("El valor debe ser positivo.");
		fondosDisponibles+=cantidad;
		hist.addIngreso(fecha, cantidad);
		umbral = admin.calcularUmbral(hist, fondosDisponibles);
	}
	
	public void retirar(String fecha, int cantidad) {
		if(cantidad <= 0) throw new CuentaException("El valor debe ser positivo.");
		cantidad = (fondosDisponibles-cantidad < 0) ? fondosDisponibles : cantidad;
		fondosDisponibles-=cantidad;
		hist.addGasto(fecha, cantidad);
		umbral = admin.calcularUmbral(hist, fondosDisponibles);
	}
	
	public HistorialCuenta getHistorial() {
		return hist;
	}
	
	public String getID() {
		return IDCliente;
	}
	
	public int getFondosDisponibles() {
		return fondosDisponibles;
	}
	
	public int getUmbral() {
		return umbral;
	}
}
