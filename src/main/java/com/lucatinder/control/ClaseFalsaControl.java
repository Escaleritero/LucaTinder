package com.lucatinder.control;

import org.springframework.web.bind.annotation.GetMapping;

import com.lucatinder.model.Perfil;

import org.springframework.ui.Model;

public class ClaseFalsaControl {

	//Faltan datos. Mirar post-it 4.1
	@GetMapping("/principal")
	public String principal(Model model, Perfil perfil) {
				
		//Perfil perfil;
		model.addAttribute("perfil", perfil);
		return "principal";
	}
}
