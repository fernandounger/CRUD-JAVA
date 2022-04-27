package br.com.cursoja.agendacurso.view;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import br.com.cursoja.agendacurso.controller.ProfessorController;
import br.com.cursoja.agendacurso.model.entidade.Professor;

/**
 * Servlet implementation class ProfessorServelet
 */
public class ProfessorServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfessorServelet() {
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
		String strValorHora = request.getParameter("valorhora");
		String nome = request.getParameter("nomeprofessor");
		String celular = request.getParameter("celularprofessor");
		
		
		System.out.println(strValorHora);
		System.out.println(nome);
		System.out.println(celular);
		
		double valor = 0.00;
		try {
		valor = Double.parseDouble(strValorHora);
		}catch(Exception e) {
			
		}
		
		Professor p = new Professor();
		p.setValorHora(valor);
		p.setNome(nome);
		p.setCelular(celular);
		
		ProfessorController controller = new ProfessorController();
		controller.cadastrar(p);
		
		RequestDispatcher rd = request.getRequestDispatcher("listarprofessor.jsp");
		rd.forward(request, response);
		
		//doGet(request, response);
	}

}
