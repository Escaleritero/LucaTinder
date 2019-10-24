package com.lucatinder.controlREST;


import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucatinder.datos.IPerfilRepositorio;
import com.lucatinder.model.Perfil;
import com.lucatinder.servicios.IServicios;

import ch.qos.logback.classic.Logger;

/**
 * Clase = ControlREST
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
/**
 * @return
 * @throws Exception
 * Devuelve lista de 20/50 perfiles iniciales
 */
	
	@GetMapping("/home")
	public List<Perfil> mostrarListaPerfiles() throws Exception {
		logger.info("-- en HOME");
		return iservicios.listaPerfiles(id_perfil);
	}
/**
 * @param alias
 * @return Perfil 
 * Abre sesion
 */
	@GetMapping("/login/rest/{alias}")
	public Perfil loginPerfil(@PathVariable String alias) {
		logger.info("--Comprobar si existe perfil--");
		Perfil p = iservicios.validarPerfil(alias);
		if (p != null) {
			this.id_perfil = p.getId();
		}
		return p;
	}

	/**
	 * @author Ro
	 * @param perfil
	 * @return Objeto Perfil 
	 * Guarda objeto en tabla perfiles
	 */
	@PostMapping("/alta/rest")
	Perfil addPerfil(@RequestBody Perfil perfil) {
		logger.info("--linea de ADDPERFIL REST");
		return iservicios.addPerfil(perfil);
	} 

	/**
	 * @author Ro
	 * @param id_perfil
	 * @param id_perfilLike 
	 * Guarda el like en tabla contactados
	 */
	@GetMapping("/saveLike/rest/{id_perfilLike}")
	public void saveLikeRest(@PathVariable int id_perfilLike) {
		logger.info("--SAVELIKE_REST");
		iservicios.saveLike(id_perfil, id_perfilLike);
	} 

	/**
	 * @author Ro
	 * @param id_perfil
	 * @param id_perfilDislike
	 * Guarda el dislike en tabla descartados
	 */
	@GetMapping("/saveDislike/rest/{id_perfilDislike}")
	public void saveDislikeRest(@PathVariable int id_perfilDislike) {
		logger.info("--SAVEDISLIKE_REST");
		iservicios.saveDislike(id_perfil, id_perfilDislike);
	} 

	// ROCIO: para borrar o editar perfil por ID
	// @PostMapping ("/listadoPerfiles/perfil/rest/{id_perfil}")
	// public void addUsuario (@PathVariable int id_perfil){
	// iservicios.addPerfil(iservicios.devuelvePorID(id_perfil));
	// }

}
