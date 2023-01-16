package modelo;

public class Cliente {
	private String nome;
	private String sexo;
	private String cpf;
	private String dataNasc;
	private String tel;
	private String email;
	private String senha;
	private String nomeArq;
	private String notificacao;
	private int cod = 0;
	
	

	public Cliente() {}
	
	public Cliente(String nome, String sexo, String cpf, String dataNasc, String tel, String email, String senha, String nomeArq, int cod) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.tel = tel;
		this.email = email;
		this.senha = senha;
		this.nomeArq = nomeArq;
		this.cod = cod;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNomeArq() {
		return nomeArq;
	}
	public void setNomeArq(String nomeArq) {
		this.nomeArq = nomeArq;
	}
	
	public String getNotificacao() {
		return notificacao;
	}

	public void setNotificacao(String notificacao) {
		this.notificacao = notificacao;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
}

