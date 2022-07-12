package model;

public class Tecnologia {
	private String tecNome;
	private boolean isChecked;
	private int id;
	
	public Tecnologia() {
		this.setChecked(false);
	}
	public Tecnologia(String tecNome, int id) {
		this();
		this.tecNome = tecNome;
		this.id = id;
	}
	public String getTecNome() {
		return tecNome;
	}
	public void setTecNome(String tecNome) {
		this.tecNome = tecNome;
	}
	public boolean isChecked() {
		return isChecked;
	}
	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
