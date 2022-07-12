package model;

import java.util.ArrayList;

import org.json.JSONArray;

public class ParseJSON extends JSONArray {
	
	public ParseJSON(String content) {
		super(content);
		
	}
	
	public ArrayList<String> getAttributeValues(int produto, String parameter) {
		ArrayList<String> out = new ArrayList<String>();
		JSONArray arr = this.getJSONObject(produto).getJSONArray(parameter);
		for (int i=0; i < arr.length(); i++) {
			out.add(arr.getString(i));
		}
		return out;
	}
	
	public ArrayList<String> getUniqueValues(String parameter) {
		ArrayList<String> uniqueValues = new ArrayList<String>();
		ArrayList<String> values;
		for (int i = 0; i < this.length(); i++) {
			values = getAttributeValues(i, parameter);
			for (int j = 0; j < values.size(); j++) {
				if (!uniqueValues .contains(values.get(j))) {
					uniqueValues.add(values.get(j));
				}
			}
		}
		return uniqueValues;
	}
	
}
