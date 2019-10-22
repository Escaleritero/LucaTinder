package com.lucatinder.datos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lucatinder.model.Perfil;


@Repository
public interface IPerfilRepositorio extends JpaRepository<Perfil, Integer>, PerfilRepositorioCustom{
	
}

