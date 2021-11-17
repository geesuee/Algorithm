// [백준] 동전 0
// https://www.acmicpc.net/problem/11047

package week16.Advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1_11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        for(int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

//        System.out.println(Arrays.toString(coins));

        int cnt = 0;
        for(int i = N-1; i >= 0; i--) {
            if(coins[i] > K) {
                continue;
            }
            cnt += K / coins[i];
            K = K % coins[i];
        }

        System.out.println(cnt);
    }
}
