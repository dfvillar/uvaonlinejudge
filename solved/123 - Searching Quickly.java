import java.io.*;
import java.util.*;

/*
 * 123 Searching Quickly
 */ 

public class Main{
	public static void main(String... args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		LinkedList<ArrayList> listTitles = new LinkedList<ArrayList>();
		ArrayList<String> ignoreWords = new ArrayList<String>();
		ArrayList<Word> allWords = new ArrayList<Word>();

		while(!(line = br.readLine()).equals("::")){
			line = line.toUpperCase();
			ignoreWords.add(line);
		}
		int c = 0;
		while((line = br.readLine()) != null){
			String[] title = line.split(" ");
			ArrayList<Word> words = new ArrayList<Word>();

			for(int i=0; i<title.length; i++){
				Word w1 = new Word(c, title[i].toLowerCase());
				words.add(w1);

				Word w2 = new Word(c, title[i].toUpperCase());
				allWords.add(w2);
				c++;
			}
			listTitles.add(words);
			
		}
		allWords = format(allWords, ignoreWords);
		
		Collections.sort(allWords, new WordComparator<Word>());
		boolean flag = false;
		String s  ="";		

		for(Word w : allWords){
			for(ArrayList<Word> alist : listTitles){
				s = "";
				flag = false;
				int n = alist.size();
				for(int i=0; i<n; i++){
					String t = alist.get(i).getValue();
					if( w.getPos() == alist.get(i).getPos() && w.getValue().equalsIgnoreCase(t)){
						t = w.getValue();
						flag  =true;
					}
					String space = " ";
					if(i == n-1) space = "";
					s = s + t + space;				
				}
				if(flag)System.out.println(s);				
			}
			
				
		}		
	}	

	private static ArrayList<Word> format(ArrayList<Word> allWords, ArrayList<String> ignoreWords){
		ArrayList<Word> tmp_allWords = new ArrayList<Word>();
		for(int i=0; i<allWords.size(); i++){
			//System.out.println(allWords.get(i).getValue());
			if(!ignoreWords.contains(allWords.get(i).getValue()))
				tmp_allWords.add(allWords.get(i));				
		}
		return tmp_allWords;
	}

	private static void print(String... words){
		int n = words.length;
		for(int i =0; i<n; i++){
			System.out.print("[" + words[i] + "] ");
		}
	}

	private static class Word{
		int pos;
		String value;

		Word(int pos, String value){
			this.pos = pos;
			this.value = value;
		}
		String getValue(){
			return value;
		}
		int getPos(){
			return pos;
		}
	}

	private static class WordComparator<T> implements Comparator<Word>{

		@Override
		public int compare(Word w1, Word w2){
			return w1.getValue().compareTo(w2.getValue());
		}

	}
}
