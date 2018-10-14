import java.io.*;
import java.util.*;

/*
 * 353 - Pesky Palindromes
 */

public class Main{
	public static void main(String... args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		String str = "";
		while( (str=br.readLine()) != null){
			//String word = str.toUpperCase();
			int ln = str.length();
			char[] charry = str.toCharArray();
			String s = "";
			HashSet<String> set = new HashSet<String>();
			for(int i=1; i<=ln;i++){
				s  = String.valueOf(charry[i-1]);
				set.add(s);		
				for(int j=i; j<ln;j++){				
					s = s + String.valueOf(charry[j]);
					set.add(s);
				}
			}
			int count = 0;
			//for(String w : set)
			//System.out.println(w + " " + isPalindromic(w));
			
			for(String w : set)
			if(isPalindromic(w))count++;
			
			System.out.println("The string '" + str +"' contains "+ count +" palindromes.");
		}			
	}

	private static boolean isPalindromic(String str){
		
		int right = str.length()-1;
		int left = 0;

		while(left < right){
			if(str.charAt(left++) != str.charAt(right--)){
				return false;
			}
		}
			
		return true;
	}
}
