package com.lucatinder.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Perfil {

	@Id
	@GeneratedValue
	@Column (name = "id_perfiles")
	//@ManyToOne/OneToMany/JoinColumn...??
	private int id;
	private String alias, nombre, descripcion;
	private boolean genero;
	private Date fecha_de_nacimiento;		
	
	public Perfil(int id, String alias, String nombre, String descripcion, boolean genero, Date fecha_de_nacimiento) {
		super();
		this.id = id;
		this.alias = alias;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.genero = genero;
		this.fecha_de_nacimiento = fecha_de_nacimiento;
	}
	
	public Perfil() {
		super();
		// TODO Auto-generated constructor stub
	}

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
	public Date getFecha_de_nacimiento() {
		return fecha_de_nacimiento;
	}
		
}
