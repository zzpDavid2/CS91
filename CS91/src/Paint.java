import java.util.*;
import java.io.*;

public class Paint {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(new File("paint.in"));
    int n = in.nextInt();
    int k = in.nextInt();
    
    TreeMap<Integer, Integer> relCoats = new TreeMap<>();
    // key: where coats of paint change (relative to IMMEDIATELY LEFT
    //       to IMMEDIATELY RIGHT)
    // value: how much coats are changing as we go left to right
    
    int x = 0;
    for (int i = 0; i < n; i++) {
        int steps = in.nextInt();
        boolean right = in.next().equals("R");
         
        int nextX = x + (right ? +1 : -1) * steps;
        // ternary operator: (bool ? true : false)
        
        int a = Math.min(x, nextX);
        int b = Math.max(x, nextX);
        
        Integer aVal = relCoats.get(a);
        if (aVal == null) aVal = 0;
        relCoats.put(a, aVal+1);
        
        Integer bVal = relCoats.get(b);
        if (bVal == null) bVal = 0;
        relCoats.put(b, bVal-1);
        
        x = nextX;
    }
    
    in.close();

    int result = 0;
    
    int prevX = Integer.MIN_VALUE;
    int coats = 0;
    
    for(int nextX : relCoats.keySet()) {
    	
    	if(coats >= k) {
    		result += nextX - prevX;
    	}
    	
    	coats += relCoats.get(nextX);
    	
    	prevX = nextX;
    }
    
    PrintWriter out = new PrintWriter(new File("paint.out"));
    System.out.println(result);
    out.println(result);
    out.close();
  }
}