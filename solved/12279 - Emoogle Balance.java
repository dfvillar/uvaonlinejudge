import java.io.*;
import java.util.*;

/*
 * 12279 - Emoogle Balance
 */
public class Main{
	public static void main(String... args)throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = 0;
		int cases = 0;

		while( (n=sc.nextInt()) != 0){
			
			int giving = 0;
			int given = 0;
			for(int i=0; i<n; i++){
				if(sc.nextInt() != 0)
					giving++;
				else
					given++;				
			}
			cases++;
			System.out.println("Case " + cases + ": " + (giving-given));
		}
	}
}
