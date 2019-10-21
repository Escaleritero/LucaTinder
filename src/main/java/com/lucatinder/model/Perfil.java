package com.lucatinder.model;

import java.util.Date;
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
	
	@Column (name = "fecha_de_nacimiento")
	private Date fecha_de_nacimiento;
	
	@Column (name = "descripcion")
	private String descripcion;
	
	public Perfil() {
		super();
	}

	public Perfil(String alias, String nombre, boolean genero, Date fecha_de_nacimiento) {
		super();
		this.alias = alias;
		this.nombre = nombre;
		this.genero = genero;
		this.fecha_de_nacimiento = fecha_de_nacimiento;
	}

	public Perfil(String alias, String nombre, boolean genero, Date fecha_de_nacimiento, String descripcion) {
		super();
		this.alias = alias;
		this.nombre = nombre;
		this.genero = genero;
		this.fecha_de_nacimiento = fecha_de_nacimiento;
		this.descripcion = descripcion;
	}
	
	public Perfil(int id, String alias, String nombre, boolean genero, Date fecha_de_nacimiento, String descripcion) {
		super();
		this.id = id;
		this.alias = alias;
		this.nombre = nombre;
		this.genero = genero;
		this.fecha_de_nacimiento = fecha_de_nacimiento;
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
	public Date getFecha_de_nacimiento() {
		return fecha_de_nacimiento;
	}
	public void setFecha_de_nacimiento(Date fecha_de_nacimiento) {
		this.fecha_de_nacimiento = fecha_de_nacimiento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
