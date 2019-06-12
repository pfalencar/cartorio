package br.com.docket.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.docket.hibernate.Operacoes;
import br.com.docket.modelo.Cartorio;

 // Servlet implementation class ProcessaLoginServlet 
@WebServlet("/ListarCartorioServlet")
public class ListarCartorioServlet extends HttpServlet {
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
		//Listar
		Operacoes op = new Operacoes();
		List<Cartorio> carts = op.listarCartorios();
		
		int contador = 1;
		for(Cartorio cart:carts) {
		  response.getWriter().append("Registro de cartório nº " + contador + ":");
		  response.getWriter().append("Id: " + Integer.toString(cart.getId()));
		  response.getWriter().append("Nome: " + cart.getNome() + "\n");
		  contador++;
		}
		
		
	}
	

}