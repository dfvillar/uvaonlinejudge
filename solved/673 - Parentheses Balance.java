import java.util.Deque;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;

/**
 *   673 - Parentheses Balance
 */
public class Main{
	public static void main(String... args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		
		while( n-- > 0 ){
			Deque<Character> deque = new ArrayDeque<Character>();
			String line = br.readLine();
			char[] parentheses = line.toCharArray();
			boolean flag = true;
			for(char c : parentheses){

				if(c == '(' || c == '[')
					deque.push(c);
				else if(c == ')' || c == ']'){
					Character ct = (Character)deque.poll();
					if(ct == null){
						flag = false;
						break;
					}
										
					if(ct == '(' && c == ']'){
						flag = false;
						break;
					}
					else if(ct == '[' && c == ')'){
						flag = false;
						break;
					}						
				}				
			}
			if(deque.size() > 0 ) flag = false;
			String res = flag ? "Yes" : "No";
			pw.println(res);
		}
		pw.flush();	
	}

}
