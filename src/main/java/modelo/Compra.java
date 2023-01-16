package modelo;

import java.util.Calendar;
import java.util.List;

public class Compra {
	
	private int cod;
	private int codCli;
	private String formaPagamento;
	private String avaliacao;
	private String comentario;
	private Calendar dataHora;
	private List<Produto> produtosC;
	
	
	public Compra() {}

	public Compra(int cod, int codCli, String formaPagamento, String avaliacao, String comentario, Calendar dataHora, List<Produto> produtosC) {
		super();
		this.cod = cod;
		this.codCli = codCli;
		this.formaPagamento = formaPagamento;
		this.avaliacao = avaliacao;
		this.comentario = comentario;
		this.dataHora = dataHora;
		this.produtosC = produtosC;
	}
	
	public List<Produto> getProdutosC() {
		return produtosC;
	}

	public void setProdutosC(List<Produto> produtosC) {
		this.produtosC = produtosC;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public int getCodCli() {
		return codCli;
	}

	public void setCodCli(int codCli) {
		this.codCli = codCli;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Calendar getDataHora() {
		return dataHora;
	}

	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}
}
