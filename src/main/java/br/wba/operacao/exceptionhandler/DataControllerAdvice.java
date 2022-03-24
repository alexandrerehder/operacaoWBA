package br.wba.operacao.exceptionhandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(basePackages = "br.wba.operacao.controller")
public class DataControllerAdvice {
	
	@ResponseBody
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<MessageExceptionHandler> dataNotFound(DataNotFoundException dataNotFoundException){
	MessageExceptionHandler error = new MessageExceptionHandler(
			new Date(), HttpStatus.NOT_FOUND.value(), "Dados não encontrados");
	return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);	
	}
}
