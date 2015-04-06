package net.sistransitomobile.login;

public class RegistationFormat {

	private String imei, orgao,nome, matricula, cpf, login, senha, email;

	public RegistationFormat(String imei, String orgao, String nome,
			String matricula, String cpf, String login, String senha,
			String email) {
		super();
		this.imei = imei;
		this.orgao = orgao;
		this.nome = nome;
		this.matricula = matricula;
		this.cpf = cpf;
		this.login = login;
		this.senha = senha;
		this.email = email;
	}

	public String getImei() {
		return imei;
	}

	public String getOrgao() {
		return orgao;
	}

	public String getNome() {
		return nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public String getEmail() {
		return email;
	}

}
