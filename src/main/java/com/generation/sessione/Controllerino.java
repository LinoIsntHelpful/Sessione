package com.generation.sessione;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//l'attributo che metto nel model chiamato utente NON è un attributo usa e getta
//ma deve rimanere in memoria
@SessionAttributes({"utente"})
@Controller
public class Controllerino
{

	@Autowired
	private UtenteDao utenteDao;

	@PostMapping("/login")
	public String login(Model m, @RequestParam String username, @RequestParam String password)
	{
		Utente u = utenteDao.findByUsernameAndPassword(username,password);

		if(u==null)
			return "utenteNotFound";

		m.addAttribute("utente", u);

		return "loginCorretto";
	}

	@GetMapping("/vaiSito")
	public String vaiSito()
	{
		return "sitoVero";
	}

	@GetMapping("/adminPage")
	//prende l'utente dalla sessione
	public String bho(@SessionAttribute Utente utente)
	{

		if(utente.getRuolo()!=Ruolo.ADMIN)
			throw new NonSeiAdminException();

		return "adminpage";
	}
}
