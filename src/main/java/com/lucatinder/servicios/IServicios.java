package com.lucatinder.servicios;

import java.util.List;

import com.lucatinder.model.Perfil;

public interface IServicios {

	public Perfil addPerfil (Perfil perfil); 	
	public List<Perfil>listaPerfiles(String alias);
	public Perfil validarPerfil(String alias);

}
