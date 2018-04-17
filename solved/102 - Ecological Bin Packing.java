import java.io.*;

/**
102 - Ecological Bin Packing
*/
public class Main{
	public static void main(String... args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = null;

		while( (line = br.readLine()) != null){

			String[] bottles_str = line.split(" ");
			int n = bottles_str.length;
			int[] bottles = new int[n];
			for(int i=0; i<n; i++){
				bottles[i] = Integer.parseInt(bottles_str[i]);
			}		
			//Get sum by bottle
			int cntrla = 3;
			int sum_tmp = 0;
			int[] sums = new int[9];
			for(int i=0; i<n; i++){	
				sum_tmp = sum_tmp + bottles[i];			
				if(i == (cntrla-1)){
					sums[cntrla-1] = sum_tmp;
					sum_tmp = 0;
					cntrla = (cntrla + 3);				
				}		
			}

			//Get value by color
			int cntrlb = 3;
			int[] movs = new int[n];
			for(int i=0; i<n; i++){	
				movs[i] = sums[cntrlb-1] - bottles[i];			
				if(i == (cntrlb-1)){
					cntrlb = (cntrlb + 3);				
				}		
			}


			int[][] config ={ 
				{0, 4, 8}, //0
				{0, 5, 7}, //1
				{1, 3, 8}, //2
				{1, 5, 6}, //3
				{2, 3, 7}, //4
				{2, 4, 6}  //5
			};
			
			Bottle result = null;
		
			for(int i=0, j=1; i<3; i++){
				int a = movs[config[i*2][0]] + movs[config[i*2][1]] + movs[config[i*2][2]];
				int b = movs[config[j][0]] +  movs[config[j][1]] +  movs[config[j][2]];

				//System.out.println(movs[config[i*2][0]] + "\t" + movs[config[i*2][1]] + "\t" + movs[config[i*2][2]] + " = " + a);
				//System.out.println(movs[config[j][0]] + "\t" + movs[config[j][1]] + "\t" + movs[config[j][2]] + " = " + b);

				Bottle b1 = new Bottle(config[i*2][0], config[i*2][1], config[i*2][2], a);
				Bottle b2 = new Bottle(config[j][0], config[j][1], config[j][2], b);
							
				Bottle tmp = null;

				if ( b1.getSum() ==  b2.getSum() &&  b1.getBottles().compareTo(b2.getBottles()) < 0)
					tmp = b1;
				else if (b1.getSum() ==  b2.getSum() &&  b1.getBottles().compareTo(b2.getBottles()) > 0)
					tmp = b2;
				else if (b1.getSum() <  b2.getSum())
					tmp = b1;
				else if (b1.getSum() >  b2.getSum())
					tmp = b2;

				//System.out.println(tmp.getBottles() + tmp.getSum());

				if(result != null){
					if ( tmp.getSum() ==  result.getSum() &&  tmp.getBottles().compareTo(result.getBottles()) < 0)
						result = tmp;
					else if (tmp.getSum() ==  result.getSum() &&  tmp.getBottles().compareTo(result.getBottles()) > 0)
						result = result;
					else if (tmp.getSum() <  result.getSum())
						result = tmp;
					else if (tmp.getSum() >  result.getSum())
						result = result;
				}else{
					result = tmp;
				}
									
				j = j + 2;
			}

			System.out.println(result.getBottles() + " " + result.getSum());
		}
	}

	private static class Bottle{

		private String bottles;
		private int sum;

		private String[] color = {
			"B","G","C",
			"B","G","C",
			"B","G","C"
			};

		Bottle(int a, int b, int c, int sum){
			bottles = color[a] + color[b] + color[c];
			this.sum = sum;
		}

		public String getBottles(){
			return bottles;
		}
		public int getSum(){
			return sum;
		}
	}	
}
