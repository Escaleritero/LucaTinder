package com.lucatinder.datos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

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
/*
		String hql ="FROM Perfil " + 
					"WHERE Perfil.id != :id1 " + 
						"AND Perfil.id NOT IN ( " + 
						"SELECT Contactos.id_perfilLike " + 
						"FROM Contactos " + 
							"JOIN Perfil " + 
							"ON Perfil.id = Contactos.id_perfil " + 
						"WHERE Perfil.id = :id2) AND Perfil.id NOT IN ( " + 
								"SELECT Descartes.id_perfilDislike " + 
								"FROM Descartes " + 
									"JOIN Perfil " + 
									"ON Perfil.id = Descartes.id_perfil " + 
								"WHERE Perfil.id = :id3)";
	
		
		String hql2 = "FROM Contactos " + 
				"JOIN Perfil " + 
				"ON Perfil.id = Contactos.id_perfil "+
				"WHERE Perfil.id = :id2)";
		logger.info("--Realizo consulta q2--- ");
		Query q2 = em.createQuery(hql);
		q2.setParameter("id2", id_perfil);
		logger.info("----q2--- "+q2.getResultList().toString());
		
		
		String hql3 = "FROM Descartes " + 
				"JOIN Perfil " + 
				"ON Perfil.id = Descartes.id_perfil " + 
			"WHERE Perfil.id = :id3)";
		Query q3 = em.createQuery(hql);
		q3.setParameter("id3", id_perfil);
		logger.info("----q3--- "+q3.getResultList().toString());		
		
		
		logger.info("------------------------QUERY RAFA-   " + hql);
		Query q = em.createQuery(hql);
       
        q.setParameter("id1", id_perfil);
        q.setParameter("id2", id_perfil);
        q.setParameter("id3", id_perfil);
        logger.info("------------------------ 1");
        */
		
		//Prueba

		
		// Realizamos una prueba basica
		logger.info("--------- Iniciando getPerfilSelection");
		String hql ="FROM Perfil";
		Query q = em.createQuery(hql);
		q.setMaxResults(10);
        
        
        List<Perfil> p = q.getResultList();
        logger.info("------ LISTADO: "+p);

        return p;

    }
	
	@Transactional
    @SuppressWarnings("unchecked")
    public void saveLike(int id_perfil ,int id_perfilLike) {
        logger.info("--en SAVELIKE");
        em.createNativeQuery("INSERT INTO contactos (id_perfil, id_perfil_like) VALUES (?, ?)")
        .setParameter(1, id_perfil)
        .setParameter(2, id_perfilLike).executeUpdate();
    }
    
    @Transactional 
    @SuppressWarnings("unchecked")
    public void saveDislike(int id_perfil ,int id_perfilDislike) {
        logger.info("--en SAVEDISLIKE");
        em.createNativeQuery("INSERT INTO descartes (id_perfil, id_perfil_dislike) VALUES (?, ?)")
        .setParameter(1, id_perfil)
        .setParameter(2, id_perfilDislike).executeUpdate();
    }

    /**
	 * Metodo para que pasado un alias por parametro te de un perfil de la base de datos
	 * 
	 * @param alias parametro introducido por el usuario a la hora de conectarse a su cuenta
	 * @return retorna el perfil del usuario en caso de que lo encuentre
	 */
    @SuppressWarnings("unchecked")
    public Perfil obtenerPerfil(String alias) {
    	Query q = em.createQuery("from Perfil where alias = :alias");
        q.setParameter("alias", alias);
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
