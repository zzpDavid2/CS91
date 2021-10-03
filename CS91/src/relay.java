// "Message Relay" - relay
// http://www.usaco.org/index.php?page=viewproblem2&cpid=241

import java.util.*;
import java.io.*;
import java.util.HashMap;

public class relay {
    public static HashMap<Integer,String> loopy = new HashMap<Integer,String>();
    public static int[] F;
	
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(new File("relay.in"));
    
    int N = in.nextInt();
    F = new int[N+1];
    
    for(int i=1; i<=N; i++){
        F[i] = in.nextInt();
        
    }
    
    in.close();
    
    int result = 0;
    
    for(int i=1; i<=N; i++){
        checkIsLoopy(i);
        if(loopy.get(i)=="false"){
            result++;
        }
        
    }
    
    PrintWriter out = new PrintWriter(new File("relay.out"));
    System.out.println(result);
    out.println(result);
    out.close();
  }
  
  public static String checkIsLoopy(int i){
	    if(loopy.get(i) == "checking") {
	        loopy.put(i,"true");
	        return "true";
	    }
	  
	    if(loopy.containsKey(i) && loopy.get(i)!="checking"){
	        return loopy.get(i);
	    }
	    
	    if(F[i]==0){
	        loopy.put(i,"false");
	        return "false";
	    }
	    
	  	loopy.put(i,"checking");
	        
	  	loopy.put(i,checkIsLoopy(F[i]));
	    return loopy.get(i);
	}
}



/* ANALYSIS



*/