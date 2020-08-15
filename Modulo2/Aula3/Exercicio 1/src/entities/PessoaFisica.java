package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import entities.enums.PessoaCargo;
import exceptions.DomainException;

public class PessoaFisica {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private int id;
	private String nome;
	private String endereco;
	private String cpf;
	private String email;
	private int setor;
	private Date dataDeAdmissao;
	private Date dataDeDemissao;
	private Date dataUltimaFerias;
	private String nit;
	private Double salarioBase;
	private PessoaCargo cargo;
	private int horasTrabalhadas;
	private boolean feriasStatus;
	private String tipo;

	public PessoaFisica() {

	}

	public PessoaFisica(int id, String nome, String endereco, String cpf, String email, int setor, Date dataDeAdimissao,
			Date dataDeDemissao, Date dataUltimaFerias, String nit, Double salarioBase, PessoaCargo cargo) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.cpf = cpf;
		this.email = email;
		this.setor = setor;
		this.dataDeAdmissao = dataDeAdimissao;
		this.dataDeDemissao = dataDeDemissao;
		this.dataUltimaFerias = dataUltimaFerias;
		this.nit = nit;
		this.cargo = cargo;
		this.setSalarioBase(salarioBase);
		this.setHorasTrabalhadas(0);
		this.setTipo(this.cargo == PessoaCargo.GERENTE || this.cargo == PessoaCargo.SUPERVISOR ? "F" : "J");
		// Obrigatorio criar 2 classes distintas para Pessoa Fisica e Pessoa Juridica
		// Supervisores e gerentes sempre serão do tipo de funcionário Pessoa Física
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSetor() {
		return setor;
	}

	public void setSetor(int setor) {
		this.setor = setor;
	}

	public Date getDataDeAdimissao() {
		return dataDeAdmissao;
	}

	public void setDataDeAdimissao(Date dataDeAdimissao) {
		this.dataDeAdmissao = dataDeAdimissao;
	}

	public Date getDataDeDemissao() {
		return dataDeDemissao;
	}

	public void setDataDeDemissao(Date dataDeDemissao) {
		this.dataDeDemissao = dataDeDemissao;
	}

	public Date getDataUltimaFerias() {
		return dataUltimaFerias;
	}

	public void setDataUltimaFerias(Date dataUltimaFerias) {
		this.dataUltimaFerias = dataUltimaFerias;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public PessoaCargo getCargo() {
		return cargo;
	}

	public void setCargo(PessoaCargo cargo) {
		this.cargo = cargo;
	}

	public int getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(int horasTrabalhadas) {
		this.horasTrabalhadas += horasTrabalhadas;
	}

	public boolean getFeriasStatus() {
		return feriasStatus;
	}

	public void setFeriasStatus(boolean isFeriasStatus) {
		this.feriasStatus = isFeriasStatus;
	}

	public void setSalarioBase(Double salarioBase) {
		switch (this.cargo) {
		case GERENTE:
			salarioBase = (salarioBase * 0.12) + salarioBase;
			break;
		case SUPERVISOR:
			salarioBase = (salarioBase * 0.08) + salarioBase;
			break;
		default:
			break;
		}
		this.salarioBase = salarioBase;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void solicitarFerias() {
		Date dataAtual = new Date();
		final double MES_EM_MILISEGUNDOS = 30.0 * 24.0 * 60.0 * 60.0 * 1000.0;
		int numeroDeMesesAdmissao = (int) ((dataAtual.getTime() - this.dataDeAdmissao.getTime()) / MES_EM_MILISEGUNDOS);

		int numeroDeMesesUltFerias = 0;
		if (this.dataUltimaFerias != null) {
			numeroDeMesesUltFerias = (int) ((dataAtual.getTime() - this.dataUltimaFerias.getTime())
					/ MES_EM_MILISEGUNDOS);
		}

		boolean isApproved = (numeroDeMesesAdmissao >= 11
				&& (this.dataUltimaFerias == null || numeroDeMesesUltFerias >= 4));
		this.setFeriasStatus(isApproved);
		if (isApproved)
			setDataUltimaFerias(dataAtual);
	}

	public void demitir(PessoaFisica funcionario) {
		if (this.cargo == PessoaCargo.DEV && funcionario.id != this.id)
			throw new DomainException("Apenas Gerentes/Supervisores podem demitir!");

		if ((funcionario.cargo == PessoaCargo.GERENTE && funcionario.id != this.id)
				|| funcionario.cargo == PessoaCargo.SUPERVISOR && this.cargo == PessoaCargo.SUPERVISOR
						&& funcionario.id != this.id)

			throw new DomainException("Você não tem permissão para demitir esse funcionario");

		try {
			funcionario.setDataDeDemissao(new Date());

		} catch (Exception e) {
			throw new DomainException("Falha ao demitir funcionario");
		}
	}

	public void reajustarSalario(PessoaFisica funcionario, float porcentagem) {
		if (porcentagem <= 0)
			throw new DomainException("A porcentagem do reajuste deve ser maior que zero!");

		if (this.cargo != PessoaCargo.GERENTE)
			throw new DomainException("Apenas gerentes podem reajustar os salários!");

		if (funcionario.cargo == PessoaCargo.GERENTE)
			throw new DomainException("Você não pode reajustar o salário de outro gerente!");

		try {
			double salarioBase = Math.round((funcionario.salarioBase * (porcentagem / 100)) + funcionario.salarioBase);
			funcionario.setSalarioBase(salarioBase); // Se for supervisor irá receber uma bonificação

		} catch (Exception e) {
			throw new DomainException("Falha ao reajustar salário");
		}
	}

	public void trabalhar(int horasTrabalhadas) {
		if (this.getFeriasStatus())
			throw new DomainException("Você não pode trabalhar nas férias!");
		this.setHorasTrabalhadas(horasTrabalhadas);
	}

	public boolean solicitarAumento() {
		return this.getHorasTrabalhadas() >= 40;
	}

	/* Contra-Cheque */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Horelite \n");
		sb.append("Funcionário:       " + this.nome + "\n");
		sb.append("CPF:               " + this.cpf + "\n");
		sb.append("Tipo:              " + this.tipo + "\n");
		sb.append("Admissão           " + this.dataDeAdmissao + "\n");
		sb.append("Demissão           " + this.dataDeDemissao + "\n");
		sb.append("Salário:           " + this.salarioBase + "\n");
		sb.append("Cargo:             " + this.cargo + "\n");
		sb.append("Horas Trabalhadas: " + this.horasTrabalhadas + "\n");
		sb.append("Ult. Férias        " + this.dataUltimaFerias + "\n");
		sb.append("Férias Ativa:      " + this.feriasStatus + "\n");
		return sb.toString();
	}

}
