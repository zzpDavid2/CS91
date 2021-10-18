import java.util.*;
import java.io.*;

public class Crossings {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(new File("crossings.in"));
    int n=in.nextInt();
    cow[] cows = new cow[n];
    
	for(int i=0; i<n; i++) {
		cows[i] = new cow(in);
	}
	
	in.close();

	Arrays.sort(cows);
	int[] maxBs = new int[n];
	maxBs[0] = cows[0].end;
	
	for(int i=0; i<n; i++) {
		maxBs[i] = Math.max(maxBs[i-i],cows[i].end);
	}
	
	int[] minBs = new int[n];
	minBs[n-1] = cows[n-1].end;
	
	for(int i = n-2; i>=0; i--) {
		minBs[i] = Math.min(minBs[i+1], cows[i].end);
	}
	
    int result = 0;
    
    if(cows[0].end < minBs[1]) {
    	result ++;
    }
    if(cows[n-1].end > maxBs[n-2]) result ++;
    
    for(int i=1; i<n-1; i++) {
    	if(maxBs[i-1] < cows[i].end && cows[i].end < minBs[i+1]) {
    		result++;
    	}
    }
    
    PrintWriter out = new PrintWriter(new File("crossings.out"));
    System.out.println(result);
    out.println(result);
    out.close();
  }
  
  static class cow implements Comparable<cow>{
	  int start;
	  int end;
	  
	  public cow(Scanner in) {
		  start = in.nextInt();
		  end = in.nextInt();
	  }
	  
	  public int compareTo(cow other) {
		  return this.start - other.start;
	  }
  }
}