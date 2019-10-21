package com.lucatinder.servicios;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucatinder.datos.IPerfilRepositorio;
import com.lucatinder.model.Perfil;

@Service
public class ServiciosImpl  implements IServicios{
	
	@Autowired
	IPerfilRepositorio ipr ;

	/**
	 * Metodo que le pasa un objeto para mandarlo a la base de datos.
	 * 
	 * @param perfil: objeto de la clase Perfil
	 * @return retorna un objeto o en caso de fallo un null
	 */
	
	@Override
	public Perfil addPerfil(Perfil perfil) {
		perfil = ipr.obtenerPerfil(perfil.getAlias());
		if(perfil == null) {
			ipr.save(perfil);
			return perfil;
		}else {
			return null;
		}
	}
	
	@Override
	public Perfil validarPerfil(String alias) {
		Perfil perfil = ipr.obtenerPerfil(alias);
		if(perfil != null) {
			return perfil;
		}else {
			return null;
		}
	}

	@Override
	public List<Perfil> listaPerfiles(int id_perfil) {
		
		return null;
	}

	@Override
	public void deletePerfil(int id_perfil) {
		ipr.deleteById(id_perfil);
		
	}
}
