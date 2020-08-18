package com.aula4.entities;

import com.aula4.resources.Voador;

public class SuperHomem implements Voador {
	
	private Integer experiencia;
	
	public SuperHomem() {
		this.experiencia = 0;
	}
	
	public SuperHomem(Integer experiencia) {
		this.experiencia = experiencia;
	}

	@Override
	public void voar() {		
		this.experiencia +=3;
		System.out.println("Estou voando como um campeão - Experiência: "+this.experiencia);	
	}	

}
