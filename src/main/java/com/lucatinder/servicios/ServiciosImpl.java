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
		validar = iPerfilRepositorio.validarPerfil(perfil.getAlias());
		if(validar != 0) {
			iPerfilRepositorio.save(perfil);
			return perfil;
		}else {
			return null;
		}
	}
	
	@Override
	public Perfil validarPerfil(String alias) {
		int validar = 0;
		validar = iPerfilRepositorio.validarPerfil(alias);
		if(validar!=0) {
			return iPerfilRepositorio.obtenerPerfil(alias);
		}
		return null;
	}
	@Override
	public List<Perfil> listaPerfiles(int id_perfil) {
		List<Perfil> listaPerfil;
		listaPerfil = iPerfilRepositorio.listaPerfilId(id_perfil);
		
		if(listaPerfil.size()>=20) {
			return listaPerfil;
		}
		else {			
			//generadorDePerfil(); --> Método que se está creando en utilidades
			//Descomentar esta línea cuando esté hecho
		}
		return null;
	}

}
