package com.lucatinder.controlREST;

import java.net.URI;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.lucatinder.datos.IPerfilRepositorio;
import com.lucatinder.model.Perfil;
import com.lucatinder.servicios.IServicios;

import ch.qos.logback.classic.Logger;

/**
 * Clase= ControlRest
 * 
 * @author Ro
 */

@RestController
@RequestMapping("/lucatinder")
public class ControlREST {

	@Autowired
	IServicios iservicios;
	IPerfilRepositorio perfilRepo;
	private int id_perfil;
	private static final Logger logger = (Logger) LoggerFactory.getLogger(ControlREST.class);

	@GetMapping("/home")
	public List<Perfil> getProfileSelection() throws Exception {
		logger.info("-- en HOME");
		return iservicios.listaPerfiles(id_perfil);
	}
	
	
	/*@GetMapping("/home")
	public String homePerfil(Model model) {
		List<Perfil> listaPerfil = iservicios.listaPerfiles(id_perfil);
		model.addAttribute("perfil", perfilLogin);
		model.addAttribute("lista", listaPerfil);
		return "principal";
	}*/


	@GetMapping("/login/rest/{alias}")
	public Perfil loginPerfil(@PathVariable String alias) {
		logger.info("--Comprobar si existe perfil--");
		Perfil p = iservicios.validarPerfil(alias);
		if (p != null) {
			this.id_perfil = p.getId();
		}
		return p;
	} // BORRAME: ERROR ----

	/**
	 * @author Ro
	 * @param perfil
	 * @return Objeto Perfil
	 */
	@PostMapping
	ResponseEntity<?> addPerfil(@RequestBody Perfil perfil) {
		logger.info("--esta es la primera linea de ADDPERFIL REST-ERROR EN PERFIL CONVERTER");
		Perfil result = iservicios.addPerfil(perfil);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	} // BORRAME: controlado - Ro ERROR ----PERFIL CONVERTER

	/**
	 * @author Ro
	 * @param id_perfil
	 * @return Lista de Perfiles
	 */
	@GetMapping("/listadoPerfiles/rest/{id_perfil}")
	public List<Perfil> listaPerfiles(@PathVariable int id_perfil) {
		logger.info("--LISTA PERFILES_REST-FATAL ERROR 404");
		return iservicios.listaPerfiles(id_perfil);
	} // BORRAME: FALLA 404. Rastrear-----QUERY

	/**
	 * @author Ro
	 * @param id_perfil
	 * @param id_perfilLike __ Guarda contactados
	 */
	@PostMapping("/saveLike/rest/{id_perfilLike}")
	public void saveLikeRest(@PathVariable int id_perfilLike) {
		logger.info("--SAVELIKE_REST");
		iservicios.saveLike(id_perfil, id_perfilLike);
	} // BORRAME:

	/**
	 * @author Ro
	 * @param id_perfil
	 * @param id_perfilDislike __ Guarda descartados
	 */
	@PostMapping("/saveDislike/rest/{id_perfilDislike}")
	public void saveDislikeRest(@PathVariable int id_perfilDislike) {
		logger.info("--SAVEDISLIKE_REST");
		iservicios.saveDislike(id_perfil, id_perfilDislike);
	} // BORRAME:

	/**
	 * @author Ro
	 * @param alias
	 */
	@GetMapping("/validarPerfil/rest/{alias}")
	public void validarPerfilRest(@PathVariable String alias) {
		logger.info("--VALIDARPERFIL_REST");
		iservicios.validarPerfil(alias);
	}

	// ROCIO: para borrar o editar perfil por ID
	// @PostMapping ("/listadoPerfiles/perfil/rest/{id_perfil}")
	// public void addUsuario (@PathVariable int id_perfil){
	// iservicios.addPerfil(iservicios.devuelvePorID(id_perfil));
	// }

}
