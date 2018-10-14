import java.io.*;

/*
 *11309 - Counting Chaos
 */

public class Main{
	public static void main(String... args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());

		while(cases-- > 0){
			String line = br.readLine();
			System.out.println(process(line));
		}		
	}
	private static String process(String input){
		int hh = Integer.parseInt(input.split(":")[0]);
		int mm = Integer.parseInt(input.split(":")[1]);

		while(hh < 24){
			mm++;
			if(hh == 23 && mm == 60)return "00:00";
			
			if(mm == 60){
				hh++;
				mm=0;
				continue;
			}
			
			if(isPalindromic("" + (hh*100 + mm))){
				String formatHH = "" + hh;
				String formatMM = "" + mm;
				if(hh < 10 ) formatHH = "0" + hh;
				if(mm < 10 ) formatMM = "0" + mm;
								
				return  formatHH + ":" + formatMM;
			}			
		}
		return "";
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
