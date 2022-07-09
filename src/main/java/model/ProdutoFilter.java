package model;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class ProdutoFilter {
	ArrayList<Produto> produtos;
	ArrayList<String> tecnologiasBuscadas;
	/*public ProdutoFilter(ArrayList<Produto> produtos, ArrayList<String> tecnologiasBuscadas) {
		this.produtos = produtos;
		this.tecnologiasBuscadas = tecnologiasBuscadas;
	}
	*/
	public ProdutoFilter(ArrayList<Produto> produtos, HttpServletRequest request) {
		this.produtos = produtos;
		
		tecnologiasBuscadas = new ArrayList<String>();
		criarFiltro(request);
		
	}
	public ArrayList<Produto> filtrar() {
		ArrayList<Produto> saidaFiltrada = new ArrayList<Produto>();
		
		if (tecnologiasBuscadas.isEmpty()) {
			saidaFiltrada = produtos;
		} else {
			for (Produto p : produtos) {
				if (produtoContemTec(p)) {
					saidaFiltrada.add(p);
				}
			}
		}
		return saidaFiltrada;
	} 
	
	private boolean produtoContemTec(Produto p) {
		for (String t : tecnologiasBuscadas) {
			if (p.getStack().contains(t)) {
				return true;
			}
		}
		return false;
	}
	
	private void criarFiltro(HttpServletRequest request) {
		Enumeration<String> a = request.getParameterNames();			
		while (a.hasMoreElements()) {
			tecnologiasBuscadas.add(request.getParameter(a.nextElement())); 
		}
	}
}
