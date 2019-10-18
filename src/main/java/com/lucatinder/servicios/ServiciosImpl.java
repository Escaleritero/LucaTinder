package com.lucatinder.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucatinder.datos.IPerfilRepositorio;
import com.lucatinder.model.Perfil;

@Service
public class ServiciosImpl  implements IServicios{
	@Autowired
	IPerfilRepositorio iPerfilRepositorio;
	
	@Override
	public Perfil addPerfil(Perfil perfil) {
		
		return null;
	}
	
}
