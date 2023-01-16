package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileUploadException;

import dao.CompraDAO;
import dao.CompraDAOIF;
import dao.DAOException;
import modelo.Cliente;
import modelo.Compra;
import modelo.Produto;

@WebServlet("/controladorCompra")
public class controladorCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public controladorCompra() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.sendRedirect("/controladorC?acao=cadastrarCompra");
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String acao = request.getParameter("acao");
	
		if(acao.equals("cadastrarCompra")) {
			try {
				cadastrarCompra(request, response);
			} catch (ServletException | IOException | FileUploadException | DAOException e) {
				e.printStackTrace();
			}
		} else if(acao.equals("formCadastrarCompra")){
			formCadastrarCompra(request, response);
		} else if (acao.equals("detalhesCompra")) {
			try {
				detalhesCompra(request, response);
			} catch (ServletException | IOException | DAOException e) {
				e.printStackTrace();
			}
		} else if (acao.equals("gerenciarCompras")) {
			String msg = "";
			try {
				gerenciarCompras(request, response, msg);
			} catch (ServletException | IOException | DAOException e) {
				e.printStackTrace();
			}
		}		
	}
    
    protected Compra inserirCompra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, FileUploadException {
    	Calendar dH = Calendar.getInstance();
    	Compra compra = new Compra();
    	HttpSession session = request.getSession();
    	Cliente c = (Cliente) session.getAttribute("online");
    	int i = c.getCod();
    	
    	compra.setCodCli(i);
    	compra.setAvaliacao(request.getParameter("avaliacao"));
    	compra.setFormaPagamento(request.getParameter("formaPagamento"));
    	compra.setComentario(request.getParameter("comentario"));
    	compra.setDataHora(dH);
    	return compra;
    	
    }
    
    protected void detalhesCompra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DAOException {
    	CompraDAOIF dao = new CompraDAO();
    	Compra compra = dao.buscarCompra(Integer.parseInt(request.getParameter("cod")));
    	request.setAttribute("compra", compra);
    	
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/detalhesCompra.jsp");
    	rd.forward(request, response);
    }
    
    @SuppressWarnings("unchecked")
	protected void cadastrarCompra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, FileUploadException, DAOException {
    		Compra compra = inserirCompra(request, response);
    		System.out.println(compra.getDataHora().getTime());
    		CompraDAOIF dao = new CompraDAO();
    		HttpSession session = request.getSession();
    		if(session.getAttribute("qtdPedidos") != null) {
    			int i = (Integer) session.getAttribute("qtdPedidos");
        		i++;
        		session.setAttribute("qtdPedidos", i);
    		}
    		
    		
    		String msg = dao.cadastrar(compra, (List<Produto>) session.getAttribute("produtosC"));
 
	    	
	    	gerenciarCompras(request, response, msg);
    }

    
    protected void gerenciarCompras(HttpServletRequest request, HttpServletResponse response, String msg) throws ServletException, IOException, DAOException {    	
    	CompraDAOIF dao = new CompraDAO();
    	HttpSession session = request.getSession();
    	Cliente c = (Cliente) session.getAttribute("online");
    	int i = c.getCod();
    	List<Compra> compras = dao.todasCompras(i);
    	request.setAttribute("compras", compras);
    	request.setAttribute("msg", msg);
    	
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/gerenciarCompras.jsp");
    	
    	rd.forward(request, response);
    }
    
    protected void formCadastrarCompra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/formularioCompra.jsp");
    	
    	rd.forward(request, response);
    }
}
