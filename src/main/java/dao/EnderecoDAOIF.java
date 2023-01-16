package dao;

import java.util.List;
import modelo.Endereco;

public interface EnderecoDAOIF {
	public String cadastrar(Endereco endereco, int codCli) throws DAOException;

	public String atualizar(Endereco endereco) throws DAOException;

	public String remover(int cod) throws DAOException;

	public List<Endereco> todosEnderecos(int codCli) throws DAOException;

	public Endereco buscarEndereco(int cod) throws DAOException;
}
