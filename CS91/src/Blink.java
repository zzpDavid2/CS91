// blink
// http://www.usaco.org/index.php?page=viewproblem2&cpid=279
import java.util.*;
import java.io.*;

public class Blink {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(new File("blink.in"));
    int n = in.nextInt();
    long b = in.nextLong();
    
    int[] bulbs = new int [n];
    
    for (int i=0; i < n; i++) {
    	bulbs[i] = in.nextInt();
    	
    }
    in.close();
    
    long t=0;
    
    Map<String, Long> prevStates = new HashMap<>();
    // the state is converted into a string to store as key
    
    while (t < b) {
    	String state = Arrays.toString(bulbs);
    	
    	if(prevStates.containsKey(state)) {
    		long len = t - prevStates.get(state);
    		long remaining = b-t;
    		long fullCycles = remaining / len;
    		
    		t += fullCycles * len;
    		
    		prevStates.clear();
    	}else {
    		prevStates.put(state, t);
    		
    		step(bulbs);
    		t++;
    	}
    }
    
    PrintWriter out = new PrintWriter(new File("blink.out"));
    for (int i =0; i<n; i++) {
    	
    	int result =  bulbs[i];
    	System.out.println(result);
    	out.println(result);
    	
    }
    out.close();
  }
  
  static void step(int[] bulbs) {
	  int lastBulb = bulbs[bulbs.length-1];
	  
	  for (int i=bulbs.length -1; i > 0 ; i--) {
		  if (bulbs[i-1] == 1) bulbs[i] = bulbs[i] == 1 ? 0 : 1;
	  }
	  

	  if (lastBulb == 1) bulbs[0] = 1 - bulbs[0];
	  
  }
}