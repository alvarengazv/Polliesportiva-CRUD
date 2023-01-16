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

import modelo.Administrador;
import modelo.Cliente;
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
import dao.ClienteDAO;
import dao.ClienteDAOIF;
import dao.DAOException;

@WebServlet("/controladorC")
public class controladorCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Cliente c = new Cliente();
	private Administrador a = new Administrador();
	
    public controladorCliente() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.sendRedirect("/controladorC?acao=cadastrarCliente");
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String acao = request.getParameter("acao");
		
	
		if(acao.equals("cadastrarCliente")) {
			try {
				cadastrarCliente(request, response);
			} catch (ServletException | IOException | FileUploadException | DAOException e) {
				e.printStackTrace();
			}
		} else if(acao.equals("formCadastrarCliente")){
			formCadastrarCliente(request, response);
		} else if (acao.equals("formAtualizarCliente")) {
			try {
				formAtualizarCliente(request, response);
			} catch (ServletException | IOException | DAOException e) {
				e.printStackTrace();
			}
		} else if (acao.equals("removerCliente")) {
			try {
				removerCliente(request, response);
			} catch (ServletException | IOException | DAOException e) {
				e.printStackTrace();
			}
		} else if (acao.equals("atualizarCliente")) {
			try {
				atualizarCliente(request, response);
			} catch (ServletException | IOException | FileUploadException | DAOException e) {
				e.printStackTrace();
			}
		} else if (acao.equals("detalhesCliente")) {
			try {
				detalhesCliente(request, response);
			} catch (ServletException | IOException | DAOException e) {
				e.printStackTrace();
			}
		} else if (acao.equals("gerenciarClientes")) {
			String msg = "";
			try {
				gerenciarClientes(request, response, msg);
			} catch (ServletException | IOException | DAOException e) {
				e.printStackTrace();
			}
		}		
	}
    
    protected Cliente inserirCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, FileUploadException {
    	List<FileItem> atributos = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
    	servicoUpload upload = new servicoUpload("arquivos", "jpg, jpeg, png, gif", 2);
    	Cliente cliente = new Cliente();
    	int j = 0;
    	
    	if (ServletFileUpload.isMultipartContent(request)) {
    		if (atributos != null && atributos.size() > 0){
    			for(FileItem atb : atributos){
    				if(atb.isFormField()){
    					if(atb.getFieldName().equals("nomeCliente")){
    						cliente.setNome(atb.getString());
    					} else if(atb.getFieldName().equals("sexoCliente")){
    						cliente.setSexo(atb.getString());
    					} else if(atb.getFieldName().equals("cpfCliente")){
    						cliente.setCpf(atb.getString());
    					} else if(atb.getFieldName().equals("nascimentoCliente")){
    						cliente.setDataNasc(atb.getString());
    					} else if(atb.getFieldName().equals("telefoneCliente")){
    						cliente.setTel(atb.getString());
    					} else if(atb.getFieldName().equals("emailCliente")){
    						cliente.setEmail(atb.getString());
    					} else if(atb.getFieldName().equals("senhaCliente")){
    						cliente.setSenha(atb.getString());
    					} else if(atb.getFieldName().equals("desejaNotificacao")){
    						if(atb.getString() != null){
    							cliente.setNotificacao(atb.getString());
    						} else cliente.setNotificacao("Não");
    					} else if(atb.getFieldName().equals("codCliente")){
    						cliente.setCod(Integer.parseInt(atb.getString()));
    					} else if(atb.getFieldName().equals("naoAtualizado") && j != 0){
    						if(!atb.getString().equals("null")){
    							cliente.setNomeArq(atb.getString());
    						} else cliente.setNomeArq(null);
    					} 
    				} else if(atb.getSize() != 0){
    						if(upload.fazUpload(request, getServletContext(), atb)){
    							cliente.setNomeArq(upload.getNomeArq());
    						} else;
    				} else j++;
    			}
    		}
    		if(cliente.getNotificacao() == null){
    			cliente.setNotificacao("Não");
	    	}
    		return cliente;
    	}
    	return null;
    }
    
    protected void detalhesCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DAOException {
    	ClienteDAOIF dao = new ClienteDAO();
    	Cliente cliente = dao.buscarCliente(Integer.parseInt(request.getParameter("cod")));
    	request.setAttribute("cliente", cliente);
    	
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/detalhesCliente.jsp");
    	rd.forward(request, response);
    }
    
    protected void cadastrarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, FileUploadException, DAOException {
    		Cliente cliente = inserirCliente(request, response);
    		ClienteDAOIF dao = new ClienteDAO();
	    	
    		String msg = dao.cadastrar(cliente);
    		if(!msg.contains("ERRO")) {
	    		msg = msg + emailCadastro(request, response, cliente);
	    	}
    		HttpSession session = request.getSession(true);
    		if(session.getAttribute("qtdCli") != null) {
	    		int i = (Integer) session.getAttribute("qtdCli");
	    		i++;
	    		session.setAttribute("qtdCli", i);
    		}
    		if(session.getAttribute("online") != null) {
    			gerenciarClientes(request, response, msg);
    		} else {
    			session.setAttribute("online", cliente);
    			RequestDispatcher rd = request.getRequestDispatcher("/controlador?acao=perfilUsuario");
        	
    			rd.forward(request, response);
    		}
    		
    		
    }
    
    protected String emailCadastro(HttpServletRequest request, HttpServletResponse response, Cliente cliente) throws ServletException, IOException {
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.sendgrid.net");
			email.setSmtpPort(465);
			email.setAuthentication("apikey", "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");
			email.setSSLOnConnect(true);
			email.setFrom("polliesportiva@gmail.com");
			email.addTo(cliente.getEmail());
			email.setSubject("Confirmação de Cadastro");
			email.setMsg("Você foi Cadastrado com Sucesso na Polliesportiva. Bem vindo! "
					+ "\nAqui estão suas informações cadastradas:\nCódigo: " + cliente.getCod() + 
					"\nNome: " + cliente.getNome() + "\nSexo: " + cliente.getSexo() + "\nCPF: " + cliente.getCpf() + 
					"\nData de Nascimento: " + cliente.getDataNasc() + "\nTelefone: " + cliente.getTel() + 
					"\nEmail: " + cliente.getEmail() + "\nSenha: " + cliente.getSenha() + 
					"\nDeseja Receber Notificações: " + cliente.getNotificacao() + "\nObrigado por se Cadastrar na Polliesportiva!"); 
			email.send();
			return "\nUma confirmação de cadastro foi enviada ao seu email!";
		} catch (EmailException e) {
			e.printStackTrace();
			return "\nErro ao enviar o Email de cadastro!";
		}
	}
    
    protected void gerenciarClientes(HttpServletRequest request, HttpServletResponse response, String msg) throws ServletException, IOException, DAOException {    	
    	ClienteDAOIF dao = new ClienteDAO();
    	List<Cliente> clientes = dao.todosClientes();
    	request.setAttribute("clientes", clientes);
    	request.setAttribute("msg", msg);
    	HttpSession session = request.getSession(true);
    	RequestDispatcher rd =  null;
    	
    	if(session.getAttribute("online").getClass().equals(a.getClass())) {
    		rd = request.getRequestDispatcher("/WEB-INF/visao/gerenciarClientes.jsp");
    	} else if(session.getAttribute("online").getClass().equals(c.getClass())) {
    		rd = request.getRequestDispatcher("/WEB-INF/visao/perfilCliente.jsp");
    	}
    	
    	rd.forward(request, response);
    }
    
    protected void formAtualizarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DAOException {
    	ClienteDAOIF dao = new ClienteDAO();
    	Cliente cliente = dao.buscarCliente(Integer.parseInt(request.getParameter("cod")));
    	request.setAttribute("cliente", cliente);
    	
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/formularioAtualizarCliente.jsp");
    	rd.forward(request, response);
    }
    
    protected void atualizarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, FileUploadException, DAOException {
    	Cliente cliente = inserirCliente(request, response);
    	cliente.setCod(Integer.parseInt(request.getParameter("codCli")));
    	
    	ClienteDAOIF dao = new ClienteDAO();
    	
		String msg = dao.atualizar(cliente);
		
		request.setAttribute("online", cliente);
		
    	gerenciarClientes(request, response, msg);
    }
    
    protected void removerCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DAOException {
    	ClienteDAOIF dao = new ClienteDAO();
    	
		String msg = dao.remover(Integer.parseInt(request.getParameter("cod")));
		HttpSession session = request.getSession(true);
		int i = (Integer) session.getAttribute("qtdCli");
		i--;
		session.setAttribute("qtdCli", i);
		
    	gerenciarClientes(request, response, msg);
    }
    
    protected void formCadastrarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/FormularioCadastroCliente.jsp");
    	
    	rd.forward(request, response);
    }
}
