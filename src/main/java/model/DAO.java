package model;

import java.io.File;
import java.net.URL;
import java.util.Scanner;

public class DAO { 	
	private URL url = null;
	private String filePath;
	
	public DAO() {	
		getFileLocation();
	}
	public void getFileLocation() throws NullPointerException {
		ClassLoader classLoader = getClass().getClassLoader();
		url = classLoader.getResource("gubee-json2.json");
		if (url == null) {
			throw new NullPointerException("Arquivo JSON não encontrado no servidor.");
		} else {
			filePath = url.getFile();
		}
	}
	public String fetchData() {
		try {
			File file = new File(filePath);
			Scanner sc = new Scanner(file, "utf-8");
			sc.useDelimiter("\\Z");
			String json = sc.next(); 
			sc.close();
			return json;
		} catch (Exception e) {
			return e.toString();
		}
	}
}
