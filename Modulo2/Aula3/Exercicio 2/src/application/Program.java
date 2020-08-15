package application;

import entities.Cliente;
import entities.ContaCorrente;
import entities.ContaPoupanca;

public class Program {
	public static void main(String[] args) {
		ContaPoupanca contaPoupanca = new ContaPoupanca(1, 1000.0, 5.0);
		Cliente cliente = new Cliente(1, "Jemison", "Vidal", "1111111111", "00000000000", contaPoupanca, null);

		System.out.println(cliente);
		contaPoupanca.depositar(100.0);
		System.out.println(cliente);

		contaPoupanca.sacar(1100.0);
		System.out.println(cliente);

		contaPoupanca.recolherJuros();
		System.out.println();
		System.out.println(cliente);

		ContaCorrente contaCorrente = new ContaCorrente(1, 2000.0, 500.0);
		Cliente clienteComContaCorrente = new Cliente(1, "Jemison - Conta Corrente", "Vidal", "1111111111",
				"00000000000", null, contaCorrente);
		System.out.println(clienteComContaCorrente);

		// Realiza o Deposito;
		contaCorrente.depositar(500.0);
		System.out.println(clienteComContaCorrente);

		// Realiza o Saque utilizando o Lis, zerado o saldo e somando no LIS;
		contaCorrente.sacar(2501.0);
		System.out.println(clienteComContaCorrente);

		// Realiza o Deposito, diminundo o LIS, e somando o resto no saldo;
		contaCorrente.depositar(500.0);
		System.out.println(clienteComContaCorrente);

	}

}
