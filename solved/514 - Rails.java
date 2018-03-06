import java.io.*;
import static java.lang.System.out;


public class Main{
	public static void main(String... args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		while(true){
			int cases = Integer.valueOf(br.readLine());
			if(cases == 0)break;
			String line = "";
			while( !(line = br.readLine()).equals("0")){
				
				String[] couches = line.split(" ");
				boolean flag = true;
				MLinkedList<Integer> station = new MLinkedList<Integer>();
				MLinkedList<Integer> train = new MLinkedList<Integer>();

				for(int k=1; k<=cases;k++)
					train.addLast(k);
				
				for(int i=0; i<cases; i++){
					int current_couch = Integer.valueOf(couches[i]);

					//System.out.println("size " + train.getSize());
					while(train.getSize() > 0 && current_couch >= train.getFirst()  ){
						//System.out.println(current_couch + " " + train.getFirst());
						station.addFirst(train.removeFirst());						
					}	
					
					int to_dir_B = station.removeFirst();

					if(to_dir_B != current_couch){
						flag = false;
						break;
					}				
				}
				String res = flag ? "Yes" : "No";
				System.out.println(res);
			}
			System.out.println("");			
		}
	}
}



class MLinkedList<E>{
	
	private Node<E> first;
	private Node<E> last;
	private int size;

	void addFirst(E item){
		linkFirst(item);
	}

	void addLast(E item){
		linkLast(item);
	}

	E removeFirst(){
		Node<E> f = first;
		first = first.next;
		size--;
		return f.item;		
	}
	
	E removeLast(){
		Node<E> prev = last.prev;
		E item = last.item;
		last.item = null;
		last.prev = null;
		last = prev;
		if(prev == null)
			first = null;
		else
		prev.next = null;

		size--;
		return item	;
	}

	E getFirst(){
		return first.item;
	}

	E getLast(){
		return last.item;
	}

	int getSize(){
		return size;
	}
	


	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();

		for(Node<E> p = first; p != null; p = p.next)
			sb.append("[" + p.item + "] ");

		return sb.toString();
	}
	
	private void linkFirst(E item){
		Node<E> f = first;

		if(f == null){
			first = new Node<E>(null, item, null);
			last = first;
		}else{
			first = new Node<E>(null, item, f);
		}
		size++;
	}

	private void linkLast(E item){
		Node<E> l = last;

		if(l == null){
			last = new Node<E>(l, item, null);
			first = last;
		}else{
			last.next = new Node<E>(l, item, null);
			last = last.next;
		}
		size++;
	}

	private static class Node<E>{
		E item;
		Node<E> next;
		Node<E> prev;

		Node(Node<E> prev, E item, Node<E> next){
			this.item = item;
			this.next = next;
			this.prev = prev;
		}
	}
}
/***
 * 5 6 4 8 7 3 2 9 1 10              
			  <--- B                      <--- A
 step                       station
==========================================================
    1                                1 2 3 4 5 6 7 8 9 10
 // starting scenario
----------------------------------------------------------
    2                                6 7 8 9 10
                                5
                                4
                                3
                                2
                                1
 // moved 5 from A to station
----------------------------------------------------------
    3   5                            6 7 8 9 10
                                4
                                3
                                2
                                1
 // moved 1 from station to B
----------------------------------------------------------
    4   5 6                          7 8 9 10
                                4
                                3
                                2
                                1
 // moved 1 from A to B
----------------------------------------------------------
    5   5 6 4                        7 8 9 10
                                3
                                2
                                1
 // moved 1 from station to B
----------------------------------------------------------
    6   5 6 4                        9 10
                                8
                                7
                                3
                                2
                                1
 // moved 2 from A to station
----------------------------------------------------------
    7   5 6 4 8 7 3 2                9 10
                                1
 // moved 4 from station to B
----------------------------------------------------------
    8   5 6 4 8 7 3 2 9               10
                                1
 // moved 1 from A to B

.
.
.

the last 2 steps left as an exercise :)




3 1 4 2 YES
Max 3 > Curr 1 < Prev 3
Max 3 < Curr 4 > Prev 1
Max 4 > Curr 2 < Prev 4


3 1 2 4 NO
Max 3 > Curr 1 < Prev 3
Max 3 > Curr 2 > Prev 1
Max 3 < Curr 4 > Prev 1

*/
