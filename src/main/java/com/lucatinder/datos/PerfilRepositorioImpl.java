package com.lucatinder.datos;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


import com.lucatinder.model.Perfil;

@Repository
public class PerfilRepositorioImpl implements PerfilRepositorioCustom {
	
	
	@PersistenceContext
	EntityManager em;

	
	private static final Logger logger = LoggerFactory.getLogger(PerfilRepositorioImpl.class);	
	
	
	/**
	 * @author Ro
	 * metodo para guardar descartados en tabla descartados
	 */
	
	@Override
	public Perfil saveDislike(int id_perfil1, int id_perfil2) {
		logger.info("--en SAVEDISLIKE");
		em.createNativeQuery("INSERT INTO lucatinder.descartes (id_descartes, id_perfil1, id_perfil2) VALUES (?, ?, ?)")
		.setParameter(1, null)
		.setParameter(2, id_perfil1)
		.setParameter(2, id_perfil2);
		return null;
	}
/**
 * @author Ro
 * metodo para guardar los likes en tabla contactos
 */

	@Override
	public Perfil saveLike(int id_perfil1, int id_perfil2) {
		logger.info("--en SAVELIKE");
		em.createNativeQuery("INSERT INTO lucatinder.contactos (id_contactos, id_perfil1, id_perfil2) VALUES (?, ?, ?)")
		.setParameter(1, null)
		.setParameter(2, id_perfil1)
		.setParameter(3, id_perfil2);
		return null;
	}
	
	
	@Override
	public int validarPerfil(String alias) {
		String sql = "SELECT * FROM perfiles WHERE upper(alias)like(\""+alias+"\")";
		Query q = em.createNativeQuery(sql);
		return q.getFirstResult();
	}

	@Override
	public List<Perfil> listaPerfilId(int id_perfil) {
		String sql = "SELECT * FROM perfiles WHERE id_perfil =(\""+id_perfil+"\")";
		Query q = em.createNativeQuery(sql);
		return q.getResultList();
	}

	@Override
	public Perfil obtenerPerfil(String alias) {
		//ROCIO
		//String sql = "SELECT * FROM perfiles WHERE id_perfil =(\""+alias+"\")";
		//Query q = em.createNativeQuery(sql);
		//return (Perfil)q.getSingleResult() ;
		return new Perfil();
	}

	
				
}



