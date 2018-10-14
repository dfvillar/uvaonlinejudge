import java.io.*;
import java.util.*;

/*
 * 10098 Generating Fast, Sorted Permutation
 */

public class Main{

	public static void main(String... args)throws IOException{
		//long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		OutputStream out = new BufferedOutputStream(System.out);
		int c = Integer.parseInt(br.readLine());
		String newLine = "\n";
		
		while(c-- > 0){
			String str = br.readLine();
			int[] ascii = new int[256];
			char[] charray = str.toCharArray();
			int sum = 0;
			TreeSet<String> set = new TreeSet<String>();
			for(int i=0; i<charray.length; i++){ascii[(int)charray[i]] = 1;}			
			for(int j=0; j<ascii.length; j++)sum += ascii[j];

			if(sum == 1){
				out.write(str.getBytes());
				out.write(newLine.getBytes());
				out.write(newLine.getBytes());
				continue;
			}
			
			Arrays.sort(charray);
			str = new String(charray);
			perm1(str, set);

			for(String s : set){
				out.write(s.getBytes());
				out.write("\n".getBytes());
			}
			
			if(c != 0)
			out.write(newLine.getBytes());						
		}
		//out.write(newLine.getBytes());
		out.flush();
		//long end = System.currentTimeMillis();
		//System.out.println(((end-start)/1000));
	}




	private  static void perm1(String s, TreeSet<String> set)throws IOException {
		perm1("", s, set);
	}

	private static void perm1(String prefix, String s, TreeSet<String> set) throws IOException{
		int n = s.length();
		if (n == 0) {
			set.add(prefix);
			//System.out.println(prefix);
		}else {
			for (int i = 0; i < n; i++){
				//System.out.println(i + "  [" + prefix+ " " +s.charAt(i) +"][" +s.substring(0, i) +" "+ s.substring(i+1, n)+"]");
				if((String.valueOf(s.charAt(i))).equals(s.substring(0, i))){continue;} //without repetitions
				perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n), set);
			}
		}

	}
}
