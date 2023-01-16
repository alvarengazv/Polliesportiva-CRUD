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
import modelo.Endereco;
import util.ConnectionFactory;
import java.util.Calendar;

public class EnderecoDAO implements EnderecoDAOIF {
	private Connection connection;

	public EnderecoDAO() throws DAOException {
		try {
			this.connection = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new DAOException("Erro na conexÃ£o: " + e.getMessage());
		}
	}

	@Override
	public String cadastrar(Endereco endereco, int codCli) throws DAOException {
		try {
			String sql = "INSERT INTO ENDERECO (cep, numero_end, complemento, nome_end, rua, bairro, referencia, cidade, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement stmt = this.connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setString(1, endereco.getCep());
			stmt.setString(2, endereco.getNumero());
			stmt.setString(3, endereco.getComplemento());
			stmt.setString(4, endereco.getNomeEnd());
			stmt.setString(5, endereco.getRua());
			stmt.setString(6, endereco.getBairro());
			stmt.setString(7, endereco.getReferencia());
			stmt.setString(8, endereco.getCidade());
			stmt.setString(9, endereco.getEstado());
			

			stmt.execute();

			ResultSet rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				int cod = rs.getInt(1);
				endereco.setCod(cod);
			}
			
			sql = "INSERT INTO CADASTRA (codigo_cliente, codigo_end) VALUES (?, ?);";
			stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, codCli);
			stmt.setInt(2, endereco.getCod());
			
			stmt.execute();
			
			rs.close();
			stmt.close();
			return "Endereço com o código \"" + endereco.getCod() + "\" cadastrado com sucesso!";
		} catch (Exception e) {
			System.out.println(new DAOException("Erro ao cadastrar: " + e.getMessage()));
			return "ERRO: Não foi possível cadastrar.";
		}

	}

	@Override
	public String atualizar(Endereco endereco) throws DAOException {
		try {
			String sql = "UPDATE ENDERECO SET cep = ?, numero_end = ?, complemento = ?, nome_end = ?, rua = ?, bairro = ?, referencia = ?, cidade = ?, estado = ? WHERE codigo_end = ?";

			PreparedStatement stmt = this.connection.prepareStatement(sql);

			stmt.setString(1, endereco.getCep());
			stmt.setString(2, endereco.getNumero());
			stmt.setString(3, endereco.getComplemento());
			stmt.setString(4, endereco.getNomeEnd());
			stmt.setString(5, endereco.getRua());
			stmt.setString(6, endereco.getBairro());
			stmt.setString(7, endereco.getReferencia());
			stmt.setString(8, endereco.getCidade());
			stmt.setString(9, endereco.getEstado());
			stmt.setInt(10, endereco.getCod());

			stmt.executeUpdate();
			stmt.close();
			return "Endereço com o código \"" + endereco.getCod() + "\" foi atualizado com sucesso!";
		} catch (Exception e) {
			System.out.println(new DAOException("Erro ao atualizar: " + e.getMessage()));
			return "ERRO: Não foi possível atualizar o endereço. Verifique se seus dados estão corretos!";
		}
	}

	@Override
	public String remover(int cod) throws DAOException {
		try {
			String sql = "DELETE FROM CADASTRA WHERE codigo_end = ?";
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt = this.connection.prepareStatement(sql);
			
			stmt.setInt(1, cod);
			
			stmt.executeUpdate();
			
			sql = "DELETE FROM ENDERECO WHERE codigo_end = ?";
			
			stmt = this.connection.prepareStatement(sql);
			
			stmt.setInt(1, cod);

			stmt.executeUpdate();
			
			
			stmt.close();
			return "Endereço com o código \"" + cod + "\" foi removido com sucesso!";
		} catch (Exception e) {
			System.out.println(new DAOException("Erro ao remover: " + e.getMessage()));
			return "ERRO: Não foi possível remover o endereço escolhido.";
		}
	}

	@Override
	public List<Endereco> todosEnderecos(int codCli) throws DAOException {

		List<Endereco> enderecos = new ArrayList<Endereco>();

		try {
			/*Statement st = this.connection.createStatement();*/

			String sql = "SELECT DISTINCT e.codigo_end, cep, numero_end, complemento, nome_end, rua, bairro, referencia, cidade, estado FROM ENDERECO e INNER JOIN CADASTRA c INNER JOIN CLIENTE cl ON (e.codigo_end = c.codigo_end) AND (c.codigo_cliente = ?)";
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, codCli);
			/*stmt.executeQuery();*/
			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int cod = rs.getInt("e.codigo_end");
				String cep = rs.getString("cep");
				String numero = rs.getString("numero_end");
				String complemento = rs.getString("complemento");
				String nome = rs.getString("nome_end");
				String rua = rs.getString("rua");
				String bairro = rs.getString("bairro");
				String referencia = rs.getString("referencia");
				String cidade = rs.getString("cidade");
				String estado = rs.getString("estado");

				Endereco endereco = new Endereco();
				endereco.setCod(cod);
				endereco.setCep(cep);
				endereco.setNumero(numero);
				endereco.setComplemento(complemento);
				endereco.setNomeEnd(nome);
				endereco.setRua(rua);
				endereco.setBairro(bairro);
				endereco.setReferencia(referencia);
				endereco.setCidade(cidade);
				endereco.setEstado(estado);
				

				enderecos.add(endereco);
			}

			rs.close();
			/*st.close();*/
			stmt.close();
			return enderecos;
		} catch (Exception e) {
			throw new DAOException("Erro ao buscar1: " + e.getMessage());
		}
	}

	@Override
	public Endereco buscarEndereco(int cod) throws DAOException {
		Endereco endereco = null;
		try {
			String sql = "SELECT cep, numero_end, complemento, nome_end, rua, bairro, referencia, cidade, estado FROM ENDERECO WHERE codigo_end = ?";

			PreparedStatement stmt = this.connection.prepareStatement(sql);

			stmt.setInt(1, cod);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				String cep = rs.getString("cep");
				String numero = rs.getString("numero_end");
				String complemento = rs.getString("complemento");
				String nome = rs.getString("nome_end");
				String rua = rs.getString("rua");
				String bairro = rs.getString("bairro");
				String referencia = rs.getString("referencia");
				String cidade = rs.getString("cidade");
				String estado = rs.getString("estado");

				endereco = new Endereco();
				endereco.setCod(cod);
				endereco.setCep(cep);
				endereco.setNumero(numero);
				endereco.setComplemento(complemento);
				endereco.setNomeEnd(nome);
				endereco.setRua(rua);
				endereco.setBairro(bairro);
				endereco.setReferencia(referencia);
				endereco.setCidade(cidade);
				endereco.setEstado(estado);
				
			}
			rs.close();
			stmt.close();
			return endereco;
		} catch (Exception e) {
			throw new DAOException("Erro ao buscar: " + e.getMessage());
		}
	}
	

}
