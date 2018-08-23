	import java.io.*;
import java.util.*;

/*
 * 621 - Secret Research
 */ 

public class Main{
	public static void main(String... args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n  = Integer.parseInt(br.readLine());
		
		while(n-- > 0){
			String s = process(br.readLine());
			if(s != null )
				System.out.println(s);
		}
	}
	private static String process(String line){
		//System.out.print(line + " ");
		int ln = line.length();
		if(ln == 1 &&
			(line.equals("1") || line.equals("4")))
			return "+";
		if(ln == 2 && line.equals("78") )
			return "+";			
		if(line.charAt(ln-2) == '3' && line.charAt(ln-1) == '5' )
			return "-";
		if(line.charAt(0) == '9' && line.charAt(ln-1) == '4' )
			return "*";
		if(line.charAt(0) == '1' && line.charAt(1) == '9' && line.charAt(2) == '0' )
			return "?";			
		
		return null;
	}
}
