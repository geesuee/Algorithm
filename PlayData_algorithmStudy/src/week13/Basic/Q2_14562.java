// [백준] 태권왕
// https://www.acmicpc.net/problem/14562

package week13.Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2_14562 {
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int C = Integer.parseInt(br.readLine());
        for(int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            cnt = 0;

            System.out.println(kick(S, T, cnt));
        }
    }

    public static int kick(int S, int T, int count) {
        if (S > T) {
            return 100;
        }
        if (S == T) {
            return count;
        } else {
            int min1 = kick(S * 2, T + 3, count + 1);
            int min2 = kick(S + 1, T, count + 1);
            return Math.min(min1, min2);
        }
    }
}
