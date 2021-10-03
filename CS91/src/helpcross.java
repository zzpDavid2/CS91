// "Why Did the Cow Cross the Road"
// Bronze February 2017 Problem 1
// http://usaco.org/index.php?page=viewproblem2&cpid=714

import java.util.*;
import java.io.*;

public class helpcross {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(new File("helpcross.in"));
    int C = in.nextInt();
    int N = in.nextInt();
    int[] chikens = new int[20001];
    ArrayList<Set<Integer>> cows = new ArrayList<Set<Integer>>();
    for(int i=0; i<C; i++) {
    	int t = in.nextInt();
    	chikens[t]++;
    }
    for(int i=0; i<C; i++) {
    	int a = in.nextInt();
    	if(cows.get(a)==null) {
    		cows.add(new HashSet<Integer>());
    	}
    	int b = in.nextInt();
    	cows.get(a).add(b);
    }
    TreeSet<Integer> ts = new TreeSet<Integer>();
    in.close();
    int result = 0;
    int prevt = 0;
    for(int i=0;i<20001;i++) {
    	if(cows.get(i)!=null) {
    		for(int cow : cows) {
    			ts.add(Turple t)
    		}
    	}
    }
    PrintWriter out = new PrintWriter(new File("helpcross.out"));
    System.out.println(result);
    out.println(result);
    out.close();
  }
  
  public class Tuple<X, Y> { 
	  public final X x; 
	  public final Y y; 
	  public Tuple(X x, Y y) { 
	    this.x = x; 
	    this.y = y; 
	  } 
	} 
}