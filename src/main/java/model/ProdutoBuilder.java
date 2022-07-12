package model;

public class ProdutoBuilder {
	ListaTecnologias tecsDisponiveis;
	public ProdutoBuilder(ListaTecnologias tecsDisponiveis) {
		this.tecsDisponiveis = tecsDisponiveis;
	}
	
	public ListaProdutos getTodosProdutos(ParseJSON parser) {
		ListaProdutos listaProdutos = new ListaProdutos();
		Produto p;
		for (int i=0; i < parser.length(); i++) {
			p = new Produto();
			p.setProductName(parser.getJSONObject(i).getString("productName"));
			p.setDescription(parser.getJSONObject(i).getString("description"));
			p.setTargetMarket(parser.getAttributeValues(i, "targetMarket"));
			for (String tec: parser.getAttributeValues(i, "stack")) {
				p.getStack().add(tecsDisponiveis.get(tec));
			}
			listaProdutos.add(p);
		}
		return listaProdutos;
	}
	
}
