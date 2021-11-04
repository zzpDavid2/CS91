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
    ArrayList<Boolean> haveSpot = new ArrayList<Boolean>();
    for(int i=0; i<N;i++) {
    	String s = in.next();
    	
    }
    in.close();
    
    int result = 0;

    PrintWriter out = new PrintWriter(new File("learning.out"));
    out.println(result);
    System.out.println(result);
    out.close();
  }
}