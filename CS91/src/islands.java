

// Homework: 
//    Linear sweep (helpcross)
//      due in 1 week 10/9

//    Sorting (field reduction)
//      due 10/16



// Islands
// http://www.usaco.org/index.php?page=viewproblem2&cpid=132

import java.util.*;
import java.io.*;

public class islands {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(new File("islands.in"));
    int n = in.nextInt();
    
    Region[] regions = new Region[n+2];
    
    for (int i = 1; i <= n; i++)  regions[i] = new Region(in, i);
    regions[0] = new Region(0);
    regions[0] = new Region(n+1);
    in.close();
    
    Region[] floodOrder = Arrays.copyOf(regions, regions.length);
    Arrays.sort( floodOrder );
    

    int result = 0;
    int islands = 1;
    
    for(int i=2; i< floodOrder.length; i++) {
    	Region r = floodOrder[i];
    	if(regions[r.x-1].under && regions[r.x+1].under){
    		islands --;
    	}
    	if(!regions[r.x-1].under && !regions[r.x+1].under){
    		islands ++;
    	}
    	
    	r.under = true;
    	
    	//only count results if the next region ISN'T tied with this one
    	if(i+1 >= floodOrder.length || floodOrder[i+1].h > r.h) {
    		result = Math.max(islands, result);
    	}
    }
    
    PrintWriter out = new PrintWriter(new File("islands.out"));
    System.out.println(result);
    out.println(result);
    out.close();
  }
  
  // a Region is one part/element of the field
  static class Region implements Comparable<Region> {
      int h;
      int x;    // position from left to right
      
      boolean under;
      
      Region(Scanner in, int x) {
          h = in.nextInt();
          this.x = x;
      }
      
      Region(int x){
    	  this.x = x;
    	  h = -1;
    	  under = true;
      }
      
      // contract:
      //     positive - this elem goes later in sorting than other
      //     negative - this elem goes earlier in sorting
      //     zero     - these elems are tied in sorting
      public int compareTo( Region other ) {
          return this.h - other.h;
          //        7       4            = +3
          //       30        100         = -70
          //        42       42          = 0
          // "subtraction trick"
      }
  }
}







