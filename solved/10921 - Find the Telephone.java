import java.io.*;

/*
 *10921 - Find the Telephone
 */
public class Main{

	static int l = 'Z' + 1;
	static int[] phone = new int[l];
	static{
		phone['A']=2;
		phone['B']=2;
		phone['C']=2; 
		phone['D']=3;
		phone['E']=3;
		phone['F']=3; 
		phone['G']=4;
		phone['H']=4;
		phone['I']=4; 
		phone['J']=5;
		phone['K']=5;
		phone['L']=5; 
		phone['M']=6;
		phone['N']=6;
		phone['O']=6; 
		phone['P']=7;
		phone['Q']=7;
		phone['R']=7;
		phone['S']=7;
		phone['T']=8;
		phone['U']=8;
		phone['V']=8; 
		phone['W']=9;
		phone['X']=9;
		phone['Y']=9;
		phone['Z']=9;
	}
	
	public static void main(String... args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while((line=br.readLine()) != null){
			for(int i=0; i<line.length();i++){
				char c = line.charAt(i);
				if(c != '-' && c!= '1')
					System.out.print(phone[c]);
				else
					System.out.print(c);		
			}
			System.out.println("");
		}		
	}
}
