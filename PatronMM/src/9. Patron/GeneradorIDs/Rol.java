package Patron.GeneradorIDs;

public enum Rol {
	USUARIO(0),
	SUPERVISOR_CUENTAS(1),
	SUPERVISOR_GENERAL(2);
	
	private final int valor;
	
	private Rol(int valor) {
		this.valor = valor;
	}
	
	public int getValue() {
		return this.valor;
	}
}
