package com.lucatinder.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucatinder.datos.IPerfilRepositorio;
import com.lucatinder.model.Perfil;

@Service
public class ServiciosImpl  implements IServicios{
	@Autowired
	IPerfilRepositorio iPerfilRepositorio;

	/**
	 * Metodo que le pasa un objeto para mandarlo a la base de datos.
	 * 
	 * @param perfil: objeto de la clase Perfil
	 * @return retorna un objeto o en caso de fallo un null
	 */
	@Override
	public Perfil addPerfil(Perfil perfil) {
		int validar = 0;
		validar = iPerfilRepositorio.validador(perfil.getAlias());
		
		if(validar != 0) {
			iPerfilRepositorio.save(perfil);
			return perfil;
		}else {
			return null;
		}
	}
}
