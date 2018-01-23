import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Deque;
import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;
/*
 * 1062 - Containers
 */
public class Main{

	public static void main(String... args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		PrintWriter pw = new PrintWriter(System.out);			
		int count = 1;

		while( !(line = br.readLine()).equals("end") ){
			char[] chs = line.toCharArray();
			int l = chs.length;
			int sum = 0;
			List<ArrayDeque<Character>> containers = new ArrayList<ArrayDeque<Character>>();
			
			for(int i=0; i<l; i++){
				sum += stack(containers, chs[i]);
			}
			pw.println("Case "+ count +": " + sum);
			count++;
		}
		pw.flush();
	}

	private static int stack(List<ArrayDeque<Character>> containers, char c){
		int ln = containers.size();
		
		for(int i=0; i<ln; i++){
			Character ch = containers.get(i).peek();
			if(ch != null && c <= ch){
				containers.get(i).addFirst(c);
				return 0;
			}			
		}
		ArrayDeque<Character> deque = new ArrayDeque<Character>();
		deque.addFirst(c);

		containers.add(deque);	

		return 1;
	}
}


