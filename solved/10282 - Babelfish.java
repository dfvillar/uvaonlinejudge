import java.io.*;
import java.util.*;

/*
 *
 * 10282 Babelfish
 *
 */ 

public class Main{
	public static void main(String... args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		TreeMap<String, String> dictionary = new TreeMap<String, String>();
		while( (line = br.readLine()) != null && !line.equals("")){
			String[] data = line.split(" ");
			dictionary.put(data[1], data[0]);	
		}
		while( (line = br.readLine()) != null ){
			String out = dictionary.get(line) == null ? "eh" : dictionary.get(line);
			//String out = dictionary.get(line);
			System.out.println(out);			
		}
	}
}
