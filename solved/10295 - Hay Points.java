import java.io.*;
import java.util.*;

/*
 * 10295 Hay Points
 */

public class Main{
	public static void main(String... args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		TreeMap<String, Integer> dictionary = new TreeMap<String, Integer>();
		int dict = 0;
		int desc = 0;

		line=br.readLine();
		String[] control = line.split(" ");
		dict = Integer.parseInt(control[0]);
		desc = Integer.parseInt(control[1]);			

		
		while( dict-- > 0 ){
			line = br.readLine();
			String[] d = line.split(" ");
			int dollars = Integer.valueOf(d[1]);
			dictionary.put(d[0], dollars); 
		}
		
		while(desc-- > 0){
			int sum = 0;
			while(!(line = br.readLine()).equals(".")){
				String[] words = line.split(" ");
				for(String w : words){
					int value = dictionary.get(w) == null ? 0 : dictionary.get(w);
					sum += value;
				}
			}
			System.out.println(sum);
		}

	}
}
