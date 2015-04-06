package net.sistransitomobile.database;

public class UsuarioEntry {
	private String nome, matricula, nome_orgao, codigo_orgao;
	
	public UsuarioEntry(String nome, String matricula, String nome_orgao,
			String codigo_orgao) {
		super();
		this.nome = nome;
		this.matricula = matricula;
		this.nome_orgao = nome_orgao;
		this.codigo_orgao = codigo_orgao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome_orgao() {
		return nome_orgao;
	}

	public void setNome_orgao(String nome_orgao) {
		this.nome_orgao = nome_orgao;
	}

	public String getCodigo_orgao() {
		return codigo_orgao;
	}

	public void setCodigo_orgao(String codigo_orgao) {
		this.codigo_orgao = codigo_orgao;
	}

	

}
