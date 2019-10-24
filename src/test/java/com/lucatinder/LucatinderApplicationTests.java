package com.lucatinder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lucatinder.control.ControlMVC;
import com.lucatinder.datos.IPerfilRepositorio;
import com.lucatinder.datos.PerfilRepositorioCustom;
import com.lucatinder.model.Perfil;
import com.lucatinder.servicios.IServicios;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LucatinderApplicationTests {

	
	@Autowired
	PerfilRepositorioCustom prc;
	@Autowired
	IPerfilRepositorio ipr ;
	@Autowired
	private IServicios iservicios;
	
	
	@Test
	public void contextLoads() {
	}
		
	
	private static final Logger logger = LoggerFactory.getLogger(ControlMVC.class);
    
	
	
	
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
        iservicios.addPerfil(p);
    
        //compruebo
        cantFinal = ipr.findAll().size();
        logger.info("Numero de perfiles finales: " + cantFinal);
        
        //compruebo que se ha agregado
        assertEquals(cantFinal, cantInicial + 1);
       
    }
	
	
}
