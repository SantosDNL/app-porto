package com.AppPorto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class MovimentacaoNotFoundException extends RuntimeException{

	public MovimentacaoNotFoundException (String id) {
		super("ID da Movimentação não encontrado: " + id);
	}
	
}
