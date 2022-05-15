package ec.gob.como.domain.exception;

public class ClienteNoExisteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ClienteNoExisteException(String nombre) {
		super("No se encuentra ese cliente %s !"+nombre);
		
	}
	

}
