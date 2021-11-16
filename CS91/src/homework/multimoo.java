// http://www.usaco.org/index.php?page=viewproblem2&cpid=836
// "Multiplayer Moo"

import java.util.*;
import java.io.*;

public class multimoo {
	static Map<Integer,Integer> players = new HashMap<Integer,Integer>();
	static int[][] board;
	static int singleMax;
	static int groupMax;
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("multimoo.in"));
    int N = in.nextInt();
    board = new int[N][N];
    for(int i=0;i<N;i++) {
    	for(int j=0;j<N;j++) {
    		board[i][j] = in.nextInt();
    	}
    }
    in.close();
    
    

    int result = 0;
    PrintWriter out = new PrintWriter(new File("multimoo.out"));
    System.out.println(singleMax);
    out.println(singleMax);
    System.out.println(groupMax);
    out.println(groupMax);
    out.close();
  }
  
  public static int fill(int a,int b,int t) {
	  int result =0;
	  Deque<int[]> queue = new ArrayDeque<int[]>();
	  queue.add(new int[]{a,b});
	  int N = board[0].length;
	  while(queue.size()>0) {
		  int[] cell = queue.remove();
		  int x=cell[0];
		  int y=cell[1];
		  
		  if(x>=N || x<0 || y>=N || y<0) continue;
		  if(board[x][y]!=t) continue;
		  board[x][y]=-t;
		  result++;
	  }
	  
	  
  }
}