import java.util.*;
import java.io.*;

/*
 * 10460 Find the Permuted String
 */ 

public class Main {

	public static int POS = 0;

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		ArrayList<String> perms = null;
		PrintWriter pw = new PrintWriter(System.out);
		//long start = System.currentTimeMillis();
        while(cases-- > 0){
			String str = br.readLine();
			POS = Integer.parseInt(br.readLine());
			perms = permute(str);
			pw.println(perms.get(POS-1));
		}
		//long end = System.currentTimeMillis();
		//pw.println("time: " + (end - start));
		pw.flush();		   
    }
	
    public static ArrayList<String> permute(String str){		
		ArrayList<String> perms = new ArrayList<String>();
		int n = str.length();
		if(n == 0){
			perms.add("");
			return perms;
		}	
		char first = str.charAt(n-1);
		String remainder = str.substring(0, n-1);

		ArrayList<String> words = permute(remainder);

		for(String word : words){
			for(int i=0; i<=word.length(); i++){
				String s = swap(word, first, i);
				perms.add(s);
				if(perms.size()>= POS){return perms;}
			}
		}
		return perms;
	}

	public static String swap(String word, char c, int i){
		String start = word.substring(0, i);
		String end = word.substring(i);
		String ch = String.valueOf(c);

		return start + ch + end;
	}


}
