
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

/**
 10901 - Ferry Loading III
 */

public class Main{
	
	final static int LEFT = 0;
	final static int RIGHT = 1;	
	
	public static void main(String... args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cases = Integer.parseInt(br.readLine());
		
		while(cases-- > 0){
			String[] control = br.readLine().split(" ");
			int n = Integer.parseInt(control[0]);
			int t = Integer.parseInt(control[1]);
			int m = Integer.parseInt(control[2]);
			
			Deque<Car>[] line_cars = new ArrayDeque[2];
			int[] uploadedTime = new int[m];
			
			line_cars[0] = new ArrayDeque<Car>();
			line_cars[1] = new ArrayDeque<Car>();
			
			for(int i=0; i< m; i++ ){
				String[] carDetail = br.readLine().split(" ");
				Car car = new Car(i, Integer.valueOf(carDetail[0]), carDetail[1]);
				
				if(car.side.equals("left")) {
					line_cars[LEFT].addLast(car);				
				}else {
					line_cars[RIGHT].addLast(car);
				}							
			}
			
			int time = 0;
			int index = LEFT;
			
			while(! (line_cars[LEFT].isEmpty() && line_cars[RIGHT].isEmpty()) ) {
				
				int earliest_car = Integer.MAX_VALUE;
				
				if(!line_cars[LEFT].isEmpty())
					earliest_car = line_cars[LEFT].peek().time;
				if(!line_cars[RIGHT].isEmpty())
					earliest_car = Math.min(line_cars[RIGHT].peek().time, earliest_car);
				
				time = Math.max(earliest_car, time);
				
				int car_count = 0;
				while(!line_cars[index].isEmpty()
						&& car_count < n
						&& line_cars[index].peek().time <= time) {
					
					uploadedTime[line_cars[index].peek().position] = time + t;
					line_cars[index].pop();
					++car_count;					
				}
				time += t;
				index ^= 1;				
			}
			for(int j=0; j<m; j++) {
				System.out.println(uploadedTime[j]);				
			}
			System.out.println();			
		}	
	}

	
	private static class Car{
		int position;
		int time;
		String side;

		Car(int position, int time, String side){
			this.position = position;
			this.time = time;
			this.side = side;
		}
	}
}
