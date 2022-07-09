package model;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class ParseJSON {
	private JSONArray arr; 
	
	public ParseJSON(String json) throws Exception {
		try {
			arr = new JSONArray(json);
		} catch (Exception e) {
			
		}
	}
	
	public JSONArray getArr() {
		return arr;
	}
	public Produto getProduto(int position) {
		try {
			JSONObject jo = arr.getJSONObject(position);
			Produto produto = new Produto();
			produto.setProductName(jo.getString("productName"));
			produto.setDescription(jo.getString("description"));
			produto.setStack(getArrayList(jo, "stack"));
			produto.setTargetMarket(getArrayList(jo, "targetMarket"));
			return produto;
		} catch (Exception e) {
			return null;
		}
	}
	public ArrayList<String> getArrayList(JSONObject jo, String paramName) {
		JSONArray ja = jo.getJSONArray(paramName);
		ArrayList<String> arr = new ArrayList<String>();
		for (int i=0; i < ja.length(); i++) {
			arr.add(ja.getString(i));
		}
		return arr;
	}
	public ArrayList<Produto> getTodosProdutos() {
		ArrayList<Produto> todosProdutos = new ArrayList<Produto>();
		for (int i = 0; i < arr.length(); i++) {
			todosProdutos.add(getProduto(i));
		}
		return todosProdutos;
	}
}
