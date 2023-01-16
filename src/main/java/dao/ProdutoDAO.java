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
import modelo.Produto;
import util.ConnectionFactory;
import java.util.Calendar;

public class ProdutoDAO implements ProdutoDAOIF {
	private Connection connection;

	public ProdutoDAO() throws DAOException {
		try {
			this.connection = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new DAOException("Erro na conexÃ£o: " + e.getMessage());
		}
	}

	@Override
	public String cadastrar(Produto produto) throws DAOException {
		try {
			String sql = "INSERT INTO PRODUTO (nome_produto, preco, marca, fornecedor, categoria, subcategoria, descricao, imagem) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement stmt = this.connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getPreco());
			stmt.setString(3, produto.getMarca());
			stmt.setString(4, produto.getFornecedor());
			stmt.setString(5, produto.getCategoria());
			stmt.setString(6, produto.getSubcategoria());
			stmt.setString(7, produto.getDescricao());
			stmt.setString(8, produto.getNomeArq());
			

			stmt.execute();

			ResultSet rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				int cod = rs.getInt(1);
				produto.setCod(cod);
			}
			
			rs.close();
			stmt.close();
			return "Produto com o código \"" + produto.getCod() + "\" cadastrado com sucesso!";
		} catch (Exception e) {
			System.out.println(new DAOException("Erro ao cadastrar: " + e.getMessage()));
			return "ERRO: Não foi possível cadastrar. Verifique se seus dados estão corretos!";
		}

	}

	@Override
	public String atualizar(Produto produto) throws DAOException {
		try {
			String sql = "UPDATE PRODUTO SET nome_produto = ?, preco = ?, marca = ?, fornecedor = ?, categoria = ?, subcategoria = ?, descricao = ?, imagem = ? WHERE codigo_produto = ?";

			PreparedStatement stmt = this.connection.prepareStatement(sql);

			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getPreco());
			stmt.setString(3, produto.getMarca());
			stmt.setString(4, produto.getFornecedor());
			stmt.setString(5, produto.getCategoria());
			stmt.setString(6, produto.getSubcategoria());
			stmt.setString(7, produto.getDescricao());
			stmt.setString(8, produto.getNomeArq());
			stmt.setInt(9, produto.getCod());

			stmt.executeUpdate();
			stmt.close();
			return "Produto com o código \"" + produto.getCod() + "\" foi atualizado com sucesso!";
		} catch (Exception e) {
			System.out.println(new DAOException("Erro ao atualizar: " + e.getMessage()));
			return "ERRO: Não foi possível atualizar o produto. Verifique se seus dados estão corretos!";
		}
	}

	@Override
	public String remover(int cod) throws DAOException {
		try {
			String sql = "DELETE FROM PRODUTO WHERE codigo_produto = ?";

			PreparedStatement stmt = this.connection.prepareStatement(sql);

			stmt.setInt(1, cod);

			stmt.executeUpdate();
			stmt.close();
			return "Produto com o código \"" + cod + "\" foi removido com sucesso!";
		} catch (Exception e) {
			System.out.println(new DAOException("Erro ao remover: " + e.getMessage()));
			return "ERRO: Não foi possível remover o produto escolhido.";
		}
	}

	@Override
	public List<Produto> todosProdutos() throws DAOException {

		List<Produto> produtos = new ArrayList<Produto>();

		try {
			Statement st = this.connection.createStatement();

			String sql = "SELECT codigo_produto, nome_produto, preco, marca, fornecedor, categoria, subcategoria, descricao, imagem FROM PRODUTO";

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				int cod = rs.getInt("codigo_produto");
				String nome = rs.getString("nome_produto");
				String preco = rs.getString("preco");
				String marca = rs.getString("marca");
				String fornecedor = rs.getString("fornecedor");
				String categoria = rs.getString("categoria");
				String subcategoria = rs.getString("subcategoria");
				String descricao = rs.getString("descricao");
				String nomeArq = rs.getString("imagem");

				Produto produto = new Produto();
				produto.setCod(cod);
				produto.setNome(nome);
				produto.setPreco(preco);
				produto.setMarca(marca);
				produto.setFornecedor(fornecedor);
				produto.setCategoria(categoria);
				produto.setSubcategoria(subcategoria);
				produto.setDescricao(descricao);
				produto.setNomeArq(nomeArq);				

				produtos.add(produto);
			}

			rs.close();
			st.close();
			return produtos;
		} catch (Exception e) {
			throw new DAOException("Erro ao buscar: " + e.getMessage());
		}
	}

	@Override
	public Produto buscarProduto(int cod) throws DAOException {
		Produto produto = null;
		try {
			String sql = "SELECT nome_produto, preco, marca, fornecedor, categoria, subcategoria, descricao, imagem FROM PRODUTO WHERE codigo_produto = ?";

			PreparedStatement stmt = this.connection.prepareStatement(sql);

			stmt.setInt(1, cod);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				String nome = rs.getString("nome_produto");
				String preco = rs.getString("preco");
				String marca = rs.getString("marca");
				String fornecedor = rs.getString("fornecedor");
				String categoria = rs.getString("categoria");
				String subcategoria = rs.getString("subcategoria");
				String descricao = rs.getString("descricao");
				String nomeArq = rs.getString("imagem");
				
				produto = new Produto();
				produto.setCod(cod);
				produto.setNome(nome);
				produto.setPreco(preco);
				produto.setMarca(marca);
				produto.setFornecedor(fornecedor);
				produto.setCategoria(categoria);
				produto.setSubcategoria(subcategoria);
				produto.setDescricao(descricao);
				produto.setNomeArq(nomeArq);	
			}
			rs.close();
			stmt.close();
			return produto;
		} catch (Exception e) {
			throw new DAOException("Erro ao buscar: " + e.getMessage());
		}
	}

}
