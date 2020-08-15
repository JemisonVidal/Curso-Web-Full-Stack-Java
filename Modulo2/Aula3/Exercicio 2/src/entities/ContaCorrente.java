package entities;

import java.util.Date;
import java.text.SimpleDateFormat;

import exceptions.DomainException;

public class ContaCorrente extends Conta {
	private Double valorLimite;
	private Double valorUsadoChequeEspecial;

	public ContaCorrente() {

	}

	public ContaCorrente(int id, Double saldo, Double valorLimite) {
		super(id, saldo);
		this.valorLimite = valorLimite;
		this.valorUsadoChequeEspecial = 0.0;
	}

	public Double getValorLimite() {
		return valorLimite;
	}

	public void setValorLimite(Double valorLimite) {
		this.valorLimite = valorLimite;
	}

	public Double getValorUsadoChequeEspecial() {
		return valorUsadoChequeEspecial;
	}

	public void setValorUsadoChequeEspecial(Double valorUsadoChequeEspecial) {
		this.valorUsadoChequeEspecial = valorUsadoChequeEspecial;
	}

	public void depositarCheque(Double valor, String banco, Date data) {
		StringBuilder sb = new StringBuilder();
		sb.append("Cheque Depositado \n");
		sb.append("Banco:          " + banco + "\n");
		sb.append("Data Pagamento: " + new Date() + "\n");
		sb.append("Valor:          " + valor + "\n");
		System.out.println(sb);
		this.depositar(valor);
	}

	@Override
	public void depositar(Double valor) {
		Double saldoAtual = this.getSaldo();
		if (this.valorUsadoChequeEspecial > 0) {
			valor = (valor - this.valorUsadoChequeEspecial);

			this.setValorUsadoChequeEspecial(valor >= 0 ? 0 : valor * -1);
		}

		if (valor > 0)
			this.setSaldo(saldoAtual += valor);
	}

	@Override
	public void sacar(Double valor) {
		Double saldoAtual = this.getSaldo();
		if (valor > (saldoAtual + this.valorLimite - this.valorUsadoChequeEspecial))
			throw new DomainException(
					"Saldo insuficiente! Saldo Atual: " + saldoAtual + " Saldo Cheque Especial: " + this.valorLimite);

		Double valorUtilizadoLis = valor > saldoAtual ? valor - saldoAtual : 0.0;
		this.setSaldo(saldoAtual -= valor);
		this.setValorUsadoChequeEspecial(valorUtilizadoLis);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Conta - Corrente \n");
		sb.append("Número:                 " + this.getId() + "\n");
		sb.append("Saldo:                  " + this.getSaldo() + "\n");
		sb.append("Limite cheque especial: " + this.valorLimite + "\n");
		sb.append("LIS Utilizado           " + this.valorUsadoChequeEspecial + "\n");

		return sb.toString();
	}

}
