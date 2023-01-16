package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import modelo.Compra;
import modelo.Produto;
import util.ConnectionFactory;

public class CompraDAO implements CompraDAOIF {
	private Connection connection;

	public CompraDAO() throws DAOException {
		try {
			this.connection = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new DAOException("Erro na conexÃ£o: " + e.getMessage());
		}
	}

	@Override
	public String cadastrar(Compra compra, List<Produto> produtos) throws DAOException {
		try {
			String sql = "INSERT INTO COMPRA (codigo_cliente, formaPagamento, avaliacao, comentario, dataHora) VALUES (?, ?, ?, ?, ?);";

			PreparedStatement stmt = this.connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setInt(1, compra.getCodCli());
			stmt.setString(2, compra.getFormaPagamento());
			stmt.setString(3, compra.getAvaliacao());
			stmt.setString(4, compra.getComentario());
			stmt.setDate(5, new Date(compra.getDataHora().getTimeInMillis()));
			

			stmt.execute();

			ResultSet rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				int cod = rs.getInt(1);
				compra.setCod(cod);
			}
			for(int i = 0; i < produtos.size(); i++) {
				sql = "INSERT INTO CONTEM (codigo_produto, codigo_compra) VALUES (?, ?);";
				stmt = this.connection.prepareStatement(sql);
				stmt.setInt(1, produtos.get(i).getCod());
				stmt.setInt(2, compra.getCod());
				
				stmt.execute();
			}
			
			
			rs.close();
			stmt.close();
			return "Compra com o código \"" + compra.getCod() + "\" cadastrada com sucesso!";
		} catch (Exception e) {
			System.out.println(new DAOException("Erro ao cadastrar: " + e.getMessage()));
			return "ERRO: Não foi possível cadastrar.";
		}

	}

	@Override
	public List<Compra> todasCompras(int codCli) throws DAOException {

		List<Compra> compras = new ArrayList<Compra>();

		try {
			/*Statement st = this.connection.createStatement();*/

			String sql = "SELECT DISTINCT com.codigo_compra, formaPagamento, avaliacao, comentario, dataHora FROM COMPRA com INNER JOIN CONTEM con ON (com.codigo_compra = con.codigo_compra) AND (com.codigo_cliente = ?)";
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, codCli);
			/*stmt.executeQuery();*/
			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int cod = rs.getInt("com.codigo_compra");
				String formaPagamento = rs.getString("formaPagamento");
				String avaliacao = rs.getString("avaliacao");
				String comentario = rs.getString("comentario");
				Date dataHora = rs.getDate("dataHora");

				Compra compra = new Compra();
				compra.setCod(cod);
				compra.setFormaPagamento(formaPagamento);
				compra.setAvaliacao(avaliacao);
				compra.setComentario(comentario);
				
				Calendar dataHoraC = Calendar.getInstance();
				dataHoraC.setTime(dataHora);
				compra.setDataHora(dataHoraC);
				

				compras.add(compra);
			}

			rs.close();
			/*st.close();*/
			stmt.close();
			return compras;
		} catch (Exception e) {
			throw new DAOException("Erro ao buscar1: " + e.getMessage());
		}
	}

	@Override
	public Compra buscarCompra(int cod) throws DAOException {
		Compra compra = null;
		try {
			String sql = "SELECT DISTINCT com.codigo_compra, formaPagamento, avaliacao, comentario, dataHora FROM COMPRA com INNER JOIN CONTEM con INNER JOIN PRODUTO p ON (com.codigo_compra = con.codigo_compra) AND (con.codigo_produto = p.codigo_produto) AND (com.codigo_compra = ?)";

			PreparedStatement stmt = this.connection.prepareStatement(sql);

			stmt.setInt(1, cod);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				String formaPagamento = rs.getString("formaPagamento");
				String avaliacao = rs.getString("avaliacao");
				String comentario = rs.getString("comentario");
				Date dataHora = rs.getDate("dataHora");

				
				
				compra = new Compra();
				compra.setCod(cod);
				compra.setProdutosC(todosProdutosC(cod));
				compra.setFormaPagamento(formaPagamento);
				compra.setAvaliacao(avaliacao);
				compra.setComentario(comentario);
				
				Calendar dataHoraC = Calendar.getInstance();
				dataHoraC.setTime(dataHora);
				compra.setDataHora(dataHoraC);
				
				
			}
			rs.close();
			stmt.close();
			return compra;
		} catch (Exception e) {
			throw new DAOException("Erro ao buscar: " + e.getMessage());
		}
	}
	
	@Override
	public List<Produto> todosProdutosC(int cod) throws DAOException {

		List<Produto> produtos = new ArrayList<Produto>();

		try {
			/*Statement st = this.connection.createStatement();*/

			String sql = "SELECT DISTINCT p.codigo_produto, p.nome_produto, p.preco FROM COMPRA com INNER JOIN CONTEM con INNER JOIN PRODUTO p ON (p.codigo_produto = con.codigo_produto) AND (com.codigo_compra = con.codigo_compra) AND (com.codigo_compra = ?)";
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, cod);
			/*stmt.executeQuery();*/
			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int codP = rs.getInt("p.codigo_produto");
				String nome_produto = rs.getString("nome_produto");
				String preco = rs.getString("preco");

				Produto produto = new Produto();
				produto.setCod(codP);
				produto.setNome(nome_produto);
				produto.setPreco(preco);
				
				produtos.add(produto);
			}

			rs.close();
			/*st.close();*/
			stmt.close();
			return produtos;
		} catch (Exception e) {
			throw new DAOException("Erro ao buscar1: " + e.getMessage());
		}
	}
	
	/*@Override
	public String atualizar(Compra compra) throws DAOException {
		try {
			String sql = "UPDATE COMPRA SET cep = ?, numero_end = ?, complemento = ?, nome_end = ?, rua = ?, bairro = ?, referencia = ?, cidade = ?, estado = ? WHERE codigo_end = ?";

			PreparedStatement stmt = this.connection.prepareStatement(sql);

			stmt.setString(1, compra.getCep());
			stmt.setString(2, compra.getNumero());
			stmt.setString(3, compra.getComplemento());
			stmt.setString(4, compra.getNomeEnd());
			stmt.setString(5, compra.getRua());
			stmt.setString(6, compra.getBairro());
			stmt.setString(7, compra.getReferencia());
			stmt.setString(8, compra.getCidade());
			stmt.setString(9, compra.getEstado());
			stmt.setInt(10, compra.getCod());

			stmt.executeUpdate();
			stmt.close();
			return "Endereço com o código \"" + compra.getCod() + "\" foi atualizado com sucesso!";
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
			
			sql = "DELETE FROM COMPRA WHERE codigo_end = ?";
			
			stmt = this.connection.prepareStatement(sql);
			
			stmt.setInt(1, cod);

			stmt.executeUpdate();
			
			
			stmt.close();
			return "Endereço com o código \"" + cod + "\" foi removido com sucesso!";
		} catch (Exception e) {
			System.out.println(new DAOException("Erro ao remover: " + e.getMessage()));
			return "ERRO: Não foi possível remover o endereço escolhido.";
		}
	}*/

}
