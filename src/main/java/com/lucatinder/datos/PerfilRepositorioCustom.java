package com.lucatinder.datos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.lucatinder.control.ControlMVC;
import com.lucatinder.model.Perfil;
import com.lucatinder.util.Utiles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class PerfilRepositorioCustom {
	Utiles u;
	private static final Logger logger = LoggerFactory.getLogger(ControlMVC.class);
	
	@PersistenceContext
	EntityManager em;
	/**
	 * @author Rafael
	 * Metodo que al recibir un entero te devuelve una lista de perfiles a los que nos has dado like ni dislike
	 * 
	 * @param id_perfil parametro de tipo entero utilizaremos con condicion en la consulta de sql.
	 * @return retorna una lista de perfiles.
	 */
	@Transactional
	@SuppressWarnings("unchecked")
    public List<Perfil> getPerfilSelection(int id_perfil) {
		u = new Utiles();
		String hql = "SELECT P.* " +
                "FROM perfiles P "+
                "WHERE P.id_perfiles != ? " +
                "AND P.id_perfiles NOT IN ( " +
                "    SELECT C.id_perfil_like " +
                "    FROM contactos C " +
                "    JOIN perfiles P " +
                "    ON P.id_perfiles = C.id_perfil " +
                "    WHERE P.id_perfiles = ?) " +
                "AND P.id_perfiles NOT IN ( " +
                "    SELECT d.id_perfil_dislike " +
                "    FROM descartes D " +
                "    JOIN perfiles P " +
                "    ON P.id_perfiles = D.id_perfil " +
                "    WHERE P.id_perfiles = ?) ";
		List<Object[]> lp = em.createNativeQuery(hql)
                .setParameter(1, id_perfil)
                .setParameter(2, id_perfil)
                .setParameter(3, id_perfil)
                .getResultList();
                return u.convertirLista(lp);
    }
	
	/**
	 * @author Rafael
	 * Metodo que al recibir dos id de perfiles diferentes se guardan en la tabla contectos
	 *  
	 * @param id_perfil parametro de tipo entero que guarda el id del usuario logeado
	 * @param id_perfilLike parametro de tipo entero que guarda el id del usuario que ha recibido el like.
	 */
	@Transactional
    @SuppressWarnings("unchecked")
    public void saveLike(int id_perfil ,int id_perfilLike) {
        logger.info("--en SAVELIKE");
        em.createNativeQuery("INSERT INTO contactos (id_perfil, id_perfil_like) VALUES (?, ?)")
        .setParameter(1, id_perfil)
        .setParameter(2, id_perfilLike).executeUpdate();
    }
    
	/**
	 * @author Rafael
	 * 
	 * Metodo que al recibir el id del usuario conectado le devuelve una lista de los usuarios que ha dado like anteriormente
	 * 
	 * @param id_perfil parametro de tipo entero que utilizaremos como condicion en la consulta sql.
	 * @return retorna una lista de perfiles con like.
	 */
	@Transactional
    @SuppressWarnings("unchecked")
	public List<Perfil> listadoContactos(int id_perfil) {
		u = new Utiles();
		String hql = "SELECT P.* " +
                "FROM perfiles P "+
                "WHERE P.id_perfiles != ? " +
                "AND P.id_perfiles IN ( " +
                "    SELECT C.id_perfil_like " +
                "    FROM contactos C " +
                "    JOIN perfiles P " +
                "    ON P.id_perfiles = C.id_perfil " +
                "    WHERE P.id_perfiles = ?)";
		List<Object[]> lp = em.createNativeQuery(hql)
                .setParameter(1, id_perfil)
                .setParameter(2, id_perfil)
                .getResultList();
                return u.convertirLista(lp);
	}
	
	/**
	 * @author Rafael
	 * 
	 * Metodo que al recibir el id del usuario conectado le devuelve una lista de los usuarios que ha dado dislike anteriormente
	 * 
	 * @param id_perfil parametro de tipo entero que utilizaremos como condicion en la consulta sql.
	 * @return retorna una lista de perfiles con dislike.
	 */
	@Transactional
    @SuppressWarnings("unchecked")
	public List<Perfil> listadoDescartes(int id_perfil) {
		u = new Utiles();
		String hql = "SELECT P.* " +
                "FROM perfiles P "+
                "WHERE P.id_perfiles != ? " +
                "AND P.id_perfiles IN ( " +
                "    SELECT D.id_perfil_dislike " +
                "    FROM descartes D " +
                "    JOIN perfiles P " +
                "    ON P.id_perfiles = D.id_perfil " +
                "    WHERE P.id_perfiles = ?)";
		List<Object[]> lp = em.createNativeQuery(hql)
                .setParameter(1, id_perfil)
                .setParameter(2, id_perfil)
                .getResultList();
                return u.convertirLista(lp);
	}
	
	/**
	 * @author Rafael
	 * Metodo que al recibir dos id de perfiles diferentes se guardan en la tabla descartes
	 *  
	 * @param id_perfil parametro de tipo entero que guarda el id del usuario logeado
	 * @param id_perfilDislike parametro de tipo entero que guarda el id del usuario que ha recibido el dislike.
	 */
    @Transactional 
    @SuppressWarnings("unchecked")
    public void saveDislike(int id_perfil ,int id_perfilDislike) {
        logger.info("--en SAVEDISLIKE");
        em.createNativeQuery("INSERT INTO descartes (id_perfil, id_perfil_dislike) VALUES (?, ?)")
        .setParameter(1, id_perfil)
        .setParameter(2, id_perfilDislike).executeUpdate();
    }

    /**
     * @author Rafael
	 * Metodo para que pasado un alias por parametro te de un perfil de la base de datos
	 * 
	 * @param alias parametro introducido por el usuario a la hora de conectarse a su cuenta
	 * @return retorna el perfil del usuario en caso de que lo encuentre
	 */
    @SuppressWarnings("unchecked")
    public Perfil obtenerPerfil(String alias) {
    	Query q = em.createQuery("from Perfil where alias = :alias");
        q.setParameter("alias", alias);
        System.out.println(alias);
        if(q.getResultList().size()>0) {
            Perfil p1 = (Perfil)q.getResultList().get(0);
            p1.toString();
            return p1;
        }
        else {
        	logger.warn("No hay valores con ese dato: "+alias);
        	return null;
        }
    }
}
