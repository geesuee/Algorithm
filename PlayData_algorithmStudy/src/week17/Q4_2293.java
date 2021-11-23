// [백준] 동전 1
// https://www.acmicpc.net/problem/2293
// 출처 : https://squareyun.tistory.com/14

package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4_2293 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 코인 종류 수
        int k = Integer.parseInt(st.nextToken()); // 목표 합

        int[] coin = new int[n+1];
        for(int i = 1; i <= n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k+1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = coin[i]; j <= k; j++) {
                dp[j] = dp[j] + dp[j - coin[i]]; // 점화식
            }
        }

        System.out.println(dp[k]);
        br.close();
    }
}
