package com.lucatinder.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.github.javafaker.Faker;
import com.lucatinder.model.Perfil;

public class Utiles {
	private static Faker faker = new Faker(new Locale("es"));
	
	public List<Perfil> obtenerLista(){
		List<Perfil> listaPerfil = new ArrayList();
		for (int i = 0; i < 50; i++) {
			listaPerfil.add(generarPerfil());
		}
		return listaPerfil;
	}
	/**
	 * Metodo para generar perfiles falsos que utilizaremos para guardarlos en la base de datos.
	 * 
	 * @return retorna un objeto de tipo Perfil.
	 */
	public Perfil generarPerfil() {
		Perfil p = new Perfil();
		p.setNombre(faker.name().fullName());
		p.setEdad(obtenerRango(18,65));
		p.setAlias(p.getNombre().replaceAll(" ", "")+p.getEdad());
		p.setGenero((Math.random()>0.5)? true : false);
		p.setDescripcion("La vida es dura pero mas dura es la verdura");
		return p;
	}
	
	public int obtenerRango(int a, int b) {
		double randomNumber = (Math.random() * 100);
		b-=a;
		return (int) (((randomNumber *= b) / 100)+a);

	}
	
	public List<Perfil> convertirLista(List<Object[]> rq){
		List<Perfil> listaPerfil = new ArrayList<>();
		boolean genero;
		
		for (Object[] p : rq) {
			int g = Integer.parseInt(p[3].toString());
			if(g == 1) {
				genero = true;
			}else {
				genero = false;
			}
			listaPerfil.add(new Perfil((int) p[0], (String) p[1], (String) p[2], genero, (int)p[4], (String) p[5]));
        }
		return listaPerfil;
	}
}
