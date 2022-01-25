// [백준] 오르막 수
// https://www.acmicpc.net/problem/11057

package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2_11057 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][10];
        // dp[N][K]는 N개 자리의 숫자 중 가장 맨뒤의 숫자가 K 일 때의 경우의 수
        // N-1이 K와 같거나 작은 수를 선택해서 모든 경우의 수를 다 더함

        // 한 자리 수일 때는 모든 숫자가 한 번씩 사용됨
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) { // 2 부터 입력한 숫자 N 까지
            for (int j = 0; j < 10; j++) { // 매 숫자 (0~9)
                for (int k = 0; k <= j; k++) { // 특정 숫자를 기준으로 0~j 탐색
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= 10007;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[N][i];
        }

        System.out.println(sum % 10007);
    }
}
