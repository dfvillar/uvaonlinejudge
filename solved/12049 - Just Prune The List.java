import java.util.*;
import java.io.*;

/*
 * 12049 - Just Prune The List
 *
 */

public class Main{
	public static void main(String... args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		while(c-- > 0){
			HashMap<Integer, Integer> n = new HashMap<Integer, Integer>();
			HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
			TreeSet<Integer> t = new TreeSet<Integer>();
			String line = br.readLine();
			String[] l = line.split(" ");
			int nth = Integer.parseInt(l[0]);
			int mth = Integer.parseInt(l[1]);

			String nsrt = br.readLine();
			String msrt = br.readLine();

			String[] narr = nsrt.split(" ");
			String[] marr = msrt.split(" ");

			for(int i=0; i<nth; i++){
				int np = Integer.parseInt(narr[i]);
				int tmp = n.get(np) != null ? n.get(np) : 0;
				tmp++;
				n.put(np, tmp);
				t.add(np);
			}
			//System.out.println(n);
			for(int i=0; i<mth; i++){
				int mp = Integer.parseInt(marr[i]);
				int tmp = m.get(mp) != null ? m.get(mp) : 0;
				tmp++;
				m.put(mp, tmp);
				t.add(mp);
			}
			//System.out.println(m);
			//System.out.println(t);
			int sum = 0;
			for(int k : t){
				int nt = n.get(k) != null ? n.get(k) : 0;
				int mt = m.get(k) != null ? m.get(k) : 0;
				//System.out.println(k + " " + nt + " " +mt);
				if(nt != mt){
					sum += Math.abs(nt - mt);
				}
			}
			System.out.println(sum);
		}
	}
}
