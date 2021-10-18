package homework;

//http://www.usaco.org/index.php?page=viewproblem2&cpid=188
//"Typo"

import java.util.*;
import java.io.*;

public class typo {
public static void main(String[] args) throws Exception {
 Scanner in = new Scanner(new File("typo.in"));
 String ip = in.next();
 in.close();
 
 int n= ip.length();
 
 int[] leftQ = new int[n];
 int[] rightQ= new int[n];
 
 if(ip.charAt(0) == '(') {
	 leftQ[0] = 1;
 }else {
	 leftQ[0] = -1;
 }

 for(int i=1; i<n;i++) {
	 if(ip.charAt(i)=='(') {
		 leftQ[i] = leftQ[i-1]+1;
	 }else {
		 leftQ[i] = leftQ[i-1]-1;
	 }

 } 
 
 if(ip.charAt(n-1) == ')') {
	 rightQ[n-1] = 1;
 }else {
	 rightQ[n-1] = -1;
 }
 
 for(int i=n-2; i>=0; i--) {
	 if(ip.charAt(i)=='(') {
		 rightQ[i] = rightQ[i+1]-1;
	 }else{
		 rightQ[i] = rightQ[i+1]+1;
	 }

 }
 
 for(int i=0; i<n;i++) {
	 System.out.print(leftQ[i]);
	 System.out.print(" ");
 }
 
 System.out.println();
 
 for(int i=0; i<n;i++) {
	 System.out.print(rightQ[i]);
	 System.out.print(" ");
 }

 System.out.println();

 int result = 0;
 
 for(int i=0; i<n; i++) {
	 if(ip.charAt(i)=='(' && leftQ[i]-1 == rightQ[i]+2 &&i!=0) {
		 result++;
		 System.out.println(i);
	 }else if(ip.charAt(i)==')' && rightQ[i]-1 == leftQ[i]+2 && i!=n-1) {
		 result++;
		 System.out.println(i);
	 }
 }
  
 PrintWriter out = new PrintWriter(new File("typo.out"));
 System.out.println(result);
 out.println(result);
 out.close();
}
}