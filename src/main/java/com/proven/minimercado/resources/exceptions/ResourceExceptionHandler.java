package com.proven.minimercado.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.proven.minimercado.servicos.exceptions.BancoDadosException;
import com.proven.minimercado.servicos.exceptions.ResourceNaoAchadoException;

@ControllerAdvice // Essa anotattion intercepta as excecoes e faz com que esse objeto possa tratalas
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNaoAchadoException.class) // Verifica se a excecao cairá aqui
	public ResponseEntity<StandardError> resourceNaoAchado(ResourceNaoAchadoException e, 
			HttpServletRequest request) {
		
		String error = "Resource não foi achado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError erro = new StandardError(Instant.now(), status.value(), error, e.getMessage(), 
				request.getRequestURI());
		return ResponseEntity.status(status).body(erro);
		
	}
	
	@ExceptionHandler(BancoDadosException.class)
	public ResponseEntity<StandardError> bancoDadosErro(BancoDadosException e, 
			HttpServletRequest request) {
		
		String error = "Erro com o Banco de dados";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError erro = new StandardError(Instant.now(), status.value(), error, e.getMessage(), 
				request.getRequestURI());
		return ResponseEntity.status(status).body(erro);
		
	}
	
}
