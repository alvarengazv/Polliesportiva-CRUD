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
import modelo.Administrador;
import util.ConnectionFactory;
import java.util.Calendar;

public class AdministradorDAO implements AdministradorDAOIF {
	private Connection connection;

	public AdministradorDAO() throws DAOException {
		try {
			this.connection = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new DAOException("Erro na conexÃ£o: " + e.getMessage());
		}
	}

	@Override
	public String cadastrar(Administrador Administrador) throws DAOException {
		try {
			String sql = "INSERT INTO ADMINISTRADOR (nome_admin, sexo_admin, dataNasc_admin, tel_admin, email_admin, senha_admin) VALUES (?, ?, ?, ?, ?, ?);";

			PreparedStatement stmt = this.connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setString(1, Administrador.getNome());
			stmt.setString(2, Administrador.getSexo());
			stmt.setString(3, Administrador.getDataNasc());
			stmt.setString(4, Administrador.getTel());
			stmt.setString(5, Administrador.getEmail());
			stmt.setString(6, Administrador.getSenha());
			

			stmt.execute();

			ResultSet rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				int cod = rs.getInt(1);
				Administrador.setCod(cod);
			}
			
			rs.close();
			stmt.close();
			return "Administrador com o código \"" + Administrador.getCod() + "\" cadastrado com sucesso!";
		} catch (Exception e) {
			System.out.println(new DAOException("Erro ao cadastrar: " + e.getMessage()));
			return "ERRO: Não foi possível cadastrar. Verifique se seus dados estão corretos ou se este CPF já está cadastrado!";
		}

	}

	@Override
	public String atualizar(Administrador Administrador) throws DAOException {
		try {
			String sql = "UPDATE ADMINISTRADOR SET nome_admin = ?, sexo_admin = ?, dataNasc_admin = ?, tel_admin = ?, email_admin = ?, senha_admin = ? WHERE codigo_admin = ?";

			PreparedStatement stmt = this.connection.prepareStatement(sql);

			stmt.setString(1, Administrador.getNome());
			stmt.setString(2, Administrador.getSexo());
			stmt.setString(3, Administrador.getDataNasc());
			stmt.setString(4, Administrador.getTel());
			stmt.setString(5, Administrador.getEmail());
			stmt.setString(6, Administrador.getSenha());
			stmt.setInt(7, Administrador.getCod());

			stmt.executeUpdate();
			stmt.close();
			return "Administrador com o código \"" + Administrador.getCod() + "\" foi atualizado com sucesso!";
		} catch (Exception e) {
			System.out.println(new DAOException("Erro ao atualizar: " + e.getMessage()));
			return "ERRO: Não foi possível atualizar o Administrador. Verifique se seus dados estão corretos!";
		}
	}

	@Override
	public String remover(int cod) throws DAOException {
		try {
			String sql = "DELETE FROM ADMINISTRADOR WHERE codigo_admin = ?";

			PreparedStatement stmt = this.connection.prepareStatement(sql);

			stmt.setInt(1, cod);

			stmt.executeUpdate();
			stmt.close();
			return "Administrador com o código \"" + cod + "\" foi removido com sucesso!";
		} catch (Exception e) {
			System.out.println(new DAOException("Erro ao remover: " + e.getMessage()));
			return "ERRO: Não foi possível remover o Administrador escolhido.";
		}
	}

	@Override
	public List<Administrador> todosAdministradores() throws DAOException {

		List<Administrador> administradores = new ArrayList<Administrador>();

		try {
			Statement st = this.connection.createStatement();

			String sql = "SELECT codigo_admin, nome_admin, sexo_admin, dataNasc_admin, tel_admin, email_admin, senha_admin FROM ADMINISTRADOR";

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				int cod = rs.getInt("codigo_cliente");
				String nome = rs.getString("nome_admin");
				String sexo = rs.getString("sexo_admin");
				String dataNasc = rs.getString("dataNasc_admin");
				String tel = rs.getString("tel_admin");
				String email = rs.getString("email_admin");
				String senha = rs.getString("senha_admin");

				Administrador Administrador = new Administrador();
				Administrador.setCod(cod);
				Administrador.setNome(nome);
				Administrador.setSexo(sexo);
				Administrador.setDataNasc(dataNasc);
				Administrador.setTel(tel);
				Administrador.setEmail(email);
				Administrador.setSenha(senha);

				administradores.add(Administrador);
			}

			rs.close();
			st.close();
			return administradores;
		} catch (Exception e) {
			throw new DAOException("Erro ao buscar: " + e.getMessage());
		}
	}

	@Override
	public Administrador buscarAdministrador(int cod) throws DAOException {
		Administrador Administrador = null;
		try {
			String sql = "SELECT nome_admin, sexo_admin, dataNasc_admin, tel_admin, email_admin, senha_admin FROM ADMINISTRADOR WHERE codigo_admin = ?";

			PreparedStatement stmt = this.connection.prepareStatement(sql);

			stmt.setInt(1, cod);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				String nome = rs.getString("nome_admin");
				String sexo = rs.getString("sexo_admin");
				String dataNasc = rs.getString("dataNasc_admin");
				String tel = rs.getString("tel_admin");
				String email = rs.getString("email_admin");
				String senha = rs.getString("senha_admin");
				
				Administrador = new Administrador();
				Administrador.setCod(cod);
				Administrador.setNome(nome);
				Administrador.setSexo(sexo);
				Administrador.setDataNasc(dataNasc);
				Administrador.setTel(tel);
				Administrador.setEmail(email);
				Administrador.setSenha(senha);
			}
			rs.close();
			stmt.close();
			return Administrador;
		} catch (Exception e) {
			throw new DAOException("Erro ao buscar: " + e.getMessage());
		}
	}
	
	@Override
	public Administrador logarAdministrador(String loginU, String senhaU) throws DAOException {
		Administrador Administrador = null;
		try {
			String sql = "SELECT * FROM ADMINISTRADOR WHERE email_admin = ? AND senha_admin = ?";
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, loginU);
			stmt.setString(2, senhaU);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				int cod = rs.getInt("codigo_admin");
				String nome = rs.getString("nome_admin");
				String sexo = rs.getString("sexo_admin");
				String dataNasc = rs.getString("dataNasc_admin");
				String tel = rs.getString("tel_admin");
				String email = rs.getString("email_admin");
				String senha = rs.getString("senha_admin");
				
				Administrador = new Administrador();
				Administrador.setCod(cod);
				Administrador.setNome(nome);
				Administrador.setSexo(sexo);
				Administrador.setDataNasc(dataNasc);
				Administrador.setTel(tel);
				Administrador.setEmail(email);
				Administrador.setSenha(senha);
			}
			
		} catch (Exception e) {
			throw new DAOException("Erro ao logar: " + e.getMessage());
		}
		return Administrador;
	}
	

}
