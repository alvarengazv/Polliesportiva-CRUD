package modelo;

public class Endereco {
	private int cod;
	private String cep;
	private String numero;
	private String complemento;
	private String nomeEnd;
	private String rua;
	private String bairro;
	private String referencia;
	private String cidade;
	private String estado;
	
	public Endereco() {}
	
	public Endereco(int cod, String cep, String numero, String complemento, String nomeEnd, String rua, String bairro,
			String referencia, String cidade, String estado) {
		super();
		this.cod = cod;
		this.cep = cep;
		this.numero = numero;
		this.complemento = complemento;
		this.nomeEnd = nomeEnd;
		this.rua = rua;
		this.bairro = bairro;
		this.referencia = referencia;
		this.cidade = cidade;
		this.estado = estado;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNomeEnd() {
		return nomeEnd;
	}

	public void setNomeEnd(String nomeEnd) {
		this.nomeEnd = nomeEnd;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
