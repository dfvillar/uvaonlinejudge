import java.util.*;

/*
 *  10976 - Fractions Again
 */ 

class Main{	
	public static void main(String... arg){
		
		Scanner sc = new Scanner(System.in);
		int k = 0;
		while(sc.hasNextInt()){
			k = sc.nextInt();
			calculate(k);	
		}
	}

	private static void calculate(int k){

		String ini = "1/"+ k + " = ";
		String part = "1/";
		double x = 0;
		double y = 0;
		List<String> result = new ArrayList<String>();

		for(int i=k+1; i<=k*2; i++){
			y = i;
			x= (k*y) / (y-k);
			if(x  == (int) x)
				result.add(ini + part + (int)x + " + " + part + i);
		}
		System.out.println(result.size());
		for(String fracc : result){
			System.out.println(fracc);
		}
		
	}
	
}
