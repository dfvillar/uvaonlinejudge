import java.util.PriorityQueue;
import java.util.Queue;
import java.io.*;

/**
 * 10954 Add All
 * */

public class Main{
	public static void main(String... args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = 0;
		while((n = Integer.valueOf(br.readLine())) != 0){
			Queue<Integer> priorityInt = new PriorityQueue<Integer>();
			String[] integers = br.readLine().split(" ");

			for(int i=0; i<n; i++){
				priorityInt.add(Integer.valueOf(integers[i]));
			}		
			int cost = 0;
			while(priorityInt.size() > 1){
				int a = priorityInt.poll();
				int b = priorityInt.poll();
				cost += a+b;
				priorityInt.add(a+b);
			}
			System.out.println(cost);
		}
	}
}
