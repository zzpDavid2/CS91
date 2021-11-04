// http://www.usaco.org/index.php?page=viewproblem2&cpid=619
// balancing
import java.util.*;
import java.io.*;

public class balancing {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(new File("balancing.in"));
    
    int n= in.nextInt();
    
    Cow[] byX = new Cow[n];
    for(int i=0; i<n; i++) {
    	byX[i] = new Cow(in);
    }
    
    Arrays.sort(byX, new Comparator<Cow>() {
    	public int compare(Cow a, Cow b) {
    		return a.x - b.x;
    	}
    	
    });
    
    Cow[] byY = Arrays.copyOf(byX, n);
    // Lambda notation
    Arrays.sort(byY, (a,b) -> a.y-b.y);
    
    in.close();

    int result = n;
    
    int ul=0, ur =0, ll=0, lr=n;
    
    for(int ix =0; ix<n;ix++) {
    	//ix is index number of a cow; the fence X position is one to left of that cow
    	
    	int fenceX = byX[ix].x -1;
    	
        if (ix == 0 || byX[ix-1].x == byX[ix].x) {
            //  additional sliding window w/vertical fence y sliding
            
        	for(int jy = 0; jy<n;jy++)
            {
        		int fenceY = byY[jy].y - 1;
                
                //  check if balance level is best so
                if (jy == 0 || byY[jy-1].y < byY[jy].y)
                {
                	int balance = Math.max( Math.max(ul, ur)
                			, Math.max(ll, lr));
                	
                    result = Math.min(result, balance);
                }
                
                if(byY[jy].x < fenceX) {
                	ul++;
                	ll--;
                }else {
                	ur++;
                	lr--;
                }
                
            }
        	
        	ll += ul;
        	ul = 0;
        	lr += ur;
        	ur =0;
            
        }
    	
    	// slide cow ix from right to left side of the fence, b/c ix is about to increase by 1 b/c of our loop
        lr--;
        ll++;
    }
    
    PrintWriter out = new PrintWriter(new File("balancing.out"));
    System.out.println(result);
    out.println(result);
    out.close();
  }
  
  static class Cow{
	  int x, y;
	  
	  Cow(Scanner in){
		  x = in.nextInt();
		  y = in.nextInt();
	  }
  }
}