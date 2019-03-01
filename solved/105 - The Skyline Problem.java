import java.io.*;
import java.util.*;

/*
 *
 * 105 - The Skyline Problem
 */ 

public class Main{
  public static void main(String... args){
	  Scanner sc = new Scanner(System.in);
	  int[] coordinates = new int[10001];
	  int h = 0;
	  while(sc.hasNext()){
		 int l = sc.nextInt();
		 h = sc.nextInt();
		 int r = sc.nextInt();

		  for(int i=l; i<r; i++){
			  if(h>coordinates[i]){			
				coordinates[i] = h;
			  }
			  //System.out.print("[" + i + " -> " + coordinates[i] + "] ");		
		  }
		  //System.out.println("");		
	  }
	  

	  int currentHigh = 0;
	  boolean flag = false;
	  for(int i=0; i<coordinates.length; i++){
		  if(coordinates[i] != currentHigh){
			  if(flag){System.out.print(" ");}
			  System.out.print( i + " " + coordinates[i]);
			  currentHigh = coordinates[i];
			  flag = true;				
		  }
	  }
	  System.out.println("");	  
  }	
}
