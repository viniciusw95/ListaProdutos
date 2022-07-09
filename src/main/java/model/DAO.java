package model;

import java.io.File;
import java.util.Scanner;

public class DAO {
	// Parâmetro de conexão
	boolean producao = true;
	private String url = "/home/vinicius/Documentos/eclipse-workspace/Gubee/src/main/resources/gubee-json2.json";
	
	public DAO() {
		if (producao) {
			
			ClassLoader classLoader = getClass().getClassLoader();
			url = classLoader.getResource("gubee-json2.json").getFile();   

		}
	}
	
	public String fetchData() {
		try {
			File file = new File(url);
			Scanner sc = new Scanner(file, "utf-8");
			sc.useDelimiter("\\Z");
			String json = sc.next(); 
			sc.close();
			System.out.println(file.getAbsolutePath());
			return json;
		} catch (Exception e) {
			return e.toString();
		}
	}
}
