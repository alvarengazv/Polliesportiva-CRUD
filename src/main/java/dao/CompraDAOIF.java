package dao;

import java.util.List;

import modelo.Compra;
import modelo.Produto;

public interface CompraDAOIF {
	public String cadastrar(Compra compra, List<Produto> produtos) throws DAOException;

	public List<Compra> todasCompras(int codCli) throws DAOException;

	public Compra buscarCompra(int cod) throws DAOException;
	
	public List<Produto> todosProdutosC(int cod) throws DAOException;
}
