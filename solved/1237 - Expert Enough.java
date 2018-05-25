import java.util.*;
import java.io.*;

/*
 *  1237 - Expert Enough?
 */
public class Main{

	private static String UNDETERMINED = "UNDETERMINED";

	public static void main(String... args){
		Scanner sc = new Scanner(System.in);

		int t = Integer.parseInt(sc.next());

		for(int i=0; i<t; i++){
			List<Maker> db = new ArrayList<Maker>();
			int d = Integer.parseInt(sc.next());
			while(d-- > 0){
				String m = sc.next();
				int l = Integer.parseInt(sc.next());
				int h = Integer.parseInt(sc.next());
				db.add(new Maker(m, l, h));
			}
			int q = Integer.parseInt(sc.next());
			while(q-- > 0){				
				int p = Integer.parseInt(sc.next());
				String finded = "";
				int count = 0;
				for(Maker m : db)
					if(m.query(p)){
						finded = m.getMaker();
						count++;
				}
				if(count > 1 || finded.equals(""))
					finded = UNDETERMINED;

				System.out.println(finded);					
			}
			if(i == t-1)
				System.out.print("");
			else
				System.out.println();
		}
	}

	private static class Maker{
		String maker;
		int lo;
		int hi;

		public Maker(String m, int l, int h){
			maker = m;
			lo = l;
			hi = h;
		}

		public boolean query(int p){

			if(p >= lo && p <= hi)
				return true;
			else
				return false;
		}
		public String getMaker(){
			return maker;
		}

	}
}
