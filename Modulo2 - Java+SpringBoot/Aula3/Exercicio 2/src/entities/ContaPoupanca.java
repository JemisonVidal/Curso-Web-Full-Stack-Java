package entities;

import exceptions.DomainException;

public class ContaPoupanca extends Conta {

	private Double txJuros;
	private Double valorJuros;

	public ContaPoupanca() {

	}

	public ContaPoupanca(int id, Double saldo, Double txJuros) {
		super(id, saldo);
		this.txJuros = txJuros;
		this.valorJuros = calcJuros(this.getSaldo());
	}

	public Double getTxJuros() {
		return txJuros;
	}

	public void setTxJuros(Double txJuros) {
		this.txJuros = txJuros;
	}

	public Double getValorJuros() {
		return valorJuros;
	}

	public void setValorJuros(Double valorJuros) {
		this.valorJuros = valorJuros;
	}

	public void recolherJuros() {
		System.out.println("-----------------------");
		System.out.println("-----------------------");
		System.out.println("Rendimento Recolhido: " + this.valorJuros);
		System.out.println("-----------------------");
		System.out.println("-----------------------");
		this.setValorJuros(0.0);
	}

	private Double calcJuros(Double valor) {
		return (valor * (this.txJuros / 100));
	}

	@Override
	public void depositar(Double valor) {
		Double saldoAtual = this.getSaldo();
		this.setSaldo(saldoAtual += valor);
		this.setValorJuros(this.valorJuros += calcJuros(valor));
	}

	@Override
	public void sacar(Double valor) {
		Double saldoAtual = this.getSaldo();
		if (valor > saldoAtual)
			throw new DomainException("Saldo insuficiente! Saldo Atual: " + saldoAtual);
		this.setSaldo(saldoAtual -= valor);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Conta - Poupança\n");
		sb.append("Número:      " + this.getId() + "\n");
		sb.append("Saldo:       " + this.getSaldo() + "\n");
		sb.append("tx.Juros:    " + this.txJuros + "\n");
		sb.append("Rendimentos: " + this.valorJuros + "\n");
		return sb.toString();
	}

}
