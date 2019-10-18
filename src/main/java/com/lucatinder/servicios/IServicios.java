package com.lucatinder.servicios;

import com.lucatinder.model.Perfil;

public interface IServicios {
	public Perfil addPerfil (Perfil perfil); 
	public Perfil validarPerfil(String alias);
}
