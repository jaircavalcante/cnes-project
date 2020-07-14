package br.com.cnes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author jaircavalcante
 *
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NegocioException extends RuntimeException {

	private static final long serialVersionUID = 6774635773434860952L;

	public NegocioException(String message) {
		super(message);
	}

	public NegocioException(String message, Throwable cause) {
		super(message, cause);
	}
}
