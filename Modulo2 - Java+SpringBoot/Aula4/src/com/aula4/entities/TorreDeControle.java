package com.aula4.entities;

import java.util.ArrayList;
import java.util.List;

import com.aula4.resources.Voador;

public class TorreDeControle {
	
	
	List<Voador> voadores = new ArrayList<>();
	
	public TorreDeControle(List<Voador> voadores) {
		this.voadores = voadores;
	}
	
	public void voemTodos() {
		for(Voador voador: this.voadores) {
			voador.voar();			
		}		
	}
}
