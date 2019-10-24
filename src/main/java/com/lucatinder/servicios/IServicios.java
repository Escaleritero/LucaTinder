package com.lucatinder.servicios;

import java.util.List;

import com.lucatinder.model.Perfil;

public interface IServicios {
	public void deletePerfil(int id_perfil);
	public Perfil addPerfil (Perfil perfil);
	public List<Perfil>listaPerfiles(int id_perfil);
	public Perfil validarPerfil(String alias);
	public void saveDislike (int id_perfil, int id_perfilDislike);
    public void saveLike (int id_perfil, int id_perfilLike);
    public List<Perfil>listaContactos(int id_perfil);

}
