// [백준] 사냥꾼
// https://www.acmicpc.net/problem/8983
// 미완

package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1_8983 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());  // 사대의 수
        int N = Integer.parseInt(st.nextToken());  // 동물의 수
        int L = Integer.parseInt(st.nextToken());  // 사정 거리

        // 사대 위치
        long[][] gunspot = new long[M][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            gunspot[i][0] = Long.parseLong(st.nextToken());
            gunspot[i][1] = Long.parseLong(st.nextToken());
        }

        // 동물 위치
        long[][] animalspot = new long[N][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            animalspot[i][0] = Long.parseLong(st.nextToken());
            animalspot[i][1] = Long.parseLong(st.nextToken());
        }


    }


}
