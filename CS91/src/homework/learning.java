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
    ArrayList<cow> cows = new ArrayList<cow>();
    for(int i=0; i<N;i++) {
    	String s = in.next();
    	
    	int a=in.nextInt();
    	
    	cow c= new cow(a,
    	cows.add();
    }
    in.close();
    
    int result = 0;

    PrintWriter out = new PrintWriter(new File("learning.out"));
    out.println(result);
    System.out.println(result);
    out.close();
  }
  
  public class cow {
	  int n;
	  boolean hasSpot;
	  public cow(int a, boolean b) {
		  n=a;
		  hasSpot = b;
	  }
  }
}