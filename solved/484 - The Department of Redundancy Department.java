import java.util.*;

/*
 *484 - The Department of Redundancy Department
 */ 

public class Main{
	public static void main(String... args){
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, Integer> numbers = new HashMap<Integer, Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();

		while(sc.hasNext()){
			int i = sc.nextInt();
			if(numbers.get(i) == null){
				numbers.put(i, 1);
				list.add(i);
			}else{
				int v = numbers.get(i);
				v++;
				numbers.put(i, v);
			}		
		}
		Iterator it = list.iterator();
		while(it.hasNext()){
			int i = (int)it.next();
			System.out.println(i + " " + numbers.get(i));
		}

		
	}
}
