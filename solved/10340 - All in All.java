import java.io.*;
import java.util.*;

/*
 * 10340 All in All
 */

public class Main{
	public static void main(String... args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while( (line=br.readLine()) != null){
			String[] words = line.split(" ");			

			String a = words[0];
			String b = words[1];
			int j = 0;
			StringBuilder sb = new StringBuilder();
				
			for(int i=0; i<a.length(); i++){
				
				while(j < b.length()){
					//System.out.print(j + "] " + a.charAt(i) + " " + b.charAt(j) + " : ");
					if(a.charAt(i) == b.charAt(j)){
						sb.append(b.charAt(j) + "");
						j++;
						break;
					}
					j++;					
				}				
			}
			String t = sb.toString();
			
			if(a.equals(t))
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
}
