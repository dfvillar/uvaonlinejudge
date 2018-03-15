
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

/**
 11034 - Ferry Loading VI
 */

public class Main{
	
	final static int LEFT = 0;
	final static int RIGHT = 1;	
	
	public static void main(String... args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		
		while(cases-- > 0){
			String[] control = br.readLine().split(" ");
			double l = Double.parseDouble(control[0]);
			int m = Integer.parseInt(control[1]);
			
			Deque<Car>[] line_cars = new ArrayDeque[2];
			int[] uploadedTime = new int[m];
			
			line_cars[0] = new ArrayDeque<Car>();
			line_cars[1] = new ArrayDeque<Car>();
			
			for(int i=0; i< m; i++ ){
				String[] carDetail = br.readLine().split(" ");
				Car car = new Car(i, Double.parseDouble(carDetail[0]), carDetail[1]);
				
				if(car.side.equals("left")) {
					line_cars[LEFT].addLast(car);				
				}else {
					line_cars[RIGHT].addLast(car);
				}							
			}
			
			int times = 0;
			int index = LEFT;
			
			while(! (line_cars[LEFT].isEmpty() && line_cars[RIGHT].isEmpty()) ) {
				
				double one = 100.0;
				double cm_total = 0;
			
				while(((cm_total/one) < l) && !line_cars[index].isEmpty()){
					cm_total += line_cars[index].peek().cm;
					if((cm_total/one) < l)
						line_cars[index].pop();
				}
				times += 1;
				index ^= 1;				
			}
			System.out.println(times);		
		}	
	}

	
	private static class Car{
		int position;
		double cm;
		String side;

		Car(int position, double cm, String side){
			this.position = position;
			this.cm = cm;
			this.side = side;
		}
	}
}
