// "Learning By Example"
// http://www.usaco.org/index.php?page=viewproblem2&cpid=490

package homework;

import java.util.*;
import java.io.*;

public class learning {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(new File("learning.in"));
    int N = in.nextInt();
    int A = in.nextInt();
    int B = in.nextInt();
    int result = B-A+1;
	System.out.println(result);
    Cow prev = new Cow(in);
    if(prev.noSpot) {
    	result -=N-prev.n;
    }
    for(int i=1; i<N;i++) {
    	System.out.println(i);
    	Cow c= new Cow(in);
    	if(prev.noSpot) {
    		result --;
    		if(prev.noSpot) {
    			result -= prev.n - c.n;
    			System.out.println(c.n - prev.n + " " + result);
    		}else {
    			result -= (prev.n - c.n)/2;
    			System.out.println(c.n - prev.n + " " + result);
    		}
    	}
    	prev = c;
    }
    in.close();
    
    if(prev.noSpot) {
    	result-=prev.n;
    }

    PrintWriter out = new PrintWriter(new File("learning.out"));
    out.println(result);
    System.out.println(result);
    out.close();
  }
  
  static class Cow {
	  int n;
	  boolean noSpot;
	  public Cow(Scanner in) {
		  noSpot = in.next().equals("NS");
		  n=in.nextInt();
	  }
  }
}