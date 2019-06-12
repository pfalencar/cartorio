package br.com.docket.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.docket.hibernate.Operacoes;
import br.com.docket.modelo.Cartorio;

 // Servlet implementation class ProcessaLoginServlet 
@WebServlet("/VisualizarCartorioServlet")
public class VisualizarCartorioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	 // @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processaRequest(request, response);
	}

	
	 // @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processaRequest(request, response);
	}
	
	protected void processaRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uId = request.getParameter("id");
		
		//Visualizar
		Operacoes op = new Operacoes();
		Cartorio cart = op.visualizarCartorio(Integer.parseInt(uId));
		
		response.getWriter().append("O cartório solicitado é: " + cart.getNome());
	}
	

}