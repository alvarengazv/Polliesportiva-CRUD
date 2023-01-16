package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdministradorDAO;
import dao.ClienteDAO;
import dao.CompraDAO;
import dao.DAOException;
import dao.EnderecoDAO;
import dao.ProdutoDAO;
import modelo.Administrador;
import modelo.Cliente;
import modelo.Compra;
import modelo.Endereco;
import modelo.Produto;

@WebServlet("/controlador")
public class controladorGeral extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public controladorGeral() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String acao = request.getParameter("acao");
		
		if(acao == null) 
			acao = "paginaInicial";
		
		if(acao.equals("paginaInicial")) {
			retornaPaginaInicial(request, response);
		} else if(acao.equals("formCadastrarEndereco")) {
			formCadastrarEndereco(request, response);
		} else if(acao.equals("formCadastrarCartao")) {
			formCadastrarCartao(request, response);
		} else if(acao.equals("verEndereco")) {
			verEndereco(request, response);
		} else if(acao.equals("verCartao")) {
			verCartao(request, response);
		} else if(acao.equals("loginUsuario")) {
			try {
				loginUsuario(request, response);
			} catch (ServletException | IOException | DAOException e) {
				e.printStackTrace();
			}
		} else if(acao.equals("formLogin")) {
			formLogin(request, response);
		} else if(acao.equals("isLogged")) {
			isLogged(request, response);
		} else if(acao.equals("perfilUsuario")) {
			perfilUsuario(request, response);
		} else if(acao.equals("logoutUsuario")) {
			try {
				logoutUsuario(request, response);
			} catch (ServletException | IOException | DAOException e) {
				e.printStackTrace();
			}
		} else if(acao.equals("adicionarCarrinho")) {
			try {
				adicionarCarrinho(request, response);
			} catch (NumberFormatException | ServletException | IOException | DAOException e) {
				e.printStackTrace();
			}
		} else if(acao.equals("paginaCarrinho")) {
			paginaCarrinho(request, response);
		} else if(acao.equals("removerProdutoCarrinho")) {
			try {
				removerProdutoCarrinho(request, response);
			} catch (NumberFormatException | ServletException | IOException | DAOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	protected void removerProdutoCarrinho(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException, DAOException {
		HttpSession session = request.getSession(true);
		List<Produto> produtosC = new ArrayList<Produto>();
		produtosC = (List<Produto>) session.getAttribute("produtosC");
		Produto produto =  new Produto();
		ProdutoDAO pDAO = new ProdutoDAO();
		if(request.getParameter("cod") != null) {
			produto = pDAO.buscarProduto(Integer.valueOf(request.getParameter("cod")));
			produtosC.removeIf(Produto-> Produto.getCod() == Integer.valueOf(request.getParameter("cod")));
		}
		String valorTotalS = produto.getPreco().replace(".", "");
		valorTotalS = valorTotalS.replace(",", ".");
		float valorTotal = 0;
		if(session.getAttribute("valorTotal") != null) {
			float a = Float.parseFloat(valorTotalS);
			String b = session.getAttribute("valorTotal").toString();
			valorTotal = Float.parseFloat(b) - a;
		} else {
			session.setAttribute("valorTotal", 0f);
			float a = Float.parseFloat(valorTotalS);
			String b = session.getAttribute("valorTotal").toString();
			valorTotal = Float.parseFloat(b) - a;
		}
		
		session.setAttribute("valorTotal", valorTotal);
		
		session.setAttribute("produtosC", produtosC);
		
		paginaCarrinho(request, response);
	}
	
	@SuppressWarnings("unchecked")
	protected void adicionarCarrinho(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException, DAOException {
		HttpSession session = request.getSession(true);
		if(isLogged(request, response).equals("Cliente")) {
			
			/*Carrinho carrinho = new Carrinho();*/
			List<Produto> produtosC = new ArrayList<Produto>();
			if(session.getAttribute("produtosC") != null) {
				produtosC = (List<Produto>) session.getAttribute("produtosC");
			}
			
			Produto produto = new Produto();
			ProdutoDAO pDAO = new ProdutoDAO();
			if(request.getParameter("cod") != null) {
				produto = pDAO.buscarProduto(Integer.valueOf(request.getParameter("cod")));
				produtosC.add(produto);
			}
			float valorTotal = 0;
			if(produto.getPreco() != null) {
				String valorTotalS = produto.getPreco().replace(".", "");
				valorTotalS = valorTotalS.replace(",", ".");
				if(session.getAttribute("valorTotal") != null) {
					float a = Float.parseFloat(valorTotalS);
					String b = session.getAttribute("valorTotal").toString();
					valorTotal = Float.parseFloat(b) + a;
				} else {
					session.setAttribute("valorTotal", 0f);
					float a = Float.parseFloat(valorTotalS);
					String b = session.getAttribute("valorTotal").toString();
					valorTotal = Float.parseFloat(b) + a;
				}
			}
			session.setAttribute("valorTotal", valorTotal);
			
			session.setAttribute("produtosC", produtosC);			
			paginaCarrinho(request, response);
			
		} else if(isLogged(request, response).equals("Administrador")) {
			String msg = "Navegue como um cliente para realizar compras!";
			request.setAttribute("msg", msg);
			session.invalidate();
			
			formLogin(request, response);
		} else if(isLogged(request, response).equals("Offline")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/formularioLogin.jsp");
			
			rd.forward(request, response);
		}
	}
	
	protected void paginaCarrinho(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/paginaCarrinho.jsp");
		
		rd.forward(request, response);
	}
	
	protected void perfilUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(isLogged(request, response).equals("Cliente")) {
			
			session.setMaxInactiveInterval(999999999);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/perfilCliente.jsp");
			
			rd.forward(request, response);
		} else if(isLogged(request, response).equals("Administrador")) {
			session.setMaxInactiveInterval(999999999);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/perfilAdministrador.jsp");
			
			rd.forward(request, response);
		} else if(isLogged(request, response).equals("Offline")) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/formularioLogin.jsp");
			
			rd.forward(request, response);
		}
	}
	
	protected void formLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/formularioLogin.jsp");
    	rd.forward(request, response);
	}
	
	protected String isLogged(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Cliente cliente = new Cliente();
		Administrador adm = new Administrador();
		if(session.getAttribute("online") != null) {
			if(session.getAttribute("online").getClass().equals(cliente.getClass())) {
				return "Cliente";
			} else if(session.getAttribute("online").getClass().equals(adm.getClass())) {
				return "Administrador";
			}
		} else {
			String msg = "Você não está logado!";
			request.setAttribute("msg", msg);
			return "Offline";
		}
		return "Offline";
	}
	
	protected void loginUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DAOException {
		String loginU = request.getParameter("loginU");
		String senhaU = request.getParameter("senhaU");
		try {
			if(isADM(loginU)) {
				AdministradorDAO aDAO = new AdministradorDAO();
				Administrador adm = aDAO.logarAdministrador(loginU, senhaU);
			
				if(adm != null) {
					ProdutoDAO pDAO = new ProdutoDAO();
					List<Produto> produtos = pDAO.todosProdutos();
					int qtdProd = produtos.size();
					
					ClienteDAO cDAO = new ClienteDAO();
					List<Cliente> clientes = cDAO.todosClientes();
					int qtdCli = clientes.size();
					
					HttpSession session = request.getSession(true);
					session.setAttribute("online", adm);
					session.setAttribute("qtdProd", qtdProd);
					session.setAttribute("qtdCli", qtdCli);
					
					perfilUsuario(request, response);
				} else {
					String msg = "Usuário ou Senha Incorretos!";
					request.setAttribute("msg", msg);
					
					formLogin(request, response);
				}
				
			} else {
				ClienteDAO cDAO = new ClienteDAO();
				Cliente cliente = cDAO.logarCliente(loginU, senhaU);
				
				if(cliente != null) {
					EnderecoDAO eDAO = new EnderecoDAO();
					List<Endereco> enderecos = eDAO.todosEnderecos(cliente.getCod());
					int qtdEnd = enderecos.size();
					
					CompraDAO coDAO = new CompraDAO();
					List<Compra> compras = coDAO.todasCompras(cliente.getCod());
					int qtdPedidos = compras.size();
					
					HttpSession session = request.getSession(true);
					session.setAttribute("online", cliente);
					session.setAttribute("enderecos", enderecos);
					session.setAttribute("qtdEnd", qtdEnd);
					session.setAttribute("qtdPedidos", qtdPedidos);
					
					perfilUsuario(request, response);
				} else {
					String msg = "Usuário ou Senha Incorretos!";
					request.setAttribute("msg", msg);
					
					formLogin(request, response);
				}
					
			}
		} catch(Exception e) {
			throw new DAOException(e.getMessage());
		}
	}
	
	protected boolean isADM(String loginU) {
		if(loginU.contains("@")) {
			return true;
		} 
		return false;
	}
	
	protected void logoutUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DAOException {
		HttpSession session = request.getSession(true);
		if(session.getAttribute("online") != null) {
			session.invalidate();
		}
		formLogin(request, response);
	}
	
	protected void retornaPaginaInicial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/paginainicial1.jsp");
    	
    	rd.forward(request, response);
    }
	
	protected void formCadastrarEndereco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/formularioCadastroEndereco.jsp");
    	
    	rd.forward(request, response);
    }
	
	protected void verEndereco(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/verEndereco.jsp");
    	
    	rd.forward(request, response);
    }
	
	protected void formCadastrarCartao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/formularioCadastroCartao.jsp");
    	
    	rd.forward(request, response);
    }
	
	protected void verCartao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/verCartao.jsp");
    	
    	rd.forward(request, response);
    }
}