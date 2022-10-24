// [백준] 포도주 시식
// https://www.acmicpc.net/problem/2156

package week1_2210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1_2156 {

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 컵 개수
        int N = Integer.parseInt(br.readLine());
        // 포도주 양 list
        int[] arr = new int[N + 1];
        // 최선의 선택이 들어가는 arr, 메모이제이션
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = arr[1];
        if (N > 1) {
            dp[2] = arr[1] + arr[2];
        }
        for (int i = 3; i <= N; i++) {
            // 1. 이번 잔을 마실 지 말지
            // 2. 이번 잔을 마신다는 가정하에, 전 잔을 마시지 않는 것이 큰 지, 마시는 것이 큰 지
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
        }
        System.out.println(dp[N]);

    }
}