import java.util.*;



class CollectionsIterate{
	
	public static void main(String... args){
		
		//Array
		int[] arr = {3, 7, 2, 9, 1};
			
		
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");			
		}
		System.out.println("");
		
		
		//ArrayList
		List<Character> listCh = new ArrayList<Character>();
		
		listCh.add('a');
		listCh.add('b');
		listCh.add('c');
		listCh.add('d');
		
		for(int i=0; i<listCh.size(); i++){
			System.out.print(listCh.get(i) + " ");
			
		}
		System.out.println(" ");	
		
		//LinkedList
		LinkedList<String> lk = new LinkedList<String>();
		lk.add("a");
		lk.add("b");
		lk.add("c");
		lk.add("d");
		
		Iterator it = lk.iterator();
		while(it.hasNext()){
			System.out.print(it.next() + " ");
		}
		System.out.println(" ");
		
		for(int i = 0; i < lk.size(); i++) {
			System.out.print(lk.get(i) + " ");
		}
		System.out.println(" ");
		
		//Deque
		
		/**
		Queue Method	Equivalent Deque Method
		add(e)			addLast(e)
		offer(e)		offerLast(e)
		remove()		removeFirst()
		poll()			pollFirst() Retrieves and removes the first element 
		element()		getFirst()
		peek()			peekFirst()
		
		Stack Method	Equivalent Deque Method
		push(e)			addFirst(e)
		pop()			removeFirst()
		peek()			peekFirst()
		*/ 
		
		Deque<String> queue = new ArrayDeque<String>();
		queue.add("A");
        queue.add("B");
        queue.add("C");
        queue.add("D");
        Iterator itr = queue.iterator();
        while (itr.hasNext()){
			System.out.print(itr.next() + " ");
        }
        
        
        

		
		
		
		
	}
	
}
