package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import model.DAO;
import model.Filter;
import model.ListaProdutos;
import model.ListaTecnologias;
import model.ParseJSON;
import model.Produto;
import model.ProdutoBuilder;
import model.Tecnologia;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns= {"/Controller", "/listar-produtos"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
		PrintWriter out = response.getWriter();
		if (request.getServletPath().equals("/listar-produtos")) {
			
			
			try {
				DAO dao = new DAO();
				String jsonContent = dao.fetchData();
					
				ParseJSON parseJson = new ParseJSON(jsonContent);
				
				ArrayList<String> uniqueTechnologies = parseJson.getUniqueValues("stack");
				
				ListaTecnologias todasTecs = new ListaTecnologias(uniqueTechnologies);
				
				todasTecs.setMarcadas(this.getRequestValues(request));
				
				ListaProdutos todosProdutos = new ProdutoBuilder(todasTecs).getTodosProdutos(parseJson);
				
				ListaProdutos produtosFiltrados = new Filter(todosProdutos).byTechnology();
				
				request.setAttribute("todasTecs", todasTecs);
				
				request.setAttribute("produtosFiltrados", produtosFiltrados);
				
				redirect("/listar-produtos.jsp", request, response);
				
			} catch (Exception e) {
				out.println(e.toString());
			}
		}
		
	}
	
	public ArrayList<String> getRequestValues(HttpServletRequest request) {
		ArrayList<String> out = new ArrayList<String>();
		Enumeration<String> reqNames = request.getParameterNames();
		while (reqNames.hasMoreElements()) {
			out.add(request.getParameter(reqNames.nextElement()));
		}
		return out;
	}
	
	public void redirect(String destPage, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destPage);
		dispatcher.forward(request, response);
	}
	
}
