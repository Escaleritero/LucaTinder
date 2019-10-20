package com.lucatinder.utiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.github.javafaker.Faker;
import com.lucatinder.model.Perfil;



public class Utiles {

	
	
	public static List<Perfil> generadorDePerfiles()
	
	{
		
		//Descomentar en el proyecto Maven.
		//Faker faker = new Faker();
		
		List<Perfil> listaPerfiles = new ArrayList<Perfil>();
		
		for(int i=1;i<=20;i++) {
			
		Random random = new Random();
		
		//Esto es para incluirlo en el proyecto Maven. Descomentarlo para el proyecto Maven.
		//Perfil perfil = new Perfil((int) Math.random()*10000, faker.starTrek().character(), faker.name().fullName(), faker.yoda().quote(), random.nextBoolean(), random.nextInt());
		Perfil perfil = new Perfil(Math.abs(random.nextInt()), "Seducci�n69", "Glymmdok L�pez Gonz�lez", "Me gusta la pizza con pi�a y la paella con chorizo. Busco una "
				+"persona sincera, divertida y cari�osa. <3", random.nextBoolean(), Math.abs(random.nextInt()/10000000));
				
		listaPerfiles.add(perfil);

		
		
		}
		
		System.out.println(listaPerfiles);
		return listaPerfiles;
	}
	
	
}
