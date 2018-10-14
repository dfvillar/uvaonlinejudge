import java.util.*;
import java.io.*;

/*
 * 727 Equation
 */ 

public class Main{
	public static void main(String... args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		br.readLine();

		while(n-- > 0){
			String line = null;
			
			Deque<String> operator = new ArrayDeque<String>();
		
			while(  (line = br.readLine()) != null && !line.equals("") ){
				if(isNumber(line)){
					System.out.print(line);
				}else if(line.equals("(")){
					operator.addFirst(line);
				}else if(line.equals(")")){
					while(!operator.isEmpty()){
						if(operator.peekFirst().equals("(")){
							operator.removeFirst();
							break;
						}
						System.out.print(operator.removeFirst());			
					}
				} else {
					validate(line, operator);
				}
				
			}
			while(!operator.isEmpty()){
					System.out.print(operator.removeFirst());	
			}
			System.out.println("");

			if(n != 0)
			System.out.println("");
			//System.out.println("| " + operator);
		}			
	}

	private static void validate(String oper, Deque<String> operator){
		if(operator.isEmpty()){
			operator.addFirst(oper);
			return;
		}
		//System.out.print(" [" + oper + " " + getPriority(oper) + " " +operator.peek() + " "+ getPriority(operator.peek()) + "] ");

		if(getPriority(oper) > getPriority(operator.peekFirst())){
			operator.addFirst(oper);	
		}else {
			//System.out.print(" while "  + (getPriority(oper) <= getPriority(operator.peek())) );
			while(!operator.isEmpty() && getPriority(oper) <= getPriority(operator.peekFirst())){
				System.out.print(operator.removeFirst());				
			}
			operator.addFirst(oper);
		}
		//System.out.print("| " + operator);
	}

	private static int getPriority(String oper){
		int val = -1;

		switch(oper){
			case "*":
				val = 1;
				break;
			case "/":
				val = 1;
				break;
			case "+":
				val = 0;
				break;
			case "-":
				val = 0;
				break;
		}
		return val;
	}

	private static boolean isNumber(String str){
		if(str.matches("^[0-9]+$"))
			return true;
		else
			return false;
	}
}
