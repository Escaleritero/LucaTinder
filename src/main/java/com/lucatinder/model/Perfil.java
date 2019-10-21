package com.lucatinder.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "perfiles")
public class Perfil {


	@Override
	public String toString() {
		return "Perfil [id=" + id + ", alias=" + alias + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", genero=" + genero + ", edad=" + edad + "]\n";
	}
	//@ManyToOne/OneToMany/JoinColumn...??
	private int id;
	private String alias, nombre, descripcion;
	private boolean genero;
	private int edad;		
	
	public Perfil(int id, String alias, String nombre, String descripcion, boolean genero, int edad) {
		super();
		this.id = id;
		this.alias = alias;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.genero = genero;
		this.edad = edad;
	}
	
	public Perfil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setGenero(boolean genero) {
		this.genero = genero;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	
	@Id
	@GeneratedValue
	@Column(name = "id_perfiles")
	public int getId() {
		return id;
	}
	public String getAlias() {
		return alias;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public boolean isGenero() {
		return genero;
	}
	public int getEdad() {
		return edad;
	}
	
}
