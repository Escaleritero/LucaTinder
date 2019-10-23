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
import org.springframework.web.bind.annotation.RequestParam;

import com.lucatinder.model.Perfil;
import com.lucatinder.servicios.IServicios;

@Controller
public class ControlMVC {

	@Autowired
	private IServicios iservicios;

	private int id_perfil;
	private Perfil perfilLogin;

	private static final Logger logger = LoggerFactory.getLogger(ControlMVC.class);

	@GetMapping("/")
	public String inicio(Model model, @ModelAttribute("perfil") Perfil perfil) {
		logger.info("--en INICIO");
		return "index";
	}

	@GetMapping("/formulario") // alta
	public String newPerfil(Model model) {
		logger.info("--NEW");
		model.addAttribute("perfil", new Perfil());
		return "registro";
	}

	@PostMapping("/registro") // alta
	public String addPerfil(@ModelAttribute Perfil perfil) {
		logger.info("--ADD");
		Perfil aux;
		aux = iservicios.addPerfil(perfil);
		if (aux == null) {
			return "registro";
		} else {
			perfilLogin = aux;
			return "redirect:/home";
		}
	}

	@PostMapping("/login")
	public String loginPerfil(Perfil p, Model model) {
		logger.info("-------ABRIR SESION" + p.getAlias() + "----");
		Perfil perfil = iservicios.validarPerfil(p.getAlias());

		if (perfil != null) {
			this.id_perfil = perfil.getId();
			this.perfilLogin = perfil;

			return "redirect:/home";
		} else {
			return "redirect:/";
		}
	}

	/**
	 * @autor Pedro Umpierrez
	 * 
	 *        Metodo para guardar el like que del perfil gustado por el usuario
	 *        logeado
	 * 
	 * @param id_perfil       parametro del perfil del usuario que ha dado like
	 * @param id_perfil_liked parametro del perfil que ha recibido un like del
	 *                        usuario
	 * @return vuelve a retornar la pagina principal de la cual esta conectado el
	 *         usuario
	 */
	@PostMapping("/like")
	public String savelike(@RequestParam("id_perfil_dislike") int id_perfillike) {
		iservicios.saveLike(id_perfil, id_perfillike);
		System.out.println("id_perfil1= " + id_perfil + " id_perfil2: " + id_perfillike);
		return "redirect:/home";
	}

	/**
	 * @author Pedro Umpierrez
	 * 
	 *         Metodo para guardar el dislike que del perfil gustado por el usuario
	 *         logeado
	 * 
	 * @param id_perfil         parametro del perfil del usuario que ha dado like
	 * @param id_perfil_dislike parametro del perfil que ha recibido un dislike del
	 *                          usuario
	 * @return vuelve a retornar la pagina principal de la cual esta conectado el
	 *         usuario
	 */

	@PostMapping("/disLike")
	public String saveDislike(@RequestParam("id") int id_perfilDislike) {
		iservicios.saveDislike(id_perfil, id_perfilDislike);
		System.out.println("id_perfil1= " + id_perfil + " id_perfil2: " + id_perfilDislike);
		return "redirect:/mvc/profile/home";
	}

	@GetMapping("/home")
	public String homePerfil(Model model) {
		List<Perfil> listaPerfil = iservicios.listaPerfiles(id_perfil);
		model.addAttribute("perfil", perfilLogin);
		model.addAttribute("lista", listaPerfil);
		return "principal";
	}

}
