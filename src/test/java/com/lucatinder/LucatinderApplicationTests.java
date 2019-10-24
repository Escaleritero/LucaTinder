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
public class LucatinderApplicationTests {
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
	public void pruebaDeletePerfil() {
		Perfil p = new Perfil("Antonio","Antonio Santos",true,29,"Hola lechones");
		int cantidad1;
		int cantidad2;
		
		cantidad1 = ipr.findAll().size();
		logger.info("Usuario almacenados: "+cantidad1);
		p = service.addPerfil(p);
		
		cantidad2 = ipr.findAll().size();
		logger.info("Usuario almacenados: "+cantidad2);
		service.deletePerfil(p.getId());
		
		assertEquals(cantidad1, cantidad2-1);
		assertNull(ipr.findById(p.getId()).orElse(null));
		
	}
	
	
	/**
	 * @author Hector
	 * 
	 * Metodo que prueba que obtienes un perfil ha traves de un id.
	 */
	@Test
	public void pruebaObtenerPerfil() {
		Perfil p1 = new Perfil("LucasTonson","Lucas Tonson",true,29,"leña al mono");
		Perfil p2 = new Perfil();
		
		p2 = service.addPerfil(p1);
		assertEquals(p1.getAlias(),p2.getAlias());
		assertEquals("Rafa",p2.getAlias());
	}
	
	/**
	 * @author Ro
	 * Prueba para verificar que funcione el alta de Perfil a la base de datos.
	 */
	@Test
    public void testAddPerfil() {
        logger.info("Prueba para comprobar que se ha añadido un perfil");
        
        int cantInicial = 0;
        int cantFinal = 0;
        Perfil p = new Perfil( 500, "Prueba1", "Pruebafalsa", true, 20, "prueba para probar");
        
        //cantidad de perfiles
        cantInicial = ipr.findAll().size();
        logger.info("Numero de perfiles iniciales: " + cantInicial);
    
        //agrego uno
        logger.info("Creando Perfil");
        service.addPerfil(p);
    
        ipr.delete(p);
        //compruebo
        cantFinal = ipr.findAll().size();
        logger.info("Numero de perfiles finales: " + cantFinal);
        
        //compruebo que se ha agregado
        assertEquals(cantFinal, cantInicial + 1);
       
    }
}
