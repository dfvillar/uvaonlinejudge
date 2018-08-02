import java.io.*;
import java.util.*;

/*
 * 11286 - Conformity
 */

public class Main{
	public static void main(String... args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		TreeMap<String, Integer> popularity = null;		

		while( !(line = br.readLine()).equals("0")){
			popularity = new TreeMap<String, Integer>();
			int students = Integer.parseInt(line);
			int total = 0;
			
			for(int i=0; i<students; i++){
				line = br.readLine();
				String[] courses = line.split(" ");
				String key = sort(courses);
				int value = popularity.get(key) == null ? 1 : popularity.get(key) + 1;					
				popularity.put(key, value);
				
			}
			//System.out.println(popularity);

			int count = 0;
			int mayor = 0;
			boolean flag = true;
			int[] res = new int[1000];
			for(Map.Entry<String, Integer> map : popularity.entrySet()){
				int actual = map.getValue();
				res[actual]++;		
			}
			for(int h=1; h<1000; h++){
				if(h == 1){
					count = res[h];
					flag = true;
				}
				if(h > 1 && res[h]>0){
					mayor = res[h] * h;
					flag = false;
				}
			}
			if(flag)
				System.out.println(count);
			else
				System.out.println(mayor);
		}
	}

	private static String sort(String[] courses){		
		int n = courses.length;
		for(int i=0; i<n; i++){
			int min = i;
			for(int j=i+1; j<n; j++)
				if(Integer.parseInt(courses[min]) > Integer.parseInt(courses[j]))
					min = j;
				
				String tmp = courses[min];
				courses[min] = courses[i];
				courses[i] = tmp;			
		}
		StringBuilder sb = new StringBuilder();
		for(int l=0; l<n; l++){
			sb.append(courses[l]);
		}		
		return sb.toString();
	}


}
