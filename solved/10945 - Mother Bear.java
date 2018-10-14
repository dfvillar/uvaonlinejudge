import java.io.*;

/*
 * 10945 - Mother Bear
 */

public class Main{
	public static void main(String... args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";

		while( !(line=br.readLine()).equals("DONE") ){

			if(isPalindromic(line.replaceAll("[.,!? ]", "")))
				System.out.println("You won't be eaten!");
			else
				System.out.println("Uh oh..");

		}		
	}

	private static boolean isPalindromic(String word){
		word = word.toUpperCase();
		int right = word.length()-1;
		int left = 0;

		while( left < right)
			if(word.charAt(left++) != word.charAt(right--))
				return false;

		return true;
	}
}
