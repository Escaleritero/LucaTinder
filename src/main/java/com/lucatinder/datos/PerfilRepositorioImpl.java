package com.lucatinder.datos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lucatinder.model.Perfil;

public class PerfilRepositorioImpl implements PerfilRepositorioCustom {
/*
	@PersistenceContext
	EntityManager em;
	
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
		String sql = "SELECT * FROM perfiles WHERE id_perfil =(\""+alias+"\")";
		Query q = em.createNativeQuery(sql);
		return (Perfil)q.getSingleResult() ;
	}
	*/
}
