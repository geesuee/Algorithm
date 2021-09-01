// [백준] 나이순 정렬
// https://www.acmicpc.net/problem/10814

package week9.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2_10814 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 입력되는 나이의 범위 : 1 ~ 200
        StringBuilder[] sba = new StringBuilder[201];

        for(int i = 0; i < sba.length; i++) {
            sba[i] = new StringBuilder();
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            sba[age].append(age).append(" ").append(name).append("\n");
        }

        StringBuilder sb = new StringBuilder();
        for(StringBuilder s : sba) {
            sb.append(s);
        }

        System.out.println(sb);
    }
}
