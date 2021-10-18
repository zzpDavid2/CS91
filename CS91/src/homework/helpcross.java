package homework;
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
    for(int i=0; i<20001; i++) {
    	cows.add(null);
    }
    for(int i=0; i<C; i++) {
    	int t = in.nextInt();
    	chikens[t]++;
    }
    for(int i=0; i<N; i++) {
    	int a = in.nextInt();
    	if(cows.get(a)==null) {
    		cows.set(a, new HashSet<Integer>());
    	}
    	int b = in.nextInt();
    	cows.get(a).add(b);
    }
    TreeSet<Tuple> ts = new TreeSet<Tuple>(new TupleComp());
    
    in.close();
    int result = 0;
    for(int i=0;i<20001;i++) {
    	if(cows.get(i)!=null) {
    		for(Integer end : cows.get(i)) {
    			ts.add(new Tuple(i, end));
    		}
    	}
    	while(chikens[i]>0 && !ts.isEmpty()) {
    		if(ts.first().y>=i) {
        		ts.pollFirst();
        		result++;
        		chikens[i]--;
    		}else {
        		ts.pollFirst();
    		}
  
    	}
    }
    PrintWriter out = new PrintWriter(new File("helpcross.out"));
    System.out.println(result);
    out.println(result);
    out.close();
  }
  
  static public class TupleComp implements Comparator <Tuple>{
  	@Override
  	public int compare(Tuple t1, Tuple t2) {
  		if(t1.x<t2.x) {
  			return 1;
  		}else if (t1.x>t2.x) {
  			return -1;
  		}else {
  			return 0;
  		}
  		
  	}
 }
  
}

	class Tuple { 
	  public final int x; 
	  public final int y; 
	  public Tuple(int a, int b) { 
	    this.x = a; 
	    this.y = b; 
	  } 
}
  


  