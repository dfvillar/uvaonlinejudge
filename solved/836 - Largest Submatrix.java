import java.io.*;
import java.util.*;

/*
 * 836 - Largest Submatrix
 */
 
public class Main{
	public static void main(String... args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int l = Integer.parseInt(br.readLine());
		ArrayList<String> lines = null;
		br.readLine();
		while(l-- > 0){
			lines = new ArrayList<String>();
			String line  = null;
			while((line = br.readLine()) != null && !line.equals("")){
				lines.add(line);			
			}
			if(lines.size() == 1){
				System.out.println(lines.get(0));
			}else{
				int[][] a = listToRectangule(lines);
				int[][] b = row_sum(a);
				calculate_max(b);
			}
			if(l != 0)
			System.out.println("");		
		}
		/*
		int[][] matrix = {{1, 2, -1, -4, -20},
							{-8, -3, 4, 2, 1},
							{3, 8, 10, 1, 3},
							{-4, -1, 1, 7, -6}};

		int[][] matrix = {{2,  1, -3, -4,  5},
						  {0,  6,  3,  4,  1},
						  {2, -2, -1,  4, -5},
						  {2, -2 ,-1,  4,  -5},
						  {-3, 3,  1,  0,  3}};
		max_sub_array(matrix);*/

	}

	public static int[][] listToRectangule(ArrayList<String> list){
		int columns = list.get(0).length();
		int rows = list.size();
		int[][] a = new int[rows][columns];

		for(int i=0; i<list.size(); i++){
			String line = list.get(i);
			for(int j=0; j < line.length(); j++){
				a[i][j] = Integer.parseInt(line.charAt(j) + "");
				//System.out.print(a[i][j] + " ");
			}
			//System.out.println(" ");
		}
		//System.out.println(" ");		
		return a;
	}

	private static int[][] row_sum(int[][] a){
		int n= a[0].length;
		int m = a.length;
		
		for(int i=1; i<m; i++){
			for(int j=0; j<n; j++){
				if(a[i][j] == 1)
					a[i][j] = a[i-1][j] + a[i][j];
			}
		}
		return a;
	}

	private static void calculate_max(int[][] a){
		int n= a[0].length;
		int m = a.length;

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
}
