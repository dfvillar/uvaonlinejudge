import java.io.*;
import java.util.*;

/*
 * 12577 - Hajj-e-Akbar
 */ 

public class Main{
	private static HashMap<String, String> languages;

	static{
		languages = new HashMap<String, String>();
		languages.put("Hajj","Hajj-e-Akbar");
		languages.put("Umrah","Hajj-e-Asghar");
	}
	
	public static void main(String... args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		int count = 1;
		while(!(line = br.readLine()).equals("*")){
			String res = languages.get(line) == null ? "UNKNOWN" : languages.get(line);
			System.out.println("Case " + count + ": " + res);
			count++;
		}
	}
}
