package dao;

import java.util.List;
import modelo.Cliente;

public interface ClienteDAOIF {
	public String cadastrar(Cliente cliente) throws DAOException;

	public String atualizar(Cliente cliente) throws DAOException;

	public String remover(int cod) throws DAOException;

	public List<Cliente> todosClientes() throws DAOException;

	public Cliente buscarCliente(int cod) throws DAOException;
	
	public Cliente logarCliente(String loginU, String senhaU) throws DAOException;
}
