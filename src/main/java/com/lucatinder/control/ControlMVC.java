package com.lucatinder.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lucatinder.model.Perfil;
import com.lucatinder.servicios.IServicios;

@Controller
public class ControlMVC {

	@Autowired
	private IServicios iservicios;

	private static final Logger logger = LoggerFactory.getLogger(ControlMVC.class);

	@GetMapping("/")
	public String inicio(Model model, @ModelAttribute("perfil") Perfil perfil) {
		logger.info("--en INICIO");
		return "index";
	}

	@GetMapping("/registro") // alta
	public String newPerfil(Model model) {
		logger.info("--NEW");
		model.addAttribute("perfil", new Perfil());
		return "registro";
	}
/*
	@PostMapping("/registro") // alta
	public String addPerfil(@ModelAttribute Perfil perfil) {
		logger.info("--ADD");
		iservicios.addPerfil(perfil);
		if (perfil == null) {
			return "registro";
		} else {
			return "principal";
		}
	}


	@PostMapping("/login")
	public String loginPerfil(@ModelAttribute String alias, Model model) {
		Perfil perfil = iservicios.validarPerfil(alias);
		List<Perfil> listaPerfil = iservicios.listaPerfiles(perfil.getId());
		logger.info("--ABRIR SESION");
		if (perfil != null) {
			model.addAttribute("perfil", perfil);
			model.addAttribute("lista", listaPerfil);
			return "principal";
		} else {
			return "index";
		}
	}
	*/
}
