package it.objectmethod.fattura.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import it.objectmethod.fattura.dao.FatturaDao;
import it.objectmethod.fattura.dao.Impl.FatturaDaoImpl;

public class FatturaController {

	@RequestMapping("/utenti")
	public String getNomeUtente(ModelMap map) {
		List<String> list = new ArrayList<>();
		FatturaDao fatturaDao = new FatturaDaoImpl();
		list = fatturaDao.getNomeUtente();
		map.addAttribute("nameList", list);
		return "index";
	}

}
