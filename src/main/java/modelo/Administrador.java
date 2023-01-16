package modelo;

public class Administrador {
	private int cod;
	private String nome;
	private String sexo;
	private String dataNasc;
	private String tel;
	private String email;
	private String senha;
	
	public Administrador(){}
	
	public Administrador(int cod, String nome, String sexo, String dataNasc, String tel, String email,
			String senha) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.sexo = sexo;
		this.dataNasc = dataNasc;
		this.tel = tel;
		this.email = email;
		this.senha = senha;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
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
}

