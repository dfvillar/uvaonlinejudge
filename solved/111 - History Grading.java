import java.io.*;
import java.util.*;

/**
 * 111 - History Grading
 */ 

public class Main{
	public static void main(String... args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = null;
		String line = null;
		int[] order = null;
		int[] a = null;
		boolean flag = true;
		int ln = 0;
		while((line = br.readLine()) != null){
			if(flag){
				ln = Integer.parseInt(line);
				order = new int[ln];
				a = new int[ln];
				flag = false;
				String lineOrder = br.readLine();
				sc = new Scanner(lineOrder);
				for(int i=0; i<ln; i++){
					int t = sc.nextInt();
					order[i] = t ;
					//System.out.print("[" + t + ", " + order[t] + "] ");
				}
				//System.out.println("");				
				continue;				
			}
			//System.out.println("");
			sc = new Scanner(line);
			for(int i=0; i<ln; i++){
				a[order[i]-1] = sc.nextInt();
				//System.out.print(a[order[i]-1] + " ");
			}
			//System.out.println("-");
			System.out.println(lis(a));
		}
		
		//System.out.println("-----------");
		//int[] b = {2, 3, 1, 4};
		//int[] b = {2, 10, 1, 3, 8, 4, 9, 5, 7, 6};
		//System.out.println(lis(b));
		
	}
	public static int lis(int[] a){
		int ln = a.length;
		int[] lis = new int[ln];

		for(int k=0; k<ln; k++)lis[k]=1;

		for(int i=1; i<ln; i++){
			int j=0;
			while( j < i){
				if(a[j] < a[i])
					lis[i] = Math.max((lis[j] + 1), lis[i]);
				j++;
			}
		}
		int max = lis[0];
		for(int l=0; l<ln; l++){
			max = Math.max(max, lis[l]);
		}	
		return max;
	}


}
