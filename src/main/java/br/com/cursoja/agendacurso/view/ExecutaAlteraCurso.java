package br.com.cursoja.agendacurso.view;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import br.com.cursoja.agendacurso.controller.CursoController;
import br.com.cursoja.agendacurso.model.entidade.Curso;

/**
 * Servlet implementation class ExecutaAlteraCurso
 */
public class ExecutaAlteraCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecutaAlteraCurso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nome = request.getParameter("nomeCurso");
		String strValor = request.getParameter("mensalidade");
		String strId = request.getParameter("id");
		
		double valor = 0.00;
		long id = 0;
		
		try {
			valor = Double.parseDouble(strValor);
			id = Long.parseLong(strId);			
		}catch(Exception e) {
			System.out.println("Erro na conversão");
		}
		
		Curso c = new Curso();
		c.setId(id);
		c.setNome(nome);
		c.setValor(valor);
		
		CursoController controller =  new CursoController();
		controller.alterar(c);
		
		RequestDispatcher rd = request.getRequestDispatcher("listarcurso.jsp");
		rd.forward(request, response);
	}

}
