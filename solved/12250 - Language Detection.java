import java.io.*;
import java.util.*;

/*
 * 12250 - Language Detection
 */ 

public class Main{
	private static HashMap<String, String> languages;

	static{
		languages = new HashMap<String, String>();
		languages.put("HELLO","ENGLISH");
		languages.put("HOLA","SPANISH");
		languages.put("HALLO","GERMAN");
		languages.put("BONJOUR","FRENCH");
		languages.put("CIAO","ITALIAN");
		languages.put("ZDRAVSTVUJTE","RUSSIAN");
	}
	
	public static void main(String... args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		int count = 1;
		while(!(line = br.readLine()).equals("#")){
			String res = languages.get(line) == null ? "UNKNOWN" : languages.get(line);
			System.out.println("Case " + count + ": " + res);
			count++;
		}
	}
}
