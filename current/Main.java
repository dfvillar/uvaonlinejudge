
import java.util.*;
import java.io.*;

/*
 *  483 - Word Scramble
 */
public class Main{
	public static void main(String... args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
				
		while( (line = br.readLine()) != null ){
			char[] chrs = line.toCharArray();
			int ln = chrs.length;
			Deque<Character> stack = new ArrayDeque<Character>();
			for(int i=0; i<ln; i++){
				if(chrs[i] != ' '){
					stack.addFirst(chrs[i]);
				}else{
					int size = stack.size();
					while(size-- > 0)
						System.out.print(stack.removeFirst());
					System.out.print(" ");	
				}										
			}
			int size = stack.size();
				while(size-- > 0)
					System.out.print(stack.removeFirst());	
			System.out.println();			
		}
		
	}	
}
