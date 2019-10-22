package com.lucatinder.datos;

import java.util.List;
import com.lucatinder.model.Perfil;




public interface PerfilRepositorioCustom{
	
	public int validarPerfil(String alias);
	public Perfil obtenerPerfil(String alias);
	public List<Perfil> listaPerfilId(int id_perfil);
	
	

	public Perfil saveDislike (int id_perfil1, int id_perfil2);
	public Perfil saveLike (int id_perfil1, int id_perfil2);
	
	
}
