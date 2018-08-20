import java.io.*;
import java.math.*;

/*
 * 10018 Reverse and Add
 */ 

public class Main{
	public static void main(String... args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());

		

		while(cases-- > 0){
		
			String number = br.readLine().trim();
			int count = 0;
			do{
				StringBuilder sb = new StringBuilder();
				sb.append(number);	
				sb = sb.reverse();
				BigInteger a = new BigInteger(number);
				BigInteger b = new BigInteger(sb.toString());
				BigInteger sum = a.add(b);
				number = sum.toString();
				count++;
			}while(!isPalindrome(number));

			System.out.println(count + " " + number);
		}
	}

	private static boolean isPalindrome(String word){
		int left = 0;
		int right = word.length()-1;
		while(left < right){
			if(word.charAt(left++) != word.charAt(right--)){
				return false;
			}
		}
		return true;
	}
}
