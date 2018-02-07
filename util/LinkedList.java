import static java.lang.System.out;

public class LinkedList<E>{
	
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
