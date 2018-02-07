import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main{
	public static void main(String... args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		final String keyboard = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";
		char[] keys = keyboard.toCharArray();
		int[] ascii = new int[256];

		for(int i=1; i<keys.length; i++){
			ascii[(int)keys[i]] = (int)keys[i-1];
		}
		
		String line = null;
		while( (line = br.readLine()) != null){

			char[] letters = line.toCharArray();

			for(int j=0; j<letters.length; j++){
				if(letters[j] != ' ')
					System.out.print((char)ascii[letters[j]]);
				else
					System.out.print(' ');
			}
			System.out.println("");	
		}
			
	}
}

