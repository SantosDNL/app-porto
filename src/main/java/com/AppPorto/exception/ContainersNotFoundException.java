package com.AppPorto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ContainersNotFoundException extends RuntimeException{
	
		public ContainersNotFoundException(String id) {
			super("ID do Container não encontrado: " + id);
		}

}
