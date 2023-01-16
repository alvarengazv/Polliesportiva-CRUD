package dao;

import java.util.List;
import modelo.Administrador;

public interface AdministradorDAOIF {
	public String cadastrar(Administrador adm) throws DAOException;

	public String atualizar(Administrador adm) throws DAOException;

	public String remover(int cod) throws DAOException;

	public List<Administrador> todosAdministradores() throws DAOException;

	public Administrador buscarAdministrador(int cod) throws DAOException;
	
	public Administrador logarAdministrador(String loginU, String senhaU) throws DAOException;
}
