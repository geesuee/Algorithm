// [백준] 1, 2, 3 더하기
// https://www.acmicpc.net/problem/9095

package week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1_9095 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i < 11; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        int T = Integer.parseInt(br.readLine());

        // 미리 배열에 넣어둔 값을 꺼내는 방식
        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }
        // 재귀 함수 활용 방식
        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp(n)).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

   static int dp(int n) {
        if(n == 1){
            return 1;
        }else if(n == 2){
            return 2;
        }else if(n == 3){
            return 4;
        }

        return dp(n-3) + dp(n-2) + dp(n-1);
    }
}
