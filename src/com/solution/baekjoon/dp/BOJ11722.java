package com.solution.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  백준 11722, 가장 긴 감소하는 부분 수열, 실버 2
 */
public class BOJ11722 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		int[] dp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp[0] = 1;

		for(int i=1; i<n; i++){
			dp[i] = 1;
			for(int j=0; j<i; j++){
				if(arr[j]>arr[i] && dp[j]+1>=dp[i])
					dp[i] = dp[j] + 1;
			}
		}

		int answer = 0;
		for(int i=0; i<n; i++){
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(answer);
	}
}
