import java.io.*;
import java.util.*;

/*
 * 10074 - Take the Land
 */
 
public class Main{
	public static void main(String... args)throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);

		int m = 0;
		int n = 0;

		while( (m = sc.nextInt()) != 0 && (n = sc.nextInt())!= 0){

			int[][] a = new int[m][n];
			for(int i=0; i<m; i++){
				for(int j=0; j<n; j++){
					int t = sc.nextInt();				
					a[i][j] = 1 - t;	//Covert 0 to 1 and viceversa 				
				}
			}
			int[][] b = row_sum(a, m, n);
			//print(a, m, n);
			calculate_max(b, m, n);
		
		}		
	}

	private static int[][] row_sum(int[][] a, int m, int n){
		
		for(int i=1; i<m; i++){
			for(int j=0; j<n; j++){
				if(a[i][j] == 1)
					a[i][j] = a[i-1][j] + a[i][j];
			}
		}
		return a;
	}

	private static void calculate_max(int[][] a, int m, int n){

		int maxi = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = a[i][j];
                for (int k = j + 1; k < n && a[i][j] <= a[i][k]; k++ ){					
                    cnt += a[i][j];                    
				}				
                for ( int k = j - 1; k >= 0 && a[i][j] <= a[i][k]; k-- ){
                    cnt += a[i][j];                
				}				
                if ( cnt > maxi) maxi = cnt;
            }
        }
		System.out.println(maxi);
	}
	private static void print(int[][] b, int m, int n){
		
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				System.out.print(b[i][j] + " ");
			}
			System.out.println(" ");
		}
	}
}
