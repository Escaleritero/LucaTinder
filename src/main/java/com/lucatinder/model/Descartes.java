package com.lucatinder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="descartes")
public class Descartes {
	@Id
	@GeneratedValue
	@Column (name = "id_descartes")
	private int id_descartes;
	@Column (name = "id_perfil")
	private int id_perfil;
	@Column (name = "id_perfil_dislike")
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

	@Override
	public String toString() {
		return "Descartes [id_descartes=" + id_descartes + ", id_perfil=" + id_perfil + ", id_perfilDislike="
				+ id_perfilDislike + "]";
	}
	
	
}
