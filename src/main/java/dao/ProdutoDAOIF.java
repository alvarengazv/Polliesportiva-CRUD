package dao;

import java.util.List;
import modelo.Cliente;
import modelo.Produto;

public interface ProdutoDAOIF {
	public String cadastrar(Produto produto) throws DAOException;

	public String atualizar(Produto produto) throws DAOException;

	public String remover(int cod) throws DAOException;

	public List<Produto> todosProdutos() throws DAOException;

	public Produto buscarProduto(int cod) throws DAOException;
}
