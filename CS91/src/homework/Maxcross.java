// "Why Did the Cow Cross the Road"
// http://www.usaco.org/index.php?page=viewproblem2&cpid=715
//package homework;

import java.util.*;
import java.io.*;

public class Maxcross {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(new File("maxcross.in"));
    int N = in.nextInt();
    int K = in.nextInt();
    int B = in.nextInt();
    boolean[] signals = new boolean[N];
    for(int i=0; i<B;i++) {
    	signals[in.nextInt()-1] = true;
    }
    in.close();
    
    int cur=0;
    for(int i=0; i<K;i++) {
    	if(signals[i]) {
    		cur++;
    	}
    }
    
    int min = cur;
    
    for(int i=K; i<N;i++) {
    	if(signals[i]) {
    		cur++;
    	}
    	if(signals[i-K]) {
    		cur--;
    	}
    	min = Math.min(min, cur);
    }
    
    int result = min;
    
    PrintWriter out = new PrintWriter(new File("maxcross.out"));
    System.out.println(result);
    out.println(result);
    out.close();
  }
}