package controladores;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Produto;
import modelo.servicoUpload;
import java.io.File;
import java.util.Random;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.DAOException;
import dao.ProdutoDAO;
import dao.ProdutoDAOIF;

@WebServlet("/controladorP")
public class controladorProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    public controladorProduto() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.sendRedirect("/controladorP?acao=cadastrarProduto");
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String acao = request.getParameter("acao");
		
		if(acao == null) 
			acao = "paginaInicial";
	
		if(acao.equals("cadastrarProduto")) {
			try {
				cadastrarProduto(request, response);
			} catch (ServletException | IOException | FileUploadException | DAOException e) {
				e.printStackTrace();
			}
		} else if(acao.equals("formCadastrarProduto")){
			formCadastrarProduto(request, response);
		} else if (acao.equals("formAtualizarProduto")) {
			try {
				formAtualizarProduto(request, response);
			} catch (ServletException | IOException | DAOException e) {
				e.printStackTrace();
			}
		} else if (acao.equals("removerProduto")) {
			try {
				removerProduto(request, response);
			} catch (ServletException | IOException | DAOException e) {
				e.printStackTrace();
			}
		} else if (acao.equals("atualizarProduto")) {
			try {
				atualizarProduto(request, response);
			} catch (ServletException | IOException | FileUploadException | DAOException e) {
				e.printStackTrace();
			}
		} else if (acao.equals("detalhesProduto")) {
			try {
				detalhesProduto(request, response);
			} catch (NumberFormatException | ServletException | IOException | DAOException e) {
				e.printStackTrace();
			}
		} else if (acao.equals("gerenciarProdutos")) {
			String msg = "";
			try {
				gerenciarProdutos(request, response, msg);
			} catch (ServletException | IOException | DAOException e) {
				e.printStackTrace();
			}
		}		
	}
    
    protected Produto inserirProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, FileUploadException {
    	List<FileItem> atributos = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
    	servicoUpload upload = new servicoUpload("arquivos", "jpg, jpeg, png, gif", 2);
    	Produto Produto = new Produto();
    	int j = 0;
    	
    	if (ServletFileUpload.isMultipartContent(request)) {
    		if (atributos != null && atributos.size() > 0){
    			for(FileItem atb : atributos){
    				if(atb.isFormField()){
    					if(atb.getFieldName().equals("nomeProduto")){
    						Produto.setNome(atb.getString());
    					} else if(atb.getFieldName().equals("precoProduto")){
    						Produto.setPreco(atb.getString());
    					} else if(atb.getFieldName().equals("marcaProduto")){
    						Produto.setMarca(atb.getString());
    					} else if(atb.getFieldName().equals("fornecedorProduto")){
    						Produto.setFornecedor(atb.getString());
    					} else if(atb.getFieldName().equals("categoriaProduto")){
    						Produto.setCategoria(atb.getString());
    					} else if(atb.getFieldName().equals("subcategoriaProduto")){
    						Produto.setSubcategoria(atb.getString());
    					} else if(atb.getFieldName().equals("descricaoProduto")){
    						Produto.setDescricao(atb.getString());
    					} else if(atb.getFieldName().equals("naoAtualizado") && j != 0){
    						if(!atb.getString().equals("null")){
    							Produto.setNomeArq(atb.getString());
    						} else Produto.setNomeArq(null);
    					} 
    				} else if(atb.getSize() != 0){
    						if(upload.fazUpload(request, getServletContext(), atb)){
    							Produto.setNomeArq(upload.getNomeArq());
    						} else;
    				} else j++;
    			}
    		}
    		return Produto;
    	}
    	return null;
    }
    
    protected void detalhesProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException, DAOException {
    	ProdutoDAOIF dao = new ProdutoDAO();
    	Produto Produto = dao.buscarProduto(Integer.parseInt(request.getParameter("cod")));
    	request.setAttribute("Produto", Produto);
    	
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/detalhesProduto.jsp");
    	rd.forward(request, response);
    }
    
    protected void cadastrarProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, FileUploadException, DAOException {
    		Produto Produto = inserirProduto(request, response);
	    	
    		ProdutoDAOIF dao = new ProdutoDAO();
    		
    		String msg = dao.cadastrar(Produto);
    		HttpSession session = request.getSession(true);
    		int i = (Integer) session.getAttribute("qtdProd");
    		i++;
    		session.setAttribute("qtdProd", i);
	    	
	    	cadastroDeProduto(request, response, msg, Produto);
    }
    
    protected void cadastroDeProduto(HttpServletRequest request, HttpServletResponse response, String msg, Produto produto) throws ServletException, IOException {    	
    	if(msg.contains("ERRO")) {
    		produto = null;
    	}
    	
    	request.setAttribute("produto", produto);
    	request.setAttribute("msg", msg);
    	
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/CadastroDeProduto.jsp");
    	
    	rd.forward(request, response);
    }
    
    protected void gerenciarProdutos(HttpServletRequest request, HttpServletResponse response, String msg) throws ServletException, IOException, DAOException {    	
    	ProdutoDAOIF dao = new ProdutoDAO();
    	List<Produto> Produtos = dao.todosProdutos();
    	
    	request.setAttribute("Produtos", Produtos);
    	request.setAttribute("msg", msg);
    	HttpSession session = request.getSession(true);
    	
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/GerenciarProdutos.jsp");
    	
    	rd.forward(request, response);
    }
    
    protected void formAtualizarProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DAOException {
    	ProdutoDAOIF dao = new ProdutoDAO();
    	Produto Produto = dao.buscarProduto(Integer.parseInt(request.getParameter("cod")));
    	request.setAttribute("Produto", Produto);
    	
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/formularioAtualizarProduto.jsp");
    	rd.forward(request, response);
    }
    
    protected void atualizarProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, FileUploadException, DAOException {
    	Produto Produto = inserirProduto(request, response);
    	Produto.setCod(Integer.parseInt(request.getParameter("cod")));
    	ProdutoDAOIF dao = new ProdutoDAO();
    	
    	String msg = dao.atualizar(Produto);
    	
    	atualizacaoDeProduto(request, response, msg, Produto);
    }
    
    protected void atualizacaoDeProduto(HttpServletRequest request, HttpServletResponse response, String msg, Produto Produto) throws ServletException, IOException {    	
    	if(msg.contains("ERRO")) {
    		Produto = null;
    	}
    	
    	request.setAttribute("Produto", Produto);
    	request.setAttribute("msg", msg);
    	
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/atualizarProduto.jsp");
    	
    	rd.forward(request, response);
    }
    
    protected void removerProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DAOException {
    	ProdutoDAOIF dao = new ProdutoDAO();
    	
    	Produto Produto = dao.buscarProduto(Integer.parseInt(request.getParameter("cod")));
    	String msg = dao.remover(Integer.parseInt(request.getParameter("cod")));
    	HttpSession session = request.getSession(true);
		int i = (Integer) session.getAttribute("qtdProd");
		i--;
		session.setAttribute("qtdProd", i);
    	
    	
    	request.setAttribute("Produto", Produto);
    	    	
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/removerProduto.jsp");
    	rd.forward(request, response);
    }
    
    protected void formCadastrarProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/FormularioCadastroProduto.jsp");
    	
    	rd.forward(request, response);
    }
}
