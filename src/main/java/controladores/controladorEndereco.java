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

import modelo.Endereco;
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
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import dao.EnderecoDAO;
import dao.EnderecoDAOIF;
import dao.DAOException;

@WebServlet("/controladorE")
public class controladorEndereco extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public controladorEndereco() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.sendRedirect("/controladorC?acao=cadastrarEndereco");
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String acao = request.getParameter("acao");
	
		if(acao.equals("cadastrarEndereco")) {
			try {
				cadastrarEndereco(request, response);
			} catch (ServletException | IOException | FileUploadException | DAOException e) {
				e.printStackTrace();
			}
		} else if(acao.equals("formCadastrarEndereco")){
			formCadastrarEndereco(request, response);
		} else if (acao.equals("formAtualizarEndereco")) {
			try {
				formAtualizarEndereco(request, response);
			} catch (ServletException | IOException | DAOException e) {
				e.printStackTrace();
			}
		} else if (acao.equals("removerEndereco")) {
			try {
				removerEndereco(request, response);
			} catch (ServletException | IOException | DAOException e) {
				e.printStackTrace();
			}
		} else if (acao.equals("atualizarEndereco")) {
			try {
				atualizarEndereco(request, response);
			} catch (ServletException | IOException | FileUploadException | DAOException e) {
				e.printStackTrace();
			}
		} else if (acao.equals("detalhesEndereco")) {
			try {
				detalhesEndereco(request, response);
			} catch (ServletException | IOException | DAOException e) {
				e.printStackTrace();
			}
		} else if (acao.equals("gerenciarEnderecos")) {
			String msg = "";
			try {
				gerenciarEnderecos(request, response, msg);
			} catch (ServletException | IOException | DAOException e) {
				e.printStackTrace();
			}
		}		
	}
    
    protected Endereco inserirEndereco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, FileUploadException {
    	
    	Endereco endereco = new Endereco();
    	
    	endereco.setCep(request.getParameter("cepEndereco"));
    	endereco.setBairro(request.getParameter("bairroEndereco"));
    	endereco.setComplemento(request.getParameter("complementoEndereco"));
    	endereco.setRua(request.getParameter("ruaEndereco"));
    	endereco.setNomeEnd(request.getParameter("nomeEndereco"));
    	endereco.setEstado(request.getParameter("estadoEndereco"));
    	endereco.setCidade(request.getParameter("cidadeEndereco"));
    	endereco.setNumero(request.getParameter("numeroEndereco"));
    	endereco.setReferencia(request.getParameter("referenciaEndereco"));
    	
    	
    	return endereco;
    		
    }
    
    protected void detalhesEndereco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DAOException {
    	EnderecoDAOIF dao = new EnderecoDAO();
    	Endereco endereco = dao.buscarEndereco(Integer.parseInt(request.getParameter("cod")));
    	request.setAttribute("endereco", endereco);
    	
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/detalhesEndereco.jsp");
    	rd.forward(request, response);
    }
    
    protected void cadastrarEndereco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, FileUploadException, DAOException {
    		Endereco endereco = inserirEndereco(request, response);
    		EnderecoDAOIF dao = new EnderecoDAO();
    		request.setAttribute("codCli", Integer.parseInt(request.getParameter("codCli")));
    		
    		String msg = dao.cadastrar(endereco, Integer.parseInt(request.getParameter("codCli")));	  
    		HttpSession session = request.getSession();
    		if(session.getAttribute("qtdEnd") != null) {
	    		int i = (Integer) session.getAttribute("qtdEnd");
	    		i++;
	    		session.setAttribute("qtdEnd", i);
    		}
	    	gerenciarEnderecos(request, response, msg);
    }
    
    protected void gerenciarEnderecos(HttpServletRequest request, HttpServletResponse response, String msg) throws ServletException, IOException, DAOException {    	
    	EnderecoDAOIF dao = new EnderecoDAO();
    	List<Endereco> enderecos = dao.todosEnderecos(Integer.parseInt(request.getParameter("codCli")));
    	request.setAttribute("codCli", Integer.parseInt(request.getParameter("codCli")));
    	request.setAttribute("enderecos", enderecos);
    	request.setAttribute("msg", msg);
    	
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/gerenciarEnderecos.jsp");
    	
    	rd.forward(request, response);
    }
    
    protected void formAtualizarEndereco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DAOException {
    	EnderecoDAOIF dao = new EnderecoDAO();
    	Endereco endereco = dao.buscarEndereco(Integer.parseInt(request.getParameter("cod")));
    	request.setAttribute("endereco", endereco);
    	request.setAttribute("codCli", Integer.parseInt(request.getParameter("codCli")));
    	
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/formularioAtualizarEndereco.jsp");
    	rd.forward(request, response);
    }
    
    protected void atualizarEndereco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, FileUploadException, DAOException {
    	Endereco endereco = inserirEndereco(request, response);
    	endereco.setCod(Integer.parseInt(request.getParameter("cod")));
    	
    	EnderecoDAOIF dao = new EnderecoDAO();
    	
		String msg = dao.atualizar(endereco);
		
    	gerenciarEnderecos(request, response, msg);
    }
    
    protected void removerEndereco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DAOException {
    	EnderecoDAOIF dao = new EnderecoDAO();
    	
		String msg = dao.remover(Integer.parseInt(request.getParameter("cod")));
		HttpSession session = request.getSession();
		int i = (Integer) session.getAttribute("qtdEnd");
		i--;
		session.setAttribute("qtdEnd", i);
		
    	gerenciarEnderecos(request, response, msg);
    }
    
    protected void formCadastrarEndereco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setAttribute("codCli", Integer.parseInt(request.getParameter("codCli")));
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/formularioCadastroEndereco.jsp");
    	
    	rd.forward(request, response);
    }
}
