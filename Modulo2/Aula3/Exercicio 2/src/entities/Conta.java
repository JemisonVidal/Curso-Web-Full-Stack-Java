package entities;

public abstract class Conta {

	private int id;
	private Double saldo;

	public Conta() {

	}

	public Conta(int id, Double saldo) {
		super();
		this.id = id;
		this.saldo = saldo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo < 0 ? 0 : saldo;
	}

	public abstract void depositar(Double valor);

	public abstract void sacar(Double valor);

}
