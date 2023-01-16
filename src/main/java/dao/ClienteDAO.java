package dao;

import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import modelo.Cliente;
import util.ConnectionFactory;
import java.util.Calendar;

public class ClienteDAO implements ClienteDAOIF {
	private Connection connection;

	public ClienteDAO() throws DAOException {
		try {
			this.connection = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new DAOException("Erro na conexÃ£o: " + e.getMessage());
		}
	}

	@Override
	public String cadastrar(Cliente cliente) throws DAOException {
		try {
			String sql = "INSERT INTO CLIENTE (cpf, nome_cliente, sexo_cliente, dataNasc_cliente, tel_cliente, email_cliente, senha_cliente, nomeArq_cliente, notificacao_cliente) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement stmt = this.connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setString(1, cliente.getCpf());
			stmt.setString(2, cliente.getNome());
			stmt.setString(3, cliente.getSexo());
			stmt.setString(4, cliente.getDataNasc());
			stmt.setString(5, cliente.getTel());
			stmt.setString(6, cliente.getEmail());
			stmt.setString(7, cliente.getSenha());
			stmt.setString(8, cliente.getNomeArq());
			stmt.setString(9, cliente.getNotificacao());
			

			stmt.execute();

			ResultSet rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				int cod = rs.getInt(1);
				cliente.setCod(cod);
			}
			
			rs.close();
			stmt.close();
			return "Cliente com o código \"" + cliente.getCod() + "\" cadastrado com sucesso!";
		} catch (Exception e) {
			System.out.println(new DAOException("Erro ao cadastrar: " + e.getMessage()));
			return "ERRO: Não foi possível cadastrar. Verifique se seus dados estão corretos ou se este CPF já está cadastrado!";
		}

	}

	@Override
	public String atualizar(Cliente cliente) throws DAOException {
		try {
			String sql = "UPDATE CLIENTE SET cpf = ?, nome_cliente = ?, sexo_cliente = ?, dataNasc_cliente = ?, tel_cliente = ?, email_cliente = ?, senha_cliente = ?, nomeArq_cliente = ?, notificacao_cliente = ? WHERE codigo_cliente = ?";

			PreparedStatement stmt = this.connection.prepareStatement(sql);

			stmt.setString(1, cliente.getCpf());
			stmt.setString(2, cliente.getNome());
			stmt.setString(3, cliente.getSexo());
			stmt.setString(4, cliente.getDataNasc());
			stmt.setString(5, cliente.getTel());
			stmt.setString(6, cliente.getEmail());
			stmt.setString(7, cliente.getSenha());
			stmt.setString(8, cliente.getNomeArq());
			stmt.setString(9, cliente.getNotificacao());
			stmt.setInt(10, cliente.getCod());

			stmt.executeUpdate();
			stmt.close();
			return "Cliente com o código \"" + cliente.getCod() + "\" foi atualizado com sucesso!";
		} catch (Exception e) {
			System.out.println(new DAOException("Erro ao atualizar: " + e.getMessage()));
			return "ERRO: Não foi possível atualizar o cliente. Verifique se seus dados estão corretos!";
		}
	}

	@Override
	public String remover(int cod) throws DAOException {
		try {
			String sql = "DELETE FROM CADASTRA WHERE codigo_cliente = ?";
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt = this.connection.prepareStatement(sql);
			
			stmt.setInt(1, cod);
			
			stmt.executeUpdate();
			
			sql = "DELETE FROM CLIENTE WHERE codigo_cliente = ?";

			stmt = this.connection.prepareStatement(sql);

			stmt.setInt(1, cod);

			stmt.executeUpdate();
			stmt.close();
			return "Cliente com o código \"" + cod + "\" foi removido com sucesso!";
		} catch (Exception e) {
			System.out.println(new DAOException("Erro ao remover: " + e.getMessage()));
			return "ERRO: Não foi possível remover o cliente escolhido.";
		}
	}

	@Override
	public List<Cliente> todosClientes() throws DAOException {

		List<Cliente> clientes = new ArrayList<Cliente>();

		try {
			Statement st = this.connection.createStatement();

			String sql = "SELECT codigo_cliente, cpf, nome_cliente, sexo_cliente, dataNasc_cliente, tel_cliente, email_cliente, senha_cliente, nomeArq_cliente, notificacao_cliente FROM CLIENTE";

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				int cod = rs.getInt("codigo_cliente");
				String cpf = rs.getString("cpf");
				String nome = rs.getString("nome_cliente");
				String sexo = rs.getString("sexo_cliente");
				String dataNasc = rs.getString("dataNasc_cliente");
				String tel = rs.getString("tel_cliente");
				String email = rs.getString("email_cliente");
				String senha = rs.getString("senha_cliente");
				String nomeArq = rs.getString("nomeArq_cliente");
				String notificacao = rs.getString("notificacao_cliente");

				Cliente cliente = new Cliente();
				cliente.setCod(cod);
				cliente.setCpf(cpf);
				cliente.setNome(nome);
				cliente.setSexo(sexo);
				cliente.setDataNasc(dataNasc);
				cliente.setTel(tel);
				cliente.setEmail(email);
				cliente.setSenha(senha);
				cliente.setNomeArq(nomeArq);
				cliente.setNotificacao(notificacao);
				

				clientes.add(cliente);
			}

			rs.close();
			st.close();
			return clientes;
		} catch (Exception e) {
			throw new DAOException("Erro ao buscar: " + e.getMessage());
		}
	}

	@Override
	public Cliente buscarCliente(int cod) throws DAOException {
		Cliente cliente = null;
		try {
			String sql = "SELECT cpf, nome_cliente, sexo_cliente, dataNasc_cliente, tel_cliente, email_cliente, senha_cliente, nomeArq_cliente, notificacao_cliente FROM CLIENTE WHERE codigo_cliente = ?";

			PreparedStatement stmt = this.connection.prepareStatement(sql);

			stmt.setInt(1, cod);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				String cpf = rs.getString("cpf");
				String nome = rs.getString("nome_cliente");
				String sexo = rs.getString("sexo_cliente");
				String dataNasc = rs.getString("dataNasc_cliente");
				String tel = rs.getString("tel_cliente");
				String email = rs.getString("email_cliente");
				String senha = rs.getString("senha_cliente");
				String nomeArq = rs.getString("nomeArq_cliente");
				String notificacao = rs.getString("notificacao_cliente");

				cliente = new Cliente();
				cliente.setCod(cod);
				cliente.setCpf(cpf);
				cliente.setNome(nome);
				cliente.setSexo(sexo);
				cliente.setDataNasc(dataNasc);
				cliente.setTel(tel);
				cliente.setEmail(email);
				cliente.setSenha(senha);
				cliente.setNomeArq(nomeArq);
				cliente.setNotificacao(notificacao);
			}
			rs.close();
			stmt.close();
			return cliente;
		} catch (Exception e) {
			throw new DAOException("Erro ao buscar: " + e.getMessage());
		}
	}
	
	@Override
	public Cliente logarCliente(String loginU, String senhaU) throws DAOException {
		Cliente cliente = null;
		try {
			String sql = "SELECT * FROM CLIENTE WHERE cpf = ? AND senha_cliente = ?";
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, loginU);
			stmt.setString(2, senhaU);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				int cod = rs.getInt("codigo_cliente");
				String cpf = rs.getString("cpf");
				String nome = rs.getString("nome_cliente");
				String sexo = rs.getString("sexo_cliente");
				String dataNasc = rs.getString("dataNasc_cliente");
				String tel = rs.getString("tel_cliente");
				String email = rs.getString("email_cliente");
				String senha = rs.getString("senha_cliente");
				String nomeArq = rs.getString("nomeArq_cliente");
				String notificacao = rs.getString("notificacao_cliente");
				
				cliente = new Cliente();
				cliente.setCod(cod);
				cliente.setCpf(cpf);
				cliente.setNome(nome);
				cliente.setSexo(sexo);
				cliente.setDataNasc(dataNasc);
				cliente.setTel(tel);
				cliente.setEmail(email);
				cliente.setSenha(senha);
				cliente.setNomeArq(nomeArq);
				cliente.setNotificacao(notificacao);
			}
			
		} catch (Exception e) {
			throw new DAOException("Erro ao logar: " + e.getMessage());
		}
		return cliente;
	}
	

}
