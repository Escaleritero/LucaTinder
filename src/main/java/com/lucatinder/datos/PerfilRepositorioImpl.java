package com.lucatinder.datos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class PerfilRepositorioImpl implements PerfilRepositorioCustom {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public int validarPerfil(String alias) {
		String sql = "SELECT * FROM perfiles WHERE upper(alias)like(\""+alias+"\")";
		Query q = em.createNativeQuery(sql);
		return q.getFirstResult();
	}

}
