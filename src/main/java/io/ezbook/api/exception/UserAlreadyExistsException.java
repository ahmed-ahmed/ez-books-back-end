package io.ezbook.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 8533264446769665566L;

	public UserAlreadyExistsException(String exception) {
		super(exception);
	}
}