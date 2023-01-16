package modelo;

public class Produto {
	private int cod;
	private String nome;
	private String preco;
	private String marca;
	private String fornecedor;
	private String categoria;
	private String subcategoria;
	private String descricao;
	private String nomeArq;
	
	public Produto() {}

	public Produto(int cod, String nome, String preco, String marca, String fornecedor, String categoria, String subcategoria, String descricao, String nomeArq) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.preco = preco;
		this.marca = marca;
		this.fornecedor = fornecedor;
		this.categoria = categoria;
		this.subcategoria = subcategoria;
		this.descricao = descricao;
		this.nomeArq = nomeArq;
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

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(String subcategoria) {
		this.subcategoria = subcategoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getNomeArq() {
		return nomeArq;
	}

	public void setNomeArq(String nomeArq) {
		this.nomeArq = nomeArq;
	}
	
}

