package Testing.Exceptions;

public class CuentaException extends RuntimeException{
	
	public CuentaException() {
		super();
	}
	
	public CuentaException(String msg) {
		super(msg);
	}
}
