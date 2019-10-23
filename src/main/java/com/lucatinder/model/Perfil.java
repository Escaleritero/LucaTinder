package com.lucatinder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "perfiles")
public class Perfil {

	@Id
	@GeneratedValue
	@Column (name = "id_perfiles")
	private int id;
	
	@Column (name = "alias")
	private String alias;
	
	@Column (name = "nombre")
	private String nombre;
	
	@Column (name = "genero")
	private boolean genero;
	
	@Column (name = "edad")
	private int edad;
	
	@Column (name = "descripcion")
	private String descripcion;
	
	public Perfil() {
		super();
	}

	
	public Perfil(String alias) {
		super();
		this.alias = alias;
	}


	public Perfil(String alias, String nombre, boolean genero, int edad) {
		super();
		this.alias = alias;
		this.nombre = nombre;
		this.genero = genero;
		this.edad = edad;
	}

	public Perfil(String alias, String nombre, boolean genero, int edad, String descripcion) {
		super();
		this.alias = alias;
		this.nombre = nombre;
		this.genero = genero;
		this.edad = edad;
		this.descripcion = descripcion;
	}
	
	public Perfil(int id, String alias, String nombre, boolean genero, int edad, String descripcion) {
		super();
		this.id = id;
		this.alias = alias;
		this.nombre = nombre;
		this.genero = genero;
		this.edad = edad;
		this.descripcion = descripcion;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isGenero() {
		return genero;
	}
	public void setGenero(boolean genero) {
		this.genero = genero;
	}
	
	
	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Override
	public String toString() {
		return "Perfil [id=" + id + ", alias=" + alias + ", nombre=" + nombre + ", genero=" + genero + ", edad=" + edad
				+ ", descripcion=" + descripcion + "]";
	}
	
	
	
}
