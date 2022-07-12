package model;

import java.util.ArrayList;

public class ListaTecnologias extends ArrayList<Tecnologia> {
	private static final long serialVersionUID = 1L;
	
	public ListaTecnologias(ArrayList<String> tecnologias) {
		super();
		addTecs(tecnologias);
	}
	
	private void addTecs(ArrayList<String> tecnologias) {
		int cont = 0;
		for (String tec: tecnologias) {
			this.add(new Tecnologia(tec, cont));
			cont++;
		}
	}
	
	public void setMarcadas(ArrayList<String> requestValues) {
		for (Tecnologia tec: this) {
			if (requestValues.contains(tec.getTecNome())) {
				tec.setChecked(true);
			} 
		}
	}
	public ArrayList<Tecnologia> getMarcadas() {
		ArrayList<Tecnologia> marcadas = new ArrayList<Tecnologia>();
		for (Tecnologia tec: this) {
			if (tec.isChecked()) {
				marcadas.add(tec);
			} 
		}
		return marcadas;
	}
	
	public Tecnologia get(String tecNome) {
		for (Tecnologia tec: this) {
			if (tec.getTecNome().equals(tecNome)) {
				return tec;
			} 
		}
		return null;
	}
	
}
