package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import entities.PessoaFisica;
import entities.PessoaJuridica;
import entities.enums.PessoaCargo;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		PessoaFisica pessoaFisicaDev = new PessoaFisica(1, "Jemison Vidal", "Rua Urano", "00000000000",
				"jemison.santoos@gmail.com", 1, sdf.parse("01/09/2019"), null, null, "0001", 6000.0, PessoaCargo.DEV);

		PessoaFisica pessoaFisicaSupervisor = new PessoaFisica(2, "Supervisor", "Endereco", "00000000000",
				"Supervisor@gmail.com", 1, sdf.parse("01/09/2019"), null, sdf.parse("01/05/2020"), "0001", 6000.0,
				PessoaCargo.SUPERVISOR);

		PessoaFisica pessoaFisicaGerente = new PessoaFisica(3, "Gerente", "Endereco", "00000000000",
				"Gerente@gmail.com", 1, sdf.parse("01/01/2019"), null, sdf.parse("01/04/2020"), "0001", 6000.0,
				PessoaCargo.GERENTE);

		PessoaFisica pessoaFisicaDev2 = new PessoaFisica(4, "Jemison Vidal", "Rua Urano", "00000000000",
				"jemison.santoos@gmail.com", 1, sdf.parse("01/09/2019"), null, null, "0001", 6000.0, PessoaCargo.DEV);

		PessoaFisica pessoaFisicaSupervisor2 = new PessoaFisica(5, "Supervisor", "Endereco", "00000000000",
				"Supervisor@gmail.com", 1, sdf.parse("01/09/2019"), null, sdf.parse("01/05/2020"), "0001", 6000.0,
				PessoaCargo.SUPERVISOR);

		PessoaFisica pessoaFisicaGerente2 = new PessoaFisica(6, "Gerente", "Endereco", "00000000000",
				"Gerente@gmail.com", 1, sdf.parse("01/01/2019"), null, sdf.parse("01/04/2020"), "0001", 6000.0,
				PessoaCargo.GERENTE);
		
		
		System.out.println("---------------------------------------------");
		System.out.println("Classe PessoaJurica");
		System.out.println("---------------------------------------------");
		PessoaJuridica pessoaJuricaDev = new PessoaJuridica(1, "Juridica", "Rua Urano", "00000000000000",
				"jemison.santoos@gmail.com", 1, sdf.parse("01/09/2019"), null, null, 10000.0, PessoaCargo.DEV);
		System.out.println(pessoaJuricaDev);		
		//Obs: Como era obrigatório criar 2 classes distintas, o resultado é praticamente o mesmo, os testes abaixo foram feitos apenas em uma.
		System.out.println("---------------------------------------------");
		System.out.println("Classe PessoaFisica");
		System.out.println("---------------------------------------------");
		System.out.println("---------------------------------------------");
		System.out.println("Holerite");
		System.out.println("---------------------------------------------");
		System.out.println(pessoaFisicaDev);
		System.out.println(pessoaFisicaSupervisor);
		System.out.println(pessoaFisicaGerente);
		System.out.println("---------------------------------------------");
		System.out.println("Solicitar Férias");
		System.out.println("---------------------------------------------");
		pessoaFisicaDev.solicitarFerias();
		System.out.println(pessoaFisicaDev);
		pessoaFisicaSupervisor.solicitarFerias();
		System.out.println(pessoaFisicaSupervisor);
		pessoaFisicaGerente.solicitarFerias();
		System.out.println(pessoaFisicaGerente);
		System.out.println("---------------------------------------------");
		System.out.println("Reajustar Salário");
		System.out.println("---------------------------------------------");
		// Exemplo Exception - Um gerente não pode reajustar os salários de gerente
		// pessoaFisicaGerente.reajustarSalario(pessoaFisicaGerente, 5);
		// Exemplo Exception - reajuste não implique em redução do salário
		// pessoaFisicaGerente.reajustarSalario(pessoaFisicaDev, -1);
		pessoaFisicaGerente.reajustarSalario(pessoaFisicaDev, 5); // Obs: Não irá receber bonificação pelo cargo de dev.
		System.out.println(pessoaFisicaDev);
		pessoaFisicaGerente.reajustarSalario(pessoaFisicaSupervisor, 5); // Obs: irá receber bonificação pelo cargo de
																			// Supervisor.
		System.out.println(pessoaFisicaSupervisor);
		System.out.println("---------------------------------------------");
		System.out.println("Demissão");
		System.out.println("---------------------------------------------");
		// Exemplos Exception - Um dev não pode demitir funcionarios;
		// pessoaFisicaDev.demitir(pessoaFisicaDev2);
		// pessoaFisicaDev.demitir(pessoaFisicaSupervisor);
		// pessoaFisicaDev.demitir(pessoaFisicaGerente);
		// Mas pode se demitir;
		pessoaFisicaDev.demitir(pessoaFisicaDev);
		System.out.println(pessoaFisicaDev);

		// Um supervisor pode demitir um funcionário
		pessoaFisicaSupervisor.demitir(pessoaFisicaDev);
		System.out.println(pessoaFisicaDev);

		// Exemplos Exception - mas não pode demitir outro supervisor
		// pessoaFisicaSupervisor.demitir(pessoaFisicaSupervisor2);

		// Exemplos Exception - mas não pode demitir um gerente
		// pessoaFisicaSupervisor.demitir(pessoaFisicaGerente);

		// Mas pode se demitir;
		pessoaFisicaSupervisor.demitir(pessoaFisicaSupervisor);
		System.out.println(pessoaFisicaSupervisor);

		// um gerente pode demitir um funcionário
		pessoaFisicaGerente.demitir(pessoaFisicaDev);
		System.out.println(pessoaFisicaDev);

		// um gerente pode demitir um supervisor
		pessoaFisicaGerente.demitir(pessoaFisicaSupervisor);
		System.out.println(pessoaFisicaSupervisor);

		// um gerente pode se demitir
		pessoaFisicaGerente.demitir(pessoaFisicaGerente);
		System.out.println(pessoaFisicaGerente);

		// Exemplos Exception - mas não pode demitir outro gerente
		// pessoaFisicaGerente.demitir(pessoaFisicaGerente2);

		System.out.println("---------------------------------------------");
		System.out.println("Horas Trabalhadas");
		System.out.println("---------------------------------------------");
		pessoaFisicaDev.setFeriasStatus(false);
		pessoaFisicaDev.trabalhar(5);
		pessoaFisicaDev.trabalhar(5);
		System.out.println(pessoaFisicaDev);
		System.out.println("---------------------------------------------");
		System.out.println("Solicitar Aumento");
		System.out.println("---------------------------------------------");
		boolean isAumento = pessoaFisicaDev.solicitarAumento();
		System.out.println("Aumento Aprovado: " + isAumento);
		System.out.println("Aplicado +30h trabalhadas.");
		pessoaFisicaDev.trabalhar(30);
		isAumento = pessoaFisicaDev.solicitarAumento();
		System.out.println("Aumento Aprovado: " + isAumento);
	}
}
