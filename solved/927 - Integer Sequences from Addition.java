import java.io.*;

//927 Integer Sequences from Addition of Terms

class Main{
	public static void main(String... args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		while(n-- > 0){
			String polynomial = br.readLine();
			int d = Integer.parseInt(br.readLine());
			int k = Integer.parseInt(br.readLine());
			int kval = serie(d, k);
			String[] poly = polynomial.split(" ");
			int c = Integer.parseInt(poly[0]);
			long t = 0;
			for(int i=1, j=0; i<poly.length; i++, j++){
				t += Integer.parseInt(poly[i]) * Math.pow(kval, j);
			}
			System.out.println(t);
		}
	}

	private static int serie(int d, int k){
		int bm = 0;
		int kval = 0;

		do{
			kval++;
			bm += kval * d;
		}while( bm < k);
			
		return kval;
	}
}
