// [백준] 파도반 수열
// https://www.acmicpc.net/problem/9461

package week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3_9461 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        long[] triSequence = new long[101];
        triSequence[1] = 1;
        triSequence[2] = 1;
        triSequence[3] = 1;
        for (int i = 4; i < 101; i++) {
            triSequence[i] = triSequence[i - 2] + triSequence[i - 3];
        }

        for (int i = 0; i < T; i++) {
            int t = Integer.parseInt(br.readLine());
            sb.append(triSequence[t]).append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}
