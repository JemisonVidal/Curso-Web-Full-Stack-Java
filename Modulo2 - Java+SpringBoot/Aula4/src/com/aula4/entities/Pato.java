package com.aula4.entities;

import com.aula4.resources.Voador;

import exceptions.DomainException;

public class Pato implements Voador{
	
	private int energia;
	
	public Pato() {
		this.energia = 100;
	}

	public int getEnergia() {
		return energia;
	}	

	@Override
	public void voar() {
		if (this.energia == 0) throw new DomainException("Não tenho energia suficiente para voar");
		this.energia -= 5;		
		System.out.println("Estou voando como um pato - Energia: "+this.energia);
	}
	
	public void dormir() {	
		this.energia = 100;
	}

}
