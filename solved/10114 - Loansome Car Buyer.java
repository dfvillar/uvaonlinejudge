import java.io.*;
import java.util.*;

/*
 * 10114 - Loansome Car Buyer
 */

public class Main{
	public static void main(String... args)throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		while(true){
		String data = sc.next();
			if(data.contains("-"))break;

			int months = Integer.parseInt(data);
			double dowPayment = Double.parseDouble(sc.next());
			double loan = Double.parseDouble(sc.next());
			int depreciation = Integer.parseInt(sc.next());
			double worth = loan;
			double payment= 0;
			
			String depreciationLine = "";
			double[] percentage = new double[months+1];
			for(int i=0; i<percentage.length; i++)percentage[i]=-1;

			for(int i=0; i<depreciation; i++){
				String month = sc.next();
				String value = sc.next();			
				percentage[Integer.parseInt(month)] = Double.parseDouble(value);
			}
			percentage = depreciation_calc(percentage);
			payment = loan / months;
			worth = worth + dowPayment;
			
			int count = 0;
			for(int i=0; i<percentage.length; i++){
				worth = worth - (worth*percentage[i]);
				if(i>0)loan -= payment;
				//System.out.println(count + " " + loan + " " + worth + " " + percentage[i]);
				if(loan < worth)break;
				count++;
			}
			if(count == 1)
				System.out.println(count + " month");
			else
				System.out.println(count + " months");
		}

	}

	private static double[] depreciation_calc(double[] percentage){

		double t = 0.0;
		for(int i=0; i<percentage.length; i++){
			if(percentage[i] != -1)
				t = percentage[i];
			else
				percentage[i] = t;				
		}
		return percentage;
	}
}
