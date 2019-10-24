package com.lucatinder;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.lucatinder.control.ControlMVC;
import com.lucatinder.datos.IPerfilRepositorio;
import com.lucatinder.datos.PerfilRepositorioCustom;
import com.lucatinder.model.Perfil;
import com.lucatinder.servicios.IServicios;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LucatinderTest {
	private static final Logger logger = LoggerFactory.getLogger(ControlMVC.class);
	
	@Autowired
	private IServicios service;
	@Autowired
	private PerfilRepositorioCustom rpc;
	
	@Autowired
	private IPerfilRepositorio ipr;
	
	/**
	 * @author Pedro
	 * 
	 * Prueba que mediante un id de perfil te recoja la lista de los perfiles de los que haya dado like
	 */
	@Test
	public void pruebaListaContactos() {
		List<Perfil> listaPerfil = rpc.listadoContactos(1);
		for (Perfil perfil : listaPerfil) {
			System.out.println(perfil);
		}
	}
	/**
	 * @author Rafael
	 * 
	 * Prueba para eliminar un perfil que hemos creado falso
	 */
	@Test
	public void deletePerfil() {
		Perfil p = new Perfil();
		int cantidad1;
		int cantidad2;
		
		cantidad1 = ipr.findAll().size();
		logger.info("Usuario almacenados: "+cantidad1);
		p = service.addPerfil(new Perfil("Antonio","Antonio Santos",true,29,"Hola lechones"));
		
		cantidad2 = ipr.findAll().size();
		logger.info("Usuario almacenados: "+cantidad2);
		service.deletePerfil(p.getId());
		
		assertEquals(cantidad1-1, cantidad2);
		assertNull(ipr.findById(p.getId()).orElse(null));
		
	}
}
