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
	
	List aux=iPerfilRepositorio.
	
	@Override
	public String addPerfil(Perfil perfil) {		
		return null;
	}

	
	public Perfil validarPerfil (String alias){
		return null;
		//Descomentar cuando el método validarPerfil esté creado
		//return iPerfilRepositorio.validarPerfil( String alias);
		}

	
	
	@Override
	public List<Perfil> listaPerfiles(String alias) {
		
		if() 
		{
			//Si hay 20 perfiles
			return iPerfilRepositorio.listaPerfiles();
			
		}
		else {
			//
		}
		return utilidades.generadorDePerfil();
	}
}
