package com.christianrubiales.dcp._13dynamicProgramming;

public class NumberOfWaysToDecodeString {

	// O(n) time, O(n) space
	public int numberOfDecodings(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}
		
		int n = s.length();
		int[] dp = new int[n + 1];
		dp[0] = 1; // ways to decode empty string
		dp[1] = s.charAt(0) == '0' ? 0 : 1; // ways to decode string of size 1
		
		for (int i = 2; i <= n; i++) {
			int n1 =  Integer.parseInt(s.substring(i - 1, i));
			int n2 = Integer.parseInt(s.substring(i - 2, i));
			
			if (n1 >= 1 && n1 <= 9) {
				dp[i] = dp[i] + dp[i-1];
			}

			if (n2 >= 10 && n2 <= 26) {
				dp[i] = dp[i] + dp[i-2];
			}
		}
		
		return dp[n];
	}
}
