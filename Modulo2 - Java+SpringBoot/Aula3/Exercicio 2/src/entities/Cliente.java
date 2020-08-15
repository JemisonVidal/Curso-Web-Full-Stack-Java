package entities;

public class Cliente {
	private int id;
	private String nome;
	private String sobrenome;
	private String rg;
	private String cpf;
	private ContaPoupanca contaPoupanca;
	private ContaCorrente contaCorrente;

	public Cliente() {

	}

	public Cliente(int id, String nome, String sobrenome, String rg, String cpf, ContaPoupanca contaPoupanca,
			ContaCorrente contaCorrente) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.rg = rg;
		this.cpf = cpf;
		this.contaPoupanca = contaPoupanca;
		this.contaCorrente = contaCorrente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public ContaPoupanca getContaPoupanca() {
		return contaPoupanca;
	}

	public void setContaPoupanca(ContaPoupanca contaPoupanca) {
		this.contaPoupanca = contaPoupanca;
	}

	public ContaCorrente getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(ContaCorrente contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Cliente \n");
		sb.append("Nome:           " + this.nome + "\n");
		sb.append("Sobrenome:      " + this.sobrenome + "\n");
		sb.append("RG:             " + this.rg + "\n");
		sb.append("CPF:            " + this.cpf + "\n");
		if (this.contaPoupanca != null)
			sb.append("Conta Poupanca: " + this.contaPoupanca + "\n");
		if (this.contaCorrente != null)
			sb.append("Conta Corrente: " + this.contaCorrente + "\n");

		return sb.toString();

	}

}
