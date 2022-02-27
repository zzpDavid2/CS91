//http://www.usaco.org/index.php?page=viewproblem2&cpid=1064

import java.util.Scanner;

public class StuckinaRut {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // possibly investigate BufferedReader style input
        int n = in.nextInt();
        String s = in.next();
        in.close();
        
        
        
        int result = n * s.length();
        System.out.println( result );
    }
}
