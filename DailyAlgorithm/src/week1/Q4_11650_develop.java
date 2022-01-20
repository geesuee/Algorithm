// [백준] 좌표 정렬하기
// https://www.acmicpc.net/problem/11650

package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q4_11650_develop {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        long[] xy = new long[N];
        // -100,000 ≤ xi, yi ≤ 100,000
        long a = 1000000;
        long b = 100000;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Integer.parseInt(st.nextToken()) + b;
            long y = Integer.parseInt(st.nextToken()) + b;
            xy[i] = x * a + y;
            // 이렇게 되면 주어진 좌표가 3, 1 일 때 -> 100003100001
            // 음수로 나오면 알아서 작은 수로 계산 됨
        }

        Arrays.sort(xy);
        for (int i = 0; i < N; i++) {
            sb.append(String.valueOf((xy[i] / a) - b))
                    .append(" ")
                    .append(String.valueOf((xy[i] % a) - b))
                    .append("\n");
        }

        System.out.println(sb);
    }
}
