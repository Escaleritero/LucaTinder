package com.lucatinder.model;

import java.util.Date;

public class Perfil {

	private int id;
	private String alias, nombre, descripcion;
	private boolean genero;
	private Date fecha_de_nacimiento;
	
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
