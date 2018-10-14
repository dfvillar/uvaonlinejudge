import java.io.*;
import java.util.*;

/**
 * 108 - Maximun Sum
 */

public class Main{
	public static void main(String... args){
		Scanner sc = new Scanner(System.in);

		while(sc.hasNext()){
			int n = sc.nextInt();
			int[][] matrix = new int[n][n];
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){					
					matrix[i][j] = sc.nextInt();				
				}
			}
			System.out.println(maxsubarr(matrix));
		}
		/*
		 int matrix[][] = {
			 {1, 2, -1, -4, -20}, 
                            {-8, -3, 4, 2, 1}, 
                            {3, 8, 10, 1, 3}, 
                            {-4, -1, 1, 7, -6} };
		System.out.println(maxsubarr(matrix));
		* */
	}
	

	public static int maxsubarr(int[][] matrix){
		int n = matrix[0].length;
		int m = matrix.length;
		

		int currentSum = 0;
		int maxsum = -1000; //Fixed to handle negative numbers in comparision
		//EXTRA Position
		int maxleft = 0;
		int maxright = 0;
		int maxup = 0;
		int maxdown = 0;

		int[] tmparr = new int[m];

		for(int i=0; i<n; i++){
			for(int j=i; j<n; j++){
				for(int k=0; k<m; k++){
					tmparr[k] += matrix[k][j];
				}
				currentSum = kadane(tmparr);
				
				if(currentSum > maxsum){
					maxsum = currentSum;
					//EXTRA Position
					//maxleft = i;
					//maxright = j;
				}				
			}
			tmparr = new int[m];
		}		
		return maxsum;		
	}

	public static int kadane(int[] a){
		int max_end_here = a[0];
		int max_so_far = a[0];

		//EXTRA Position
		int start = 0;
		int end = 0;

		for(int i=1; i<a.length; i++){
			max_end_here = Math.max(a[i], max_end_here + a[i]);
			max_so_far = Math.max(max_so_far, max_end_here);

			//EXTRA Position
			if(max_end_here >= max_so_far){
				if(start == 0)
					start = i;				
				end = i;
			}			
		}
		return max_so_far;
	}
}
