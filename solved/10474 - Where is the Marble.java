import java.io.*;
import java.util.*;

/*
 * 10474 - Where is the Marble
 */

public class Main{
	public static void main(String... args)throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		int c = 1;
		int n = 0;
		int q = 0;
		PrintStream out = new PrintStream(System.out, true, "ISO-8859-1");
		while(((n = sc.nextInt()) != 0) && ((q = sc.nextInt()) != 0)){

			int[] a = new int[n];
			for(int i=0; i<n; i++){
				a[i] = sc.nextInt();
			}

			int[] b = countingSort(a);
			String s1 = "CASE# "+c+":\n";
			out.write(s1.getBytes());
			for(int i=0; i<q; i++){
				 int t =  sc.nextInt();
				 String s2 = "";
				 if(b[t] >= 0)					
					s2 = t + " found at "+ b[t] + "\n";
				else
					s2 = t + " not found\n";

				out.write(s2.getBytes());
			}
			c++;
		}
	}


	private static int[] countingSort(int[] a){
		int ln = 10001;
		int[] count = new int[ln];
		int[] pos = new int[ln];

		for(int i=0; i<pos.length; i++)pos[i] = -1;

		for(int i=0; i<a.length; i++){
			count[a[i]] += 1;
		}

		for(int i=1; i<count.length; i++){
			count[i] = count[i-1] + count[i];
		}

		for(int j=a.length-1; j>=0; j--){
			int t = count[a[j]];
			//System.out.print(a[j] + ":" + t + " ");
			pos[a[j]] = t;
			count[a[j]]--;
		}
		//System.out.println();
		//for(int i=0; i<pos.length; i++)System.out.print(pos[i] + " ");
		//System.out.println();
		return pos;
	}
}
