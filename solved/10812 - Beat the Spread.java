import java.io.*;

/*
 * 10812 - Beat the Spread!
 */

public class Main{
	public static void main(String... args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		while(n-- > 0){
			String[] values = br.readLine().split(" ");
			int a = Integer.parseInt(values[0]);
			int b = Integer.parseInt(values[1]);

			if(((a+b)%2) == 1 || ((a-b)%2) == 1 || (a-b) < 0){
				System.out.println("impossible");
			}else{
				System.out.println(((a+b)/2) + " " + ((a-b)/2));
			}	
		}		
	}
}
