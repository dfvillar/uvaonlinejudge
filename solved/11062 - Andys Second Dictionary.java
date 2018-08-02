import java.util.*;

/*
 *11062 - Andy's Second Dictionary
 * 
 */

class Main{

	public static void main(String... args){
		Scanner sc = new Scanner(System.in); 
		String str = "";
		TreeSet<Word> treeWords = new TreeSet<Word>();
		StringBuilder sb = new StringBuilder();

		while(sc.hasNext()){
			
			str = sc.next();				
			str = str.replaceAll("[^a-zA-Z-]", " ");

			if(str.endsWith("-")){
				str = str.replace("-", "");
				sb.append(str);
			}else{
				
				sb.append(str);
				sb.append(" ");
			}
		}
		Scanner sctwo = new Scanner(sb.toString());

		while(sctwo.hasNext()){
			Word word = new Word();
			//System.out.println(sctwo.next());
			word.setValue(sctwo.next());
			treeWords.add(word);
		}	

		for(Word w : treeWords){
			System.out.println(w.getValue().toLowerCase());
		}
	}

	private static class Word implements Comparable{
		private String value;

		public String getValue(){
			return this.value;
		}

		public void setValue(String value){
			this.value = value;
		}

		@Override
		public int compareTo(Object obj){
			Word w = (Word) obj;
			return this.value.compareToIgnoreCase(w.getValue());
		}
	}
}
