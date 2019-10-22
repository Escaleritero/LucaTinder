package com.lucatinder.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lucatinder.model.Perfil;


public interface IServicios {

	public Perfil addPerfil (Perfil perfil); 	
	public List<Perfil>listaPerfiles(int id_perfil);
	public Perfil validarPerfil(String alias);

	
	public Perfil saveDislike (int id_perfil1, int id_perfil2);
	public Perfil saveLike (int id_perfil1, int id_perfil2);
	public Perfil devuelvePorID(int id_perfil);
	
}
