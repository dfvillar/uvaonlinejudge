import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.ListIterator;
import java.util.*;
/*
 *11988 - Broken Keyboard (a.k.a. Beiju Text)
 */
public class Main{

	public static void main(String... args)throws IOException{
		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
					
		while( (line = br.readLine()) != null ){
			process(line);
			System.out.println();
		}
		//test();
		long end = System.currentTimeMillis();
		//System.out.println("time: " + (end - start));
	}

	private static void process(String text){
		PrintWriter pw = new PrintWriter(System.out);
		char[] charr = text.toCharArray();
		int ln = charr.length;
		//int ln = text.length();
		//LinkedList<Character> textLinked = new LinkedList<Character>();
		//ListIterator it = textLinked.listIterator();
		StringBuilder sb = new StringBuilder();
		LinkedList<StringBuilder> textLinked = new LinkedList<StringBuilder>();
		boolean flag = false;
		int j = 0;
		for(int i = 0; i<ln; i++){
			char ch = charr[i];

			if('[' == ch){
				//j=0;
				//it = textLinked.listIterator(0);
				if(flag)
					textLinked.addFirst(sb);
				else
					textLinked.addLast(sb);
				sb = new StringBuilder();
				flag = true;				
			}else if (']' == ch){
				if(flag)
					textLinked.addFirst(sb);
				else
					textLinked.addLast(sb);			
				sb = new StringBuilder();
				flag = false;
			}else{
				sb.append(ch);
			}				
		}
		if(flag){
			textLinked.addFirst(sb);
			//it.add(ch);
			//textLinked.add(j, ch);
			//j++;				
		}else{
			textLinked.add(sb);	
		}		
		StringBuilder sb_out = new StringBuilder();
		for(StringBuilder sbIt : textLinked){
			sb_out.append(sbIt);
		}
		pw.print(sb_out);
		pw.flush();
	}
/*
	static void test(){
		MyLinkedList<Character> lkList = new MyLinkedList<Character>();

		lkList.add('a');
		lkList.add('b');
		lkList.add('c');
		lkList.print();
		
	}
	static class MyLinkedList<E>{
		transient Node<E> first;
		transient Node<E> last;

		void add(E item){
			insertLast(item);
		}
		private void insertLast(E item){
			final Node<E> l = last;
			final Node<E> newNode = new Node<>(item, null);
			last = newNode;
			if (l == null)
				first = newNode;
			else
				l.next = newNode;
		}
		private void insertNext(E item){
			final Node<E> l = last;
			final Node<E> newNode = new Node<>(item, null);
			last = newNode;
			if (l == null)
				first = newNode;
			else
				l.next = newNode;
		}

		void print(){
			for (Node<E> x = first; x != null; x = x.next) {
				System.out.println(x +" => "+ x.next + " " + x.item + ", ");
			}

		}
	}
	
	static class Node<E>{
		private E item;
		private Node<E> next;

		Node(E item, Node<E> next){
			this.item = item;
			this.next = next;
		}
	}	
*/
}


