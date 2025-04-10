package com.generation.sessione;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GestoreEccezioni
{
	@ExceptionHandler(NonSeiAdminException.class)
	public String noAdmin(NonSeiAdminException e)
	{
		return "nonSeiAdmin";
	}
}
