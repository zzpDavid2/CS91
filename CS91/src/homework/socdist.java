// "Social Distancing"
// http://www.usaco.org/index.php?page=viewproblem2&cpid=1038

package homework;

import java.util.*;
import java.io.*;

public class socdist {
	static int N, M;
	static ArrayList<grass> farm;
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(new File("socdist.in"));
    N = in.nextInt();
    M = in.nextInt();
    farm =  new ArrayList<>(M);
    
    int maxG= 0;
    
    for(int i=0; i<M; i++) {
    	grass g = new grass(in);
    	maxG = Math.max(maxG, g.length);
    	farm.add(g);
    	System.out.println(g);
    }
    in.close();
    
    int left = 1; // inclusive
    int right = maxG; // exclusive
    
    System.out.println(N);
    
    int mid=(left+right)/2;
    while(left<right) {
    	boolean b = distance(mid);
    	if(b) {
    		left=mid;
    	}else {
    		right=mid-1;
    	}
    	System.out.println(mid + " " + b);
    	System.out.println(left + " " + right);
    	mid = (left+right)/2;
    }
    
    int result = mid;
    
    PrintWriter out = new PrintWriter(new File("socdist.out"));
    System.out.println(result);
    out.println(result);
    out.close();
  }
  public static boolean distance(int d) {
	  int c=0;
	  for(int i=0;i< M; i++) {
		  int n =1+((farm.get(i).length-1)/d);
		  c+=n;
		  System.out.println(farm.get(i).length+ " " + n);
		  if (c>=N) return true;
	  }
	  return false;
  }
  
  public static class grass{
	  int a;
	  int b;
	  int length;
	  public grass(Scanner in) {
		  a = in.nextInt();
		  b = in.nextInt();
		  length = b-a+1;//includes bonds
		  return;
	  }
	  
	  public String toString() {
		  return a + " " + b+ " " + length;
	  }
  }
}
