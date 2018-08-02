import java.util.*;

/*
 *
 * 10815 Andy’s First Dictionary
 */

class Main{

	public static void main(String... args){
		Scanner sc = new Scanner(System.in); 
		String str = "";
		TreeSet<Word> treeWords = new TreeSet<Word>();

		while(sc.hasNext()){
			
			str = sc.nextLine();				
			str = str.replaceAll("[^a-zA-Z]", " ");

			Scanner sctwo = new Scanner(str);

			while(sctwo.hasNext()){
				Word word = new Word();
				//System.out.println(sctwo.next());
				word.setValue(sctwo.next());
				treeWords.add(word);
			}		
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
