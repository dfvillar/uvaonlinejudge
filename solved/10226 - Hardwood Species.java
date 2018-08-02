import java.io.*;
import java.util.*;

/*
 * 10226 - Hardwood Species
 */

public class Main{
	public static void main(String... args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int c = Integer.parseInt(br.readLine());
		br.readLine();
		while(c-- > 0){
			
			double total = 0;
			TreeMap<String, Double> listTree = new TreeMap<String, Double>();
			String tree = "";
			while((tree = br.readLine()) != null ){
				//System.out.println(tree +"|");
				if( tree.length() == 0) break;
				total++;
				Double q = listTree.get(tree) == null ? 1 : listTree.get(tree)  + 1;
				listTree.put(tree, q);
			}
			//System.out.println(listTree +"|");
			for(Map.Entry<String, Double> entry: listTree.entrySet()){
				System.out.print(entry.getKey());
				double t =  entry.getValue();
				System.out.print(" ");
				double percent = (t / total) * 100;
				System.out.println(String.format("%.4f", percent));
			}
			if(c > 0)
			System.out.println();
		}		
	}
}
