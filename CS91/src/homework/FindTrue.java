package homework;

import java.util.*;

public class FindTrue {
	
	static boolean[] conclusions = new boolean[1000];
	
	static int startTrue = (int) (Math.random() * 1001);
	
	public static void main(String[] args) {
		for(int i= startTrue; i<1000; i++) {
			conclusions[i] = true;
		}
		
		int left = 0;
		int right = 1000;
		
		while(left < right) {
			int mid= (left + right)/2;
			
			if(check(mid)) {
				right = mid;
			}
		}
		
	}
	static boolean check(int possibility) {
		return possibility
	}
}
