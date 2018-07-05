import java.util.*;

/**
 * 10063 - Knuth's Permutation
 */ 
public class Main{

	public static void main(String... args){
		Scanner sc = new Scanner(System.in);
		String str = "";

		while(sc.hasNext()){
			str = sc.nextLine();
			ArrayList<String> perms = permute(str);
			for(int i=0; i<perms.size(); i++){				
				System.out.println(perms.get(i));				
			}
			if(sc.hasNext())System.out.println();
		}
		
	}

	public static ArrayList<String> permute(String str){
		ArrayList<String> perm = new ArrayList<String>();
		int ln = str.length();
		if(ln == 0){
			perm.add("");
			return perm;
		}
		String first = str.substring(ln-1);
		String remainder = str.substring(0, ln-1);
		ArrayList<String> words = permute(remainder);

		for(String word : words){
			for(int i=0; i<=word.length(); i++){
				String w = swap(i, first, word);
				perm.add(w);
			}
		}
		return perm;
	}

	public static String swap(int i, String c, String word){
		String init = word.substring(0, i);
		String last = word.substring(i);
		return  init + c + last;
	}

}
