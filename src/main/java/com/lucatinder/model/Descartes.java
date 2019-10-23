package com.lucatinder.model;

public class Descartes {
	private int id_descartes;
	private int id_perfil;
	private int id_perfilDislike;
	
	public Descartes(int id_descartes, int id_perfil, int id_perfilDislike) {
		super();
		this.id_descartes = id_descartes;
		this.id_perfil = id_perfil;
		this.id_perfilDislike = id_perfilDislike;
	}
	
	public int getId_descartes() {
		return id_descartes;
	}
	public void setId_contacto(int id_descartes) {
		this.id_descartes = id_descartes;
	}
	public int getId_perfil() {
		return id_perfil;
	}
	public void setId_perfil(int id_perfil) {
		this.id_perfil = id_perfil;
	}
	public int getId_perfilDislike() {
		return id_perfilDislike;
	}
	public void setId_perfilLike(int id_perfilDislike) {
		this.id_perfilDislike = id_perfilDislike;
	}
}
