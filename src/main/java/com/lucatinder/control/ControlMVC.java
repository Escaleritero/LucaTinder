package com.lucatinder.control;

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
	
	@RequestMapping ("/")
	public String abrir(Model model) {
		return "index";	
	}
	//-----
	/**
	 * @param model Metodo para crear un objeto para generar un perfil nuevo.
	 * @return registro
	 */
	@GetMapping("/addperfil") // alta
	public String newPerfil(Model model) {
		logger.info("--NEW");
		model.addAttribute("perfil", new Perfil());
		return "registro";
	}

	/**
	 * @param perfil 
	 	Metodo para
	 * @return principal
	 */
	@PostMapping("/addPerfil")
	public String addPerfil (@ModelAttribute Perfil perfil) {
		logger.info("--ADD");
		perfil = iservicios.addPerfil(perfil);
		if (perfil == null) {
			return "registro";
		} else {
			return "principal";
		}
	}
	
	/**
	 * @param alias Metodo para abrir sesion, validando el alias, para devolver listado de 20 contactos en principal.
	 * @return "principal" / "index"
	 */
	
	@PostMapping("/sesion")
	public String abrirSesion(@ModelAttribute String alias) {
		Perfil perfil;
		logger.info("--ABRIR SESION");
		perfil = iservicios.validarPerfil(alias);
		if (perfil == null) {
			return "index";
		} else {
			return "principal";
		}
	}

	
	

}
