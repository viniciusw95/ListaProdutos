package model;
import java.util.ArrayList;

public class StackGetter {
	ArrayList<Produto> todosProdutos;
	ArrayList<String> stack;
	public StackGetter(ArrayList<Produto> todosProdutos) {
		this.todosProdutos = todosProdutos;
	}
	public ArrayList<String> getTodasStacks() {
		stack = new ArrayList<String>();
		for (Produto p : todosProdutos) {
			extrairStack(p);
		}
		return stack;
	}
	private void extrairStack(Produto p) {
		for (String tec: p.getStack()) {
			if (!stack.contains(tec)) {
				stack.add(tec);
			}
		}
	}
}
