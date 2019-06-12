package br.com.docket.main;

import java.util.List;

import br.com.docket.hibernate.Operacoes;
import br.com.docket.modelo.Cartorio;

public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Operacoes op = new Operacoes();
		List<Cartorio> cartorios = op.listarCartorios();
		
		for(Cartorio cartorio:cartorios) {
			System.out.println("Id: " + cartorio.getId());
			System.out.println("Nome: " + cartorio.getNome());
		}
	}

}
