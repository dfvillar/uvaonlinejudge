import java.io.*;

/*
 * 11340 - Newspaper
 */
public class Main{
	public static void main(String... args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1")); //HINT from https://www.redgreencode.com/solving-uva-11340-in-java/
		int tests = Integer.parseInt(br.readLine());


		PrintStream out = null;
		try {
			out = new PrintStream(System.out, true, "ISO-8859-1");
		} catch (UnsupportedEncodingException uee) {}
			

		while( tests-- > 0){
			int k = Integer.parseInt(br.readLine());
			double[] dictionary = new double[256];

			for(int i=0; i<256; i++)dictionary[i]=0;

			while(k-- > 0){
				String[] pair = br.readLine().split(" ");
				int index = (int) pair[0].charAt(0);				
				dictionary[index] = Double.parseDouble(pair[1])/100.0;
			}
			int m = Integer.parseInt(br.readLine());

			double total = 0;
			while(m-- > 0){
				String line = br.readLine();
				
				for(int j=0; j<line.length(); j++){
					total += dictionary[line.charAt(j)];
				}
			}
			out.println(String.format("%.2f", total) + "$");

		}

	}
}
