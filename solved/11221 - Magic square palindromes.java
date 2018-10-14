import java.io.*;

/*
 * 11221 - Magic square palindromes
 */

public class Main{
	public static void main(String... args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		int count = 0;
		while(c-- > 0){
			String input = br.readLine();
			//[,?!.¿() ]
			input = input.replaceAll("[^a-z]", "");
			int ln = input.length();
			double r = Math.sqrt(ln);
			count++;
			System.out.println("Case #"+count+":");
			if(isPalindromic(input) && ( (r%2) == 0 || (r%2) == 1)){				
				System.out.println((int)r);
			}else{
				System.out.println("No magic :(");
			}
		}		
	}

	private static boolean isPalindromic(String word){
		int right = word.length()-1;
		int left = 0;

		while(left < right){
			if(word.charAt(left++) != word.charAt(right--))return false;
		}
		return true;
	}
}



