package com.lucatinder.datos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.lucatinder.model.Perfil;


@Repository
public interface IPerfilRepositorio extends JpaRepository<Perfil, Integer>{
	/**
	 * Metodo para que pasado un alias por parametro te de un perfil de la base de datos
	 * 
	 * @param alias parametro introducido por el usuario a la hora de conectarse a su cuenta
	 * @return retorna el perfil del usuario en caso de que lo encuentre
	 */
	@Query(
			value = "SELECT * FROM perfiles WHERE upper(alias) like = ?1", 
			nativeQuery = true)
		public Perfil obtenerPerfil(String alias);
	
	/**
	 * Metodo que devuelve una lista sencilla por el id del perfil pasado por parametro.
	 * 
	 * @param id_perfil parametro que servira para darle la condicion al select.
	 * @return retorna una lista de perfiles.
	 */
	@Query(
			value = "SELECT * FROM usuario WHERE id_perfil <> ?1 LIMIT 20", 
			nativeQuery = true)
		public List<Perfil> devuelveListadoInicialSencillo(int id_perfil);

}

