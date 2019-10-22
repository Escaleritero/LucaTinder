package com.lucatinder.controlREST;

import java.net.URI;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
 *
 */

@RestController
@RequestMapping("/lucatinder")
public class ControlREST {

	@Autowired
	IServicios iservicios;

	@Autowired
	IPerfilRepositorio perfilRepo;

	private static final Logger logger = (Logger) LoggerFactory.getLogger(ControlREST.class);

	
	@PostMapping
	ResponseEntity<?> addPerfil(@RequestBody Perfil perfil) {
		logger.info("--esta es la primera linea de ADDPERFIL REST");
		Perfil result = iservicios.addPerfil(perfil);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}").buildAndExpand(result.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping ("/listadoPerfiles/rest/{id_perfil}") 
	public List<Perfil> listaPerfiles (@PathVariable int id_perfil){
		return iservicios.listaPerfiles(id_perfil);	
	}

	@PostMapping ("/saveLike/rest/{id_perfil, id_perfilLike}")
	public void saveLikeRest (@PathVariable int id_perfil, int id_perfilLike) {
	iservicios.saveLike(id_perfil, id_perfilLike);
	}
	
	@PostMapping ("/saveDislike/rest/{id_perfil, id_perfilDislike}")
	public void saveDislikeRest (@PathVariable int id_perfil, int id_perfilDislike) {
		iservicios.saveDislike(id_perfil, id_perfilDislike);
	}
	
	@GetMapping ("/validarPerfil/rest/{alias}")
	public void validarPerfilRest (@PathVariable String alias) {
		iservicios.validarPerfil(alias);
	}
	
	
	
	
	
	
	
	
	
	//para borrar o editar perfil por ID
	//@PostMapping ("/listadoPerfiles/perfil/rest/{id_perfil}") 
	//public void addUsuario (@PathVariable int id_perfil){
	//	iservicios.addPerfil(iservicios.devuelvePorID(id_perfil));	
	//}
	
	
		
	
	}
