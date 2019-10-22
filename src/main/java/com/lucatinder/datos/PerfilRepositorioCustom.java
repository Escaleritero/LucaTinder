package com.lucatinder.datos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.Query;
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
	
	@SuppressWarnings("unchecked")
    public List<Perfil> getPerfilSelection(int id_perfil) {        
		String hql = "SELECT p.* " +
				"FROM perfiles p "+
                "WHERE LIMIT 20 and p.id_perfil != ? " +
                "AND p.id_perfil NOT IN ( " +
                
                "    SELECT c.id_perfil_liked" +
                "    FROM contactos c " +
                "    JOIN perfiles p " +
                "    ON p.id_perfil = c.id_perfil " +
                "    WHERE p.id_perfil = ?) " +
                "AND p.id_perfil NOT IN ( " +
                
                "    SELECT d.id_perfil_dislike " +
                "    FROM descartes d " +
                "    JOIN perfiles p " +
                "    ON p.id_perfil = d.id_perfil " +
                "    WHERE p.id_perfil = ?) ";
		List<Object[]> lp = em.createNativeQuery(hql)
				.setParameter(1, id_perfil)
                .setParameter(2, id_perfil)
                .setParameter(3, id_perfil)
                .getResultList();
		return u.PerfilConverter(lp);
    }
	
    @SuppressWarnings("unchecked")
    public void saveLike(int id_perfil ,int id_perfilLike) {
        logger.info("--en SAVELIKE");
        em.createNativeQuery("INSERT INTO contactos (id_perfil, id_perfil_liked) VALUES (?, ?)")
        .setParameter(1, id_perfil)
        .setParameter(2, id_perfilLike);
    }
    
    @SuppressWarnings("unchecked")
    public void saveDislike(int id_perfil ,int id_perfilDislike) {
        logger.info("--en SAVEDISLIKE");
        em.createNativeQuery("INSERT INTO descartes (id_perfil, id_perfil_dislike) VALUES (?, ?)")
        .setParameter(1, id_perfil)
        .setParameter(2, id_perfilDislike);
    }

    @SuppressWarnings("unchecked")
    /**
	 * Metodo para que pasado un alias por parametro te de un perfil de la base de datos
	 * 
	 * @param alias parametro introducido por el usuario a la hora de conectarse a su cuenta
	 * @return retorna el perfil del usuario en caso de que lo encuentre
	 */
    public Perfil obtenerPerfil(String alias) {
    	logger.info("--en obtener perfil");
    	String sql = "SELECT * "
					+ "FROM perfiles "
					+ "WHERE alias like ?";//Con native query no hace falta poner comillas simples en el like
    	System.out.println("---- "+sql);
    	List<Object[]>lp = em.createNativeQuery(sql)
				.setParameter(1, alias)
                .getResultList();
    	if(lp.size()>0) {
    		return u.perfilConverter(lp);
    	}else {
    		return null;
    	}
    }
}
