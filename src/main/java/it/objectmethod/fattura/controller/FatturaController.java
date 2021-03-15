package it.objectmethod.fattura.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.objectmethod.fattura.dao.FatturaDao;
import it.objectmethod.fattura.dao.Impl.FatturaDaoImpl;
import it.objectmethod.fattura.domain.Fattura;
import it.objectmethod.fattura.jasper.JasperService;

@Controller
public class FatturaController {

	@RequestMapping("/ordini")
	public String getOrdini(ModelMap map) {
		List<Fattura> list = new ArrayList<>();
		FatturaDao fatturaDao = new FatturaDaoImpl();
		list = fatturaDao.getOrdini();
		map.addAttribute("listaOrdini", list);
		return "index";
	}

	@RequestMapping(value = "/fattura-pdf", produces = "application/pdf")
	public @ResponseBody byte[] getFattura(@RequestParam("numeroOrdine") String numeroOrdine) {
		List<Fattura> list = null;
		FatturaDao fatturaDao = new FatturaDaoImpl();
		list = fatturaDao.getFattura(numeroOrdine);
		JasperService jasperService = new JasperService();
		byte[] pdf = null;
		try {
			pdf = jasperService.getJasperPrintFattura(list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pdf;
	}

}
