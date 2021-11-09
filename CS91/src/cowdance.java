// cowdance
// http://www.usaco.org/index.php?page=viewproblem2&cpid=690


import java.util.*;
import java.io.*;

public class cowdance {
	
	static int n, tMax;
	static int[] durations;
	
	public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(new File("cowdance.in"));
    
    n = in.nextInt();
    tMax = in.nextInt();
    
    for(int i = 0; i<n;i++) {
    	durations[i] = in.nextInt();
    }
    
    in.close();

    int left = 1; // inclusive, or 0 exclusive
    int right = n; // Exclusive, n-1 inclusive
    
    while(left < right) {
    	// stop once bounds are equal
    	
    	int mid = (left + right) / 2;
    	
    	if(check(mid)) {
    		right = mid;
    	}else {
    		left = mid+1;
    	}
    }
    
    
    int result = left;
    PrintWriter out = new PrintWriter(new File("cowdance.out"));
    System.out.println(result);
    out.println(result);
    out.close();
  }
	
	private static boolean check(int k) {
		PriorityQueue<Integer> stage = new PriorityQueue<>();
		for(int i=0; i<k;i++) {
			stage.add(durations[i]);
		}
		
		for(int i=0;i<n;i++) {
			int t=stage.poll();
			int willFinish = t + durations[i];
			if(willFinish > tMax) {
				return false;
			}
			stage.add(willFinish);
		}
		return true;
	}
}