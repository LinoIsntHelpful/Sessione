package com.generation.sessione;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NonSeiAdminException extends RuntimeException
{
	public NonSeiAdminException(String message)
	{
		super(message);
	}
}
