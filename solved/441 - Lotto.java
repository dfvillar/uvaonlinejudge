import java.io.*;
import java.util.*;

/*
 * 441 - Lotto
 */

public class Main{
	public static void main(String... args){
		Scanner sc = new Scanner(System.in);
		int ln = 0;
		boolean flag = false; // println control
		
		while((ln = sc.nextInt()) != 0){

			if(flag)System.out.println("");
			
			int[] lotto = new int[ln];
			for(int i=0; i<ln; i++){
				lotto[i] = sc.nextInt();
			}
			function(lotto);
			flag = true;
			

		}
	}

	static void function(int[] p){
		int ln = p.length;
		for(int a=0; a<ln-5; a++)
			for(int b=a+1; b<ln-4; b++)
				for(int c=b+1; c<ln-3; c++)
					for(int d=c+1; d<ln-2; d++)
						for(int e=d+1; e<ln-1; e++)
							for(int f=e+1; f<ln; f++)
								System.out.println(p[a] + " " + p[b] + " " + p[c] + " " + p[d] + " " + p[e] + " " + p[f]);

	}
}
