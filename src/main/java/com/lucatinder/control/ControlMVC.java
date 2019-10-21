package com.lucatinder.control;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lucatinder.model.Perfil;
import com.lucatinder.servicios.IServicios;

/**
 * 
 * @author RocioB
 *
 */

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

	/**
	 * @param model
	 * @return registro
	 */

	@GetMapping("/registro") // alta
	public String newPerfil(Model model) {
		logger.info("--NEW");
		model.addAttribute("perfil", new Perfil());
		return "registro";
	}

	/**
	 * @param perfil Metodo para crear Perfil nuevo
	 * @return principal
	 */
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

	/**
	 * @param alias Metodo para abrir sesion, validando el alias y devolver listado
	 *              de 20 contactos. Si falla vuelve al comienzo.
	 * @return "principal" / "index"
	 */

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

}
