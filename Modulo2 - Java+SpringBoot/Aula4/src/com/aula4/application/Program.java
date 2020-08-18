package com.aula4.application;

import java.util.ArrayList;
import java.util.List;

import com.aula4.entities.Aviao;
import com.aula4.entities.Pato;
import com.aula4.entities.SuperHomem;
import com.aula4.entities.TorreDeControle;
import com.aula4.resources.Voador;

public class Program {

	public static void main(String[] args) {
		List<Voador> voadores = new ArrayList<>();
		voadores.add(new Pato());
		voadores.add(new Aviao());
		voadores.add(new SuperHomem());

		TorreDeControle torreDeControle = new TorreDeControle(voadores);
		torreDeControle.voemTodos();

		torreDeControle.voemTodos();

	}

}
