package com.lucatinder.controlREST;

import java.net.URI;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
 * @author Ro
 */

@RestController
@RequestMapping("/lucatinder")
@CrossOrigin(origins = "*")
public class ControlREST {

	@Autowired
	IServicios iservicios;

	@Autowired
	IPerfilRepositorio perfilRepo;
	
	Perfil perfilSesion;


	private static final Logger logger = (Logger) LoggerFactory.getLogger(ControlREST.class);

	/**
	 * @author Ro
	 * @param perfil
	 * @return Objeto Perfil
	 */
	@PostMapping
	ResponseEntity<?> addPerfil(@RequestBody Perfil perfil) {
		logger.info("--esta es la primera linea de ADDPERFIL REST");
		Perfil result = iservicios.addPerfil(perfil);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}").buildAndExpand(result.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	} // BORRAME: controlado - Ro

	/**
	 * @author Ro
	 * @param id_perfil
	 * @return Lista de Perfiles
	 */
	@GetMapping ("/listadoPerfiles/rest/{id_perfil}") 
	public List<Perfil> listaPerfiles (@PathVariable int id_perfil){
		logger.info("--LISTA PERFILES_REST");
		return iservicios.listaPerfiles(id_perfil);	
	}

	/**
	 * @author Ro
	 * @param id_perfil
	 * @param id_perfilLike
	 * Guarda contactados
	 */
	@PostMapping ("/saveLike/rest/{id_perfilLike}")
	public void saveLikeRest (@PathVariable int id_perfilLike) {
	logger.info("--SAVELIKE_REST");
	iservicios.saveLike(this.perfilSesion.getId(), id_perfilLike);
	}
	
	/**
	 * @author Ro
	 * @param id_perfil
	 * @param id_perfilDislike
	 * Guarda descartados
	 */
	@PostMapping ("/saveDislike/rest/{id_perfilDislike}")
	public void saveDislikeRest (@PathVariable int id_perfilDislike) {
		logger.info("--SAVEDISLIKE_REST");
		iservicios.saveDislike(this.perfilSesion.getId(), id_perfilDislike);
	}
	/**
	 * @author Ro
	 * @param alias
	 */
	@GetMapping ("/validarPerfil/rest/{alias}")
	public void validarPerfilRest (@PathVariable String alias) {
		logger.info("--VALIDARPERFIL_REST");
		iservicios.validarPerfil(alias);
		perfilSesion = iservicios.validarPerfil(alias);
		System.out.println("----------------------");
		System.out.println(perfilSesion);
		
		
	}
	
	@GetMapping ("/get/perfil/{id}")
	public Perfil getPerfil(@PathVariable String id) {
		return iservicios.devuelvePorID(Integer.parseInt(id));
	}
	
	@GetMapping ("/get/sesion")
	public Perfil getPerfil() {
		return perfilSesion;
	}
	
	@GetMapping ("/get/likeados")
	public List<Perfil> getlikeados() {
		
		return iservicios.listaContactos(perfilSesion.getId());
	}
	
	@GetMapping ("/get/descartes")
	public List<Perfil> getDescartados() {
		
		return iservicios.listaDescartes(perfilSesion.getId());
	}
	
	//ROCIO: para borrar o editar perfil por ID
	//@PostMapping ("/listadoPerfiles/perfil/rest/{id_perfil}") 
	//public void addUsuario (@PathVariable int id_perfil){
	//	iservicios.addPerfil(iservicios.devuelvePorID(id_perfil));	
	//}
	
	}
