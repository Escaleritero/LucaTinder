package com.lucatinder.datos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucatinder.model.Perfil;

public interface IPerfilRepositorio extends JpaRepository<Perfil, Integer>, PerfilRepositorioCustom{
	
}
