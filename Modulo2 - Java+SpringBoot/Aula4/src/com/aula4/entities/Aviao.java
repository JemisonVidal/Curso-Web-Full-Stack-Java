package com.aula4.entities;

import com.aula4.resources.Voador;

public class Aviao implements Voador {

	private Integer horasVoo;

	public Aviao() {
		this.horasVoo = 0;
	}

	public Aviao(Integer horasVoo) {
		this.horasVoo = horasVoo;
	}

	public Integer getHorasVoo() {
		return horasVoo;
	}
	

	@Override
	public void voar() {
		this.horasVoo +=13;
		System.out.println("Estou voando como um avião, e tenho "+ this.horasVoo +" horas de voo");
	}

}
