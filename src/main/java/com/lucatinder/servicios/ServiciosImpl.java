package com.lucatinder.servicios;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lucatinder.datos.IPerfilRepositorio;
import com.lucatinder.datos.PerfilRepositorioCustom;
import com.lucatinder.model.Perfil;
import com.lucatinder.util.Utiles;

@Service
public class ServiciosImpl  implements IServicios{
	
	@Autowired
	IPerfilRepositorio ipr ;

	@Autowired
	PerfilRepositorioCustom prc;
	
	/**
	 * @author Rafael
	 * 
	 * Metodo que le pasa un objeto para mandarlo a la base de datos.
	 * 
	 * @param perfil: objeto de la clase Perfil
	 * @return retorna un objeto o en caso de fallo un null
	 */
	@Override
	public Perfil addPerfil(Perfil perfil) {
		Perfil aux = prc.obtenerPerfil(perfil.getAlias());
		if(aux == null) {
			return ipr.save(perfil);
		}else {
			return null;
		}
	}
	/**
	 * Metodo para validar el alias introducido por el usuario.
	 * @param alias parametro de tipo String que recoger el alias introducido por el usuario
	 * @return retorna un perfil o un null si da fallo.
	 */
	@Override
	public Perfil validarPerfil(String alias) {
		Perfil perfil = prc.obtenerPerfil(alias);
		if(perfil != null) {
			return perfil;
		}else {
			return null;
		}
	}

	
    /**
     * @author Ro
     * Metodo para pasar el dislike que ha dado el usuario a la capa datos
     * 
     * @param id_perfil parametro de tipo entero donde guarda el id del perfil conectado
     * @param id_perfilDislike parametro de tipo entero donde recoge el id al que el usuario le ha marcado dislike.
     */
    @Override
    public void saveDislike(int id_perfil, int id_perfilDislike) {
        prc.saveDislike(id_perfil, id_perfilDislike);
    }

    /**
     * @author Ro
     * 
     * metodo para pasar el like que ha dado el usuario a la capa datos
     */
    @Override
    public void saveLike(int id_perfil, int id_perfilLike) {
    	prc.saveLike(id_perfil, id_perfilLike);
    }
	
	
	/**
	 * @author Rafael
	 * 
	 * Metodo que recoge una lista de perfiles en caso de que no tenga 20 introducira 50 perfiles mas.
	 * despues volvera a recoger la lista para retornarla a la pagina.
	 * 
	 * @param id_perfil parametro que nos permitira hacer una busqueda mas adecuada para el perfil conectado.
	 * @return retorna una lista de perfiles.
	 */
	@Override
	public List<Perfil> listaPerfiles(int id_perfil) {
		List<Perfil> listaPerfil = new ArrayList();
		listaPerfil = prc.getPerfilSelection(id_perfil);

			if(listaPerfil.size()>=3) {
				return listaPerfil;
			}else{
				listaPerfil = new Utiles().obtenerLista();
				
				for (Perfil perfil : listaPerfil) {
					ipr.save(perfil);
				}
				listaPerfil = prc.getPerfilSelection(id_perfil);
				return listaPerfil;
			}
	}

	/**
	 * @author Rafael
	 * 
	 * Metodo para eliminar la cuenta del perfil
	 * 
	 * @param id_perfil id que utlizaremos para elimar el perfil de la base de datos
	 */
	@Override
	public void deletePerfil(int id_perfil) {
		ipr.deleteById(id_perfil);
	}


	public Perfil devuelvePorID(int id_perfil) {
		Optional<Perfil> perfil=ipr.findById(id_perfil);
		return perfil.get();
	}
	
	/**
	 * @author Rafael
	 * 
	 * Metodo que recibe el id del usuario conectado y se lo pasa a la capa datos para que le devuelva una lista
	 * de los perfiles que ha dado el usuario like anteriormente
	 * 
	 * @param id_perfil parametro de tipo entero que contiene el id del usuario conectado
	 * @return retorna una lista de perfiles a los que el usuario ha dado like
	 */
	@Override
	public List<Perfil> listaContactos(int id_perfil) {
		return prc.listadoContactos(id_perfil);
	}
	
	/**
	 * @author Rafael
	 * 
	 * Metodo que recibe el id del usuario conectado y se lo pasa a la capa datos para que le devuelva una lista
	 * de los perfiles que ha dado el usuario dislike anteriormente
	 * 
	 * @param id_perfil parametro de tipo entero que contiene el id del usuario conectado
	 * @return retorna una lista de perfiles a los que el usuario ha dado dislike
	 */
	@Override
	public List<Perfil> listaDescartes(int id_perfil) {
		return prc.listadoContactos(id_perfil);
	}
}
