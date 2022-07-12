package model;

public class Filter {
	
	ListaProdutos listaProdutos;
	public Filter(ListaProdutos listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	
	public ListaProdutos byTechnology() {
		ListaProdutos filtrados = new ListaProdutos();
		for (Produto p: listaProdutos) {
			if (p.hasAnyCheckedTechnology()) {
				filtrados.add(p);
			}
		}
		if (filtrados.isEmpty()) {
			return this.listaProdutos;
		} else {
			return filtrados;
		}
		
	}
}
