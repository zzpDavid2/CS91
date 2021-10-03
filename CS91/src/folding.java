// "Rope Folding" - folding
// http://www.usaco.org/index.php?page=viewproblem2&cpid=112

import java.util.*;
import java.io.*;

public class folding{
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("folding.in"));
        int N = in.nextInt();
        int L = in.nextInt();
        
        int[] nodes;
       
        nodes= new int[N];
        
        for(int i=0; i<nodes.length; i++){
            nodes[i]=in.nextInt();
        }
        
        in.close();
        
        Arrays.sort(nodes);
        
        int[] s;
        s = new int[N-1];
        
        for(int i=0; i<s.length; i++){
            s[i]=nodes[i+1]-nodes[i];
        }
        int result = 0;
        if(N>=3){
        	result = 2;
        }else{
        	result = 1;
        }

        
        for(int i=s.length-1 ;i>=0; i-- ){
            for(int j=0; j<i/2+1; j++){
                if(i-j<=j){
                    result++;
                    break;
                }
                if(s[i-j]!=s[j]){
                    break;
                }
            }
            
        }
 
        
        PrintWriter out = new PrintWriter(new File("folding.out"));
        System.out.println(result);
        out.println(result);
        out.close();
    }
}

/* ANALYSIS

5 10
0
10
6
2
4

4

*/