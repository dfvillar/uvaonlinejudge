import java.util.*;
import java.io.*;

/*
 * 11849 CD
 */ 

public class Main{
	public static void main(String... args)throws IOException{
		long s = System.currentTimeMillis();
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = -1;

		while(total != 0){
			String l = br.readLine();
			String[] la = l.split(" ");
			int n = Integer.parseInt(la[0]);
			int m = Integer.parseInt(la[1]);
			total = n + m;
			TreeSet<Integer> allCD = new TreeSet<Integer>();
			for(int i=0; i<total; i++){
				int cd = Integer.parseInt(br.readLine());
				allCD.add(cd);
			}
			if(total != 0)
			System.out.println(total  - allCD.size());
		}
		//long e = System.currentTimeMillis();
		//System.out.println("Time " + (e-s));
	}
}
