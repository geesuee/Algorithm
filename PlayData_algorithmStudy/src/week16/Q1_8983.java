// [백준] 사냥꾼
// https://www.acmicpc.net/problem/8983
// 이분 탐색

package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1_8983 {
    static int M, N, L;
    static int[] gunspot;
    static int[][] animalspot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());  // 사대의 수
        N = Integer.parseInt(st.nextToken());  // 동물의 수
        L = Integer.parseInt(st.nextToken());  // 사정 거리

        // 사대 위치
        gunspot = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            gunspot[i] = Integer.parseInt(st.nextToken());
        }

        // 동물 위치
        animalspot = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            animalspot[i][0] = Integer.parseInt(st.nextToken());
            animalspot[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution());
    }

    static int solution() {
        int cnt = 0;
        Arrays.sort(gunspot);

        for(int i = 0; i < N; i++) {
            cnt += search(i);
        }

        return cnt;
    }

    static int search(int idx) {
        int start = 0;
        int end = M;
        int mid = 0;

        while(start <= end) {
            mid = (start + end) / 2;

            if(mid >= M) {
                return 0;
            }

            // x좌표값 차의 절대값에 y좌표값을 더해 사대와 동물 간 거리 계산
            int distance = Math.abs(gunspot[mid] - animalspot[idx][0]) + animalspot[idx][1];

            if (L < distance && animalspot[idx][0] < gunspot[mid]) {
                end = mid - 1;
            }else if (L < distance && animalspot[idx][0] >= gunspot[mid]) {
                start = mid + 1;
            }else if (L >= distance) {
                return 1;
            }
        }
        return 0;
    }
}
