package com.generation.sessione;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteDao extends JpaRepository<Utente, Long>
{
	Utente findByUsernameAndPassword(String username,String password);
}
