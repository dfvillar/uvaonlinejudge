import java.util.*;

/*
 * 256 Quirksome Squares
 */ 

public class Main{
	public static void main(String... args){

		Scanner sc = new Scanner(System.in);

		while( sc.hasNextInt()){
			int n = sc.nextInt();
			process(n);
		}	
	}

	public static void process(int n){
		String format = "%0"+ n + "d";
		
		double t = Math.pow(10, n);
		double m = Math.pow(10, n/2);

		int j = 1;
		int i=0;
				
		while(i<t){
			double sqrt = Math.sqrt(i);		
			double a =  (int) (i / m);
			double b = sqrt - (int)( i / m);
				
			if(((a*m) + b) == Math.pow(a+b, 2)){
				String result = String.format(format, i);
				System.out.println(result);
			}			
			i = i + j;
			j+=2;
		}	

	}
}
