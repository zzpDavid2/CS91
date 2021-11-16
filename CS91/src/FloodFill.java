import java.util.*;

public class FloodFill {
    public static void main(String[] args)  {
    
        String[] pattern = {
            "WWWWWWWWWWWWWWWWWWW",
            "W     W    W   W  W",
            "WWWWWW  *  W    * W",
            "W      *   WWW  WWW",
            "W! ***     W    **W",   // <-- row index 4
            "WWWWWWWWWWWWWWWWWWW"
        };
        
        char[][] grid = new char[pattern.length][];
        for (int r=0; r<grid.length; r++) {
        	pattern[r].toCharArray();
        }
        
//        System.out.println(countStars(grid, 1,1));
        
        int rCount = 0;
        for(int r=0;r<grid.length;r++) {
        	for(int c=0; c<grid[r].length; c++) {
        		if(grid[r][c] != 'W' && grid[r][c] != 'X') {
        			rCount++;
        			
        			System.out.println(countStars(grid,r,c));
        		}
        	}
        }
        
        System.out.println(rCount);
    }
    
    static int countStars(char[][] g, int startR, int startC) {
    	int stars =0;
    	
    	Deque<int[]> toVisit = new ArrayDeque<>();
    	
    	toVisit.add(new int[] {startR, startC});
    	
    	while(toVisit.size()>0) {
    		int[] cell = toVisit.remove();
    		
    		int r = cell[0];
    		int c = cell[1];
    		
    		//checks
    		if(r<0 || c<0 || r>=g.length ||c>=g[c].length) continue;
    		if(g[r][c] == 'W') continue;
    		if(g[r][c] == 'X' ) continue;
    		
    		//work
    		if(g[r][c] == '*') stars++;
    		
    		g[r][c] = 'X';
    		
    		toVisit.add(new int[] {r+1,c});
    		toVisit.add(new int[] {r-1,c});
    		toVisit.add(new int[] {r,c+1});
    		toVisit.add(new int[] {r,c-1});


    		
    		
    	}
    	
    	return stars;
    }
}