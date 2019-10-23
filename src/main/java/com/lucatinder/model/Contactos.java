package com.lucatinder.model;

public class Contactos {
	private int id_contacto;
	private int id_perfil;
	private int id_perfilLike;
	
	public Contactos(int id_contacto, int id_perfil, int id_perfilLike) {
		super();
		this.id_contacto = id_contacto;
		this.id_perfil = id_perfil;
		this.id_perfilLike = id_perfilLike;
	}
	
	public int getId_contacto() {
		return id_contacto;
	}
	public void setId_contacto(int id_contacto) {
		this.id_contacto = id_contacto;
	}
	public int getId_perfil() {
		return id_perfil;
	}
	public void setId_perfil(int id_perfil) {
		this.id_perfil = id_perfil;
	}
	public int getId_perfilLike() {
		return id_perfilLike;
	}
	public void setId_perfilLike(int id_perfilLike) {
		this.id_perfilLike = id_perfilLike;
	}
	
	
}
