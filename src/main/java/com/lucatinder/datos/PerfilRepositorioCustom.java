package com.lucatinder.datos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

//import org.springframework.data.jpa.repository.Query;
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
		String hql = "SELECT p.*  " + 
					"FROM Perfil p " + 
					"WHERE p.id_perfil != :id1" + 
						"AND p.id_perfil NOT IN (" + 
						"SELECT c.id_perfilLike" + 
						"FROM Contactos c " + 
							"JOIN Perfil p" + 
							"ON p.id_perfil = c.id_perfil" + 
						"WHERE p.id_perfil = :id2) AND p.id_perfil NOT IN (" + 
								"SELECT d.id_perfilDislike" + 
								"FROM Descartes d" + 
									"JOIN Perfil p" + 
									"ON p.id_perfil = d.id_perfil" + 
								"WHERE p.id_perfil = :id3) LIMIT 20";
		Query q = em.createQuery(hql);
        q.setParameter("id1", id_perfil);
        q.setParameter("id2", id_perfil);
        q.setParameter("id3", id_perfil);
        
        if(q.getResultList().size()>0) {
            List<Perfil> lp = q.getResultList();
            return lp;
        }
        else {
        	return null;
        }
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

    /**
	 * Metodo para que pasado un alias por parametro te de un perfil de la base de datos
	 * 
	 * @param alias parametro introducido por el usuario a la hora de conectarse a su cuenta
	 * @return retorna el perfil del usuario en caso de que lo encuentre
	 */
    @SuppressWarnings("unchecked")
    public Perfil obtenerPerfil(String alias) {
    	Query q = em.createQuery("from Perfil where alias = :id");
        q.setParameter("id", alias);
        if(q.getResultList().size()>0) {
            Perfil p1 = (Perfil)q.getResultList().get(0);
            return p1;
        }
        else {
        	logger.warn("No hay valores con ese dato: "+alias);
        	return null;
        }
    }
}
