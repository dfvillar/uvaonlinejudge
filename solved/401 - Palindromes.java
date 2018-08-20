import java.io.*;

/*
 * 401 - Palindromes
 */ 

public class Main{
	private static char[] ascii;

	static{

		ascii = new char[256];
		for(int i=0; i<ascii.length; i++) ascii[i]= '#';
		ascii['A'] = 'A';
		ascii['E'] = '3';
		ascii['H'] = 'H';
		ascii['I'] = 'I';
		ascii['J'] = 'L';
		ascii['L'] = 'J';
		ascii['M'] = 'M';
		ascii['O'] = 'O';
		ascii['S'] = '2';
		ascii['T'] = 'T';
		ascii['U'] = 'U';
		ascii['V'] = 'V';
		ascii['W'] = 'W';
		ascii['X'] = 'X';
		ascii['Y'] = 'Y';
		ascii['Z'] = '5';
		ascii['1'] = '1';
		ascii['2'] = 'S';
		ascii['3'] = 'E';
		ascii['5'] = 'Z';
		ascii['8'] = '8';
	}

	
	public static void main(String... args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = "";

		while( (word = br.readLine()) != null ){
			if(isPalondromic(word) && word.equals(reversed(word))){				
				System.out.println(word + " -- is a mirrored palindrome.");
			}else if(word.equals(reversed(word))){
				System.out.println(word + " -- is a mirrored string.");
			}else if(isPalondromic(word)){
				System.out.println(word + " -- is a regular palindrome.");
			}else{
				System.out.println(word + " -- is not a palindrome.");
			}
			System.out.println("");
		}
	}

	private static String reversed(String word){
		int ln = word.length();
		StringBuilder sb = new StringBuilder();

		for(int i=ln-1; i>=0; i--){			
			char t = ascii[word.charAt(i)];
			sb.append(String.valueOf(t));
		}
		return sb.toString();
	}

	private static boolean isPalondromic(String word){
		int left = 0;
		int right = word.length()-1;

		while(left < right){
			if(word.charAt(left++) != word.charAt(right--))
				return false;			
		}
		return true;
	}
}
