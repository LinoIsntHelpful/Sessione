package com.generation.sessione;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utente
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username, password;

	@Enumerated(EnumType.STRING)
	private Ruolo ruolo;

	public boolean admin()
	{
		return ruolo == Ruolo.ADMIN;
	}
}
