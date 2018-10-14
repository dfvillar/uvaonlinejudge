import java.io.*;

/*
 * 11150 - Cola
 */

public class Main{
	public static void main(String... args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		
		while( (line = br.readLine()) != null ){
			int n = Integer.parseInt(line);
			System.out.println(calculate(n, n, 0));
			System.out.println("");	
		}
		
		
	}

	private static int calculate(int n, int total, int borrowed){
		if(n <= 1)return total;

		System.out.println("input " + n +" total " + total);
		
		int remainder = n - ((n/3)*3);
		int promo = (n/3);

		System.out.println("Promo Propios " + promo);
		
		if(remainder > 0){
			borrowed = borrowed + (3-remainder);
			promo = promo + ((3-remainder)+remainder)/3;
			total = total + promo;
			promo = promo - borrowed;
		}else{
			total = total + promo;
		}
		

		System.out.println("Restantes " + remainder + " Prestados " + borrowed);

		System.out.println("Promo (Restantes + Prestados) " + promo);

		System.out.println("Total " + total);
		
		return calculate(promo, total, borrowed);
	
	}
}
