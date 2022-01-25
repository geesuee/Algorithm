// [백준] 개똥벌레
// https://www.acmicpc.net/problem/3020

package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1_3020 {
    static int N;
    static int H;
    static int[] up;   // 종유석
    static int[] down; // 석순
    static int min;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 길이
        H = Integer.parseInt(st.nextToken()); // 높이
        up = new int[H + 1];
        down = new int[H + 1];
        min = N;
        cnt = 0;

        for (int i = 0; i < N/2; i++) {
            down[Integer.parseInt(br.readLine())]++;
            up[Integer.parseInt(br.readLine())]++;
        }

        checkObstacles();

        System.out.println(min + " " + cnt);

    }

    static void checkObstacles() {
        int[] up_sum = new int[H + 1];
        int[] down_sum = new int[H + 1];

        for (int i = 1; i < H + 1; i++) {
            up_sum[i] = up_sum[i - 1] + up[i];
            down_sum[i] = down_sum[i - 1] + down[i];
        }

        for (int i = 1; i < H + 1; i++) {
            int crush = 0;

            // 부딪히는 석순의 개수 = 전체 석순의 개수 - (H-1) 이하인 석순의 개수
            crush += down_sum[H] - down_sum[i - 1];
            // 부딪히는 종유석의 개수 = 전체 종유석의 개수 - (i-1) 이하인 종유석의 개수
            crush += up_sum[H] - up_sum[H - i];

            if (crush < min) {
                min = crush;
                cnt = 1;
            } else if (crush == min) {
                cnt++;
            }
        }
    }
}
